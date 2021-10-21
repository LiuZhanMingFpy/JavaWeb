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
//filter拦截的请求
@WebFilter(urlPatterns = "/*",filterName = "ownerFilter")
public class GetOwnerFilter implements Filter{

	@Autowired
	private UserService userService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//在model中放置Owner数据
		//得到Owner
		//User owner = userService.getOwner();
		//在request域（model）中放置owner
		//request.setAttribute("owner", owner);
		//放行
		chain.doFilter(request, response);
		
	}

}
