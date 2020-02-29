package com.speda.captain.sonar.game

import com.speda.captain.sonar.game.board.SeaSpace
import com.speda.captain.sonar.game.board.GameSetting
import com.speda.captain.sonar.game.board.GameType

class GameState(var gameSetting: GameSetting) {
    val boardGame: Array<Array<SeaSpace>>

    init {
        val boardSize = when (gameSetting.gameType) {
            GameType.TURN_BASE -> 10
            GameType.REAL_TIME -> 15
        }

        boardGame = Array(boardSize) { x -> Array(boardSize) { y -> SeaSpace(x, y) } }
    }
}