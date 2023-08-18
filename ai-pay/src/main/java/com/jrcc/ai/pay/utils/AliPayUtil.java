package com.jrcc.ai.pay.utils;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.jrcc.ai.pay.entity.AliPayBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author jinxin
 * @description TODO
 * @date 2023-07-27 17:18
 */
@Component
@Configuration
@EnableConfigurationProperties({AliPayBean.class})
public class AliPayUtil {

    private AliPayBean aliPay;

    public AliPayUtil(AliPayBean aliPay) {
        this.aliPay = aliPay;
        Config config = new Config();
        config.protocol = aliPay.getProtocol();
        config.gatewayHost = aliPay.getGatewayHost();
        config.signType = aliPay.getSignType();
        config.appId = aliPay.getAppId();
        /**
         * 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
         */
        config.merchantPrivateKey = aliPay.getMerchantPrivateKey();
        config.alipayPublicKey = aliPay.getAliPayPublicKey();
        config.notifyUrl = aliPay.getNotifyUrl();
        config.encryptKey = aliPay.getEncryptKey();
        Factory.setOptions(config);
    }

    public AliPayBean getConfig(){
        return aliPay;
    }
}
