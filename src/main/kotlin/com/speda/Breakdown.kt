package com.speda


sealed class Breakdown {
    var crossed: Boolean = false
    class Reactor : Breakdown()
    open class System(val type: SubmarineSystem) : Breakdown()
    class CircuitSystem(type: SubmarineSystem, val circuit: Circuit) : Breakdown.System(type)



}