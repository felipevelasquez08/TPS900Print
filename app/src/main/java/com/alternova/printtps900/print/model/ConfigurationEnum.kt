package com.alternova.printtps900.print.model


enum class ConfigurationEnum(val values: IntArray) {
    T20(intArrayOf(2, 7, 8, 10, 11, 12, 13, 15, 16)),
    T20P(intArrayOf(2, 7, 8, 10, 11, 12, 13, 15)),
    T20B(intArrayOf(2, 7, 8, 10, 11, 12, 13, 15, 16, 20)),
    S8G(intArrayOf(2, 6, 7, 8, 15, 20)),
    M8(intArrayOf(1, 2, 4, 7, 8, 9, 10, 12, 15, 18, 19)),
    C1B(intArrayOf(1, 4, 10, 12, 17, 18)),
    C1P(intArrayOf(1, 4, 18)),
    C11(intArrayOf(4, 12, 15)),
    TPS967M(intArrayOf(7, 11, 13, 15, 12, 10)),
    F10B(intArrayOf(5, 7, 11, 13, 15, 12)),
    TPS980B(intArrayOf(7, 10, 13, 15, 12)),
    C1Pro(intArrayOf(1, 4, 18)),
    TPS900(intArrayOf(1, 2, 3, 6, 7, 8)),
    COMMON(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

    companion object {
        fun find(key: String): ConfigurationEnum = values().find { it.name == key } ?: COMMON
    }
}