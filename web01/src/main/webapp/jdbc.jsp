<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#line{
		width : 100%;
		word-break : normal;
		text-align : left;
	}
	
</style>

</head>
<body>


	<%

		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/myweb?useSSL=false&serverTimezone=UTC";
		String id = "root";                     //MySQL에 접속을 위한 계정의 ID
		String pwd = "campus";            //MySQL에 접속을 위한 계정의 암호
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pwd);
		
	%>
	
	<%
	String sql1 = "INSERT INTO guestbook(usrName,contents,wrDate) VALUES(?,?,?)";
	PreparedStatement pstmt = null;
	
	pstmt = conn.prepareStatement(sql1);
	
	String name = request.getParameter("usrname");
	String content = request.getParameter("content");
	
	LocalDateTime now = LocalDateTime.now();
	String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	
	pstmt.setString(1,name);
	pstmt.setString(2,content);
	pstmt.setString(3,formatedNow);
	pstmt.executeUpdate();
	
	%>
	
	<table id="line" border=1>
	
	<% 
	String sql2 = "SELECT * FROM guestbook";
	PreparedStatement pstmt2 = null;
	
	
	pstmt2 = conn.prepareStatement(sql2);
	
	ResultSet rs = null;
	// 4) 실행
	rs = pstmt2.executeQuery();

	// 5) 결과를 테이블에 출력
	while (rs.next()) {
		String usrName = rs.getString("usrName");
		String contents = rs.getString("contents");
		String wrDate = rs.getString("wrDate");
	%>
<tr>
	<td><%=usrName%></td>
	<td><%=contents%></td>
</tr>
<tr>
	<td></td>
	<td style="font-size : 9pt"><%=wrDate%></td>
</tr>
<%
	}
	
	
%>

</table>
	
</body>
</html>