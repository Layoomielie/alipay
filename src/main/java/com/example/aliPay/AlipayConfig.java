package com.example.aliPay;


import java.io.FileWriter;
import java.io.IOException;

/**
 * @author：张鸿建
 * @date: 2019/6/26
 * @desc: 支付基本配置类
 **/
public class AlipayConfig {


    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016093000630269";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDdTCaYkecPotAr\n" +
            "R2GJVNhWe359ofVSBnnJ2TMkGRsMS88tMIr2Xy7PLXbrp6m/ExlpvCu6sHlSgaa7\n" +
            "36UrrgOHDGkPSbQ92sTRTyFbFG7cMS5f5bNp3YIHTD9dX35E9Mfg+JcMd218Xq8j\n" +
            "C2xSMYaKtFqcFE7GdO8V9x6jqlWhKoTVvXBN/DcUOlfCahWVkbOlmRXxC75tq4zg\n" +
            "ClPyQssQ8c0GRjW4X7adlZEtaEIqPAmWmnRI4Bkx7zelQ/9rmYX8R2x5fJBUyr77\n" +
            "hgYdXTF8zTARabuX9ftiGVRuTiiMkfdnPKWJ/7oaKOUjBzTmEqJIBhd5A6EuPkSL\n" +
            "+tuJCF5HAgMBAAECggEAfpQGJ5Kc5ZatF3Q22ASN0bnFejrfRVGq68eutuEdVYUv\n" +
            "NZvkgFOlRJ+uu9AlCcP070PQh3JVktnR8vhTU46vOdnhZfs0e4TcuxRV8fDYEF6Z\n" +
            "NgT/AHjQ3TfBrrjmUq7ofUfzrg/Jsi++YX8xMDpfyIqsoUYEYQOVlazJ+7d8Tzgg\n" +
            "AwUwzhol9orXdpJ7g4EvrB58+OcaDy1yuQ263k3EVZtTJicH0VKQ5gxD5Nl7Phv8\n" +
            "ETDDLvwF5DWklN9UfDfln4crSdUHktG+b3cKfI0lzF95uW0Q8wBmXEDTZpOyuzB7\n" +
            "6jmD86M4N7uZX+0BT2bu657ZzqWJPsrJpONDHQcSYQKBgQD9BXFYudXkPdajAwOZ\n" +
            "LU7XHiYg4KTi9D2kNJAVX19318CBapGVRjLWnQ7eyFXMP68YHHLwiBLqAkJDanOm\n" +
            "p00LHRaXLig/dRPkYEl2VpFfTB+hTNkLad3d9z+7uSh7+iQqWBY2/8AYtHQIIfqR\n" +
            "AKIUTskNAdq5Ho3YSN6XdN9nWQKBgQDf5xk+MihYNtOAEjK4TLGVEqsZgkkIzgT1\n" +
            "SWuoYqtctOY5M0Ig2LTe2b3ulHUdZhGsuet/OGLxa9Sc2m1JWXk54BK5c5eddS7j\n" +
            "qtaMEHHnu5bUUvZtY824xxBJiKP29qHtfjzwj3jDwWIV7ApE1K3Z9x95apW5VWNN\n" +
            "7dIrPujenwKBgHlZyusK9hLpta+pGmi02kNCKndKRsqy6X1/2Drn6xnHWIS5X+mA\n" +
            "KZHU8fTXkI7NXGTsABRsruWc/7rlq2Iai1DxOox3jsYgmNHHfHRNQJu8Hs911AMt\n" +
            "W0PB+cdHHquXZREJ/l2Se8ddhOkBovM4ooOq5bJfWU+/37gD+v4ZB6zBAoGBAKhg\n" +
            "/Z3FUIvOZ02H4faxTlbCHEPps4zYiegAl+KgmSf1rrDTeGaFMbfpXak+obhDGwWf\n" +
            "J5ebyuStZ82xgcBIdh7tAIfQgvNZvbJetkvMziwr6WixHzrydDICGaCDDnNZ1Dpq\n" +
            "1d8+td3Y3y+HO825dyhUbKn9Wq1upmhjccst2ygXAoGBANawqmIZAHravZx4yUWm\n" +
            "I6+wX3VecvDDvPY8fWMD4VfqpDWK/afHg91KO5OO0ZA9C8qaGm93WjTlZ9OcRe7l\n" +
            "tCw3NroqwlhbdFvZejUtGeI/EcuXM1I0xoJifMvVDhlc+bHzWEHZuvrk9U4kKn5D\n" +
            "daNmrt5n+otuNHeretAFTxC7";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3UwmmJHnD6LQK0dhiVTYVnt+faH1UgZ5ydkzJBkbDEvPLTCK9l8uzy1266epvxMZabwrurB5UoGmu9+lK64DhwxpD0m0PdrE0U8hWxRu3DEuX+Wzad2CB0w/XV9+RPTH4PiXDHdtfF6vIwtsUjGGirRanBROxnTvFfceo6pVoSqE1b1wTfw3FDpXwmoVlZGzpZkV8Qu+bauM4ApT8kLLEPHNBkY1uF+2nZWRLWhCKjwJlpp0SOAZMe83pUP/a5mF/EdseXyQVMq++4YGHV0xfM0wEWm7l/X7YhlUbk4ojJH3Zzylif+6GijlIwc05hKiSAYXeQOhLj5Ei/rbiQheRwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://25t49l5841.wicp.vip/ali/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://25t49l5841.wicp.vip/ali/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志地址
    public static String log_path = "D:\\";


    /**
     * @author：张鸿建
     * @date: 2019/6/26
     * @desc: 日志写入测试
     **/
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

