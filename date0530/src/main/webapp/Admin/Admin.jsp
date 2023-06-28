<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link rel="stylesheet" href="./Admincss.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Jua&display=swap');
</style>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>
	
	$(function(){
		$("#start").hide();
		$("#end").hide();
		
		/* 출생년도, 출생월, 출생일을 선택하면 기간을 선택할 수 있도록. ex)출생년도가 1960년~1970년 사이인 사람들을 모두 검색 */
		$("#search").change(function(){
			if($("#search").val()=="birth_y" || $("#search").val()=="birth_m" || $("#search").val()=="birth_d"){
				$("#searchtext").hide();
				$("#start").show();
				$("#end").show();
			}else{
				$("#searchtext").show();
				$("#start").hide();
				$("#end").hide();
			}
		})
	});
	
	function validateSearch(){
		var searchtext = document.getElementById('searchtext').value;
		var start = document.getElementById('start').value;
		var end = document.getElementById('end').value;
		
		if(!searchtext && (!start || !end)){
			alert('검색할 내용을 입력해주세요!!');
			return false;
		}
		else{ return true;}
	}
	
	/* 삭제할건지 한 번더 물어봄 */
	function validatedelete(){
		if(confirm("삭제하시겠습니까?")){
			return true;
		}
		else{
			return false;
		}
	}
	
	/* 부서 추가하기 전에 빈칸이 있는지 확인 */
	function validateInsert(){
		var num = document.getElementById('insert_no').value;
		var nam = document.getElementById('insert_name').value;
		
		if(!num || !nam){
			alert("빈칸이 있습니다.");
			return false;
		}
		else{ return true;}
	}
	
	/* 부서 정보 변경하기 전에 빈칸이 있는지 확인 */
	function validateUpdate(){
		var num = document.getElementById('update_no').value;
		var column = document.getElementById('column').value;
		var content = document.getElementById('content').value;
		
		if(!num || !column || !content){
			alert("빈칸이 있습니다.")
			return false;
		}
		else{return true;}
	}
</script>
</head>
<body>
<div id="wrapper">
<header>회원&nbsp;관리&nbsp;페이지</header>
<aside>
&lt;&lt;부서 관리&gt;&gt;
	<%
		String sql2 = "SELECT * FROM dept";
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		ResultSet rs2 = pstmt2.executeQuery();%>
	<form action=Dept_plus.jsp>
	<table>
		<tr><th>번호</th><th>부서명</th></tr>
		<%while(rs2.next()){%>
		<tr><td><%=rs2.getInt("dept_no") %></td><td><%=rs2.getString("dept_name") %></td>
		<td><a href="Dept_delete.jsp?dept_no=<%=rs2.getInt("dept_no") %>" onclick="return validatedelete()">삭제</a></td></tr>
		<%}
	%>
	<tr><td><input style="width:50px" type="text" name="insert_no" id="insert_no" placeholder="번호"/></td>
	<td><input style="width:50px" type="text" name="insert_name" id="insert_no" placeholder="부서명"/></td>
	<td><input style="float:right;width:30px;height:15px;font-size:5pt" type="submit" value="추가" onclick="return validateInsert()"/></td></tr>
	</table></form><br>
	<form action=Dept_update.jsp>
	<table>
		<tr><th>변경</th></tr>
		<tr><td><input type="text" style="width:50px" name="update_no" id="update_no" placeholder="번호"/></td></tr>
		<tr><td><select name="column" id="column">
		<option value="dept_no">번호</option><option value="dept_name">부서명</option></select>
		<input style="width:50px" type="text" name="content" id="content" placeholder="변경사항"/></td>
	</table>
	<input style="float:right;width:30px;height:15px;font-size:5pt" type="submit" value="변경" onclick="return validateUpdate()"/><br>
	</form>
	
</aside>
<section>
<form style="vertical-align : middle;" action="Search.jsp" onSubmit="return validateSearch();">
<select name="search" id="search" style="height:30px">
<script> 
	var options = ['ID','이름','부서','출생년도','출생월','출생일','전화번호','이메일','우편번호','지번주소','도로명 주소','상세주소','가입일자'];
	var value = ['member_id','member_name','dept_name','birth_y','birth_m','birth_d','tel','email','addr_post','addr_lot','addr_road','addr_rest','reg_date']
	for(var i=0;i<13;i++){
		/* select 항목의 value를 db 테이블의 column으로 설정 */
		document.write("<option value='"+value[i]+"'>"+options[i]+"</option>")
	}
</script>
</select>
<!-- 해당 column에서 검색할 내용 입력 -->
<input type="text" style="width:300px;height:30px" name="searchtext" id="searchtext" placeholder="검색할 내용을 입력하세요."/>
<!-- 출생년도, 출생월, 출생일을 선택하면 기간을 선택할 수 있도록. ex)출생년도가 1960년~1970년 사이인 사람들을 모두 검색 -->
<input type="text" style="width:150px;height:30px" name="start" id="start" placeholder="시작"/>
<input type="text" style="width:150px;height:30px" name="end" id="end" placeholder="끝"/>
<input type="image" src="https://cdn-icons-png.flaticon.com/128/751/751463.png" style="background-color:#C3FDB8;width:30px;height:30px"> 
</form><br>
<table> <!-- 처음엔 전체 데이터를 볼 수 있게 --> 
	<tr style="background-color:#B6B6B4"><th>아이디</th><th>비밀번호</th><th>이름</th><th>성별</th><th>부서</th><th>출생년도</th><th>출생월</th><th>출생일</th><th>양력/음력</th>
	<th>폰 번호</th><th>이메일</th><th>수신동의</th><th>우편번호</th><th>지번주소</th><th>도로명주소</th><th>상세주소</th><th>가입일자</th><th>수정/삭제</th></tr>
<%
	String sql = "SELECT * FROM usrregist,dept WHERE usrregist.dept_no=dept.dept_no";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()){
		String member_id = rs.getString("member_id");
		String member_pwd = rs.getString("member_pwd");
		String member_name = rs.getString("member_name");
		String member_gender = rs.getString("member_gender");
		String dept_name = rs.getString("dept_name");
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
	<tr style="background-color:#F0F8FF"><td><%=member_id %></td><td><%=member_pwd %></td><td><%=member_name %></td><td><%=member_gender %></td><td><%=dept_name %></td>
	<td><%=birth_y %>년</td><td><%=birth_m %>월</td><td><%=birth_d %>일</td><td><%=birth_kind %></td><td><%=tel %></td><td><%=email %></td><td><%=sms_al %>,<%=email_al %></td>
	<td><%=addr_post %></td><td><%=addr_lot %></td><td><%=addr_road %></td><td><%=addr_rest %></td><td><%=reg_date %></td>
	<td><a href="./Admin_update.jsp?usr_id=<%=member_id%>">변경</a>/<a href="./Admin_delete.jsp?delete_id=<%=member_id%>" onclick="return validatedelete()">삭제</a></tr>
	<%} %>
	</table> 
	
</section>
</div>
</body>
</html>