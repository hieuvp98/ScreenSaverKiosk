package data

import javafx.scene.image.Image
import java.sql.Connection
import java.sql.SQLException
import java.util.*

class AppImageService {

    fun findAllImage(): List<Image>? {
        val connection: Connection
        try {
            connection = MySQLConnect.mySQLConnection
            val statement = connection.createStatement()
            val sql = "select * from image"
            val resultSet = statement.executeQuery(sql)
            val images = LinkedList<Image>()
            while (resultSet.next()) {
                images.add(AppImage(resultSet.getInt("id"), resultSet.getString("url")).image)
            }
            connection.close()
            return images
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return null
    }
}
