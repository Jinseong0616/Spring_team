<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/HttpRequest.js"></script>
<script type="text/javascript">
	function send(f){
		var m_email = f.m_email.value.trim();
		var m_pwd = f.m_pwd.value.trim();
		
		
		if(m_email ==''){
			alert("이메일을 입력해주세요")
			return;
		}
		if(m_pwd ==''){
			alert("비밀번호를 입력해주세요")
			return;
		}
		
		var url="login";
		var param = "m_email="+m_email+"&m_pwd="+encodeURIComponent(m_pwd);
		
		sendRequest(url,param, myCheck,"post");
	}
	
	function myCheck(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = (new Function('return' + data))();
			
			if(json[0].param == 'no_m_email'){
				alert('아이디가 존재하지 않습니다.')
			}else if(json[0].param == 'no_m_pwd'){
				alert('비밀번호가 올바르지 않습니다.')
			}else{
				alert('로그인 성공')
				location.href = "index";
			}
		}
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>로그인</caption>
			<tr>
				<th>이메일</th>
				<td><input name="m_email"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="m_pwd" type="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="로그인" onclick="send(this.form)">
					<input type="button" value="회원가입" onclick="location.href='member_insert_form'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>