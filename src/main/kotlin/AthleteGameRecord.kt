object AthleteGameRecord {
    /**
     * CREATE TABLE athlete_game_record (
     *                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
     *                                      equipment VARCHAR(255),
     *                                      age FLOAT,
     *                                      age_class VARCHAR(255),
     *                                      birth_year_class VARCHAR(255),
     *                                      division VARCHAR(255),
     *                                      body_weight DOUBLE,
     *                                      weight_class VARCHAR(255),
     *                                      squat1 FLOAT,
     *                                      squat2 FLOAT,
     *                                      squat3 FLOAT,
     *                                      squat4 FLOAT,
     *                                      bench1 FLOAT,
     *                                      bench2 FLOAT,
     *                                      bench3 FLOAT,
     *                                      bench4 FLOAT,
     *                                      deadlift1 FLOAT,
     *                                      deadlift2 FLOAT,
     *                                      deadlift3 FLOAT,
     *                                      deadlift4 FLOAT,
     *                                      total VARCHAR(255),
     *                                      place INT,
     *                                      dots DOUBLE,
     *                                      wilks DOUBLE,
     *                                      glossbrenner DOUBLE,
     *                                      goodlift DOUBLE,
     *                                      tested BOOLEAN,
     *                                      sanctioned BOOLEAN,
     *                                      athlete_id BIGINT NOT NULL,
     *                                      game_id BIGINT NOT NULL,
     *                                      FOREIGN KEY (athlete_id) REFERENCES athlete(id),
     *                                      FOREIGN KEY (game_id) REFERENCES game(id)
     * );
     */

    // insert
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
        bench1: Float?,
        bench2: Float?,
        bench3: Float?,
        bench4: Float?,
        deadlift1: Float?,
        deadlift2: Float?,
        deadlift3: Float?,
        deadlift4: Float?,
        total: String?,
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
               .setTable("athlete_game_record")
               .addColumn("equipment", equipment)
               .addColumn("age", age)
               .addColumn("age_class", ageClass)
               .addColumn("birth_year_class", birthYearClass)
               .addColumn("division", division)
               .addColumn("body_weight", bodyWeight)
               .addColumn("weight_class", weightClass)
               .addColumn("squat1", squat1)
               .addColumn("squat2", squat2)
               .addColumn("squat3", squat3)
               .addColumn("squat4", squat4)
               .addColumn("bench1", bench1)
               .addColumn("bench2", bench2)
               .addColumn("bench3", bench3)
               .addColumn("bench4", bench4)
               .addColumn("deadlift1", deadlift1)
               .addColumn("deadlift2", deadlift2)
               .addColumn("deadlift3", deadlift3)
               .addColumn("deadlift4", deadlift4)
               .addColumn("total", total)
               .addColumn("place", place)
               .addColumn("dots", dots)
               .addColumn("wilks", wilks)
               .addColumn("glossbrenner", glossbrenner)
               .addColumn("goodlift", goodlift)
               .addColumn("tested", tested)
               .addColumn("sanctioned", sanctioned)
               .addColumn("athlete_id", athleteId)
               .addColumn("game_id", gameId)
               .execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}