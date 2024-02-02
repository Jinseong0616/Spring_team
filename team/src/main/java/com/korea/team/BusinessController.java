package com.korea.team;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.RoomDAO;
import dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import util.MyCommon;

@Controller
@RequiredArgsConstructor
public class BusinessController {

	
	 @Autowired HttpServletRequest request;
	 

	int ro_num = 0;

	@Autowired
	final RoomDAO room_dao;

	@RequestMapping("addRoom_form")
	public String addRoom_from() {
		return MyCommon.VIEW_PATH + "business/addRoom.jsp";

	}

	@RequestMapping("addRoom")
	public String addRoom(RoomDTO dto) {
		photo_upload(dto);
		dto.setBu_email("hhh@naver.com");
		int res = room_dao.add(dto);

		if (res > 0) {
			return "rommList_form";
		}

		return "roomList_form";
	}

	@RequestMapping("roomList_form")
	public String roomList_form() {
		return MyCommon.VIEW_PATH + "business/roomList.jsp";
	}

	@RequestMapping("reservation_confirm_form")
	public String reservation_confirm_form() {
		return MyCommon.VIEW_PATH + "business/reservation_confirm.jsp";
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

	public RoomDTO photo_upload(RoomDTO dto) {
		String savePath = "C:/WEB_HTB/5.spring/work/Project_business/src/main/webapp/resources/room_img";
		MultipartFile photo = dto.getRopicture();
		String fileName = "no_file";

		if (!photo.isEmpty()) {
			fileName = dto.getRo_name() + ".jpg";
			File saveFile = new File(savePath, fileName);
			dto.setPhotoSavePath(savePath);
			if (!saveFile.exists()) {
				saveFile.mkdirs();
			}

			try {
				photo.transferTo(saveFile);
			} catch (Exception e) {

			}
		}
		return dto;

	}
}
