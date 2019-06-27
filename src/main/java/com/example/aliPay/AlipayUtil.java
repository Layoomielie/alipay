package com.example.aliPay;/**
 * ${tag}
 *
 * @author zhanghongjian
 * @Date 2019/6/26 11:08
 */

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author：张鸿建
 * @time：2019/6/26
 * @desc： 阿里支付工具类
 **/
public class AlipayUtil {

    private static AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

    private AlipayUtil() {

    }

    /**
     * @author：张鸿建
     * @date: 2019/6/26
     * @desc: 返回单例aliPayClient
     **/
    public static AlipayClient getAlipayClient() {
        return alipayClient;
    }

    /**
     * @author：张鸿建
     * @date: 2019/6/26
     * @desc: 将map参数用&拼接
     **/
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            //拼接时，不包括最后一个&字符
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }


}
