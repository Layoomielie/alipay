package com.example;

import com.unionpay.acp.sdk.SDKConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlipayPcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AlipayPcApplication.class, args);
    }

    /**
     * @author：张鸿建
     * @date: 2019/6/26
     * @desc: 加载银联证书配置
     **/
    @Override
    public void run(String... args) throws Exception {
        SDKConfig.getConfig().loadPropertiesFromSrc();
    }

}
