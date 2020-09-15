package com.zyl.flowershop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliPayConfig {
	@Value("${alipay.appId}")
	public String appId;
	// 商户私钥，您的PKCS8格式RSA2私钥
	@Value("${alipay.privateKey}")
	public String privateKey;
	// 对应APPID下的支付宝公钥。
	@Value("${alipay.publicKey}")
	public String publicKey;
	// 签名方式
	@Value("${alipay.signType}")
	public String signType;
	@Value("${alipay.gatewayHost}")
	public String gatewayHost;
//	    public static String returnUrl="http://120.26.184.107:8080/aliPay/return";
//	    public static String notifyUrl="http://120.26.184.107:8080/aliPay/notify";
	@Value("${alipay.returnUrl}")
	public String returnUrl;
	@Value("${alipay.notifyUrl}")
	public String notifyUrl;

	// 字符编码格式
	@Value("${alipay.charset}")
	public String charset;
	@Value("${alipay.protocol}")
	public String protocol;
	// 支付宝网关
	@Value("${alipay.gatewayUrl}")
	public String gatewayUrl;
	@Value("${alipay.timeExpire}")
	public long time_expire;
}
