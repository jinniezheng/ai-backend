package com.jrcc.ai.pay.controller;

import com.jrcc.ai.pay.entity.Product;
import com.jrcc.ai.pay.service.AliPayService;
import com.jrcc.ai.base.handler.response.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;

/**
 * <p>IJPay 让支付触手可及，封装了微信支付、支付宝支付、银联支付常用的支付方式以及各种常用的接口。</p>
 *
 * <p>不依赖任何第三方 mvc 框架，仅仅作为工具使用简单快速完成支付模块的开发，可轻松嵌入到任何系统里。 </p>
 *
 * <p>IJPay 交流群: 723992875、864988890</p>
 *
 * <p>Node.js 版: <a href="https://gitee.com/javen205/TNWX">https://gitee.com/javen205/TNWX</a></p>
 *
 * <p>支付宝支付 Demo</p>
 *
 * @author jinxin
 */
@Controller
@RequestMapping("/aliPay")
public class AliPayController  {
	private static final Logger log = LoggerFactory.getLogger(AliPayController.class);

	@Resource
	private AliPayService aliPayService;

	/**
	 * 扫码支付
	 */
	@RequestMapping(value = "/scanCreatePay")
	@ResponseBody
	public R tradePreCreatePay(Product product) {
		log.info("二维码支付");
		try {
			String value = aliPayService.aliPay(product);
			if ("fail".equals(value)) {
				return R.fail(value);
			} else {
				return R.data(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(e.getMessage());
		}
	}


}
