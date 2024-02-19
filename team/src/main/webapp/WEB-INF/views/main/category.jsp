<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/header.css" />
<style type="text/css">
#roomList {
	border: solid 1px green;
	width: 600px;
	height: 183px;
	margin: auto;
	margin-top: 30px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/main/header.jsp"></jsp:include>

	<c:forEach var="dto" items="${list}">
		<form action="room_view" method="post">
			<input type="hidden" name ="bu_email" value ="${dto.bu_email}">
			<%-- <a href = "room_view?bu_email=${dto.bu_email}">테스트 해보기</a> --%>
			<!-- <button>테스트 해보기2</button> -->
			<button>
			<div align="center" id="">
				<%-- <img src="/resources/business_img/${dto.bu_title}/${dto.ro_picture}" align="left"> --%>
				<h2 id="roomName" align="center">${dto.bu_title}</h2>
				<p>${dto.bu_addr}</p>
				<h3 align="center">가격 : ${dto.min_price}원~</h3>
			</div>
			</button>
		</form>
	</c:forEach>




</body>
</html>