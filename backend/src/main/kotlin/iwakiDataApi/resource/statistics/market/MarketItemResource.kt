package iwakiDataApi.resource.statistics.market

/**
 * 市場取扱品目要素
 */
data class MarketItemResource(
    // 取り扱い量
    val quantity : Int = 0,
    // 取り扱い円
    val amount : Long = 0
)
