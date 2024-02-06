<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
		f.action = "modify";
		f.method = "post";
		f.submit();
	}

</script>
</head>
<body>
	<form enctype="multipart/form-data">
		<input type="hidden" name="ro_num" value="${dto.ro_num}">
		<table border="1">
			<caption>:::객실 정보 수정:::</caption>
			<tr>
				<th>객실 이름</th>
				<td><input name="ro_name" value="${dto.ro_name}"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input name="ro_price" value="${dto.ro_price}"></td>
			</tr>
			<tr>
				<th>체크인 시간</th>
				<td><input type="time" name="checkin" value="${dto.checkin}"></td>				
			</tr>
			<tr>
				<th>체크아웃 시간</th>
				<td><input type="time"  name="checkout" value="${dto.checkout}"></td>				
			</tr>
			<tr>
				<th>최대 인원수</th>
				<td><input name="ro_count" value="${dto.ro_count}"></td>
			</tr>
			<tr>
				<th>객실 기본정보</th>
				<td><textarea name="ro_info" rows="10" cols="50" style="resize:none;">${dto.ro_info}</textarea></td>
			</tr>
			<tr>
				<th>사진등록</th>
				<td><input name="ropicture" type="file"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="send(this.form)">
					<input type="button" value="목록" onclick="location.href='roomList_form'">
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>