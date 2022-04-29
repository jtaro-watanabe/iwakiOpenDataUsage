package jp.co.iwaki.data.api.domain.model.resource.market;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 市場取扱品目要素
 */
@Data
@AllArgsConstructor
public class MarketItemResource {

    /** 取り扱い量 */
    private int quantity = 0;
    /** 取り扱い円 */
    private long amount = 0L;

}
