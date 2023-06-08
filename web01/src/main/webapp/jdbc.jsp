<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ include file="dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	
	
</style>

</head>
<body>

	<%
	
	String sql1 = "INSERT INTO guestbook(usrName,contents,wrDate) VALUES(?,?,DEFAULT)";
	PreparedStatement pstmt = null;
	
	pstmt = conn.prepareStatement(sql1);
	
	String name = request.getParameter("usrname");
	String content = request.getParameter("content");
	
	pstmt.setString(1,name);
	pstmt.setString(2,content);
	pstmt.executeUpdate();
	
	out.println("<script>alert('방명록 등록이 완료되었습니다.'); location.replace('index.jsp');</script>");
	%>
	
</body>
</html>