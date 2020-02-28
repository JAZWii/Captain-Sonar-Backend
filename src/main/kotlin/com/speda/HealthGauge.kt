package com.speda

class HealthGauge(max: Int = 4) : Gauge(max) {

    init {
        restore()
    }

    val isDead
        get() = value <= 0

    fun damage(amount: Int = 1) {
        value -= amount
    }

    fun restore() {
        value = max
    }


}