package com.example.demo.social.qq.config;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

class DemoSpringSocialConfigurer extends SpringSocialConfigurer {
	private String filterProcessesUrl;
	public DemoSpringSocialConfigurer (String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}
	@Override
	protected <T> T postProcess(T object) {
		// TODO Auto-generated method stub
		//ªÒµ√filter
		SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
		//…Ë÷√◊÷∂Œ
		filter.setFilterProcessesUrl(filterProcessesUrl);
		return (T)filter;
	}
}
