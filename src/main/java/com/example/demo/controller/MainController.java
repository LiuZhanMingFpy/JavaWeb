package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.enumeration.ModifyType;
import com.example.demo.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public String root() {
		return "/index";
	}
	@RequestMapping("/index")
	public ModelAndView index(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/index.html","ownermodel",model);	
		
	}
	
	@RequestMapping("/require")
	public ModelAndView require(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/login.html","ownermodel",model);	
		
	}
	@RequestMapping("/use")
	public String vendor(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return "/index.html";
		
	}
	@RequestMapping("/detail")
	public ModelAndView detail(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/detail.html","ownermodel",model);
	}
	@RequestMapping("/mood")
	public ModelAndView mood(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/mood.html","ownermodel",model);
	}
	@RequestMapping("/gustbook")
	public ModelAndView gustBook(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/gustbook.html","ownermodel",model);
	}
	@RequestMapping("/link")
	public ModelAndView link(Model  model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/link.html","ownermodel",model);
	}
	@RequestMapping("/archives")
	public ModelAndView archives(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/archives.html","ownermodel",model);
	}	
	@RequestMapping("/blog")
	public ModelAndView  bolg(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/blog.html","ownermodel",model);
	}	
	@RequestMapping("/image")
	public ModelAndView image(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/image.html","ownermodel",model);
	}
	@RequestMapping("/user")
	public ModelAndView user(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/user.html","ownermodel",model);
	}
	@RequestMapping("/findOwner")
	public ModelAndView findOwner(Model model){
		User owner = userService.getOwner();
		model.addAttribute("owner",owner);
		return new ModelAndView("/findOwner.html","ownermodel",model);
	}
	@RequestMapping("/visitorRegister")
	public String visitorRegister(Model model){
		
		return "register.html";
	}
	
}
