package jp.co.iwaki.data.api.controller;

import jp.co.iwaki.data.api.domain.model.resource.map.hospital.DentalMapResource;
import jp.co.iwaki.data.api.domain.model.resource.map.wifi.WifiMapResource;
import jp.co.iwaki.data.api.domain.model.response.DentalMapResponse;
import jp.co.iwaki.data.api.domain.model.response.WifiMapResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DentalMapController {

    @Value("${url.dental.list.csv}")
    public String strCsvUrl;

    @CrossOrigin
    @GetMapping("/map/dental")
    public DentalMapResponse getDentalList() throws Exception {
        List<DentalMapResource> dentalMapResourceList = new ArrayList<>();

        // csv url設定
        URL csvURl = new URL(strCsvUrl);

        HttpURLConnection connection = (HttpURLConnection)csvURl.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());
        connection.connect();

        if (HttpURLConnection.HTTP_OK != connection.getResponseCode()) {
            throw new Exception("歯科診療所リストCSVファイルの読み込みができません");
        }

        try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "SHIFT_JIS"))) {

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
                DentalMapResource dentalMapResource = new DentalMapResource();
                dentalMapResource.setName(wifiRecords[1]);
                dentalMapResource.setKana(wifiRecords[2]);
                dentalMapResource.setPostalCode(wifiRecords[3]);
                dentalMapResource.setAddress(wifiRecords[4]);
                dentalMapResource.setLatitude(Double.parseDouble(wifiRecords[5]));
                dentalMapResource.setLongitude(Double.parseDouble(wifiRecords[6]));
                dentalMapResource.setPhoneNumber(wifiRecords[7]);
                dentalMapResource.setDepartment(wifiRecords[8]);
                dentalMapResourceList.add(dentalMapResource);

            }

        }

        connection.disconnect();
        return new DentalMapResponse(dentalMapResourceList);
    }

}
