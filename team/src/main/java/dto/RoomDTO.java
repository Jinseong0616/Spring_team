package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {
	private String ro_name, ro_price, checkIn, checkOut, ro_info, bu_email, photoSavePath;
	private int ro_num, ro_count;
	private MultipartFile ropicture;
}
