package jp.co.iwaki.data.api.domain.model.resource.map.hospital;

import jp.co.iwaki.data.api.domain.model.resource.map.MapBaseResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DentalMapResource extends MapBaseResource {

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

    /** 診療科 */
    private String department;

}
