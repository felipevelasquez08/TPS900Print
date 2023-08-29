package com.alternova.printtps900

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.alternova.printtps900.print.PrintScreen
import com.alternova.printtps900.print.model.PrinterEnum
import com.alternova.printtps900.print.thread.PrintTextThread
import com.alternova.printtps900.ui.theme.PrintTPS900Theme

class MainActivity : ComponentActivity() {

    private val handler = TPS900Handler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrintTPS900Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val onPrint: (String) -> Unit = {
                        printText(it)
                    }
                    PrintScreen(onLaunchPrint = onPrint)
                }
            }
        }
    }

    private fun printText(text: String) {
        textToPrint = text
        val message = handler.obtainMessage(PrinterEnum.PRINTER_CONTENT.key, 1, 0, null)
        handler.handleMessage(message)
    }

    companion object {
        private var textToPrint: String = ""
    }

    private class TPS900Handler(private val context: Context) : Handler() {
        override fun handleMessage(msg: Message) {
            when (PrinterEnum.find(msg.what)) {
                PrinterEnum.UNKNOWN -> TODO()
                PrinterEnum.NO_PAPER -> TODO()
                PrinterEnum.LOW_BATTERY -> TODO()
                PrinterEnum.PRINTER_CONTENT -> PrintTextThread(context, textToPrint).start()
            }
        }
    }
}