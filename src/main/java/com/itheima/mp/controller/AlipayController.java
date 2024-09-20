package com.itheima.mp.controller;





import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.OrderInfoDTO;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.itheima.config.AlipayConfig;
import com.itheima.mp.domain.po.Order;
import com.itheima.mp.service.OrderService;
import com.itheima.mp.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/alipay")
public class AlipayController {

    //支付宝沙箱网关地址
    private static final String GATEWAY_URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private static final String FORMAT = "json";
    private static final String CHARSET = "utf-8";
    private static final String SIGN_TYPE = "RSA2";

    @Autowired
    private OrderService orderService;

    @Resource
    private AlipayConfig aliPayConfig;

    @Autowired
    private ScheduleService scheduleService;

    // 支付接口
    @GetMapping("/pay")
    public void pay(@RequestParam("orderId") Integer orderId, HttpServletResponse httpResponse) throws IOException {
        try {
            // 根据 orderId 查询订单信息
            Order order = orderService.getById(orderId);
            if (order == null) {
                System.err.println("支付失败: 订单不存在");
                httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "订单不存在");
                return;
            }

            // 创建 Alipay 请求并设置参数
            AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, aliPayConfig.getAppId(),
                    aliPayConfig.getPrivateKey(), FORMAT, CHARSET, aliPayConfig.getPublicKey(), SIGN_TYPE);
            AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
            request.setNotifyUrl(aliPayConfig.getNotifyUrl());

            JSONObject bizContent = new JSONObject();
            bizContent.put("out_trade_no", order.getOrderId()+"4242423325353533232");  // 使用订单ID作为商户订单号
            bizContent.put("total_amount", orderService.getTicketsPrice(orderId));  // 使用订单中的总金额
            bizContent.put("subject", "汽车票订单支付");  // 商品名称
            bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");  // 销售产品码，固定值

            request.setBizContent(bizContent.toString());
            request.setReturnUrl("http://localhost:7070/user-dashboard/user-buyticket");

            // 执行请求并返回支付表单
            String form = alipayClient.pageExecute(request).getBody();
            System.out.println("Alipay form generated: " + form);

            // 将支付表单返回给前端
            httpResponse.setContentType("text/html;charset=" + CHARSET);
            httpResponse.getWriter().write(form);
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        } catch (Exception e) {
            System.err.println("支付请求失败: " + e.getMessage());
            e.printStackTrace();
            httpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "支付请求失败");
        }
    }


    // 支付回调接口
    @PostMapping("/notify")
    public String alipayNotify(HttpServletRequest request) {
        try {
            // 从请求中获取支付结果
            Map<String, String> params = extractAlipayParams(request);

            // 验证签名
            boolean verifyResult = AlipaySignature.rsaCheckV1(
                    params, aliPayConfig.getPublicKey(), CHARSET, SIGN_TYPE);

            if (verifyResult) {
                // 验证通过后，获取订单信息
                String outTradeNo = params.get("out_trade_no");  // 商户订单号，对应订单ID
                String tradeStatus = params.get("trade_status");  // 支付状态

                if ("TRADE_SUCCESS".equals(tradeStatus)) {
                    // 支付成功，处理订单
                    Order order = orderService.getOrderByTradeNo(outTradeNo);

                        // 扣除余票
                        scheduleService.deleteAvailableSeats(order.getScheduleId());
                    }
            } else {
                return "fail";  // 验证失败，返回给支付宝
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";  // 支付宝要求的返回值
    }

    private Map<String, String> extractAlipayParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();

        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            StringBuilder valueStr = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                valueStr.append(i == 0 ? "" : ",").append(values[i]);
            }
            params.put(name, valueStr.toString());
        }
        return params;
    }



}