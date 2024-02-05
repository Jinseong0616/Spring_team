package com.korea.team;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.ReservationDAO;
import dao.RoomDAO;
import dto.ReservationDTO;
import dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import util.MyCommon;

@Controller
@RequiredArgsConstructor
public class BusinessController {

	
	@Autowired HttpServletRequest request;

	@Autowired
	final RoomDAO room_dao;
	
	@Autowired
	final ReservationDAO res_dao;

	@RequestMapping("addRoom_form")
	public String addRoom_from() {
		return MyCommon.VIEW_PATH + "business/addRoom.jsp";

	}

	@RequestMapping("addRoom")
	public String addRoom(RoomDTO dto) {
		photo_upload(dto);
		dto.setBu_email("hhh@naver.com");
		int res = room_dao.add(dto);
		
		if(res > 0) {
			return "roomList_form";
		}
		
		return null;
	}

	@RequestMapping("roomList_form")
	public String roomList_form(Model model) {
		
		List<RoomDTO> list = room_dao.selectList();
		model.addAttribute("list", list);
		
		return MyCommon.VIEW_PATH+"business/roomList.jsp";
	}

	@RequestMapping("reservation_form")
	public String reservation_form(Model model) {
		List<ReservationDTO> list = res_dao.selectList();
		model.addAttribute("list", list);
		return MyCommon.VIEW_PATH+"business/reservation_confirm.jsp";
	}

	@RequestMapping("checkIn_form")
	public String checkIn_form() {
		return MyCommon.VIEW_PATH + "business/checkIn.jsp";
	}

	@RequestMapping("checkOut_form")
	public String checkOut_form() {
		return MyCommon.VIEW_PATH + "business/checkOut.jsp";
	}

	@RequestMapping("review_form")
	public String review_form() {
		return MyCommon.VIEW_PATH + "business/review.jsp";
	}
	
	@RequestMapping("modify_form")
	public String modify_form(Model model, int ro_num) {
		//매개변수로 넘어온 idx를 이용해 게시물 한건을 찾는다.
		//RoomDTO dto = room_dao.selectOne(idx);
		System.out.println(ro_num);
		RoomDTO dto = room_dao.selectOne(ro_num);
		
		model.addAttribute("dto",dto);
		
		return MyCommon.VIEW_PATH + "business/roomModify.jsp";
	}
	
	@RequestMapping("modify")
	public String modify(RoomDTO dto) {
		photo_upload(dto);
		dto.setBu_email("hhh@naver.com");
		int res = room_dao.update(dto);
		
		if(res > 0) {
			return "roomList_form";
		}
		
		return null;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(int num) {
		int res = room_dao.delete(num);
		
		String result = "no";
		
		if(res == 1) {
			result = "yes";
		}
		
		String finRes = String.format("[{'res':'%s'}]", result);
		return finRes;
	}
	
	
	//함수---------------------------------함수--------------------함수-------------
	public RoomDTO photo_upload(RoomDTO dto) {
		String webPath = "/resources/room_img/";
		webPath = String.format("%s/%s/", webPath, dto.getRo_name());
		String savePath = request.getServletContext().getRealPath(webPath);
		System.out.println(savePath);
		
		MultipartFile photo = dto.getRopicture();
		String fileName = "no_file";

		if (!photo.isEmpty()) {
			fileName = dto.getRo_name()+".jpeg";
			
		
			File saveFile = new File(savePath, fileName);
			
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				saveFile.delete();
				saveFile = new File(savePath,fileName);
			}

			try {
				photo.transferTo(saveFile);
			} catch (Exception e) {

			}
			dto.setRo_picture(fileName);
		}
		return dto;

	}
}
