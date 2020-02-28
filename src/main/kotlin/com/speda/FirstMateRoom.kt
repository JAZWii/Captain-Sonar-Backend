package com.speda

class FirstMateRoom(gameSetting: GameSetting) {
    val health: HealthGauge
    val mine: SystemGauge
    val torpedo: SystemGauge
    val drone: SystemGauge
    val sonar: SystemGauge
    val silence: SystemGauge
    val scenario: SystemGauge

    init {
        when(gameSetting.gameType) {

            GameType.TURN_BASE -> {
                health = HealthGauge()
                mine = SystemGauge(2, SubmarineSystem.WEAPON)
                torpedo = SystemGauge(3, SubmarineSystem.WEAPON)
                drone = SystemGauge(3, SubmarineSystem.DETECTION)
                sonar = SystemGauge(2, SubmarineSystem.DETECTION)
                silence = SystemGauge(5, SubmarineSystem.SPECIAL)
                scenario = SystemGauge(4, SubmarineSystem.SPECIAL)
            }

            GameType.REAL_TIME -> {
                health = HealthGauge()
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

