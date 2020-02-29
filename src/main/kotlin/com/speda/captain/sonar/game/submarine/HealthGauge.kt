package com.speda.captain.sonar.game.submarine

import com.speda.captain.sonar.game.model.Gauge

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