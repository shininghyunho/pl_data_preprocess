import java.sql.Connection
import java.sql.DriverManager

object Database {
    private var connection : Connection? = null

    fun getConnection() : Connection {
        if(connection == null) {
            connection = DriverManager.getConnection(DatabaseConfig.url, DatabaseConfig.user, DatabaseConfig.password)
        }
        return connection!!
    }
}