package data

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

internal object MySQLConnect {
    // Kết nối vào MySQL.
    val mySQLConnection: Connection
        @Throws(SQLException::class)
        get() {
            val hostName = "localhost"
            val dbName = "screensaver"
            val userName = "root"
            val password = "root"
            return getMySQLConnection(hostName, dbName, userName, password)
        }

    @Throws(SQLException::class)
    private fun getMySQLConnection(hostName: String, dbName: String,
                                   userName: String, password: String): Connection {
        val connectionURL = "jdbc:mysql://$hostName:3306/$dbName"
        DriverManager.registerDriver(com.mysql.cj.jdbc.Driver())
        return DriverManager.getConnection(connectionURL, userName,
                password)
    }
}
