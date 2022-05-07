package jp.co.iwaki.data.api.domain.model.response;

import jp.co.iwaki.data.api.domain.model.resource.map.wifi.WifiMapResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * Wifi提供施設一覧レスポンス
 */
@Data
@AllArgsConstructor
public class WifiMapResponse {

    private List<WifiMapResource> data = new ArrayList<>();
}
