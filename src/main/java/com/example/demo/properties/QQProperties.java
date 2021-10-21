package com.example.demo.properties;

public class QQProperties {
	private String appId = "100550231";
	private String appSecret = "69b6ab57b22f3c2fe6a614927e3295e";
	private String providerId = "callback.do";
	private String filterProcessUrl= "/qqLogin";
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String addSecret) {
		this.appSecret = addSecret;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getFilterProcessUrl() {
		return filterProcessUrl;
	}
	public void setFilterProcessUrl(String filterProcessUrl) {
		this.filterProcessUrl = filterProcessUrl;
	}
	
}
