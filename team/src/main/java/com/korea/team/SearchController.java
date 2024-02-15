package com.korea.team;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.RoomDAO;
import dao.SearchDAO;
import dto.RoomDTO;
import dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import util.MyCommon;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
	final RoomDAO room_dao;
	final SearchDAO search_dao;
	
	@RequestMapping("search")
	public String main_search(Model model, SearchDTO dto) {
		
		List<SearchDTO> list = search_dao.selectList(dto);
		
		model.addAttribute("list", list);
		return MyCommon.VIEW_PATH+"search.jsp";
		
		
	}
	
	//카테고리별로 보기
		@RequestMapping("category")
		public String view_accomoList(Model model, @RequestParam(value = "bu_id", required = true)int bu_id) {
			
			List<SearchDTO> list = search_dao.selectList(bu_id);
			model.addAttribute("list",list);
			
			return MyCommon.VIEW_PATH+"main/category.jsp?bu_id=" + bu_id;
		}
	
	
	@RequestMapping("room_view")
	public String room_view(Model model, String bu_email) {
		
		List<RoomDTO> list = room_dao.selectList(bu_email);
		
		model.addAttribute("list", list);
		
		return MyCommon.VIEW_PATH+"search.jsp";
	}
	
	
	
	
	
	
	
	
	

}
