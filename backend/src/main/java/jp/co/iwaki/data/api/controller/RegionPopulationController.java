package jp.co.iwaki.data.api.controller;

import jp.co.iwaki.data.api.domain.model.resource.population.PopulationResource;
import jp.co.iwaki.data.api.domain.model.response.TotalPopulationResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 人口取得APIコントローラ
 */
@RestController
public class RegionPopulationController {

    @CrossOrigin
    @GetMapping("/population/total")
    public TotalPopulationResponse getTotalPopulation() throws Exception {
        List<PopulationResource> populationList = new ArrayList<>();

        InputStream inputStream = getClass().getResourceAsStream("/csv/statistics/population/regionTotal.csv");

        if (inputStream == null) {
            throw new Exception(" 人口CSVファイルの読み込みができません");
        }

        try (inputStream; BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            int rowNum = 0;


            while ((line = bufferedReader.readLine()) != null) {

                if (rowNum == 0) {
                    rowNum++;
                    continue;
                } else {
                    rowNum++;
                }

                String[] populationRecords = line.split(",");
                PopulationResource populationResource = new PopulationResource(populationRecords[1]
                        , Integer.parseInt(populationRecords[2]), Integer.parseInt(populationRecords[3]), Integer.parseInt(populationRecords[4])
                        , Integer.parseInt(populationRecords[5]), Integer.parseInt(populationRecords[6]), Integer.parseInt(populationRecords[7])
                        , Integer.parseInt(populationRecords[8]), Integer.parseInt(populationRecords[9]), Integer.parseInt(populationRecords[10])
                        , Integer.parseInt(populationRecords[11]), Integer.parseInt(populationRecords[12]), Integer.parseInt(populationRecords[13])
                        , Integer.parseInt(populationRecords[14]), Integer.parseInt(populationRecords[15]));
                populationList.add(populationResource);

            }

        }

        return new TotalPopulationResponse(populationList);
    }

}
