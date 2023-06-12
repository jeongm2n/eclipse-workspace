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
	int dept_no = Integer.parseInt(request.getParameter("update_no"));
	String column = request.getParameter("column");
	String content = request.getParameter("content");
	
	String sql = "UPDATE dept SET "+column+"='"+content+"' WHERE dept_no="+dept_no;
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.executeUpdate();
	
	out.println("<script>alert('"+dept_no+"의 "+column+"이 변경되었습니다.'); location.replace('Admin.jsp')</script>");
%>
</body>
</html>