<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
String column = request.getParameter("search");
String sql = "";
String value = request.getParameter("searchtext");
if(!value.equals("")){
	/* 검색한 내용이 들어간 데이터는 다 화면에 들 수 있게 value 앞뒤로 % 붙임 */
	sql = "SELECT * FROM usrregist WHERE "+column+" LIKE '%"+value+"%'";
}
else{
	String start = request.getParameter("start");
	String end = request.getParameter("end");
	
	/* BETWEEN A AND B 를 사용하여 A~B사이의 값 SELECT하기 */
	sql = "SELECT * FROM usrregist WHERE "+column+" BETWEEN '"+start+"' AND '"+end+"'";
}

%>
<title>검색</title>
<link rel="stylesheet" href="./Admincss.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Jua&display=swap');
</style>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>

	function validateDelete(){
		if(!confirm('회원을 삭제하시겠습니까?')){
			return false;
		}
		else{ return true;}
	}
	
	function validateUpdate(){
		var content = document.getElementById('content').value;
		if(!content){
			alert('변경할 내용을 입력하세요!');
			return false;
		}
		else { return true;}
	}
</script>
</head>
<body>
<div id="wrapper">
<header>회원&nbsp;관리&nbsp;페이지</header>

<aside>
	<!-- 전체보기 버튼 클릭 시 검색하기 전 전체 데이터를 볼 수 있는 Admin.jsp로 이동 -->
	<button onclick="location.href='Admin.jsp'">전체보기</button><br>
	회원 삭제
	<form action="Admin_delete.jsp" onSubmit="return validateDelete();">
	<input type="text" name="delete_id" placeholder="삭제할 회원의 ID를 입력하세요." style="width:170px"/>
	<input type="submit" value="회원 삭제"/>
	</form><br>
	
	회원 정보 변경 
	<form action="Admin_update.jsp" onSubmit="return validateUpdate();">
	<input type="text" name="update_id" placeholder="변경할 회원의 ID를 입력하세요." style="width:170px"/><br>
	<select name="update" style="height:20px">
	<script>
		var options = ['ID','비밀번호','이름','출생년도','출생월','전화번호','이메일','우편번호','지번주소','도로명 주소','상세주소'];
		var value = ['member_id','member_pwd','member_name','birth_y','birth_month','tel','email','addr_post','addr_lot','addr_road','addr_rest'];
		for(var i=0;i<11;i++){
			document.write("<option value='"+value[i]+"'>"+options[i]+"</option>");
		}
	</script>
	</select>
	<input type="text" name="content" id="content" placeholder="변경할 내용을 입력하세요." style="width:170px"/>
	<input type="submit" value="정보 변경"/>
	</form>
	
</aside>
<section>
<table> <!-- 검색한 내용만 화면에 뜨도록 -->
	<tr style="background-color:#B6B6B4"><th>아이디</th><th>비밀번호</th><th>이름</th><th>성별</th><th>출생년도</th><th>출생월</th><th>출생일</th><th>양력/음력</th>
	<th>폰 번호</th><th>수신동의</th><th>이메일</th><th>수신동의</th><th>우편번호</th><th>지번주소</th><th>도로명주소</th><th>상세주소</th><th>가입일자</th></tr>
<%

	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();

	while(rs.next()){
		String member_id = rs.getString("member_id");
		String member_pwd = rs.getString("member_pwd");
		String member_name = rs.getString("member_name");
		String member_gender = rs.getString("member_gender");
		String birth_y = rs.getString("birth_y");
		String birth_m = rs.getString("birth_m");
		String birth_d = rs.getString("birth_d");
		String birth_kind = rs.getString("birth_kind");
		String tel = rs.getString("tel");
		String sms_al = rs.getString("sms_al");
		String email = rs.getString("email");
		String email_al = rs.getString("email_al");
		String addr_post = rs.getString("addr_post");
		String addr_lot = rs.getString("addr_lot");
		String addr_road = rs.getString("addr_road");
		String addr_rest = rs.getString("addr_rest");
		String reg_date = rs.getString("reg_date");
	
%>
	<tr style="background-color:#F0F8FF"><td><%=member_id %></td><td><%=member_pwd %></td><td><%=member_name %></td><td><%=member_gender %></td><td><%=birth_y %>년</td><td><%=birth_m %>월</td>
	<td><%=birth_d %>일</td><td><%=birth_kind %></td><td><%=tel %></td><td><%=sms_al %></td><td><%=email %></td><td><%=email_al %></td>
	<td><%=addr_post %></td><td><%=addr_lot %></td><td><%=addr_road %></td><td><%=addr_rest %></td><td><%=reg_date %></td></tr>
	<%} %>
	</table> 
	
</section>
</div>
</body>
</html>