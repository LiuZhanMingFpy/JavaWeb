package com.example.demo.social.qq.connection;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;

import com.example.demo.social.qq.api.QQ;
import com.example.demo.social.qq.template.QQOAuth2Template;



public class QQSerciceProvider extends AbstractOAuth2ServiceProvider<QQ> {
	private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
	private static final String URL_ACCESSTOKEN = "https://graph.qq.com/oauth2.0/token";

	private String appId;
	public QQSerciceProvider(String appid, String appSecret) {
		super(new QQOAuth2Template(appid, appSecret, URL_AUTHORIZE, URL_ACCESSTOKEN));
		this.appId = appid;
	}

	@Override
	public QQ getApi(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}
}
