package com.speda.captain.sonar.game.model

open class Gauge(val max: Int) {
    var value: Int = 0
        protected set
}