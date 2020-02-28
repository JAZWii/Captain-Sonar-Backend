package com.speda

class SystemGauge(max: Int, val system: SubmarineSystem) : Gauge(max) {

    val isReady
        get() = value == max

    fun charge() = value++

    fun clear() {
        value = 0
    }
}