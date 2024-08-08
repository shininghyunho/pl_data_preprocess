import java.sql.Connection
import java.sql.DriverManager

// TODO : AWS RDS 정보 입력
const val url = ""
const val user = ""
const val password = ""

object AwsDB {
    private var connection : Connection? = null

    fun getConnection() : Connection {
        if(connection == null) {
            connection = DriverManager.getConnection(url, user, password)
        }
        return connection!!
    }
}