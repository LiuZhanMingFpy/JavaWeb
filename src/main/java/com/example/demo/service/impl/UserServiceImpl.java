package com.example.demo.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	@Transactional 
	public void modifyUsername(String username) {
		userRepository.modifyUsername(username);
	}
	@Override
	public User getOwner() {
		// TODO Auto-generated method stub
		Optional<User> owner = userRepository.findById(1L);
		 return owner.get();
	}
	@Override
	@Transactional 
	public void modifyPassword(String password) {
		// TODO Auto-generated method stub
		userRepository.modifyPassword(password);
	}
	@Override
	@Transactional 
	public void modifyPersonalSign(String personalSign) {
		// TODO Auto-generated method stub
		userRepository.modifyPersonalSign(personalSign);
	}
	@Override
	@Transactional
	public void modifyHead(String head) {
		// TODO Auto-generated method stub
		userRepository.modifyHead(head);
	}
	@Override
	public User findUserByUsername(String username) {
		User user= userRepository.findUserByUsername(username);
		return user;
	}
}
