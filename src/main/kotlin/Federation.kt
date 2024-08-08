object Federation {
    // federation 이름이 중복 되는지 여부
    private fun isDuplicatedFederation(name:String) : Boolean {
       SelectExecutor()
            .select("id")
            .from("federation")
            .addWhere("name", name)
            .execute()
            ?.let {
                return true
            }
        return false
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