package com.example.demo.social.qq.template;

import java.nio.charset.Charset;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import 	org.thymeleaf.util.*;

public  class QQOAuth2Template extends OAuth2Template {

	public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
		// TODO Auto-generated constructor stub
		setUseParametersForClientAuthentication(true);
		
	}
	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate template = super.createRestTemplate();
		template.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return template;
	}
	@Override	 
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		// TODO Auto-generated method stub
	String responseStr =getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
	String[] items =  StringUtils.split(responseStr, "&");
	String[] item = StringUtils.split(items[1], "&");
	String access_token = StringUtils.replace(items[0], "access_token = ","");
	Long expries_in =new Long( StringUtils.replace(item[0], "expires_in=", ""));
	String refresh_token = StringUtils.replace(item[1], "refresh_token=", "");
	
		return new AccessGrant(access_token,null, refresh_token	,expries_in);
	}
	
	
}
