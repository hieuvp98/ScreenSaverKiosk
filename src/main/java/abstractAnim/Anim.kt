package abstractAnim

import javafx.animation.Transition
import javafx.scene.Node

abstract class Anim(var node: Node) {
    lateinit var transition: Transition

    abstract fun config()

    fun start() {
        transition.play()
    }
}
