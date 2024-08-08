import java.sql.PreparedStatement

class InsertExecutor {
    var tableName: String = ""

    val columns = mutableListOf<column>()
    class column (
        val name: String,
        val value : Any
    )

    fun setTable(tableName:String) : InsertExecutor {
        this.tableName = tableName
        return this
    }

    fun addColumn(columnName:String, value:Any?) : InsertExecutor {
        value?.let {
            columns.add(column(columnName, it))
        }
        return this
    }
    fun execute()  {
        val columnNames = columns.joinToString(",") { it.name }
        val columnValues = columns.joinToString(",") { "?" }
        val sql = "insert into $tableName ($columnNames) values ($columnValues)"
        execute(sql)
    }

    private fun execute(sql : String) {
        val preparedStatement = getPreparedStatement(sql)
        preparedStatement.executeUpdate()
        preparedStatement.close()
    }

    private fun getPreparedStatement(sql:String) : PreparedStatement {
        val connection = Database.getConnection()
        val preparedStatement = connection.prepareStatement(sql)
        for((i, column) in columns.withIndex()) {
            val index = i + 1
            val value = column.value
            when(value) {
                is String -> preparedStatement.setString(index, value)
                is Int -> preparedStatement.setInt(index, value)
                is Long -> preparedStatement.setLong(index, value)
                is Double -> preparedStatement.setDouble(index, value)
                is Float -> preparedStatement.setFloat(index, value)
                is Boolean -> preparedStatement.setBoolean(index, value)
            }
        }
        return preparedStatement
    }
}
