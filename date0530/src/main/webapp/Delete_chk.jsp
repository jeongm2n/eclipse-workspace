<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page session="true"%>
<%@ include file="./dbconn.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	String pwdchk = request.getParameter("pwdchk"); //Delete.jsp에서 받아올 비밀번호 
	String usr_id = (String)session.getAttribute("ID"); //Delete.jsp에서 받아올 아이디 
	
	String sql = "SELECT member_pwd FROM usrregist WHERE member_id='"+usr_id+"'";
		
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	String member_pwd = null;
		
	if(rs.next()){
		member_pwd = rs.getString("member_pwd");
	}
		
	if(!pwdchk.equals(member_pwd)){ /* 비밀번호가 다르면 삭제 못하게 함 */
		out.println("<script>alert('비밀번호를 다시 확인해주세요.'); location.href='Delelte.jsp';</script>");
	}
	else{ /* 비밀번호가 맞으면 탈퇴 */
		String sql2 = "DELETE FROM usrregist WHERE member_pwd='"+pwdchk+"'";
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.executeUpdate();
		out.println("<script>location.href='Delete_ok.jsp';</script>");
	}
%>
</body>
</html>