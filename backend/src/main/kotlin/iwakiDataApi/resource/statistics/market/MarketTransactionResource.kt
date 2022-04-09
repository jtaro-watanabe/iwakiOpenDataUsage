package iwakiDataApi.resource.statistics.market

import iwakiDataApi.resource.statistics.market.MarketItemResource

data class MarketTransactionResource(
    val year: String = "",
    // 野菜
    val vegetable: MarketItemResource,
    // 果実
    val fruit: MarketItemResource,
    // 鳥卵加工品
    val processedBirdEgg: MarketItemResource,
    // 青果部合計
    val fruitAndVegetableSectionTotal: MarketItemResource,
    // 鮮魚
    val freshFish: MarketItemResource,
    // 冷凍
    val frozen: MarketItemResource,
    // 塩干加工品
    val saltDriedProducts: MarketItemResource,
    // 水産物部合計
    val fisheriesDepartmentTotal: MarketItemResource,
    // 花き部
    val flowerPart: MarketItemResource,
    // 数量総計
    val totalQuantity: Long = 0,
    // 金額総計
    val totalAmount: Long = 0
)
