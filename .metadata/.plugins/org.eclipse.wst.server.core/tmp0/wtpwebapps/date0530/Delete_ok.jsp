<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 완료</title>
<link rel="stylesheet" href="./Newcss.css">
</head>
<body>
<%
	String usr_id = (String)session.getAttribute("ID");
%>
<div>
<h1><%=usr_id %>의 탈퇴가 완료되었습니다.</h1>
</div>
<%
	session.removeAttribute("ID");
%>
</body>
</html>