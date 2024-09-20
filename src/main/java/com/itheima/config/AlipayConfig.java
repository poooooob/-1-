package com.itheima.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "alipay")
@Component
public class AlipayConfig {

    private String appId;
    private String privateKey;
    private String publicKey;

    //支付宝通知本地接口的完整地址
    private String notifyUrl;

}
