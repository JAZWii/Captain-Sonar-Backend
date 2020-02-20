package Test

import Main.Classes.GameSetting
import Main.Classes.GameState
import Main.Classes.GameType
import java.util.*

fun testGame(){
    val gameSetting = GameSetting(GameType.TURN_BASE, true)
    val gameState = GameState(gameSetting)

    val scanner = Scanner(System.`in`)

    var mainMenuSelection:Int
    do {
        println("Welcome to Captain Sonar Board Game:\n" +
                "1- Start Game\n" +
                "2- Game Setting\n" +
                "3- Exit Game")

        mainMenuSelection = scanner.nextInt()

        when(mainMenuSelection){
            1 -> {
                startGame(gameState, scanner)
            }

            2 -> {
                modifySettings(gameState, scanner)
            }
            3 -> {
                println("Bye Bye!")
            }
            else -> {
                println("Please Select a valid Option!")
            }
        }
    }while (mainMenuSelection != 3)
}

fun startGame(gameState: GameState, scanner:Scanner){

}

fun modifySettings(gameState: GameState, scanner:Scanner){
    do {
        println("Settings:\n" +
                "1- Change the Game Type\n" +
                "2- Change Friendly Fire\n" +
                "3- Back")

        var settingsSelection = scanner.nextInt()

        when(settingsSelection){
            1 -> {
                modifyGameType(gameState, scanner)
            }

            2 -> {
                modifyFriendlyFire(gameState, scanner)
            }
            3 -> {
                println("Bye Bye!")
            }
            else -> {
                println("Please Select a valid Option!")
            }
        }
    }while (settingsSelection != 3)
}

fun modifyGameType(gameState: GameState, scanner:Scanner){
    do {
        println("Game Type:\n" +
                "1- Turn-Base Game\n" +
                "2- Real-Time Game\n" +
                "3- Back")

        var settingsSelection = scanner.nextInt()

        when(settingsSelection){
            1 -> {
                gameState.gameSetting.gameType = GameType.TURN_BASE
            }

            2 -> {
                gameState.gameSetting.gameType = GameType.REAL_TIME
            }
            3 -> {

            }
            else -> {
                println("Please Select a valid Option!")
            }
        }
    }while (settingsSelection != 1 || settingsSelection != 2 || settingsSelection != 3)
}

fun modifyFriendlyFire(gameState: GameState, scanner:Scanner){
    do {
        println("Friendly Fire:\n" +
                "1- Enabled\n" +
                "2- Disabled\n" +
                "3- Back")

        var settingsSelection = scanner.nextInt()

        when(settingsSelection){
            1 -> {
                gameState.gameSetting.friendlyFire = true
            }

            2 -> {
                gameState.gameSetting.friendlyFire = false
            }
            3 -> {

            }
            else -> {
                println("Please Select a valid Option!")
            }
        }
    }while (settingsSelection != 1 || settingsSelection != 2 || settingsSelection != 3)
}