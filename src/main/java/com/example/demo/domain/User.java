package com.example.demo.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;
	private String personalSign;
	private String image;
	private String creatTime;
	
	protected User() {
		
	}
	
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPersonalSign() {
		return personalSign;
	}
	public void setPersonalSign(String personalSign) {
		this.personalSign = personalSign;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User(Long id,String username,String passWord,String personalSign,String image,String creatTime){
		this.id = id ;
		this.username = username;
		this.password = passWord;
		this.personalSign = personalSign;
		this.image = image;
		this.creatTime = creatTime;
	}
}
