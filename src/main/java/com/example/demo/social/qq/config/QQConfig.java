package com.example.demo.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.stereotype.Component;

import com.example.demo.properties.BlogSecurityProperties;
import com.example.demo.properties.QQProperties;
import com.example.demo.social.qq.connection.QQConnerctionFactory;

@Configuration
@EnableSocial
@Order(2)
@Component
public class QQConfig extends SocialConfigurerAdapter{
	@Autowired
	private BlogSecurityProperties blogSecurityProperties;
	
	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {
		QQProperties qqConfig = blogSecurityProperties.getQqProperties();
		// TODO Auto-generated method stub
		QQConnerctionFactory qqConnectionFactory = new QQConnerctionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
		connectionFactoryConfigurer.addConnectionFactory(qqConnectionFactory);
	}

	@Override
	public UserIdSource getUserIdSource() {
		// TODO Auto-generated method stub
		return new AuthenticationNameUserIdSource();
	}

}
