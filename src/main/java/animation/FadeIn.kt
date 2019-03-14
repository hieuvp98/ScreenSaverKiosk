package animation

import abstractAnim.Anim
import javafx.animation.FadeTransition
import javafx.scene.Node
import javafx.util.Duration

class FadeIn(node: Node) : Anim(node) {
    init {
        config()
    }

    override fun config() {
        val fadeTransition = FadeTransition()
        fadeTransition.node = this.node
        fadeTransition.duration = Duration(2000.0)
        fadeTransition.fromValue = 0.0
        fadeTransition.toValue = 1.0
        fadeTransition.cycleCount = 1
        fadeTransition.isAutoReverse = true
        this.transition = fadeTransition
    }
}
