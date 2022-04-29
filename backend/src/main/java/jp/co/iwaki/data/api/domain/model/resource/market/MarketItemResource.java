package jp.co.iwaki.data.api.domain.model.resource.market;

import lombok.Data;

/**
 * 市場取扱品目要素
 */
@Data
public class MarketItemResource {

    /** 取り扱い量 */
    private Integer quantity = 0;
    /** 取り扱い円 */
    private Long amount = 0L;
}
