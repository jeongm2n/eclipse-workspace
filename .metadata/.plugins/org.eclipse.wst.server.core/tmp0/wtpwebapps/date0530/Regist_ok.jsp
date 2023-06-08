<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./dbconn.jsp"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입 완료</h1>
<%

	String usr_id = request.getParameter("usr");
	String usr_pwd = request.getParameter("pword");
	String usrname = request.getParameter("usrname");
	String gender = request.getParameter("gender");
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String kind = request.getParameter("kind");
	String num1 = request.getParameter("first");
	String num2 = request.getParameter("second");
	String num3 = request.getParameter("third");
	String sms_al = request.getParameter("sms_al");
	String front = request.getParameter("front");
	String rear = request.getParameter("rear");
	String email_al = request.getParameter("email_al");
	String addr_post = request.getParameter("addr_post");
	String addr_lot = request.getParameter("addr_lot");
	String addr_road = request.getParameter("addr_road");
	String addr_rest = request.getParameter("addr_rest");
	
	
	String tel = num1 + "-" + num2 + "-" + num3;
	String email = front + "@" + rear;

	out.println("<h1>회원가입 성공</h1>");
	
	String sql = "INSERT INTO usrregist VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,DEFAULT)";
	PreparedStatement pstmt = null;
	
	/* 예외처리 하면 값이 잘 입력되는데 안하면 오류떠서 일단 예외처리 했습니다 */
	try{
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,usr_id);
		pstmt.setString(2,usr_pwd);
		pstmt.setString(3,usrname);
		pstmt.setString(4,gender);
		pstmt.setString(5,year);
		pstmt.setString(6,month);
		pstmt.setString(7,day);
		pstmt.setString(8,kind);
		pstmt.setString(9,tel);
		pstmt.setString(10,sms_al);
		pstmt.setString(11,email);
		pstmt.setString(12,email_al);
		pstmt.setString(13,addr_post);
		pstmt.setString(14,addr_lot);
		pstmt.setString(15,addr_road);
		pstmt.setString(16,addr_rest);
		
		int rows=pstmt.executeUpdate();
		out.println(rows+"명의 회원가입 완료");
		
	}catch (SQLException e) {
		e.printStackTrace();
	} finally{
		try {
			if(pstmt!=null && !pstmt.isClosed()) {
				pstmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 
	%>
<br>
ID:&nbsp;&nbsp;<%=usr_id %><br>
PASSWORD:&nbsp;&nbsp;<%=usr_pwd %><br>
BIRTH:&nbsp;&nbsp;<%=year%>년 <%=month %>월 <%=day %>일<br> 
GENDER:&nbsp;&nbsp;<%=gender %><br>
PHONE NUMBER:&nbsp;&nbsp;<%=tel %><br>
SMS:&nbsp;&nbsp;<%=sms_al %><br>
EMAIL:&nbsp;&nbsp;<%=email %><br>
EMAIL_ADD:&nbsp;&nbsp;<%=email_al %><br>
POST NUMBER:&nbsp;&nbsp;<%=addr_post %><br>
LOT NUMBER ADDRESS:&nbsp;&nbsp;<%=addr_lot %><br>
ROAD ADDRESS:&nbsp;&nbsp;<%=addr_road %><br>
DETAIL ADDRESS:&nbsp;&nbsp;<%=addr_rest %><br>
</body>
</html>