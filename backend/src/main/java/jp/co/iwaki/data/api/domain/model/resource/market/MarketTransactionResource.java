package jp.co.iwaki.data.api.domain.model.resource.market;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 品目毎の取扱高
 */
@Data
@AllArgsConstructor
public class MarketTransactionResource {

    /** 年度 */
    private String year;
    /** 野菜 */
    private MarketItemResource vegetable;
    /** 果実 */
    private MarketItemResource fruit;
    /** 鳥卵加工品 */
    private MarketItemResource processedBirdEgg;
    /** 青果部合計 */
    private MarketItemResource fruitAndVegetableSectionTotal;
    /** 鮮魚 */
    private MarketItemResource freshFish;
    /** 冷凍 */
    private MarketItemResource frozen;
    /** 塩干加工品 */
    private MarketItemResource saltDriedProducts;
    /** 水産物部合計 */
    private MarketItemResource fisheriesDepartmentTotal;
    /** 花き部 */
    private MarketItemResource flowerPart;
    /** 数量総計 */
    private Long totalQuantity;
    /** 金額総計 */
    private Long totalAmount;

}
