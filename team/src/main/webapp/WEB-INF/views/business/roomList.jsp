<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<jsp:include page="/WEB-INF/views/business/businessTopView.jsp"></jsp:include>
	
	<c:forEach var="dto" items="${list}">
	<form action="detail" method="post">
	<button>
	<div align="center" id="roomList" >
		<input type="hidden" name="ro_num" value="${dto.ro_num}">
		<img src="resources/${dto.bu_email}/${dto.ro_name}/${dto.ro_picture}" align="left">
		<h2 id="roomName" align="center" style="margin: 0px;">${dto.ro_name}</h2>
		<p align="center">이용인원 : ${dto.ro_count}</p>
		<p align="center"  >체크인시간 : ${dto.checkin}</p>
		<p align="center">체크아웃시간 : ${dto.checkout}</p>
		<h2 align="center" style="margin-top:5px;">${dto.ro_price}원</h2>
	</div>
	</button>
	</form>
	</c:forEach>
</body>
</html>