package cmps312.lab.covidtracker

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

//singleton
object CovidStatRepository {
    var covidStats = listOf<CovidStat>()

    init {
        //step 1 read from the file
        var data = File("data/covid-data.json").readText()

        //step is convert the text into object
        covidStats = Json.decodeFromString(data)
    }

    fun totalCovidDeath() = covidStats.sumOf { it?.totalDeaths ?: 0 }

}

fun main() {
    CovidStatRepository
        .covidStats.forEach { println(it.country) }
}