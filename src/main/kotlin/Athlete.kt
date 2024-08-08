object Athlete {
    fun insert(name:String?,sex:String?) {
        try {
            InsertExecutor()
                .setTable("athlete")
                .addColumn("name", name)
                .addColumn("sex",sex)
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
            .addWhere("name", name)
            .execute()
            ?.let {
                return it.toLong()
            }
        return null
    }
}