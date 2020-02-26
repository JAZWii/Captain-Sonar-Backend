package com.speda

class Gauge(val max: Int, val gaugeType: GaugeType) {

    var value: Int = 0
        private set

    val isReady
        get() = value == max;


    fun charge() = value++;

    fun clear() {
        value = 0
    }



}