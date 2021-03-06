package com.speda.captain.sonar.game.role

import com.speda.captain.sonar.game.model.CardinalDirection
import com.speda.captain.sonar.game.board.GameSetting
import com.speda.captain.sonar.game.submarine.SubmarineSystem
import com.speda.captain.sonar.game.model.*

class EngineerRoom(gameSetting: GameSetting) {
    val panels = mutableListOf<ControlPanel>()

    // TODO maybe we can make this configurable
    init {
        // West panel
        ControlPanel(CardinalDirection.WEST).apply {
            add(Breakdown.CircuitSystem(SubmarineSystem.WEAPON, Circuit.YELLOW))
            add(Breakdown.CircuitSystem(SubmarineSystem.SPECIAL, Circuit.YELLOW))
            add(Breakdown.CircuitSystem(SubmarineSystem.DETECTION, Circuit.YELLOW))

            add(Breakdown.System(SubmarineSystem.DETECTION))
            add(Breakdown.Reactor())
            add(Breakdown.Reactor())

        }.also { panels.add(it) }

        // North panel
        ControlPanel(CardinalDirection.NORTH).apply {
            add(Breakdown.CircuitSystem(SubmarineSystem.SPECIAL, Circuit.ORANGE))
            add(Breakdown.CircuitSystem(SubmarineSystem.WEAPON, Circuit.ORANGE))
            add(Breakdown.CircuitSystem(SubmarineSystem.SPECIAL, Circuit.ORANGE))

            add(Breakdown.System(SubmarineSystem.DETECTION))
            add(Breakdown.System(SubmarineSystem.WEAPON))
            add(Breakdown.Reactor())
        }.also { panels.add(it) }

        // South panel
        ControlPanel(CardinalDirection.SOUTH).apply {
            add(Breakdown.CircuitSystem(SubmarineSystem.DETECTION, Circuit.GRAY))
            add(Breakdown.CircuitSystem(SubmarineSystem.SPECIAL, Circuit.GRAY))
            add(Breakdown.CircuitSystem(SubmarineSystem.WEAPON, Circuit.GRAY))

            add(Breakdown.System(SubmarineSystem.WEAPON))
            add(Breakdown.Reactor())
            add(Breakdown.System(SubmarineSystem.SPECIAL))
        }.also { panels.add(it) }

        // East panel
        ControlPanel(CardinalDirection.EAST).apply {
            add(Breakdown.CircuitSystem(SubmarineSystem.DETECTION, Circuit.GRAY))
            add(Breakdown.CircuitSystem(SubmarineSystem.SPECIAL, Circuit.GRAY))
            add(Breakdown.CircuitSystem(SubmarineSystem.WEAPON, Circuit.GRAY))

            add(Breakdown.Reactor())
            add(Breakdown.System(SubmarineSystem.DETECTION))
            add(Breakdown.Reactor())
        }.also { panels.add(it) }
    }

    fun isAvailable(system: SubmarineSystem) : Boolean {
        return panels.all { panel ->
            panel.breakdowns
                .filter { it is Breakdown.System && it.type == system }
                .none { it.crossed }
        }
    }
}