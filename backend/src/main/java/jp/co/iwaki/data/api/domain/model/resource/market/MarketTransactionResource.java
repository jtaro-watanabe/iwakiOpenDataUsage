package jp.co.iwaki.data.api.domain.model.resource.market;

import lombok.Data;

/**
 * 品目毎の取扱高
 */
@Data
public class MarketTransactionResource {

    /** 年度 */
    private String year = "";
    /** 野菜 */
    private MarketItemResource vegetable = new MarketItemResource();
    /** 果実 */
    private MarketItemResource fruit = new MarketItemResource();
    /** 鳥卵加工品 */
    private MarketItemResource processedBirdEgg = new MarketItemResource();
    /** 青果部合計 */
    private MarketItemResource fruitAndVegetableSectionTotal = new MarketItemResource();
    /** 鮮魚 */
    private MarketItemResource freshFish = new MarketItemResource();
    /** 冷凍 */
    private MarketItemResource frozen = new MarketItemResource();
    /** 塩干加工品 */
    private MarketItemResource saltDriedProducts = new MarketItemResource();
    /** 水産物部合計 */
    private MarketItemResource fisheriesDepartmentTotal = new MarketItemResource();
    /** 花き部 */
    private MarketItemResource flowerPart = new MarketItemResource();
    /** 数量総計 */
    private Long totalQuantity = 0L;
    /** 金額総計 */
    private Long totalAmount = 0L;
}
