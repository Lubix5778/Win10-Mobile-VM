package com.win10mobilevm

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val vmManager = VMManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(32, 32, 32, 32)

        val title = TextView(this)
        title.text = "Win10 Mobile VM"
        title.textSize = 28f

        val status = TextView(this)
        status.text = "Estado: ninguna VM creada"
        status.textSize = 18f

        val createButton = Button(this)
        createButton.text = "Crear VM"

        val startButton = Button(this)
        startButton.text = "Iniciar VM"

        val stopButton = Button(this)
        stopButton.text = "Detener VM"

        createButton.setOnClickListener {

            val config = VMConfig(
                name = "Windows 10",
                memoryMB = 2048,
                cpuCores = 2,
                diskSizeGB = 32,
                width = 1280,
                height = 720
            )

            if (vmManager.createVM(config)) {
                status.text = "VM creada correctamente"
            } else {
                status.text = "Error al crear la VM"
            }
        }

        startButton.setOnClickListener {
            status.text = vmManager.startVM()
        }

        stopButton.setOnClickListener {
            status.text = vmManager.stopVM()
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(createButton)
        layout.addView(startButton)
        layout.addView(stopButton)

        setContentView(layout)
    }
}
