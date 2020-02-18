package Main.Classes

class GameState(private var gameSetting: GameSetting) {

    fun setSettings(gameType:GameType, friendlyFire:Boolean){
        gameSetting = GameSetting(gameType,friendlyFire)
    }

    fun initializeGame(){
        if(gameSetting.gameType == GameType.TURN_BASE){

        }else{

        }
    }
}