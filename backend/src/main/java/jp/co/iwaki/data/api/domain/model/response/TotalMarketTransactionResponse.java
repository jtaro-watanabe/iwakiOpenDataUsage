package jp.co.iwaki.data.api.domain.model.response;

import jp.co.iwaki.data.api.domain.model.resource.market.MarketTransactionResource;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 中央卸売市場取扱高取得APIレスポンス
 */
@Data
@AllArgsConstructor
public class TotalMarketTransactionResponse {

    private List<MarketTransactionResource> data;

}
