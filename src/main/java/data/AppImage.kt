package data

import javafx.scene.image.Image

class AppImage(var id: Int, var url: String?) {
    val image: Image
        get() = Image(url!!)
}
