<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
<link rel="stylesheet" href="./Newcss.css">
<script>
	function logOut(){
		if(confirm("로그아웃 하시겠습니까?")){
			session.removeAttribute("ID");
			alert('로그아웃 되었습니다.');
			return true;
		}
		else{
			return false;
		}
	}
</script>
</head>
<body>
<%
	String usr_id = (String)session.getAttribute("ID");
%>	
<div style="padding-left:200px">
<table style="text-align:center">
<tr><td><h1 style="text-align:center"><%=usr_id %>님 반갑습니다!</h1></td></tr>
<tr><td><a href="Update.jsp"><b>회원정보 수정</b></a></td></tr>
<tr><td><a href="Main.jsp" onclick="return logOut();"><b>Logout</b></a></td></tr>
<tr><td><a href="Delete.jsp"><b>회원 탈퇴하기</b></a></td></tr>
</table>

</div>
</body>
</html>