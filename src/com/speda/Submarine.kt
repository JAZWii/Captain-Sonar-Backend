package com.speda

class Submarine (private val gameSetting: GameSetting, var currentSeaSpace: SeaSpace) {
    var health: Int = 4
    val firstMateRoom: FirstMateRoom = FirstMateRoom(gameSetting)
    val mines: MutableList<Mine> = mutableListOf()
    val path: MutableList<SeaSpace> = mutableListOf()

    fun moveTo(target: SeaSpace) {
        if(isValid(target)) {
            path.add(currentSeaSpace)
            currentSeaSpace = target
        }
    }

    private fun isValid(space: SeaSpace): Boolean {
        // TODO("not implemented")
        return true
    }
}