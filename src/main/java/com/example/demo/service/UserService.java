package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
@Service
public interface UserService {

	void modifyUsername(String name);

	User getOwner();

	void modifyPassword(String password);

	void modifyPersonalSign(String personalSign);

	void modifyHead(String modiInfo);

	User findUserByUsername(String username);

	

}
