package com.speda

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