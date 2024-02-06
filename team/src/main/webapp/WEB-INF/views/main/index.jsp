<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="resources/css/index.css">
</head>
<body>
	<header class="header">
		<div class="container g-0">
			<div class="row d-flex justify-content-between">
				<div class="col d-flex justify-content-center align-items-center">
					<h1 class="logo">LOGO</h1>
				</div>
				<div class="col-8"></div>
				<div class="info col d-flex justify-content-between">
					<ul class="gnb d-flex align-items-center">
						<li><a href="">지도검색</a></li>
						<li><a href="">예약내역</a></li>
						<li><a href="login_form">로그인<i class="bi bi-person-circle"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>

	<main>
		<section class="visual">
			<div class="row">
				<img src="resources/main_img/main1.webp" alt="">
			</div>
		</section>

		<section class="category">
			<div class="container-xl">
				<h2 class="title">원하는 숙소를 찾아보세요</h2>
				<div class="row g-0">
					<div class="col">
						<a href="view_roomList?bu_id=1"> <img src="resources/main_img/main_hotel.jpg" alt="">
							<div class="view">호텔</div>
						</a>
					</div>
					<div class="col">
						<a href="view_roomList?bu_id=2"><img src="resources/main_img/main_motel.webp" alt=""></a>
					</div>
					<div class="col">
						<a href="view_roomList?bu_id=3"><img src="resources/main_img/main_pension.webp" alt=""></a>
					</div>
					<div class="col">
						<a href="view_roomList?bu_id=4"><img src="resources/main_img/main_resort.jpg" alt=""></a>
					</div>
				</div>
			</div>

		</section>
	</main>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>