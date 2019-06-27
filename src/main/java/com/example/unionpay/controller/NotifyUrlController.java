package com.example.unionpay.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author：张鸿建
 * @time：2019/6/26 16:34
 * @desc：
 **/
@Controller
public class NotifyUrlController {
    /**
     * 后台异步通知路径
     * @param req
     * @return
     */
    @PostMapping("/notifyurl")
    public ResponseEntity<Object> back(HttpServletRequest req){

        LogUtil.writeLog("BackRcvResponse   接收后台通知开始");
        String encoding = req.getParameter(SDKConstants.param_encoding);

        // 获取银联通知服务器发送的后台通知参数
        Map<String, String> reqParam = getAllRequestParam(req);

        Map<String, String> valideData = null;
        if (null != reqParam && !reqParam.isEmpty()) {

            Iterator<Entry<String, String>> it = reqParam.entrySet().iterator();
            valideData = new HashMap<String, String>(reqParam.size());

            while (it.hasNext()) {

                Entry<String, String> e = it.next();
                String key = (String) e.getKey();
                String value = (String) e.getValue();
                valideData.put(key, value);
            }
        }

        //重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
        if (!AcpService.validate(valideData, encoding)) {
            LogUtil.writeLog("验证签名结果[失败].");
            //验签失败，需解决验签问题
        } else {
            LogUtil.writeLog("验证签名结果[成功].");

            //注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态
            //获取后台通知的数据，其他字段也可用类似方式获取
            String orderId =valideData.get("orderId");  //商户订单号
            String respCode = valideData.get("respCode"); //

            //bizType   orderId  txnSubType traceNo accNo 银行卡号 settleAmt精确到分  settleDate 付款日期精确到天 queryId 查询流水号 accessType respMsg traceTime txnTime merId respCode  txnAmt
            //txnTime 订单发送时间
            //txnAmt 交易金额 精确到分
            //txnSubType  01自助消费 03分期付款

            //orderId 商户订单号
            //orderDesc  订单描述
            //customerInfo 银行卡验证信息  身份验证信息
            //accNo 账号  卡号或卡号后四位
            //orderTimeout 订单超时时间
            //defaultPayType 默认支付方式
            //payTimeout 支付超时时间

            //queryId 查询流水号
            //traceTime 交易传输时间 MMDDhhmmss
            //signature 签名
            //settleAmt 清算金额
            // settleDate 清算日期
            //traceNo 跟踪号
            // respCode 应答码
            // respMsg 应答信息
            // accNo 账号
            // payType 支付方式
            // payCardNo 支付卡标识
            // payCardType 支付卡类型
                // payCardIssueName 支付卡名称
            // txnTime 订单发送时间
            // txnAmt 交易金额
            // txnType 交易类型
            // merId 商户代码
            // orderId 商户订单号不能包含- _ merId orderId txnTime 确认一比交易


            System.out.println(orderId+respCode);
            System.out.println(JSONObject.toJSONString(valideData));
        }

        LogUtil.writeLog("BackRcvResponse接收后台通知结束");

        //返回给银联服务器http 200  状态码
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    /**
     * 获取参数集合
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParam(
            final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                // 在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
                if (res.get(en) == null || "".equals(res.get(en))) {
                    // System.out.println("======为空的字段名===="+en);
                    res.remove(en);
                }
            }
        }
        return res;
    }

}
