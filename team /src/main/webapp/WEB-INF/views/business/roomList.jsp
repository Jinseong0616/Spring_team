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
	
	
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/business/businessTopView.jsp"></jsp:include>
	
	<c:forEach begin="1" end="10" step="1">
		<div align="center" id="roomList">
		<img src="resources/room_img/room1.jpg" align="left" >
		<h2 id="roomName" align="center">room1</h2>
		<p align="center">이용인원 : 3</p>
		<h2 align="center">30,000원</h2>
	</div>
	</c:forEach>
	
	
</body>
</html>