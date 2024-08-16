object AthleteGameRecord {
    fun insert(
        equipment: String?,
        age: Float?,
        ageClass: String?,
        birthYearClass: String?,
        division: String?,
        bodyWeight: Double?,
        weightClass: String?,
        squat1: Float?,
        squat2: Float?,
        squat3: Float?,
        squat4: Float?,
        bestSquat: Float?,
        bench1: Float?,
        bench2: Float?,
        bench3: Float?,
        bench4: Float?,
        bestBench: Float?,
        deadlift1: Float?,
        deadlift2: Float?,
        deadlift3: Float?,
        deadlift4: Float?,
        bestDeadlift: Float?,
        total: Float?,
        place: Int?,
        dots: Double?,
        wilks: Double?,
        glossbrenner: Double?,
        goodlift: Double?,
        tested: Boolean?,
        sanctioned: Boolean?,
        athleteId: Long?,
        gameId: Long?
    ) {
        try {
           InsertExecutor()
               .table("athlete_game_record")
               .column("equipment", equipment)
               .column("age", age)
               .column("age_class", ageClass)
               .column("birth_year_class", birthYearClass)
               .column("division", division)
               .column("body_weight", bodyWeight)
               .column("weight_class", weightClass)
               .column("squat1", squat1)
               .column("squat2", squat2)
               .column("squat3", squat3)
               .column("squat4", squat4)
               .column("best_squat", bestSquat)
               .column("bench1", bench1)
               .column("bench2", bench2)
               .column("bench3", bench3)
               .column("bench4", bench4)
                .column("best_bench", bestBench)
               .column("deadlift1", deadlift1)
               .column("deadlift2", deadlift2)
               .column("deadlift3", deadlift3)
               .column("deadlift4", deadlift4)
                .column("best_deadlift", bestDeadlift)
               .column("total", total)
               .column("place", place)
               .column("dots", dots)
               .column("wilks", wilks)
               .column("glossbrenner", glossbrenner)
               .column("goodlift", goodlift)
               .column("tested", tested)
               .column("sanctioned", sanctioned)
               .column("athlete_id", athleteId)
               .column("game_id", gameId)
               .execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}