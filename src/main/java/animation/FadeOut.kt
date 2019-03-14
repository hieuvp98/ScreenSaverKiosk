package animation

import abstractAnim.Anim
import javafx.animation.FadeTransition
import javafx.scene.Node
import javafx.util.Duration

class FadeOut(node: Node) : Anim(node) {
    init {
        config()
    }

    override fun config() {
        val fadeTransition = FadeTransition()
        fadeTransition.node = this.node
        fadeTransition.duration = Duration(2000.0)
        fadeTransition.fromValue = 1.0
        fadeTransition.toValue = 0.0
        //  fadeTransition.setCycleCount(1);
        fadeTransition.isAutoReverse = true
        this.transition = fadeTransition
    }
}
