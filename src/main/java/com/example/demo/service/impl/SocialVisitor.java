package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import com.example.demo.domain.Visitor;
import com.example.demo.repository.VisitorRepository;

public class SocialVisitor implements SocialUserDetailsService {
 @Autowired
 private VisitorRepository visitor;
 @Autowired
 private PasswordEncoder passwordEncoder;
	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Visitor> optional = visitor.findById(new Long(userId));
		Visitor visitor = optional.get();
		if(visitor == null) {
			throw new UsernameNotFoundException(userId);
		}
		return new SocialUser(visitor.getUsername(),passwordEncoder.encode(visitor.getPassword()),true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("VISITOR"));
	}
 
 
}
