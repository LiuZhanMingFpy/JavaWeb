package com.example.demo.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Configuration
//�����ǵ�������Ч
@EnableConfigurationProperties(BlogSecurityProperties.class)
public class BlogSecurityConfig {

}
