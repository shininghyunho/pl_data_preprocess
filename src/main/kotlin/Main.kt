import java.io.File
import java.nio.file.Paths

val openPLSample = Paths.get("sample_data", "openpowerlifting-2024-07-13-16cc7ca6-sample.csv").toAbsolutePath().toString()
val openIpfSample = Paths.get("sample_data", "openipf-2024-07-13-16cc7ca6-sample.csv").toAbsolutePath().toString()

fun main() {
    printAllColumnName(openPLSample)
//    printTypeValues(openPLSample,"Sex")
//    testDB() # TODO  실제 DB를 사용하려면  DatabaseConfig.kt 파일을 수정해야 합니다.
//    insertFederation(openPLSample)
//    insertAthlete(openPLSample)
//    insertGame(openPLSample)
//    insertAthleteGameRecord(openPLSample)
}

// print all columns
fun printAllColumnName(path: String) {
    try {
        val lines = File(path).readLines(Charsets.UTF_8)
        val columnNames = lines[0].split(",").map { it.trim() }
        // index, column name
        for ((index, columnName) in columnNames.withIndex()) {
            println("$index, $columnName")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

// print federation, parentFederation
fun printFederation(path: String) {
    try {
        val lines = File(path).readLines(Charsets.UTF_8)
        val columnNames = lines[0].split(",").map { it.trim() }
        val federationIndex = columnNames.indexOf("Federation")
        val parentFederationIndex = columnNames.indexOf("ParentFederation")
        for (line in lines.subList(1, 10)) {
            val values = line.split(",")
            val federation = values[federationIndex]
            val parentFederation = values[parentFederationIndex]
            println("federation: $federation, parentFederation: $parentFederation")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun insertFederation(path: String) {
    try {
        val lines = File(path).readLines(Charsets.UTF_8)
        val columnNames = lines[0].split(",").map { it.trim() }
        val federationIndex = columnNames.indexOf("Federation")
        val parentFederationIndex = columnNames.indexOf("ParentFederation")
        for (line in lines.subList(1,lines.size )) {
            val values = line.split(",")
            val federation = values[federationIndex]
            val parentFederation = values[parentFederationIndex]
            Federation.insertFederation(federation, parentFederation)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    println("insert federation done")
}

fun insertAthlete(path: String) {
    try {
        val lines = File(path).readLines(Charsets.UTF_8)
        val columnNames = lines[0].split(",").map { it.trim() }
        val nameIndex = columnNames.indexOf("Name")
        val sexIndex = columnNames.indexOf("Sex")
        for (line in lines.subList(1,lines.size )) {
            val values = line.split(",")
            val name = values[nameIndex]
            val sex = values[sexIndex]
            Athlete.insert(name, sex)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    println("insert athlete done")
}

fun insertGame(path: String) {
    try {
       val lines = File(path).readLines(Charsets.UTF_8)
        val columnNames = lines[0].split(",").map { it.trim() }
        val eventIndex = columnNames.indexOf("Event")
        val countryIndex = columnNames.indexOf("Country")
        val stateIndex = columnNames.indexOf("State")
        val dateIndex = columnNames.indexOf("Date")
        val meetCountryIndex = columnNames.indexOf("MeetCountry")
        val meetStateIndex = columnNames.indexOf("MeetState")
        val meetTownIndex = columnNames.indexOf("MeetTown")
        val meetNameIndex = columnNames.indexOf("MeetName")
        val federationIndex = columnNames.indexOf("Federation")
        for (line in lines.subList(1,lines.size )) {
            val values = line.split(",")
            val event = values[eventIndex]
            val country = values[countryIndex]
            val state = values[stateIndex]
            val date = values[dateIndex]
            val meetCountry = values[meetCountryIndex]
            val meetState = values[meetStateIndex]
            val meetTown = values[meetTownIndex]
            val meetName = values[meetNameIndex]
            val federationName = values[federationIndex]
            Game.insert(event, country, state, date, meetCountry, meetState, meetTown, meetName, federationName)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    println("insert game done")
}

fun insertAthleteGameRecord(path: String) {
    try {
        val lines = File(path).readLines(Charsets.UTF_8)
        val columnNames = lines[0].split(",").map { it.trim() }
        val equipmentIndex = columnNames.indexOf("Equipment")
        val ageIndex = columnNames.indexOf("Age")
        val ageClassIndex = columnNames.indexOf("AgeClass")
        val birthYearClassIndex = columnNames.indexOf("BirthYearClass")
        val divisionIndex = columnNames.indexOf("Division")
        val bodyWeightIndex = columnNames.indexOf("BodyweightKg")
        val weightClassIndex = columnNames.indexOf("WeightClassKg")
        val squat1Index = columnNames.indexOf("Squat1Kg")
        val squat2Index = columnNames.indexOf("Squat2Kg")
        val squat3Index = columnNames.indexOf("Squat3Kg")
        val squat4Index = columnNames.indexOf("Squat4Kg")
        val bestSquat = columnNames.indexOf("Best3SquatKg")
        val bench1Index = columnNames.indexOf("Bench1Kg")
        val bench2Index = columnNames.indexOf("Bench2Kg")
        val bench3Index = columnNames.indexOf("Bench3Kg")
        val bench4Index = columnNames.indexOf("Bench4Kg")
        val bestBench = columnNames.indexOf("Best3BenchKg")
        val deadlift1Index = columnNames.indexOf("Deadlift1Kg")
        val deadlift2Index = columnNames.indexOf("Deadlift2Kg")
        val deadlift3Index = columnNames.indexOf("Deadlift3Kg")
        val deadlift4Index = columnNames.indexOf("Deadlift4Kg")
        val bestDeadlift = columnNames.indexOf("Best3DeadliftKg")
        val totalIndex = columnNames.indexOf("TotalKg")
        val placeIndex = columnNames.indexOf("Place")
        val dotsIndex = columnNames.indexOf("Dots")
        val wilksIndex = columnNames.indexOf("Wilks")
        val glossbrennerIndex = columnNames.indexOf("Glossbrenner")
        val goodliftIndex = columnNames.indexOf("Goodlift")
        val testedIndex = columnNames.indexOf("Tested")
        val sanctionedIndex = columnNames.indexOf("Sanctioned")
        val nameIdx = columnNames.indexOf("Name")
        val dateIndex = columnNames.indexOf("Date")
        val meetNameIndex = columnNames.indexOf("MeetName")

        for (line in lines.subList(1,lines.size )) {
            val values = line.split(",")
            val equipment = values[equipmentIndex]
            val age = values[ageIndex].toFloatOrNull()
            val ageClass = values[ageClassIndex]
            val birthYearClass = values[birthYearClassIndex]
            val division = values[divisionIndex]
            val bodyWeight = values[bodyWeightIndex].toDoubleOrNull()
            val weightClass = values[weightClassIndex]
            val squat1 = values[squat1Index].toFloatOrNull()
            val squat2 = values[squat2Index].toFloatOrNull()
            val squat3 = values[squat3Index].toFloatOrNull()
            val squat4 = values[squat4Index].toFloatOrNull()
            val bestSquat = values[bestSquat].toFloatOrNull()
            val bench1 = values[bench1Index].toFloatOrNull()
            val bench2 = values[bench2Index].toFloatOrNull()
            val bench3 = values[bench3Index].toFloatOrNull()
            val bench4 = values[bench4Index].toFloatOrNull()
            val bestBench = values[bestBench].toFloatOrNull()
            val deadlift1 = values[deadlift1Index].toFloatOrNull()
            val deadlift2 = values[deadlift2Index].toFloatOrNull()
            val deadlift3 = values[deadlift3Index].toFloatOrNull()
            val deadlift4 = values[deadlift4Index].toFloatOrNull()
            val bestDeadlift = values[bestDeadlift].toFloatOrNull()
            val total = values[totalIndex].toFloatOrNull()
            val place = values[placeIndex].toIntOrNull()
            val dots = values[dotsIndex].toDoubleOrNull()
            val wilks = values[wilksIndex].toDoubleOrNull()
            val glossbrenner = values[glossbrennerIndex].toDoubleOrNull()
            val goodlift = values[goodliftIndex].toDoubleOrNull()
            val tested = values[testedIndex].toBoolean()
            val sanctioned = values[sanctionedIndex].toBoolean()
            val athleteName = values[nameIdx]
            val date = values[dateIndex]
            val meetName = values[meetNameIndex]

            val athleteId = Athlete.getId(athleteName)
            val gameId = Game.getId(date, meetName)
            AthleteGameRecord.insert(
                equipment,
                age,
                ageClass,
                birthYearClass,
                division,
                bodyWeight,
                weightClass,
                squat1,
                squat2,
                squat3,
                squat4,
                bestSquat,
                bench1,
                bench2,
                bench3,
                bench4,
                bestBench,
                deadlift1,
                deadlift2,
                deadlift3,
                deadlift4,
                bestDeadlift,
                total,
                place,
                dots,
                wilks,
                glossbrenner,
                goodlift,
                tested,
                sanctioned,
                athleteId,
                gameId
            )
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    println("insert athlete game record done")
}

fun testDB() {
    try {
        val athletes = Athlete.getAthletes()
        print("# test success\n")
        print(athletes)
    } catch (e: Exception) {
        print("# test failed\n")
        e.printStackTrace()
    }
}

fun printTypeValues(path: String, columnName: String) {
    try {
        val lines = File(path).readLines(Charsets.UTF_8)
        val columnNames = lines[0].split(",").map { it.trim() }
        val columnIndex = columnNames.indexOf(columnName)
        val types = mutableSetOf<String>()
        // 전체에서 찾음
        for (line in lines.subList(1,lines.size )) {
            val values = line.split(",")
            val type = values[columnIndex]
            types.add(type)
        }
        val sorted= types.sorted()
        println(sorted)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}