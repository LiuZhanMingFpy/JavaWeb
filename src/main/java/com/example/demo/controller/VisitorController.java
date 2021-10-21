package com.example.demo.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Visitor;
import com.example.demo.service.VisitorService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;


@Controller
public class VisitorController {
	public String SMS = null;
	@Autowired
	private VisitorService visitorService;

public void MSM(String telephone,HttpSession session) {
	Random r = new Random();
    int appid = 1400303471;
    String appKey = "b1869b45706ed54b4c5e0210fc12cfc2";
    int templateId = 514908;
    String smsSign = "飞虎队归位";
    String phoneNumber = telephone;
   
    String code = "";
    for (int i = 0; i<4; i++) {
		code += r.nextInt(10);
	}
     System.out.println("邀请码是"+code);
     session.setAttribute("SMS", code);
     
     String[] params = new String[1];
     params[0] = code;
     SmsSingleSender ssender = new SmsSingleSender(appid, appKey);
    		 try {
				SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, templateId, params, smsSign, "", "");
				System.out.println(result);
			} catch (JSONException | HTTPException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
@RequestMapping("/sendSMS")
@ResponseBody
public String sendSMS(String telephone,HttpSession session)
{
	//判断数据库是否存在该手机号
	//存在，不发送短信
	String json = null;
	if(visitorService.findVisitorByUsername(telephone) != null)
	{
		json = "{\"message\":"+false+"}";
	}
	//不存在，发送短信
	else
	{
		MSM(telephone,session);
		json = "{\"message\":"+true+"}";
	}
	
	

	
	return json;
}

@RequestMapping("/registerVisitor")
public String registerVisitor(Visitor visitor) {
	Random r = new Random();
int random =	r.nextInt(11) + 1;

	visitor.setImage("/image/1-"+random+".jpg");
	visitorService.saveVisitory(visitor);
	return "redirect:/visitorLogin";
	
}

@ResponseBody
@RequestMapping("/judgeSMS")
public String judgeSMS(String smsCode,HttpSession session)
{
	
	 
	String codeInSession = (String) session.getAttribute("SMS");
	
	String json = null;
	if(smsCode.equals(codeInSession))
	{
		json = "{\"message\":"+true+"}";
	}
	else
	{
		json = "{\"message\":"+false+"}";
	}
	System.out.print(smsCode.equals(codeInSession));
	return json;
}}
