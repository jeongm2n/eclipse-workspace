<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page session="true"%>
<%@ include file="./dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="./Newcss.css">
<script>
	
</script>
</head>
<body>
<%
	String usr_id = (String)session.getAttribute("ID");
%>
<div>
<form name="Deleteform" action="Delete_chk.jsp">
<table style="margin:100px">
<tr><td><%=usr_id %>님의 회원 탈퇴를 진행합니다.</td></tr>
<tr><td>비밀번호 확인</td></tr>
<tr><td><input class="textbox" type="text" name="pwdchk"></td>
<td><input type="submit" value="탈퇴하기" class="button"></td></tr>
</table>
</form>
</div>
</body>
</html>