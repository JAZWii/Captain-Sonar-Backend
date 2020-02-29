package test

import com.speda.captain.sonar.game.GameState
import com.speda.captain.sonar.game.board.GameSetting
import com.speda.captain.sonar.game.board.GameType
import com.speda.captain.sonar.game.board.SeaSpace
import com.speda.captain.sonar.game.submarine.Submarine
import java.util.*

fun main(){
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
            1 -> startGame(gameState, scanner)
            2 -> modifySettings(gameState, scanner)
            3 -> println("Bye Bye!")
            else -> println("Please Select a valid Option!")
        }
    } while (mainMenuSelection != 1 && mainMenuSelection != 3)
}

fun startGame(gameState: GameState, scanner:Scanner){
    val yellowInitialPoint = getCoordinatesFor("Yellow ship", scanner)
    val blueInitialPoint = getCoordinatesFor("Yellow ship", scanner)
    val yellowSubmarine = Submarine(gameState.gameSetting, yellowInitialPoint)
    val blueSubmarine = Submarine(gameState.gameSetting, blueInitialPoint)
    drawGameBoard(gameState, yellowSubmarine, blueSubmarine)
}


// Ui = function(state)
fun drawGameBoard(gameState: GameState, yellowSubmarine: Submarine, blueSubmarine: Submarine) {

    println("=".repeat(gameState.boardGame.size * 3 + 2))

    for(row in gameState.boardGame){
        print("|")
        for(seaSpace in row){
            val cell = when (seaSpace) {
                yellowSubmarine.currentSeaSpace -> "Y"
                blueSubmarine.currentSeaSpace -> "B"
                else -> " "
            }

            print(" $cell ")
        }
        print("|\n")
    }

    println("=".repeat(gameState.boardGame.size * 3 + 2))
}


fun modifySettings(gameState: GameState, scanner:Scanner){
    do {
        println("Settings:\n" +
                "1- Change the Game Type\n" +
                "2- Change Friendly Fire\n" +
                "3- Back")

        val settingsSelection = scanner.nextInt()

        when(settingsSelection){
            1 -> modifyGameType(gameState, scanner)
            2 -> modifyFriendlyFire(gameState, scanner)
            3 -> { }
            else -> println("Please Select a valid Option!")
        }
    } while (settingsSelection != 3)
}

fun modifyGameType(gameState: GameState, scanner:Scanner){
    do {
        println("Game Type:\n" +
                "1- Turn-Base Game\n" +
                "2- Real-Time Game\n" +
                "3- Back")

        val settingsSelection = scanner.nextInt()

        when(settingsSelection){
            1 -> gameState.gameSetting.gameType = GameType.TURN_BASE

            2 -> gameState.gameSetting.gameType = GameType.REAL_TIME
            3 -> { }
            else -> println("Please Select a valid Option!")
        }
    }while (settingsSelection != 1 && settingsSelection != 2 && settingsSelection != 3)
}

fun modifyFriendlyFire(gameState: GameState, scanner:Scanner){
    do {
        println("Friendly Fire:\n" +
                "1- Enabled\n" +
                "2- Disabled\n" +
                "3- Back")
        val settingsSelection = scanner.nextInt()

        when(settingsSelection){
            1 -> gameState.gameSetting.friendlyFire = true
            2 -> gameState.gameSetting.friendlyFire = false
            3 -> { }
            else -> println("Please Select a valid Option!")
        }
    } while (settingsSelection != 1 && settingsSelection != 2 && settingsSelection != 3)
}


fun getCoordinatesFor(name: String, scanner: Scanner): SeaSpace {
    print("Enter coordinates for $name [x, y] > ")

    val coordinatesRegex: Regex = Regex("""\d+[,\s]+\d+""")
    val splitRegex: Regex = Regex("""[,\s]+""")
    while (!scanner.hasNext(coordinatesRegex.pattern)){
        scanner.nextLine()
        print("Invalid coordinates!! Try again [x, y] > ")
    }
    val line = scanner.next(coordinatesRegex.pattern)
    val input = line.split(splitRegex)
    return SeaSpace(input[0].toInt(), input[1].toInt())
}