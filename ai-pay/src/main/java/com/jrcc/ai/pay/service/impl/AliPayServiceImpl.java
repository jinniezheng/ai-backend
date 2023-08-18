package com.jrcc.ai.pay.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
import com.alipay.easysdk.payment.common.models.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeCloseResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.alipay.easysdk.payment.wap.models.AlipayTradeWapPayResponse;
import com.jrcc.ai.pay.entity.Product;
import com.jrcc.ai.pay.service.AliPayService;
import com.jrcc.ai.pay.utils.AliPayUtil;
import com.jrcc.ai.pay.utils.ZxingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * 支付宝
 * 创建者 科帮网
 * 创建时间	2018年1月15日
 * ======================
 * 商户端私钥：
 * 由我们自己生成的RSA私钥（必须与商户端公钥是一对），生成后要保存在服务端，绝对不能保存在客户端，也绝对不能从服务端下发。
 * 用来对订单信息进行加签，加签过程一定要在服务端完成，绝对不能在客户端做加签工作，客户端只负责用加签后的订单信息调起支付宝来支付。
 * ======================
 * 商户端公钥：
 * 由我们自己生成的RSA公钥（必须与商户端私钥是一对），生成后需要填写在支付宝开放平台，
 * 用来给支付宝服务端验签经过我们加签后的订单信息，以确保订单信息确实是我们商户端发给支付宝的，并且确保订单信息在传输过程中未被篡改。
 * ======================
 * 支付宝私钥：
 * 支付宝自己生成的，他们自己保存，开发者是无法看到的，用来对支付结果进行加签。
 * ======================
 * 支付宝公钥：
 * 支付宝公钥和支付宝私钥是一对，也是支付宝生成的，当我们把商户端公钥填写在支付宝开放平台后，平台就会给我们生成一个支付宝公钥。
 * 我们可以复制下来保存在服务端，同样不要保存在客户端，并且不要下发，避免被反编译或截获，而被篡改支付结果。
 * 用来让服务端对支付宝服务端返给我们的同步或异步支付结果进行验签，以确保支付结果确实是由支付宝服务端返给我们服务端的，而且没有被篡改。
 * 对支付结果的验签工作也一定要在服务端完成，绝对不能在客户端验签，因为支付宝公钥一旦存储在客户端用来验签，那就可能被反编译，这样就谁都可以验签支付结果并篡改了。
 * ======================
 * 支付宝建议加签方式升级为RSA(SHA256)密钥，以为 SHA 貌似已经被破解了。
 *
 */
@Service
public class AliPayServiceImpl implements AliPayService {
	private static final Logger logger = LoggerFactory.getLogger(AliPayServiceImpl.class);

    @Autowired
    private AliPayUtil aliPayUtil;


	@Override
	public String aliPay(Product product) {
		logger.info("订单号：{}生成支付宝支付码",product.getOutTradeNo());
        try {
            String orderNo = IdUtil.getSnowflake(1,1).nextId()+"";
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
                    .asyncNotify(aliPayUtil.getConfig().getNotifyUrl())
                    .preCreate(product.getSubject(), orderNo, product.getTotalFee());
            if (ResponseChecker.success(response)) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                ZxingUtils.createQRCodeImage(response.getQrCode(), stream);
                byte[] bytes = Base64.getEncoder().encode(stream.toByteArray());
                return "data:image/png;base64," + new String(bytes);
            } else {
                logger.error("企业支付下单失败{}{}",response.msg,response.subMsg);
                return "fail";
            }
        } catch (Exception e) {
            logger.error("企业支付下单失败");
            return "fail";
        }
	}

}
