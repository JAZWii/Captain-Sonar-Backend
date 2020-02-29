package com.speda.captain.sonar.game.role

import com.speda.captain.sonar.game.model.Gauge
import com.speda.captain.sonar.game.submarine.SubmarineSystem

class SystemGauge(max: Int, val system: SubmarineSystem) : Gauge(max) {

    val isReady
        get() = value == max

    fun charge() = value++

    fun clear() {
        value = 0
    }
}