package com.win10mobilevm

data class VMConfig(
    val name: String = "Windows 10",
    val memoryMB: Int = 2048,
    val cpuCores: Int = 2,
    val diskSizeGB: Int = 32,
    val width: Int = 1280,
    val height: Int = 720,
    val graphicsEnabled: Boolean = true
)
