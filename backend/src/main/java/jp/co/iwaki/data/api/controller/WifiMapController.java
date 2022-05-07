package jp.co.iwaki.data.api.controller;

import jp.co.iwaki.data.api.domain.model.resource.map.wifi.WifiMapResource;
import jp.co.iwaki.data.api.domain.model.resource.population.PopulationResource;
import jp.co.iwaki.data.api.domain.model.response.TotalPopulationResponse;
import jp.co.iwaki.data.api.domain.model.response.WifiMapResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WifiMapController {

    @CrossOrigin
    @GetMapping("/map/wifi")
    public WifiMapResponse getWifiList() throws Exception {
        List<WifiMapResource> wifiMapResourceList = new ArrayList<>();

        InputStream inputStream = getClass().getResourceAsStream("/csv/statistics/map/wifi/wifiProviderList.csv");

        if (inputStream == null) {
            throw new Exception("WifiリストCSVファイルの読み込みができません");
        }

        try (inputStream; BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            int rowNum = 0;


            while ((line = bufferedReader.readLine()) != null) {

                // 先頭の行はヘッダなのでスキップ
                if (rowNum == 0) {
                    rowNum++;
                    continue;
                } else {
                    rowNum++;
                }

                String[] wifiRecords = line.split(",");
                WifiMapResource wifiMapResource = new WifiMapResource();
                wifiMapResource.setName(wifiRecords[1]);
                wifiMapResource.setKana(wifiRecords[2]);
                wifiMapResource.setPostalCode(wifiRecords[3]);
                wifiMapResource.setAddress(wifiRecords[4]);
                wifiMapResource.setLongitude(Double.parseDouble(wifiRecords[5]));
                wifiMapResource.setLatitude(Double.parseDouble(wifiRecords[6]));
                wifiMapResource.setPhoneNumber(wifiRecords[7]);
                wifiMapResource.setFaxNumber(wifiRecords[8]);
                wifiMapResource.setEmail(wifiRecords[9]);
                wifiMapResource.setUrl(wifiRecords[10]);
                wifiMapResourceList.add(wifiMapResource);

            }

        }

        return new WifiMapResponse(wifiMapResourceList);
    }

}
