package com.example.demo.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration.Password;
import org.springframework.social.security.SocialUser;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;
import com.example.demo.domain.Visitor;
import com.example.demo.service.UserService;
import com.example.demo.service.VisitorService;


@Component
public class SecurityUserService implements UserDetailsService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//在数据库中获取该用户
	
		System.out.println(username);
		
		User user = userService.findUserByUsername(username);
		//13477296494
		Visitor visitor = visitorService.findVisitorByUsername(username);
		if(user != null)
		{
			session.setAttribute("visitor", user);
			//将该用户的信息（密码）给SpringSecurity
			return new SocialUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));			
		}
		if(visitor != null)
		{
			session.setAttribute("visitor", visitor);
			return new SocialUser(visitor.getUsername(), passwordEncoder.encode(visitor.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("VISITOR"));			
		}
		
		throw new UsernameNotFoundException("用户名不存在！！");
		
		
	}
		
		
		
		
		
	
	

}

