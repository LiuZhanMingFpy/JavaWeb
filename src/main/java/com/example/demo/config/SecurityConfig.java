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
	//����SpringSecurity��������ʹ��ʲô���ܵ�
		@Bean
		public PasswordEncoder passwordEncoder() 
		{
			return new BCryptPasswordEncoder();
		}
		
		@Autowired
		private SpringSocialConfigurer springSocialConfigurer;
		
		
		
		@Override
		//������
		protected void configure(HttpSecurity http) throws Exception {
			//������Ȩ
			http.formLogin()
			//�Լ��ĵ�¼ҳ��
			.loginPage("/require")
			//����¼���ύ·��
			.loginProcessingUrl("/loginPage").defaultSuccessUrl("/index")
			//��¼ʧ�ܵ�Handler
			.and().authorizeRequests()
			.antMatchers("/search","/loginPage","/require","/registerVisitor","/judgeSMS","/sendSMS","/visitorRegister","/visitorLogin","/findMood","/findAllBlog","/findAllAlbum","/findAllArchives","/link",
					"/css/**","/images/**","/js/**","/layer/**","/social/**","/statics/**","/upload/**").permitAll()
			//��������
			.anyRequest()
			//����Ҫ���������֤
			.authenticated()
			.and()
			//����SpringSecurity����ʹ��iframeǶ��ҳ��
			.headers().frameOptions().disable()
			.and()
			//��վ����α��ķ���
			.csrf().disable();
			
			
		}

}
