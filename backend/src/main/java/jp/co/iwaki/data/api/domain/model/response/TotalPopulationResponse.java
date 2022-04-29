package jp.co.iwaki.data.api.domain.model.response;

import jp.co.iwaki.data.api.domain.model.resource.population.PopulationResource;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 人口取得APIレスポンス
 */
@Data
@AllArgsConstructor
public class TotalPopulationResponse {

    List<PopulationResource> data;

}
