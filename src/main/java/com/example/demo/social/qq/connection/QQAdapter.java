package com.example.demo.social.qq.connection;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import com.example.demo.social.qq.api.QQ;
import com.example.demo.social.qq.api.QQUserInfo;

public class QQAdapter implements ApiAdapter<QQ>{

	@Override
	public boolean test(QQ api) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		// TODO Auto-generated method stub
	QQUserInfo userInfo =	api.getUserInfo();
	values.setDisplayName(userInfo.getNickname());
	values.setImageUrl(userInfo.getFigureurl_qq_1());
	values.setProfileUrl(null);
	values.setProviderUserId(userInfo.getOpenId());
	
	}

	@Override
	public UserProfile fetchUserProfile(QQ api) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(QQ api, String message) {
		// TODO Auto-generated method stub
		
	}
	
}
