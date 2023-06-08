<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="./Newcss.css">
<script>
	function validateAdmin(){
		var mgrcode = "*1111";
		var code = document.getElementById('code').value;
		
		if(code!=mgrcode){
			alert("관리자 코드를 다시 확인해주세요!");
			return false;
		}
		else{
			window.location="./Admin/Admin.jsp"
			return true;
		}
	}
</script>
</head>
<body>

<div>
<br>
	<form name=Loginform action=Login.jsp method=post>
	<table style="width:100%;height:100%;border:1px solid white">
		<tr><td><input type="text" class="textbox" name="login_id" placeholder="아이디"/></td></tr>
		<tr><td><input type="text" class="textbox" name="login_pwd" placeholder="비밀번호"/></td></tr>
		<tr><td><input type="submit" value="로그인" class="button"/></td></tr>
	</table>
	</form><br>
	<font style="font-size:11pt">아직 회원이 아니신가요?</font><br>
	<button onclick="location='Regist.jsp'" class="button" >회원가입</button><br><br><br><br>
	<font style="font-size:13pt">회원 관리</font><br>
	<input type="text" class="textbox" id="code" name="code" placeholder="관리자 코드를 입력하세요."/><button class="button" onclick="return validateAdmin();">확인</button> 
</div>

</body>
</html>