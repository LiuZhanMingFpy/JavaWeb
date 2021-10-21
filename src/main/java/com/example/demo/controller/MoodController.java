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
		//查找说说
	List<Mood> moodList = moodservice.findAllMood();
	//放入model中
	model.addAttribute("moodList", moodList);
				
	return new ModelAndView("/mood","moodModel",model);
	}
	@RequestMapping("/saveMood")
	public String savaMood(@RequestParam("file")MultipartFile file,Mood mood) {
		System.out.println(mood + "------------------------");
		//封装createTime数据
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String createTime = format.format(date);
		mood.setCreateTime(createTime);
		//TODO image数据
		mood.setImage(file.getOriginalFilename());
		//封装User数据（维护关系）
		moodservice.savaMood(mood);
		
		
		return "redirect:/findMood";
	}
}
