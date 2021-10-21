package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;



@Component
//filter���ص�����
@WebFilter(urlPatterns = "/*",filterName = "ownerFilter")
public class GetOwnerFilter implements Filter{

	@Autowired
	private UserService userService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//��model�з���Owner����
		//�õ�Owner
		//User owner = userService.getOwner();
		//��request��model���з���owner
		//request.setAttribute("owner", owner);
		//����
		chain.doFilter(request, response);
		
	}

}
