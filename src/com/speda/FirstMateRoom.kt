package com.speda

class FirstMateRoom(gameSetting: GameSetting) {
    val mine: Gauge
    val torpedo: Gauge
    val drone: Gauge
    val sonar: Gauge
    val silence: Gauge
    val scenario: Gauge

    init {
        when(gameSetting.gameType) {

            GameType.TURN_BASE -> {
                mine = Gauge(2, GaugeType.WEAPON_SYSTEM)
                torpedo = Gauge(3, GaugeType.WEAPON_SYSTEM)
                drone = Gauge(3, GaugeType.DETECTION_SYSTEM)
                sonar = Gauge(2, GaugeType.DETECTION_SYSTEM)
                silence = Gauge(5, GaugeType.SPECIAL_SYSTEM)
                scenario = Gauge(4, GaugeType.SPECIAL_SYSTEM)
            }

            GameType.REAL_TIME -> {
                mine = Gauge(3, GaugeType.WEAPON_SYSTEM)
                torpedo = Gauge(3, GaugeType.WEAPON_SYSTEM)
                drone = Gauge(4, GaugeType.DETECTION_SYSTEM)
                sonar = Gauge(3, GaugeType.DETECTION_SYSTEM)
                silence = Gauge(6, GaugeType.SPECIAL_SYSTEM)
                scenario = Gauge(4, GaugeType.SPECIAL_SYSTEM)
            }
        }
    }
}

