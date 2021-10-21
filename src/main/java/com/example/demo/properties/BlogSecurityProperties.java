package com.example.demo.properties;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "blog.security")
public class BlogSecurityProperties {
	private QQProperties qqProperties =  new QQProperties();
	public QQProperties getQqProperties() {
		return qqProperties;
	}
	public void setQqProperties(QQProperties qqProperties) {
		this.qqProperties = qqProperties;
	}
}
