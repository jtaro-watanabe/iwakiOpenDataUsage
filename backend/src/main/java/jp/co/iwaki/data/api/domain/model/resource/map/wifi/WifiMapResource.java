package jp.co.iwaki.data.api.domain.model.resource.map.wifi;

import jp.co.iwaki.data.api.domain.model.resource.map.MapBaseResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WifiMapResource extends MapBaseResource {

    /** 名称 */
    private String name;

    /** かな */
    private String kana;

    /** 郵便番号 */
    private String postalCode;

    /** 住所 */
    private String address;

    /** 電話番号 */
    private String phoneNumber;

    /** FAX番号 */
    private String faxNumber;

    /** E-mail */
    private String email;

    /** URL */
    private String url;
}
