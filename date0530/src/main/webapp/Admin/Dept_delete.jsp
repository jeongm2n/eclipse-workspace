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
	int dept_no = Integer.parseInt(request.getParameter("dept_no"));
	
	String sql = "DELETE FROM dept WHERE dept_no="+dept_no;
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.executeUpdate();
	
	out.println("<script>alert('부서 "+dept_no+"이/가 삭제되었습니다.'); location.replace('Admin.jsp')</script>");
%>
</body>
</html>