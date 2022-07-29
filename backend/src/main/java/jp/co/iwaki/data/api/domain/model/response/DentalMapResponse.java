package jp.co.iwaki.data.api.domain.model.response;

import jp.co.iwaki.data.api.domain.model.resource.map.hospital.DentalMapResource;
import jp.co.iwaki.data.api.domain.model.resource.map.wifi.WifiMapResource;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 歯科一覧設一覧レスポンス
 */
@Data
@AllArgsConstructor
public class DentalMapResponse {

    private List<DentalMapResource> data = new ArrayList<>();
}
