package com.speda

class ControlPanel(type: CardinalDirection) {
    val breakdowns = mutableListOf<Breakdown>()

    fun add(breakdown: Breakdown) {
        breakdowns.add(breakdown)
    }
}