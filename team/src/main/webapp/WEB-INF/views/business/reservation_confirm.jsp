<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/business/businessTopView.jsp"></jsp:include>
	<h1 align="center">예약확인</h1>	
	
	<div align="center">
		<div id="searchbox" align="right">
			<select name="reservationInfo">
			  <option value="">-- 선택하세요 --</option>
			  <option value="roomName">방이름</option>
			  <option value="reservatorName">예약자이름</option>
			  <option value="checkIn">체크인</option>
			  <option value="checkOut">체크아웃</option>
			  <option value="reservationStatus">예약상태</option>
			</select>
			<input>
			<input type="button" value="검색" onclick="search()">
		</div>
		<table border="1">
		  <tr>
		    <th>객실</th>
		    <th>이용인원수</th>
		    <th>체크인</th>
		    <th>체크아웃</th>
		    <th>예약자이름</th>
		    <th>핸드폰번호</th>
		    <th>Email</th>
		    <th>예약상태</th>
		  </tr>
		  <c:forEach items="${list}" var="dto">
			  <tr>
			    <td>${dto.ro_name}</td>
			    <td>3</td>
			    <td>${dto.checkin_date}</td>
			    <td>${dto.checkout_datee}</td>
			    <td>홍길동</td>
			    <td>010-2222-2222</td>
			    <td>${dto.m_email}</td>
			    <td>${dto.status}</td>
			  </tr>
		  </c:forEach>
	
		</table>

	</div>
</body>
</html>