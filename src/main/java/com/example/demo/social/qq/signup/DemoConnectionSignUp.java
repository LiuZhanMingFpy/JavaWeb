package com.example.demo.social.qq.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
@Component
public class DemoConnectionSignUp  implements ConnectionSignUp{
@Autowired
private VisitorService service;
	@Override
	public String execute(Connection<?> connection) {
		// TODO Auto-generated method stub
		Visitor visitor = new Visitor(null, connection.getDisplayName(), "123456", connection.getImageUrl());
		visitor = service.saveVisitory(visitor);
				
			return visitor.getId().toString();
	}
	
}
