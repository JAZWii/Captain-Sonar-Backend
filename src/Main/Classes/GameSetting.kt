package Main.Classes

class GameSetting {
    var gameType:GameType = GameType.TURN_BASE
    var friendlyFire:Boolean = true

    constructor(gameType: GameType, friendlyFire: Boolean) {
        this.gameType = gameType
        this.friendlyFire = friendlyFire
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}

enum class GameType(val typeNumber: Int) {
    TURN_BASE(0),
    REAL_TIME(1),
}