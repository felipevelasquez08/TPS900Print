package com.alternova.printtps900.print.thread

import android.content.Context
import com.common.apiutil.printer.ThermalPrinter

class PrintTextThread(private val context: Context?, private val text: String) : Thread() {
    override fun run() {
        super.run()
        try {
            ThermalPrinter.start(context)
            ThermalPrinter.reset()
            ThermalPrinter.setAlgin(ThermalPrinter.ALGIN_MIDDLE)
            ThermalPrinter.setLeftIndent(0)
            ThermalPrinter.setLineSpace(1)
            ThermalPrinter.setGray(3)
            ThermalPrinter.addString(text)
            ThermalPrinter.printString()
            ThermalPrinter.walkPaper(1)
        } catch (exception: Exception) {
            println("PrintTPS900(${this::class.java.simpleName}): ${exception.message}")
            exception.printStackTrace()
        }finally {
            ThermalPrinter.stop()
        }
    }
}