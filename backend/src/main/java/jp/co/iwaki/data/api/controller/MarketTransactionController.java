package jp.co.iwaki.data.api.controller;

import jp.co.iwaki.data.api.domain.model.resource.market.MarketItemResource;
import jp.co.iwaki.data.api.domain.model.resource.market.MarketTransactionResource;
import jp.co.iwaki.data.api.domain.model.response.TotalMarketTransactionResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * いわき市中央市場の取引高データ取得用コントローラー
 *
 */
@RestController
public class MarketTransactionController {
// test
    @CrossOrigin
    @GetMapping("/market/transaction")
    public TotalMarketTransactionResponse getMarketTransaction() throws Exception {
        List<MarketTransactionResource> marketTransactionList = new ArrayList<>();

        // カンマ区切り文字のパターン作成
        String REGEX_CSV_COMMA = ",(?=(([^\"]*\"){2})*[^\"]*$)";
        Pattern commaPattern = Pattern.compile(REGEX_CSV_COMMA);

        InputStream inputStream = getClass().getResourceAsStream("/csv/statistics/market/marketTransaction.csv");

        if (inputStream == null) {
            throw new Exception("取扱高CSVファイルの読み込みができません");
        }

        // リソース上の取扱高CSVを読み込む
        try (inputStream; BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;

            int rowNum = 0;

            // ファイルの読み込み開始
            while ((line = bufferedReader.readLine()) != null) {

                if(rowNum == 0){
                    rowNum++;
                    continue;
                } else {
                    rowNum++;
                }

                String[] marketRecords = commaPattern.split(line);

                for(int i = 0; i < marketRecords.length;i++){
                    // 各レコードから不要な文字列を削除する
                    marketRecords[i] = marketRecords[i].replace("\"", "").replace(",", "");
                }

                // 年度を取得
                String year = marketRecords[1];
                // 野菜の取扱高
                MarketItemResource vegetable = new MarketItemResource(Integer.parseInt(marketRecords[2]), Long.parseLong(marketRecords[3]));
                // 果実
                MarketItemResource fruit = new MarketItemResource(Integer.parseInt(marketRecords[4]), Long.parseLong(marketRecords[5]));
                // 鳥卵加工品
                MarketItemResource processedBirdEgg = new MarketItemResource(Integer.parseInt(marketRecords[6]), Long.parseLong(marketRecords[7]));
                // 青果部合計
                MarketItemResource fruitAndVegetableSectionTotal = new MarketItemResource(Integer.parseInt(marketRecords[8]), Long.parseLong(marketRecords[9]));
                // 鮮魚
                MarketItemResource freshFish = new MarketItemResource(Integer.parseInt(marketRecords[10]), Long.parseLong(marketRecords[11]));
                // 冷凍
                MarketItemResource frozen = new MarketItemResource(Integer.parseInt(marketRecords[12]), Long.parseLong(marketRecords[13]));
                // 塩干加工品
                MarketItemResource saltDriedProducts = new MarketItemResource(Integer.parseInt(marketRecords[14]), Long.parseLong(marketRecords[15]));
                // 水産物部合計
                MarketItemResource fisheriesDepartmentTotal = new MarketItemResource(Integer.parseInt(marketRecords[16]), Long.parseLong(marketRecords[17]));
                // 花き部toLong
                MarketItemResource flowerPart = new MarketItemResource(Integer.parseInt(marketRecords[18]), Long.parseLong(marketRecords[19]));
                // 数量総計
                Long totalQuantity = Long.parseLong(marketRecords[20]);
                // 金額総計
                Long totalAmount = Long.parseLong(marketRecords[21]);

                // 年毎の取扱高を集計
                MarketTransactionResource marketTransactionResource = new MarketTransactionResource(year, vegetable, fruit, processedBirdEgg, fruitAndVegetableSectionTotal, freshFish, frozen, saltDriedProducts, fisheriesDepartmentTotal, flowerPart, totalQuantity, totalAmount);

                marketTransactionList.add(marketTransactionResource);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TotalMarketTransactionResponse(marketTransactionList);
    }


}
