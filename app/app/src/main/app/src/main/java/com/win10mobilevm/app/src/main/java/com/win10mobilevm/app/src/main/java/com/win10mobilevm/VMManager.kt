package com.win10mobilevm

class VMManager {

    private var currentVM: VMConfig? = null
    private var running = false

    fun createVM(config: VMConfig): Boolean {

        if (config.memoryMB < 512) return false
        if (config.cpuCores < 1) return false
        if (config.diskSizeGB < 8) return false
        if (config.width < 640) return false
        if (config.height < 480) return false

        currentVM = config
        running = false

        return true
    }

    fun getCurrentVM(): VMConfig? {
        return currentVM
    }

    fun startVM(): String {

        val vm = currentVM
            ?: return "Primero tenés que crear una VM."

        if (running) {
            return "La VM ya está iniciada."
        }

        /*
         * Backend de virtualización pendiente.
         *
         * En una próxima etapa conectaremos aquí
         * el motor de emulación/virtualización.
         */

        running = true

        return """
            VM preparada para iniciar.

            Nombre: ${vm.name}
            RAM: ${vm.memoryMB} MB
            CPU: ${vm.cpuCores} núcleos
            Disco: ${vm.diskSizeGB} GB
            Resolución: ${vm.width}x${vm.height}
        """.trimIndent()
    }

    fun stopVM(): String {

        if (!running) {
            return "La VM no está iniciada."
        }

        running = false

        return "VM detenida."
    }
}
