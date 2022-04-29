package iwakiDataApi.controller.statistics

import iwakiDataApi.resource.statistics.PopulationResource
import iwakiDataApi.response.statistics.TotalPopulationResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RegionPopulationController {

    @CrossOrigin
    @GetMapping("/population/total")
    fun getTotalPopulation() : TotalPopulationResponse {
        val populationList = mutableListOf<PopulationResource>()
        val inputStream = this.javaClass.getResourceAsStream("/csv/statistics/population/regionTotal.csv")
        val reader = inputStream?.bufferedReader()
        try {
            var line = reader?.readLine()
            var rowNum = 0

            while(line != null) {
                if(rowNum > 0) {
                    val populationRecords = line.split(",")
                    val populationResource = PopulationResource(populationRecords[1],populationRecords[2],populationRecords[3], populationRecords[4]
                    ,populationRecords[5], populationRecords[6],populationRecords[7],populationRecords[8],populationRecords[9],populationRecords[10]
                    ,populationRecords[11],populationRecords[12],populationRecords[13],populationRecords[14],populationRecords[15])
                    populationList.add(populationResource)
                }
                line = reader?.readLine()
                rowNum++
            }

        } finally {
            inputStream?.close()
            reader?.close()
        }

        return TotalPopulationResponse(populationList);
    }
}