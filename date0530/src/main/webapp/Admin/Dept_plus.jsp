<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int dept_no = Integer.parseInt(request.getParameter("insert_no"));
	String dept_name = request.getParameter("insert_name");
	
	String sql = "INSERT INTO dept VALUES("+dept_no+",'"+dept_name+"')";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.executeUpdate();
	
	out.println("<script>alert('"+dept_name+"이 추가되었습니다.'); location.replace('Admin.jsp')</script>");
%>
</body>
</html>