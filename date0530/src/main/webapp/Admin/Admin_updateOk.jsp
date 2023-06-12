<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../dbconn.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정 성공</title>
<link rel="stylesheet" href="../Newcss.css">
<script>

</script>
</head>
<body>
<%
	String usr_id = request.getParameter("id");
	String member_pwd = request.getParameter("pwd");
	String member_name = request.getParameter("usrname");
	String member_gender = request.getParameter("gender");
	int dept_no = Integer.parseInt(request.getParameter("dept"));
	String birth_y = request.getParameter("year");
	String birth_m = request.getParameter("month");
	String birth_d = request.getParameter("day");
	String birth_kind = request.getParameter("kind");
	String num1 = request.getParameter("first");
	String num2 = request.getParameter("second");
	String num3 = request.getParameter("third");
	String sms_al = request.getParameter("sms_al");
	String email_al = request.getParameter("email_al");
	String addr_post = request.getParameter("addr_post");
	String addr_lot = request.getParameter("addr_lot");
	String addr_road = request.getParameter("addr_road");
	String addr_rest = request.getParameter("addr_rest");
	
	String tel = num1 + "-" + num2 + "-" + num3;
	
	/* 변경 사항이 없는 항목은 원래 저장되어 있던 디폴트 값으로 변경되고(원래 있던 값으로 update하는 것이니 정보 변동 없음) 
	변경 사항이 있는 항목은 변경한 값으로 update되게 모든 항목을 update sql문에 삽입 */
	String sql = "UPDATE usrregist SET member_id='"+usr_id+"',member_pwd='"+member_pwd+"',member_name='"+member_name+"',member_gender='"+member_gender+"',dept_no="+dept_no+",birth_y='"+birth_y+
			"',birth_m='"+birth_m+"',birth_d='"+birth_d+"',birth_kind='"+birth_kind+"',tel='"+tel+"',sms_al='"+sms_al+"',email_al='"+email_al+
			"',addr_post='"+addr_post+"',addr_lot='"+addr_lot+"',addr_road='"+addr_road+"',addr_rest='"+addr_rest+"' WHERE member_id='"+usr_id+"'";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
	try{	
		pstmt.executeUpdate();
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
<div>
<table style="text-align:center;margin:100px">
<tr><td><%=usr_id %>의 정보 수정 완료!</td></tr>
<tr><td><button type="button" onclick="location.replace('Admin.jsp')">돌아가기</button></td></tr>
</table>
</div>
</body>
</html>