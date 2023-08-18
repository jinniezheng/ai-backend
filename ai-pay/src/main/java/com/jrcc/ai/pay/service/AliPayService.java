package com.jrcc.ai.pay.service;

import com.jrcc.ai.pay.entity.Product;

/**
 * 扫码支付以及手机H5支付
 * 创建者 科帮网
 * 创建时间	2017年7月27日
 */
public interface AliPayService {
	/**
	 * 阿里支付预下单
	 * 如果你调用的是当面付预下单接口(aliPay.trade.precreate)，调用成功后订单实际上是没有生成，因为创建一笔订单要买家、卖家、金额三要素。
     * 预下单并没有创建订单，所以根据商户订单号操作订单，比如查询或者关闭，会报错订单不存在。
     * 当用户扫码后订单才会创建，用户扫码之前二维码有效期2小时，扫码之后有效期根据timeout_express时间指定。
     * 2018年起，扫码支付申请需要门店拍照等等，申请流程复杂了
	 * @Author  科帮网
	 * @param product
	 * @return  String
	 * @Date	2017年7月27日
	 * 更新日志
	 * 2017年7月27日  科帮网 首次创建
	 *
	 */
	String aliPay(Product product);
    /**
     * 阿里支付退款
     * @Author  科帮网
     * @param product
     * @return  String
     * @Date	2017年7月27日
     * 更新日志
     * 2017年7月27日  科帮网 首次创建
     *
     */
}
