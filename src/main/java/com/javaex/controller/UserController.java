package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value = "/loginForm",method=RequestMethod.GET)
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("id")String id,@RequestParam("password")String password,HttpSession session) {
		
		UserVo authUser =userService.login(id, password);
		
		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "main/index";
		} else {
			return "redirect:/user/loginform?result=fail";
		}
	}
	
	@RequestMapping(value="/joinForm",method=RequestMethod.GET)
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo,Model model) {
		
		userService.join(userVo);
		model.addAttribute("userVo",userVo);
		return "user/joinSuccess";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck",method=RequestMethod.POST)
	public boolean serchId(@RequestParam("id")String id) {
		
		System.out.println("컨트롤러 serchId");
		return userService.serchId(id);

	}

}
