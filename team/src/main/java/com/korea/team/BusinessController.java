package com.korea.team;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.BusinessDAO;
import dao.ReservationDAO;
import dao.ReviewDAO;
import dao.RoomDAO;
import dto.BusinessDTO;
import dto.ReservationDTO;
import dto.ReviewDTO;
import dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import util.MyCommon;

@Controller
@RequiredArgsConstructor
public class BusinessController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	final BusinessDAO business_dao;

	@Autowired
	final RoomDAO room_dao;

	@Autowired
	final ReservationDAO res_dao;
	
	@Autowired
	final ReviewDAO rev_dao;
	
	//����� �̸���
	String bu_email;
	
	//����� �α��ν� ù ������
	@RequestMapping("businessPage")
	public String businessPage(Model model, String bu_email) {
		this.bu_email = bu_email;
		System.out.println(bu_email);
		model.addAttribute("bu_email",bu_email);
		//return MyCommon.VIEW_PATH + "business/businessTopView.jsp";
		return "roomList_form";
	}

	// ���� ��� ������
	@RequestMapping("addRoom_form")
	public String addRoom_from() {
		System.out.println("addroom: "+bu_email);
		return MyCommon.VIEW_PATH + "business/addRoom.jsp";

	}

	// ���� ���
	@RequestMapping("addRoom")
	public String addRoom(RoomDTO dto) {
		photo_upload(dto);
		dto.setRo_info(change_string(dto.getRo_info()));
		dto.setBu_email(bu_email);
		int res = room_dao.add(dto);

		if (res > 0) {
			return "redirect:roomList_form";
		}

		return null;
	}

	// ���� ����Ʈ ������
	@RequestMapping("roomList_form")
	public String roomList_form(Model model) {
		System.out.println(bu_email);
		List<RoomDTO> list = room_dao.selectList(bu_email);
		
		model.addAttribute("list", list);

		return MyCommon.VIEW_PATH + "business/roomList.jsp";
	}
	
	//���� �󼼺���
	@RequestMapping("detail")
	public String detail(Model model, int ro_num) {
		RoomDTO dto = room_dao.selectOne(ro_num);
		model.addAttribute("dto", dto);

		return MyCommon.VIEW_PATH + "business/view_detail.jsp";
	}
	
	//����ȭ��
	@RequestMapping("modify_form")
	public String modify_form(Model model, int ro_num) {
		System.out.println(bu_email);
		// �Ű������� �Ѿ�� idx�� �̿��� �Խù� �Ѱ��� ã�´�.
		// RoomDTO dto = room_dao.selectOne(idx);
		System.out.println(ro_num);
		RoomDTO dto = room_dao.selectOne(ro_num);
		model.addAttribute("dto", dto);

		return MyCommon.VIEW_PATH + "business/roomModify.jsp";
	}
	
	//���� ���
	@RequestMapping("modify")
	public String modify(RoomDTO dto) {
		if (!dto.getRopicture()[0].isEmpty()) { //
			photo_upload(dto);
			System.out.println("�������ε�Ϸ�");
		} else {
			dto.setRo_picture(dto.getRo_name() + "_" + dto.getPicture_count() + ".jpeg");
			System.out.println("���� ����");
		}
		dto.setBu_email("hhh@naver.com");
		int res = room_dao.update(dto);

		if (res > 0) {
			return "redirect:roomList_form";
		}

		return null;
	}
	
	//���� ����
	@RequestMapping("delete")
	@ResponseBody
	public String delete(int num, String ro_name) {
		delete_folder(ro_name);

		int res = room_dao.delete(num);

		String result = "no";

		if (res == 1) {
			result = "yes";
		}

		String finRes = String.format("[{'res':'%s'}]", result);
		return finRes;
	}

	// ���� ���� ������
	@RequestMapping("reservation_form")
	public String reservation_form(Model model) {
		System.out.println(bu_email);
		List<ReservationDTO> list = res_dao.selectList(bu_email);
		
		model.addAttribute("list", list);
		return MyCommon.VIEW_PATH + "business/reservation_confirm.jsp";
	}

	// ���� ���� �˻�
	@RequestMapping("search_reservation")
	public String search_reservation(Model model, String box, String text) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("bu_email", bu_email);
		map.put("box", box);
		map.put("text", text);

		List<ReservationDTO> list = res_dao.search(map);
		model.addAttribute("list", list);
		return MyCommon.VIEW_PATH + "business/reservation_confirm.jsp";

	}
	
	//üũ��ȭ��
	@RequestMapping("checkIn_form")
	public String checkIn_form(Model model) {
		System.out.println(bu_email);
		List<ReservationDTO> list = res_dao.selectList(bu_email);

		model.addAttribute("list", list);
		return MyCommon.VIEW_PATH + "business/checkIn.jsp";
	}
	
	//üũ�� ������� ����
	@RequestMapping("checkIn")
	@ResponseBody
	public String checkin(String num) {
		int res = res_dao.checkIn(num);

		if (res == 1) {
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}
	}

	//üũ�ƿ� ȭ��
	@RequestMapping("checkOut_form")
	public String checkOut_form(Model model) {
		System.out.println(bu_email);
		List<ReservationDTO> list = res_dao.selectList(bu_email);

		model.addAttribute("list", list);
		return MyCommon.VIEW_PATH + "business/checkOut.jsp";
	}

	//üũ�ƿ� ������� ����
	@RequestMapping("checkOut")
	@ResponseBody
	public String checkOut(String num) {
		int res = res_dao.checkOut(num);

		if (res == 1) {
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}
	}
	
	//���� ȭ��
	@RequestMapping("review_form")
	public String review_form(Model model) {
		List<ReviewDTO> list = rev_dao.selectList(bu_email);
		model.addAttribute("list", list);
		return MyCommon.VIEW_PATH + "business/review.jsp";
	}
	
	@RequestMapping("review_reply")
	@ResponseBody
	public String review_reply(Model model, String rev_num, String replyBox) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rev_num", rev_num);
		map.put("replyBox", replyBox);
		
		int res = rev_dao.reply(map);
		
		if (res == 1) {
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}
	}
	
	//����� �α���
	@RequestMapping("bu_login")
	@ResponseBody
	public String login(String bu_email, String bu_password) {

		BusinessDTO dto = business_dao.selectOne(bu_email);

		if (dto == null) {
			return "[{'param':'no_bu_email'}]";
		}

		if (!bu_password.equals(dto.getBu_password())) {
			return "[{'param':'no_bu_password'}]";
		}

		session.setAttribute("bu_email", dto);

		return "[{'param':'clear'}]";
	}

	// �Լ�---------------------------------�Լ�--------------------�Լ�-------------
	// ���� ���� �� ��Ͻ� ���� ���ε�
	public RoomDTO photo_upload(RoomDTO dto) {
		String webPath = "/resources/"+bu_email+'/';
		webPath = String.format("%s/%s/", webPath, dto.getRo_name());
		String savePath = request.getServletContext().getRealPath(webPath);

		System.out.println(savePath);

		int picCount = dto.getPicture_count(); // 3

		for (int i = 0; i < dto.getRopicture().length; i++) {
			System.out.println(i);
			MultipartFile photo = dto.getRopicture()[i];
			String fileName = "no_file";

			if (!photo.isEmpty()) {
				fileName = dto.getRo_name() + '_' + (++picCount) + ".jpeg"; // ���̸�_1.jpeg, ���̸�_2.jpeg

				File saveFile = new File(savePath, fileName);

				if (!saveFile.exists()) {
					saveFile.mkdirs();
				} else {
					saveFile.delete();
					saveFile = new File(savePath, fileName);
				}

				try {
					photo.transferTo(saveFile);
				} catch (Exception e) {

				}
				dto.setRo_picture(fileName);
				dto.setPicture_count(picCount);
			}
		}

		return dto;

	}

	// ���� ������ ���Ǹ��� �ٲ�� ���� ������ ��� ������ ����� ������
	// ���� �����̸����� ������� ������ �����ϴ� �޼���
	public void delete_folder(String x_name) {
		x_name = "resources/room_img/" + x_name + '/';

		File x_file = new File(request.getServletContext().getRealPath(x_name));

		File[] deleteFolderList = x_file.listFiles();

		for (int j = 0; j < deleteFolderList.length; j++) {
			deleteFolderList[j].delete();
		}

		x_file.delete();
	}

	public String change_string(String info) {
		return info.replaceAll("\n", "<br>");
	}
}
