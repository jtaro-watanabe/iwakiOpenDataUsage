package jp.co.iwaki.data.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SprintBootアプリケーション基底クラス
 */
@SpringBootApplication
public class IwakiDataApiBootApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(IwakiDataApiBootApplication.class);
        application.run(args);
    }

}

