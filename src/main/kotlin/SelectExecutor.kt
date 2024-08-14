import java.sql.PreparedStatement

class SelectExecutor {
    private var selectValue:String = ""
    private var tableName:String = ""
    class Where (
        val columnName: String,
        val value: Any
    )
    private val whereList = mutableListOf<Where>()
    private var limit:Int? = null

    fun select(selectValue:String) : SelectExecutor {
        this.selectValue = selectValue
        return this
    }

    fun from(tableName:String) : SelectExecutor {
        this.tableName = tableName
        return this
    }

    fun where(columnName:String, value:Any) : SelectExecutor {
        whereList.add(Where(columnName, value))
        return this
    }

    fun limit(limit:Int) : SelectExecutor {
        this.limit = limit
        return this
    }

    fun execute() : String? {
        val whereClause = whereList.joinToString(" and ") { "${it.columnName} = ?" }
        var sql = "select $selectValue from $tableName"
        if(whereClause.isNotBlank()) sql+=" where $whereClause"
        if(limit != null) sql+=" limit $limit"
        val preparedStatement = getPreparedStatement(sql)
        val resultSet = preparedStatement.executeQuery()
        var result:String? = null
        while (resultSet.next()) {
            result = resultSet.getString(1)
        }
        resultSet.close()
        preparedStatement.close()
        return result
    }

    fun getPreparedStatement(sql:String) : PreparedStatement {
        val connection = Database.getConnection()
        val preparedStatement = connection.prepareStatement(sql)
        for((i, where) in whereList.withIndex()) {
            val index = i + 1
            val value = where.value
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