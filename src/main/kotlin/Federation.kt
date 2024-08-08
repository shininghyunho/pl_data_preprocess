object Federation {
    fun showFederation(limit:Int = 10) {
        val statement = AwsDB.getConnection().createStatement()
        val resultSet = statement.executeQuery("SELECT * FROM federation limit $limit")
        println("id, name, parent_federation_id")
        while (resultSet.next()) {
            println("${resultSet.getLong(1)}, ${resultSet.getString(2)}, ${resultSet.getLong(3)}")
        }
        resultSet.close()
        statement.close()
    }

    // federation 이름이 중복 되는지 여부
    private fun isDuplicatedFederation(name:String) : Boolean {
        var isDuplicated = false
        try {
            val sql = "select * from federation where name = (?)"
            val preparedStatement = AwsDB.getConnection().prepareStatement(sql)
            preparedStatement.setString(1, name)

            val resultSet = preparedStatement.executeQuery()
            while (resultSet.next()) {
                isDuplicated = true
            }
            resultSet.close()
            preparedStatement.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return isDuplicated
    }

    // get federation id
    fun getFederationId(name:String?) : Long? {
        if(name == null) {
            return null
        }
       SelectExecutor()
            .select("id")
            .from("federation")
            .addWhere("name", name)
            .execute()
            ?.let {
                return it.toLong()
            }
        return null
    }

    // insert federation
    fun insertFederation(name:String, parentName:String?) {
        try {
            // 이름이 중복되는지 확인
            if (isDuplicatedFederation(name)) {
                return
            }
            // 부모가 없다면 생성
            if(!parentName.isNullOrBlank() && !isDuplicatedFederation(parentName)) {
                insertFederation(parentName, null)
            }

            // 부모가 있다면
            val parentFederationId =getFederationId(parentName)
            InsertExecutor()
                .setTable("federation")
                .addColumn("name", name)
                .addColumn("parent_federation_id", parentFederationId)
                .execute()
        } catch (e: Exception) {
            //e.printStackTrace()
        }
    }
}