package com.example.demo.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Visitor;
@Service
@ComponentScan(basePackages = {"com.example.demo.service.VisitorService"})
public interface VisitorService {
	Visitor saveVisitory(Visitor visitor);
	Visitor findVisitorByUsername(String telephone);
}
