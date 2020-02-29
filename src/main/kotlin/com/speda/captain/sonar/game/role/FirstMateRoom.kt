package com.speda.captain.sonar.game.role

import com.speda.captain.sonar.game.board.GameSetting
import com.speda.captain.sonar.game.board.GameType
import com.speda.captain.sonar.game.submarine.SubmarineSystem

class FirstMateRoom(gameSetting: GameSetting) {
    val mine: SystemGauge
    val torpedo: SystemGauge
    val drone: SystemGauge
    val sonar: SystemGauge
    val silence: SystemGauge
    val scenario: SystemGauge

    init {
        when (gameSetting.gameType) {

            GameType.TURN_BASE -> {
                mine = SystemGauge(2, SubmarineSystem.WEAPON)
                torpedo = SystemGauge(3, SubmarineSystem.WEAPON)
                drone = SystemGauge(3, SubmarineSystem.DETECTION)
                sonar = SystemGauge(2, SubmarineSystem.DETECTION)
                silence = SystemGauge(5, SubmarineSystem.SPECIAL)
                scenario = SystemGauge(4, SubmarineSystem.SPECIAL)
            }

            GameType.REAL_TIME -> {
                mine = SystemGauge(3, SubmarineSystem.WEAPON)
                torpedo = SystemGauge(3, SubmarineSystem.WEAPON)
                drone = SystemGauge(4, SubmarineSystem.DETECTION)
                sonar = SystemGauge(3, SubmarineSystem.DETECTION)
                silence = SystemGauge(6, SubmarineSystem.SPECIAL)
                scenario = SystemGauge(4, SubmarineSystem.SPECIAL)
            }
        }
    }
}

