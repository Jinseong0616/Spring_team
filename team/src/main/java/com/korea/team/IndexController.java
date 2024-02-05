package com.korea.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import util.MyCommon;

@Controller
@RequiredArgsConstructor
public class IndexController {

//	final MemberDAO member_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = {"/","index"})
	public String list(Model model) {
		model.addAttribute(model);
		return MyCommon.VIEW_PATH+"main/index.jsp";
	}
	
	@RequestMapping("login_form")
	public String login_form() {
		return MyCommon.VIEW_PATH+"main/login_form.jsp";
	}
	
}
