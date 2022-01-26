package iwakiDataApi.controller.statistics

import iwakiDataApi.resource.statistics.market.MarketItemResource
import iwakiDataApi.resource.statistics.market.MarketTransactionResource
import iwakiDataApi.response.statistics.TotalMarketTransactionResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.regex.Pattern

@RestController
class MarketTransactionController {

    val REGEX_CSV_COMMA : String  = ",(?=(([^\"]*\"){2})*[^\"]*$)";

    val REGEX_SURROUND_DOUBLEQUATATION : String = "^\"\"|\"\"$"

    @CrossOrigin
    @GetMapping("/market/transaction")
    fun getMarketTransaction() : TotalMarketTransactionResponse {
        val marketTransactionList = mutableListOf<MarketTransactionResource>()
        val inputStream = this.javaClass.getResourceAsStream("/csv/statistics/market/marketTransaction.csv")

        val reader = inputStream?.bufferedReader()
        try {
            var line = reader?.readLine()
            var rowNum = 0

            val commaPattern = Pattern.compile(REGEX_CSV_COMMA)
            val doubleQuatationPattern = Pattern.compile(REGEX_SURROUND_DOUBLEQUATATION)

            while(line != null) {
                if(rowNum > 0) {
                    val marketRecords = commaPattern.split(line)
                    for (i in marketRecords.indices){
                        marketRecords[i] = marketRecords[i].replace("\"","").replace(",","")
                    }

                    val year = marketRecords[1]
                    // 野菜
                    val vegetable = MarketItemResource(marketRecords[2].toInt(), marketRecords[3].toLong())
                    // 果実
                    val fruit = MarketItemResource(marketRecords[4].toInt(), marketRecords[5].toLong())
                    // 鳥卵加工品toDouble
                    val processedBirdEgg = MarketItemResource(marketRecords[6].toInt(), marketRecords[7].toLong())
                    // 青果部合計
                    val fruitAndVegetableSectionTotal = MarketItemResource(marketRecords[8].toInt(), marketRecords[9].toLong())
                    // 鮮魚
                    val freshFish = MarketItemResource(marketRecords[10].toInt(), marketRecords[11].toLong())
                    // 冷凍
                    val frozen = MarketItemResource(marketRecords[12].toInt(), marketRecords[13].toLong())
                    // 塩干加工品
                    val saltDriedProducts = MarketItemResource(marketRecords[14].toInt(), marketRecords[15].toLong())
                    // 水産物部合計
                    val fisheriesDepartmentTotal = MarketItemResource(marketRecords[16].toInt(), marketRecords[17].toLong())
                    // 花き部toLong
                    val flowerPart = MarketItemResource(marketRecords[18].toInt(), marketRecords[19].toLong())
                    // 数量総計
                    val totalQuantity = marketRecords[20].toLong()
                    // 金額総計
                    val totalAmount = marketRecords[21].toLong()

                    val marketTransactionResource = MarketTransactionResource(year, vegetable, fruit, processedBirdEgg, fruitAndVegetableSectionTotal, freshFish, frozen, saltDriedProducts, fisheriesDepartmentTotal, flowerPart, totalQuantity, totalAmount)

                    marketTransactionList.add(marketTransactionResource)

                }
                line = reader?.readLine()
                rowNum++
            }

        } finally {
            inputStream?.close()
            reader?.close()
        }

        return TotalMarketTransactionResponse(marketTransactionList)
    }
}