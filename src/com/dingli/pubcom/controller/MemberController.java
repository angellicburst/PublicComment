package com.dingli.pubcom.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dingli.pubcom.bean.Member;
import com.dingli.pubcom.service.impl.MemberServiceImpl;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl loginService;
	
	@RequestMapping(value="/login")
	public String preLogin() {
		return "system/login";
	}
	
	@RequestMapping(value="/checkLogin")
	public String login(HttpServletRequest request,Member member) {
		Member mem = loginService.CheckLogin(member);
		if (mem !=null) {
			request.getSession().setAttribute("loginMember", mem);
			return "redirect:/index";
		} else {
			return "redirect:/login"; //一个控制器到另一个控制器
		}	
	}	
	
	@RequestMapping(value="/index")
	public String Index(Model m) {
		return "system/index";
	}
	
	@RequestMapping(value="/session")
	public String session(HttpServletRequest request) {
		//System.out.println((Member)request.getSession().getAttribute("loginMember"));
		request.getSession().invalidate();
		//System.out.println((Member)request.getSession().getAttribute("loginMember"));
		return "redirect:/login";
	}
}
