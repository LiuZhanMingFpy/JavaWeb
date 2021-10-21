package com.example.demo.social.qq.connection;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import com.example.demo.social.qq.api.QQ;

public class QQConnerctionFactory extends OAuth2ConnectionFactory<QQ>{
	public QQConnerctionFactory(String providerId,String appid,String appSecret) {
		super(providerId,new QQSerciceProvider(appid, appSecret),new QQAdapter());
		
	}
}
