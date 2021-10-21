package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
@Component
public class VisitorServicelmpl implements VisitorService {
	@Autowired
	private VisitorRepository visitorRepository;
	@Override
	public Visitor saveVisitory(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitorRepository.save(visitor);
	}

	@Override
	public Visitor findVisitorByUsername(String telephone) {
		Visitor visitor = visitorRepository.findVisitorByUsername(telephone);
		// TODO Auto-generated method stub
		return visitor;
	}

}
