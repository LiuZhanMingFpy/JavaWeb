package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SpringSocialConfigurer;




@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	//告诉SpringSecurity我们密码使用什么加密的
		@Bean
		public PasswordEncoder passwordEncoder() 
		{
			return new BCryptPasswordEncoder();
		}
		
		@Autowired
		private SpringSocialConfigurer springSocialConfigurer;
		
		
		
		@Override
		//做拦截
		protected void configure(HttpSecurity http) throws Exception {
			//请求授权
			http.formLogin()
			//自己的登录页面
			.loginPage("/require")
			//表单登录的提交路径
			.loginProcessingUrl("/loginPage").defaultSuccessUrl("/index")
			//登录失败的Handler
			.and().authorizeRequests()
			.antMatchers("/search","/loginPage","/require","/registerVisitor","/judgeSMS","/sendSMS","/visitorRegister","/visitorLogin","/findMood","/findAllBlog","/findAllAlbum","/findAllArchives","/link",
					"/css/**","/images/**","/js/**","/layer/**","/social/**","/statics/**","/upload/**").permitAll()
			//所有请求
			.anyRequest()
			//都需要我们身份认证
			.authenticated()
			.and()
			//配置SpringSecurity允许使用iframe嵌入页面
			.headers().frameOptions().disable()
			.and()
			//跨站请求伪造的防护
			.csrf().disable();
			
			
		}

}
