package com.speda.captain.sonar.game.role

import com.speda.captain.sonar.game.model.CardinalDirection
import com.speda.captain.sonar.game.model.Breakdown

class ControlPanel(type: CardinalDirection) {
    val breakdowns = mutableListOf<Breakdown>()

    fun add(breakdown: Breakdown) {
        breakdowns.add(breakdown)
    }
}