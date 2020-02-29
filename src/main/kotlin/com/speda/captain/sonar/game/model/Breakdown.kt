package com.speda.captain.sonar.game.model

import com.speda.captain.sonar.game.submarine.SubmarineSystem


sealed class Breakdown {
    var crossed: Boolean = false
    class Reactor : Breakdown()
    open class System(val type: SubmarineSystem) : Breakdown()
    class CircuitSystem(type: SubmarineSystem, val circuit: Circuit) : System(type)



}