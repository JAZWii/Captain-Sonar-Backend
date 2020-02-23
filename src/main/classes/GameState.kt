package main.classes

class GameState(var gameSetting: GameSetting) {

    lateinit var boardGame:Array<Array<SeaSpace>>

    fun initializeGame() {
        when(gameSetting.gameType) {
            GameType.TURN_BASE -> {
                boardGame = Array(10) { Array(10) { SeaSpace() } }
            }

            GameType.REAL_TIME -> {
                boardGame = Array(15) { Array(15) { SeaSpace() } }
            }
        }
    }
}