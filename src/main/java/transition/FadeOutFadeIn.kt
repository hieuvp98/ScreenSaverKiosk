package transition

import abstractAnim.Anim
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import org.reactfx.util.FxTimer

import java.time.Duration

class FadeOutFadeIn(private val imageView1: ImageView, private val imageView2: ImageView, private val next: Image, private val firstAnim: Anim, private val secondAnim: Anim)  {

     fun start() {
        imageView2.image = next
        imageView2.opacity = 0.0
        this.firstAnim.transition.setOnFinished { imageView1.opacity = 0.0 }
        this.firstAnim.start()
        FxTimer.runLater(Duration.ofMillis(1000)) {
            imageView2.opacity = 0.0
            this.secondAnim.transition.setOnFinished {
                imageView1.image = next
                imageView1.opacity = 1.0
                imageView2.opacity = 0.0
            }
            this.secondAnim.start()
        }
    }

}
