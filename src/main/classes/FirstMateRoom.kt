package main.classes

class FirstMateRoom {
    var mine: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.WEAPON_SYSTEM)
    var torpedo: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.WEAPON_SYSTEM)
    var drone: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.DETECTION_SYSTEM)
    var sonar: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.DETECTION_SYSTEM)
    var silence: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.SPECIAL_SYSTEM)
    var scenario: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.SPECIAL_SYSTEM)

    fun initializeFirstMateRoom(gameSetting:GameSetting) {
        when(gameSetting.gameType) {
            GameType.TURN_BASE -> {
                var mine: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.WEAPON_SYSTEM)
                var torpedo: Gauge = Gauge(Array<Int>(3) { (0) }, GaugeType.WEAPON_SYSTEM)
                var drone: Gauge = Gauge(Array<Int>(3) { (0) }, GaugeType.DETECTION_SYSTEM)
                var sonar: Gauge = Gauge(Array<Int>(2) { (0) }, GaugeType.DETECTION_SYSTEM)
                var silence: Gauge = Gauge(Array<Int>(5) { (0) }, GaugeType.SPECIAL_SYSTEM)
                var scenario: Gauge = Gauge(Array<Int>(4) { (0) }, GaugeType.SPECIAL_SYSTEM)
            }

            GameType.REAL_TIME -> {
                var mine: Gauge = Gauge(Array<Int>(3) { (0) }, GaugeType.WEAPON_SYSTEM)
                var torpedo: Gauge = Gauge(Array<Int>(3) { (0) }, GaugeType.WEAPON_SYSTEM)
                var drone: Gauge = Gauge(Array<Int>(4) { (0) }, GaugeType.DETECTION_SYSTEM)
                var sonar: Gauge = Gauge(Array<Int>(3) { (0) }, GaugeType.DETECTION_SYSTEM)
                var silence: Gauge = Gauge(Array<Int>(6) { (0) }, GaugeType.SPECIAL_SYSTEM)
                var scenario: Gauge = Gauge(Array<Int>(4) { (0) }, GaugeType.SPECIAL_SYSTEM)
            }
        }
    }
}

