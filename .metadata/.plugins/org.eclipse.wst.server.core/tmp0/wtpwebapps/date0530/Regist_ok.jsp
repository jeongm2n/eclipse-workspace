<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./Newcss.css">
</head>
<body>

<h1>회원가입 완료</h1>
<%

	String usr_id = request.getParameter("usr");
	String usr_pwd = request.getParameter("pword");
	String usrname = request.getParameter("usrname");
	String gender = request.getParameter("gender");
	int dept_no = Integer.parseInt(request.getParameter("dept"));
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
	
	String sql = "INSERT INTO usrregist VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,DEFAULT)";
	PreparedStatement pstmt = null;
	
	/* 예외처리 하면 값이 잘 입력되는데 안하면 오류떠서 일단 예외처리 했습니다 */
	try{
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,usr_id);
		pstmt.setString(2,usr_pwd);
		pstmt.setString(3,usrname);
		pstmt.setString(4,gender);
		pstmt.setInt(5,dept_no);
		pstmt.setString(6,year);
		pstmt.setString(7,month);
		pstmt.setString(8,day);
		pstmt.setString(9,kind);
		pstmt.setString(10,tel);
		pstmt.setString(11,sms_al);
		pstmt.setString(12,email);
		pstmt.setString(13,email_al);
		pstmt.setString(14,addr_post);
		pstmt.setString(15,addr_lot);
		pstmt.setString(16,addr_road);
		pstmt.setString(17,addr_rest);
		
		pstmt.executeUpdate();
		out.println(usrname+"의 회원가입 완료");
		
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
<table class="tab" border=1>
<tr><th>ID</th><td><%=usr_id %></td></tr>
<tr><th>PASSWORD</th><td><%=usr_pwd %></td></tr>
<tr><th>BIRTH</th><td><%=year%>년 <%=month %>월 <%=day %>일</td></tr>
<tr><th>GENDER</th><td><%=gender %></td></tr>
<tr><th>DEPT</th><td><%=dept_no %></td></tr>
<tr><th>PHONE NUMBER</th><td><%=tel %></td></tr>
<tr><th>SMS</th><td><%=sms_al %></td></tr>
<tr><th>EMAIL</th><td><%=email %></td></tr>
<tr><th>EMAIL_ADD</th><td><%=email_al %></td></tr>
<tr><th>POST NUMBER</th><td><%=addr_post %></td></tr>
<tr><th>LOT NUMBER ADDRESS</th><td><%=addr_lot %></td></tr>
<tr><th>ROAD ADDRESS</th><td><%=addr_road %></td></tr>
<tr><th>DETAIL ADDRESS</th><td><%=addr_rest %></td></tr>
</table>

<button onclick="location.replace('Main.jsp');">확인</button>
</body>
</html>