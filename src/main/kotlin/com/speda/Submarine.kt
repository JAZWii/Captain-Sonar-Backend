package com.speda

class Submarine (private val gameSetting: GameSetting, var currentSeaSpace: SeaSpace) {
    var health = 4
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
        return SeaSpace(0,0)
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