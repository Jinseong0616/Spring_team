package com.korea.team;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import util.MyCommon;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	final MemberDAO member_dao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("login")
	@ResponseBody
	public String login(String m_email, String m_pwd) {
		
		// m_email에 해당하는 데이터 1건 조회
		MemberDTO dto = member_dao.selectOne(m_email);
		
		// dto가 null일 경우 m_email이 존재하지 DB에 존재하지 않는다.
		if(dto == null) {
			return "[{'param':'no_m_email'}]";
		}
		
		if(!m_pwd.equals(dto.getM_pwd())) {
			return "[{'param':'no_m_pwd'}]";
		}
		
		session.setAttribute("m_email", dto);
		
		// 로그인 성공한 경우
		return "[{'param':'clear'}]";
	}
	
	@RequestMapping("login_form")
	public String loging_form() {
		return MyCommon.VIEW_PATH+"member/login_form.jsp";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.removeAttribute("m_email");
		return "redirect:index";
	}
	
	@RequestMapping("member_insert_form")
	public String member_insert_form() {
		return MyCommon.VIEW_PATH+"member/member_insert_form.jsp";
	}
	
	@RequestMapping("check_e_email")
	@ResponseBody
	public String check_m_email(String m_email) {
		MemberDTO dto = member_dao.selectOne(m_email);
		
		if(dto == null) {
			return "[{'result':'yes'}]";
		}
		return "[{'result':'no'}]";	
	}
	
	@RequestMapping("member_insert")
	public String member_insert(MemberDTO dto) {
		int res = member_dao.insert(dto);
		
		if(res > 0) {
			return "redirect:index";
		}
		
		return null;
	}
}
