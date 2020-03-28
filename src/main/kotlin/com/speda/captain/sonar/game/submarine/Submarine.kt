package com.speda.captain.sonar.game.submarine

import com.speda.captain.sonar.game.board.Mine
import com.speda.captain.sonar.game.board.SeaSpace
import com.speda.captain.sonar.game.model.CardinalDirection
import com.speda.captain.sonar.game.board.GameSetting
import com.speda.captain.sonar.game.board.GameType
import com.speda.captain.sonar.game.role.EngineerRoom
import com.speda.captain.sonar.game.role.FirstMateRoom
import java.util.*

class Submarine (private val gameSetting: GameSetting, var currentSeaSpace: SeaSpace) {
    var canMove = true
    val health = HealthGauge()
    val firstMateRoom = FirstMateRoom(gameSetting)
    val engineerRoom = EngineerRoom(gameSetting)
    val mines = mutableListOf<Mine>()
    val path = mutableListOf<SeaSpace>()

    fun moveTo(target: SeaSpace) {
        if (isValid(target)) {
            path.add(currentSeaSpace)
            currentSeaSpace = target
        }
    }

    fun moveTo(direction: CardinalDirection) {
        if (isValid(direction)) {
            path.add(currentSeaSpace)
            currentSeaSpace = getAdjacentSpace(direction)
        }
    }

    fun showActions(scanner: Scanner): Int {
        println(
            "Select an action:\n"
                    + "1- Move" + if (canMove) "\n" else {"(Action isn't Available)\n"}
                    + "2- place a Mine" + if (firstMateRoom.mine.isReady && engineerRoom.isAvailable(SubmarineSystem.WEAPON)) "\n" else {"(Action isn't Available)\n"}
                    + "3- Fire a Torpedo" + if (firstMateRoom.torpedo.isReady && engineerRoom.isAvailable(SubmarineSystem.WEAPON)) "\n" else {"(Action isn't Available)\n"}
                    + "4- Use Drone" + if (firstMateRoom.drone.isReady && engineerRoom.isAvailable(SubmarineSystem.WEAPON)) "\n" else {"(Action isn't Available)\n"}
                    + "5- Use Sonar" + if (firstMateRoom.sonar.isReady && engineerRoom.isAvailable(SubmarineSystem.WEAPON)) "\n" else {"(Action isn't Available)\n"}
                    + "6- Use Silence" + if (firstMateRoom.silence.isReady && engineerRoom.isAvailable(SubmarineSystem.WEAPON)) "\n" else {"(Action isn't Available)\n"}
                    + "7- Use Scenario" + if (firstMateRoom.scenario.isReady && engineerRoom.isAvailable(SubmarineSystem.WEAPON)) "\n" else {"(Action isn't Available)\n"}
                    + "9- End your turn\n"
                    + "0- Surface"
        )
        return scanner.nextInt()
    }

    fun chooseDirection(scanner: Scanner) {
        var direction: CardinalDirection
        do {
            print(
                "Select a direction:\n"
                        + "1- Move North" + if (isValid(CardinalDirection.NORTH)) "\n" else {"(Can't Move to this direction!)\n"}
                        + "2- Move East" + if (isValid(CardinalDirection.EAST)) "\n" else {"(Can't Move to this direction!)\n"}
                        + "3- Move South" + if (isValid(CardinalDirection.SOUTH)) "\n" else {"(Can't Move to this direction!)\n"}
                        + "4- Move West" + if (isValid(CardinalDirection.WEST)) "\n" else {"(Can't Move to this direction!)\n"}
            )
            var selectedAction: Int = scanner.nextInt()
            direction = when (selectedAction) {
                1 -> CardinalDirection.NORTH
                2 -> CardinalDirection.EAST
                3 -> CardinalDirection.SOUTH
                4 -> CardinalDirection.WEST
                else -> {
                    println("invalid Selection!")
                    return
                }
            }

        } while (!isValid(direction))
        moveTo(direction)
        println("The Submarine has moved to $direction")
        canMove = false;
    }

    fun showAdjacentSpaces() {
        if (isValid(CardinalDirection.NORTH)) "1- Move into North" else "Can't go North"
        if (isValid(CardinalDirection.EAST)) "2- Move into East" else "Can't go East"
        if (isValid(CardinalDirection.SOUTH)) "3- Move into South" else "Can't go South"
        if (isValid(CardinalDirection.WEST)) "4- Move into West" else "Can't go West"
    }

    private fun getAdjacentSpace(direction: CardinalDirection) = when (direction) {
        CardinalDirection.NORTH -> SeaSpace(currentSeaSpace.x, currentSeaSpace.y - 1)
        CardinalDirection.EAST -> SeaSpace(currentSeaSpace.x + 1, currentSeaSpace.y)
        CardinalDirection.SOUTH -> SeaSpace(currentSeaSpace.x, currentSeaSpace.y + 1)
        CardinalDirection.WEST -> SeaSpace(currentSeaSpace.x - 1, currentSeaSpace.y)
    }

    private fun isValid(direction: CardinalDirection) = isValid(getAdjacentSpace(direction))

    private fun isValid(space: SeaSpace) = when {
        path.contains(space) -> false
        else -> when (gameSetting.gameType) {
            GameType.REAL_TIME -> space.x < 15 && space.y < 15
            GameType.TURN_BASE -> space.x < 10 && space.y < 10
        }
    }
}