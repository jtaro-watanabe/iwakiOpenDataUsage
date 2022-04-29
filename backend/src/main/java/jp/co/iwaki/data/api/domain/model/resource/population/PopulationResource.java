package jp.co.iwaki.data.api.domain.model.resource.population;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 人口のリソース
 */

@Data
@AllArgsConstructor
public class PopulationResource {

    /** 年度 */
    private String yearDate;

    /** 平地区人口 */
    private int taira;

    /** 小名浜地区人口 */
    private int onahama;

    /** 勿来地区人口 */
    private int nakoso;

    /** 常磐地区人口 */
    private int joban;

    /** 内郷地区人口 */
    private int uchigo;

    /** 四倉地区人口 */
    private int yotsukura;

    /** 遠野地区人口 */
    private int touno;

    /** 小川地区人口 */
    private int ogawa;

    /** 好間地区人口 */
    private int yoshima;

    /** 三和地区人口 */
    private int miwa;

    /** 田人地区人口 */
    private int tabito;

    /** 川前地区人口 */
    private int kawamae;

    /** 久ノ浜地区人口 */
    private int hisanohama;

    /** 総人口 */
    private int total;
    
}
