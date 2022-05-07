package jp.co.iwaki.data.api.domain.model.resource.map;

import lombok.Data;

/**
 * 地図表示用APIの基底データクラス
 */
@Data
public class MapBaseResource {

    /** 緯度 */
    private double longitude;

    /** 経度 */
    private double latitude;
}
