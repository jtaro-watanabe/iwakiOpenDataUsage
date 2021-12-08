package iwakiDataApi.response.statistics

import iwakiDataApi.resource.statistics.PopulationResource

data class TotalPopulationResponse(
    val data : List<PopulationResource>
)
