package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
import java.util.Base64.Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.enumeration.ModifyType;
import com.example.demo.service.UserService;

@Controller
public class UserController {

@Autowired
private UserService userService;


@RequestMapping("/modifyPersonalSign")
public String modifyPersonalSign(String personalSign,Model model) {
	
	modifyUser(ModifyType.PERSONAL_SIGN, personalSign);
	return "user.html";
}

@RequestMapping("/modifyPassword")
public String modifyPassword(String password,Model model) {
	
	modifyUser(ModifyType.PASSWORD, password);
	return "user.html";
}
//修改用户名
@RequestMapping("/modifyUsername")
public String modifyUsername(String username,Model model) {
	
	modifyUser(ModifyType.PASSWORD, username);
	return "user.html";
		
}
//得到用户的请求
@RequestMapping("/getOwner")
public String getOwner(Model model) {
	modifyUser(ModifyType.NONE, null);
	
	return "user.html";		
}
@ResponseBody
@RequestMapping("/uploadHeadImage")
public String uploadHeadImage(String base64) throws IOException {
	System.out.print("进入upload");
	String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload/image";
	File fileLocation = new File(path);
	if (!fileLocation.exists()) {
		fileLocation.mkdir();
	}
	if (base64.indexOf("jpeg") != -1) {
		base64= base64.replaceFirst("jpeg", "jpg");
	}
	String upName = UUID.randomUUID().toString() + System.currentTimeMillis() +"."+base64.substring(11, 14);
	String 	iconBase64=base64.substring(22);
	Decoder decoder = Base64.getDecoder();
	byte[] buffer = decoder.decode(iconBase64);
	 FileOutputStream out =  new FileOutputStream(path+"/"+upName);
	 System.out.print(iconBase64);
	 out.write(buffer);
	 
	 out.close();
	 modifyUser(ModifyType.HEAD,upName);
	 
	
		
		return "redirect:/user";
}
@RequestMapping("/visitorLogin")
public String visitorLogin() {
	return "/login.html";
}
private void modifyUser(ModifyType type,String modiInfo){
	switch(type) {
	case HEAD:
		userService.modifyHead(modiInfo);
		break;
	case PASSWORD:
		userService.modifyPassword(modiInfo);
		break;
	case USERNAME:
		userService.modifyUsername(modiInfo);
	break;
	case PERSONAL_SIGN:
		userService.modifyPersonalSign(modiInfo);
	break;
	default:
		break;
	}
}
}
