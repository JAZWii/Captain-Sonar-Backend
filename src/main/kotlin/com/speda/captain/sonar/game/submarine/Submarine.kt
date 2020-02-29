package com.speda.captain.sonar.game.submarine

import com.speda.captain.sonar.game.board.Mine
import com.speda.captain.sonar.game.board.SeaSpace
import com.speda.captain.sonar.game.model.CardinalDirection
import com.speda.captain.sonar.game.board.GameSetting
import com.speda.captain.sonar.game.role.EngineerRoom
import com.speda.captain.sonar.game.role.FirstMateRoom

class Submarine (private val gameSetting: GameSetting, var currentSeaSpace: SeaSpace) {
    val health = HealthGauge()
    val firstMateRoom = FirstMateRoom(gameSetting)
    val engineerRoom = EngineerRoom(gameSetting)
    val mines = mutableListOf<Mine>()
    val path = mutableListOf<SeaSpace>()

    fun moveTo(target: SeaSpace) {
        if(isValid(target)) {
            path.add(currentSeaSpace)
            currentSeaSpace = target
        }
    }

    fun moveTo(direction: CardinalDirection) {
        if(isValid(direction)) {
            path.add(currentSeaSpace)
            currentSeaSpace = getAdjacentSpace(direction)
        }
    }

    private fun getAdjacentSpace(direction: CardinalDirection): SeaSpace {
        // TODO("not implemented")
        return SeaSpace(0, 0)
    }

    private fun isValid(direction: CardinalDirection): Boolean {
        // TODO("not implemented")
        return true
    }

    private fun isValid(space: SeaSpace): Boolean {
        // TODO("not implemented")
        return true
    }
}