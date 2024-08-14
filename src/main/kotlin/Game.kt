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
                .table("game")
                .column("event", event)
                .column("country", country)
                .column("state", state)
                .column("date", date)
                .column("meet_country", meetCountry)
                .column("meet_state", meetState)
                .column("meet_town", meetTown)
                .column("meet_name", meetName)
                .column("federation_id", federationId.toString())
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
            .where("date", date)
            .where("meet_name", meet_name)
            .execute()
            ?.let {
              return it.toLong()
            }
        return null
    }
}