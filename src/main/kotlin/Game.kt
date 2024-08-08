import Federation.getFederationId

object Game {
    fun insert(event:String?,country:String?,state:String?,date:String?,meetCountry:String?,meetState:String?,meetTown:String?,meetName:String?,federationName: String?) {
        try {
            val federationId = getFederationId(federationName)
            if(federationId == null) {
                println("federation is not exist")
                return
            }

            InsertExecutor()
                .setTable("game")
                .addColumn("event", event)
                .addColumn("country", country)
                .addColumn("state", state)
                .addColumn("date", date)
                .addColumn("meet_country", meetCountry)
                .addColumn("meet_state", meetState)
                .addColumn("meet_town", meetTown)
                .addColumn("meet_name", meetName)
                .addColumn("federation_id", federationId.toString())
                .execute()
        } catch (e: Exception) {
           e.printStackTrace()
        }
    }

    fun getId(date: String?,meet_name:String?):Long? {
       if(date == null || meet_name == null) {
           return null
       }

        SelectExecutor()
            .select("id")
            .from("game")
            .addWhere("date", date)
            .addWhere("meet_name", meet_name)
            .execute()
            ?.let {
              return it.toLong()
            }
        return null
    }
}