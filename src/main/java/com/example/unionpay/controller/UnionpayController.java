package com.example.unionpay.controller;

import com.example.unionpay.DemoBase;
import com.example.unionpay.UnionPayClient;
import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.LogUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author：张鸿建
 * @time：2019/6/26
 * @desc：
 **/
@RestController
@RequestMapping("/union")
public class UnionpayController {



    /**
     * 支付
     * @param orderNumber 商户订单号
     * @param txnAmt 金额（分）
     * @return
     * @throws Exception
     */
    @GetMapping("/orderpay")
    public String pay(@RequestParam String orderNumber,
                      @RequestParam Integer txnAmt,
                      @RequestParam String goodsName) throws Exception {

        String payhtml = UnionPayClient.pay(orderNumber, txnAmt.toString(),goodsName);
        //生成自动跳转的form表单，直接返给前端，让前端做页面的跳转
        return payhtml;
    }

    /**
     * 订单状态查询
     * @param orderNumber
     * @param txnTime
     * @return
     * @throws Exception
     */
    @GetMapping("/orderquery")
    public String query(@RequestParam String orderNumber,
                        @RequestParam String txnTime)throws Exception {

        //参数限制逻辑

        Map<String, String> rspData = UnionPayClient.query(orderNumber, txnTime);

        //返回参数处理
        if(!rspData.isEmpty()){
            //验证签名
            if(AcpService.validate(rspData, DemoBase.encoding)){
                LogUtil.writeLog("验证签名成功");
                System.out.println("应答码为     "+rspData.get("respCode"));
                if("00".equals(rspData.get("respCode"))){//如果查询交易成功
                    //处理被查询交易的应答码逻辑
                    String origRespCode = rspData.get("origRespCode");
                    if("00".equals(origRespCode)){
                        System.out.println("交易成功了！！！！！！！！");

                        //交易成功，更新商户订单状态
                        //数据库修改成功后告诉前端，用户支付成功
                        return "sucess";

                    }else if("03".equals(origRespCode) ||
                            "04".equals(origRespCode) ||
                            "05".equals(origRespCode)){
                        //需再次发起交易状态查询交易
                    }else{
                        //其他应答码为失败请排查原因
                    }
                }else{
                    //查询交易本身失败，或者未查到原交易，检查查询交易报文要素
                }
            }else{
                LogUtil.writeErrorLog("验证签名失败");
                //检查验证签名失败的原因
            }
        }else{
            //未返回正确的http状态
            LogUtil.writeErrorLog("未获取到返回报文或返回http状态码非200");
        }
        return "fail";
    }

    /**
     *
     * @param refundOrderId  交易号
     * @param txnAmt    退款金额
     * @param queryId   交易索引号
     * @return
     */
    @PostMapping("/orderrefund")
    public String refund(@RequestParam String refundOrderId,
                         @RequestParam String txnAmt,
                         @RequestParam String queryId){

        Map<String, String> rspData = UnionPayClient.refund(refundOrderId, txnAmt, queryId);

        /**对应答码的处理，请根据您的业务逻辑来编写程序,以下应答码处理逻辑仅供参考------------->**/
        //应答码规范参考open.unionpay.com帮助中心 下载  产品接口规范  《平台接入接口规范-第5部分-附录》
        if(!rspData.isEmpty()){
            if(AcpService.validate(rspData, DemoBase.encoding)){
                LogUtil.writeLog("验证签名成功");
                String respCode = rspData.get("respCode");
                System.out.println(respCode);
                if("00".equals(respCode)){

                    //交易已受理，等待接收后台通知更新订单状态,也可以主动发起 查询交易确定交易状态。
                    return "sucess";

                }else if("03".equals(respCode)||
                        "04".equals(respCode)||
                        "05".equals(respCode)){
                    //后续需发起交易状态查询交易确定交易状态
                }else{
                    //其他应答码为失败请排查原因
                }
            }else{
                LogUtil.writeErrorLog("验证签名失败");
            }
        }else{
            //未返回正确的http状态
            LogUtil.writeErrorLog("未获取到返回报文或返回http状态码非200");
        }

        return "fail";
    }

}
