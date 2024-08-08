import java.sql.Connection
import java.sql.DriverManager

object Database {
    private var connection : Connection? = null

    fun getConnection() : Connection {
        if(connection == null) {
            connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD)
        }
        return connection!!
    }
}