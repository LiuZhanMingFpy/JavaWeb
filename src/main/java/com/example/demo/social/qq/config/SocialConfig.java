package com.example.demo.social.qq.config;

import javax.activation.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.stereotype.Component;

import com.example.demo.properties.BlogSecurityProperties;


@Configuration
@EnableSocial
@Order(1)
public class SocialConfig  extends SocialConfigurerAdapter{
	@Autowired
	private javax.sql.DataSource dataSource;

	@Autowired
	private BlogSecurityProperties blogSecurityProperties;
	
	@Autowired
	private ConnectionSignUp connectionSignUp;
	
	@Autowired
	private ConnectionFactoryLocator connectionFactoryLocator;
	
	//登录之后，直接将QQ的数据保存在数据库
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
		repository.setConnectionSignUp(connectionSignUp);
		return repository;
	}
	
	
	//改变拦截的请求 /auth -> /qqLogin
	@Bean
	public SpringSocialConfigurer sikieduSocialSecurityConfig() {
		String filterProcessUrl = blogSecurityProperties.getQqProperties().getFilterProcessUrl();
		DemoSpringSocialConfigurer configurer = new DemoSpringSocialConfigurer(filterProcessUrl);
		return configurer;
	}
	
	
	//在注册的过程中，拿到了这个SpringSocial中的信息
	//业务完成之后，把用户的id传给了SpringSocial
	@Bean
	public ProviderSignInUtils prividerSignInUtils()
	{
		return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator));
	}
	
	//打开ConnectController
	@Bean
	public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator,ConnectionRepository connectionRepository)
	{
		return new ConnectController(connectionFactoryLocator, connectionRepository);
	}
	
}
