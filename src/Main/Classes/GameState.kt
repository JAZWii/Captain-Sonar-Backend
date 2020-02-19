package Main.Classes

class GameState(var gameSetting: GameSetting) {

    fun initializeGame() {
        when(gameSetting.gameType) {
            GameType.TURN_BASE -> {

            }

            GameType.REAL_TIME -> {

            }
        }
    }
}