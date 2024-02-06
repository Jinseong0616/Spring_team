package com.korea.team;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BusinessDAO;
import dto.BusinessDTO;
import lombok.RequiredArgsConstructor;
import util.MyCommon;

@Controller
@RequiredArgsConstructor
public class IndexController {

	final BusinessDAO business_dao;
	
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
		return MyCommon.VIEW_PATH+"member/login_form.jsp";
	}
	
	@RequestMapping("view_roomList")
	public String list(Model model, @RequestParam(value = "bu_id", required = false)int bu_id) {
		
		List<BusinessDTO> list = business_dao.selectList(bu_id);
		model.addAttribute("list",list);
		
		return MyCommon.VIEW_PATH+"main/main_roomList.jsp?bu_id=" + bu_id;
	}
	
}
