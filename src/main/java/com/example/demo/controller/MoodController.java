package com.example.demo.controller;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Mood;
import com.example.demo.service.MoodService;
import com.example.demo.domain.User;



@Controller
public class MoodController {
	@Autowired
	private MoodService moodservice;
	
	@RequestMapping("/deleteMood")
	public String deleteMood(String deleteId) {
		Long id = new Long(deleteId);
		System.out.println(id);
		moodservice.deleteMoodById(id);
		return "redirect:/findMood";
	}
	@RequestMapping("/findMood")
	public ModelAndView findMood(Model model) {
		//����˵˵
	List<Mood> moodList = moodservice.findAllMood();
	//����model��
	model.addAttribute("moodList", moodList);
				
	return new ModelAndView("/mood","moodModel",model);
	}
	@RequestMapping("/saveMood")
	public String savaMood(@RequestParam("file")MultipartFile file,Mood mood) {
		System.out.println(mood + "------------------------");
		//��װcreateTime����
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String createTime = format.format(date);
		mood.setCreateTime(createTime);
		//TODO image����
		mood.setImage(file.getOriginalFilename());
		//��װUser���ݣ�ά����ϵ��
		moodservice.savaMood(mood);
		
		
		return "redirect:/findMood";
	}
}
