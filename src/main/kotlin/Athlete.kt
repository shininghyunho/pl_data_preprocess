object Athlete {
    fun insert(name:String?,sex:String?) {
        try {
            InsertExecutor()
                .table("athlete")
                .column("name", name)
                .column("sex",sex)
                .execute()
        } catch (e: Exception) {
            //e.printStackTrace()
        }
    }

    fun getId(name:String?):Long? {
        if (name == null) {
            return null
        }
        SelectExecutor()
            .select("id")
            .from("athlete")
            .where("name", name)
            .execute()
            ?.let {
                return it.toLong()
            }
        return null
    }

    fun getAthletes(limit:Int=10) : String? {
        return SelectExecutor()
            .select("*")
            .from("athlete")
            .limit(limit)
            .execute()
    }
}