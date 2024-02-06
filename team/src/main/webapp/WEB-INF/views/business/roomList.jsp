<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/HttpRequest.js"></script>
<style type="text/css">
 	#roomList{
		border: solid 1px green;
		width: 600px;
		height: 183px;
		margin: auto;
		margin-top: 30px;
	}
	p{
		margin: 0px;
	}
	
	img{
		width: 275px;
		height: 183px;
	}
	
	
</style>
<script type="text/javascript">

	function modify(f){
		var ro_num = f.ro_num.value;
		alert(ro_num);
		
		f.action = "modify_form";
		f.method = "POST";
		f.submit();
	}
	
	
	function del(f){
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		
		var url = "delete"
		var param = "num="+f.ro_num.value;
		
		sendRequest(url,param,resultFn,"POST");
	}
	
	function resultFn(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = (new Function ('return' + data))();
			
			if(json[0].res == 'no'){
				alert("삭제 실패");
				return;
			}
			
			alert('삭제 성공');
			location.href='roomList_form';
		}
	}
	
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/business/businessTopView.jsp"></jsp:include>
	
	<c:forEach var="dto" items="${list}">
	
	<form>
	<div align="center" id="roomList">
		<input type="hidden" name="ro_num" value="${dto.ro_num}">
		<img src="resources/room_img/${dto.ro_name}/${dto.ro_picture}" align="left"; onclick="modify('${dto.ro_num}');">
		<p align="right">
			<input type="button" value="삭제" style="background-color: red; align-content: " onclick="del(this.form)">
			<input type="button" value="수정" onclick="modify(this.form)">
		</p>		
		<h2 id="roomName" align="center" style="margin: 0px;">${dto.ro_name}</h2>
		<p align="center">이용인원 : ${dto.ro_count}</p>
		<p align="center"  >체크인시간 : ${dto.checkin}</p>
		<p align="center">체크아웃시간 : ${dto.checkout}</p>
		<h2 align="center" style="margin-top:5px;">${dto.ro_price}원</h2>		
	</div>
	</form>	
	</c:forEach>
	
	
</body>
</html>