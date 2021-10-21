package com.example.demo.social.qq.api;

import java.io.IOException;

import javax.management.RuntimeErrorException;

import org.elasticsearch.action.get.GetRequest;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.social.qq.api.OpenId;



public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
	private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	private static final String URL_GET_OPENID= "https://graph.qq.com/oauth2.0/me?access_token=%s";
	private String appId;
	private String openId;
	private ObjectMapper objectMapper = new ObjectMapper();
	 public  QQImpl(String accessToken,String appid) {
		//自动拼接一个参数
		//自动拼接一个参数
			super(accessToken,TokenStrategy.ACCESS_TOKEN_PARAMETER);
			//赋值appid
			this.appId = appId;
			//赋值openid
			//通过url获得openid
			//拼接参数
			String url = String.format(URL_GET_OPENID, accessToken);
			
			//发送请求
			String result = getRestTemplate().getForObject(url, String.class);
			//处理返回值
			//callback( {"client_id":"100550231","openid":"CDF1A28F8698E326D173DE17437FB098"} );
			result = StringUtils.replace(result, "callback( ", "");
			result = StringUtils.replace(result, " );", "");
			//{"client_id":"100550231","openid":"CDF1A28F8698E326D173DE17437FB098"}
			OpenId id = null;
			try {
				id = objectMapper.readValue(result, OpenId.class);
			} catch (IOException e) {
				throw new RuntimeException("获取OpenId失败！！");
			}
			
			//赋值openid
			this.openId = id.getOpenid();
	}
	@Override
	public QQUserInfo getUserInfo() {
		String url = String.format(URL_GET_USERINFO, appId,openId);
	String result =	getRestTemplate().getForObject(url, String.class);
	QQUserInfo userInfo = null;
	try {
		userInfo = objectMapper.readValue(result, QQUserInfo.class);
		userInfo.setOpenId(openId);	
	} catch (IOException e) {
		// TODO: handle exception
		throw new RuntimeException("获取用户信息失败");
	}
	
	return userInfo;
	}
}
