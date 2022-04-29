package iwakiDataApi.response.statistics

import iwakiDataApi.resource.statistics.market.MarketTransactionResource

data class TotalMarketTransactionResponse(
    val data : List<MarketTransactionResource>
)
