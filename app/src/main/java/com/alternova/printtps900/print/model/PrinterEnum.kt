package com.alternova.printtps900.print.model

enum class PrinterEnum(val key: Int = 0) {
    NO_PAPER(key = 3), LOW_BATTERY(key = 4), PRINTER_CONTENT(key = 9), UNKNOWN;

    companion object {
        fun find(key: Int): PrinterEnum = values().find { it.key == key } ?: UNKNOWN
    }
}