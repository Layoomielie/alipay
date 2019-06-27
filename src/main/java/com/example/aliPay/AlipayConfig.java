package com.example.aliPay;


/**
 * @author：张鸿建
 * @date: 2019/6/26
 * @desc: 支付基本配置类
 **/
public class AlipayConfig {


    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016093000630269";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiZgZir7DXqb96xlRW/J6GpmKZ4EtEsdbrJdlQkyn/D2cLOubyjuRRAmJqQDB9npyGcY2h3hcSx54VJvGYdBeVWQYbEA6SSRu5tHJ25R/BSwtj6l4iaF8erCOs6h4CpOz92WkpI17r4sQ1T3rMUIOLK7B6gk6oX+o4xFZSTifDoRB6QpX3bNDJGoLpmAFUDYcu1liS99bAd/yijSaw/7Ul+DTmersFddP+lY9VCgMaxnUouJer9FvGGZjNtPJ+e8CpJ5ryn3JBFk7KsB3FtT2iw4ajVk1kkND2DgYrbZ9h+dYVMntJLUiSwT1skpw4LxIyLzYounpWm7SJRcCmGAQLQIDAQAB";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAznrICc/VGVc4KBziGJQ1IeAjSwXUSCo3D0Lvbn1SzbdwbMc6rihCEZnIzrOfXn4bh6KCw1BE1eR9JZ6bTHtfzbqaVT7DZXh5X6SNUAgloA/Iw7qHD6B4oKZxezOW9aGKdqW4No9sxdQeGYJjEwzImhNgnktoUTrrXEQs+HjOKNO/JvFWUqNk2Sfthcoy19YtutZWzhNSpmFGUQtdeyVNUWK9TVJxbweseXVXxQLjIJjHf9avCHwvdCkX1RnHsXRIxK5jK6WhzKcFCkmQ2o7zLIh2LUhzJ1eXEO9hEeGQnvxuaxKea36XJ7TYkbU3qJnuKDv05JTmAJ7SfHBrLBHl4wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志地址
    public static String log_path = "C:\\";


    /**
     * @author：张鸿建
     * @date: 2019/6/26
     * @desc: 日志写入测试
     **/
    /*public static void logResult(String sWord) {
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
    }*/
}

