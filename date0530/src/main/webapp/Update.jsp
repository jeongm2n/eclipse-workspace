<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page session="true"%>
<%@ include file="./dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style>
	.front{
		background-color : #B4CFEC;
	}
	
	.rear{
		background-color : #F0F8FF;
	}
	
	.textbox{
		width:200px;
	}
</style>
<script>
	
	 /* 1차 2차 비밀번호 같은지 다른지 확인 */
	function checkPwd(pwd,pwd2){

		if(pwd==pwd2){
			return true;
		}
		else{
			return false;
		}
	}
	 
	function validateUpdate(){
		var pwd = document.Updateform.pwd.value;
		var pwd2 = document.Updateform.pwd2.value;
		var usrname = document.Updateform.usrname.value;
		var gender = document.Updateform.gender.value;
		var year = document.Updateform.year.value;
		var month = document.Updateform.month.value;
		var day = document.Updateform.day.value;
		var kind = document.Updateform.kind.value;
		var first = document.Updateform.first.value;
		var second = document.Updateform.second.value;
		var third = document.Updateform.third.value;
		var addr_post = document.Updateform.addr_post.value;
		var addr_lot = document.Updateform.addr_lot.value;
		var addr_road = document.Updateform.addr_road.value;
		var addr_rest = document.Updateform.addr_rest.value;
		
		if(!checkPwd(pwd,pwd2)){
			alert('비밀번호를 다시 확인해주세요');
			return false;
		}
		
		/* 모든 항목 중에 입력안한 곳이 있을 시 alert 출력 */
		if(!pwd || !pwd2 || !usrname || !gender || !year || !month || !day || !kind || !first ||
				!second || !third || !addr_post || !addr_lot || !addr_road || !addr_rest){
			alert('모든 항목을 입력해주세요!');
			return false;
		}
		else{
			return true;
		}
	}
</script>
</head>
<body>
<%
	String usr_id = (String)session.getAttribute("ID");

	/* 로그인한 유저의 정보를 가져오기 위한 SQL */
	String sql="SELECT * FROM usrregist WHERE member_id='"+usr_id+"'";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	String tels[]={"010","016","011"};
	
	/* 로그인한 유저의 모든 정보를 가져옴 */
	if(rs.next()){
		String member_pwd = rs.getString("member_pwd");
		String member_name = rs.getString("member_name");
		String member_gender = rs.getString("member_gender");
		int birth_y = Integer.parseInt(rs.getString("birth_y"));
		int birth_m = Integer.parseInt(rs.getString("birth_m"));
		int birth_d = Integer.parseInt(rs.getString("birth_d"));
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
		String num[] = tel.split("-");
%>
<!-- 유저가 기존에 갖고 있던 정보들을 디폴트값으로 설정 -->
<h1 style="color:#659EC7">회원정보수정</h1> 
<form name="Updateform" action=Update_ok.jsp method=get onSubmit="return validateUpdate();">
<table border=1>
	<tr><td class="front">아이디</td>
    <td class="rear"><%=usr_id%></td></tr>
    <tr><td class="front">기존 비밀번호</td>
    <td class="rear"><%=member_pwd%></td></tr>
   	<tr><td class="front">새로운 비밀번호</td>
   	<td class="rear"><input type="text" class="textbox" name="pwd"></td></tr>
   	<tr><td class="front">새로운 비밀번호 확인</td>
   	<td class="rear"><input type="text" class="textbox" name="pwd2"></td></tr>
   	<tr><td class="front">이름</td>
   	<td class="rear"><input type="text" name="usrname" value=<%=member_name%>></td></tr>
   	<tr><td class="front">성별</td>
   	<% //성별에 따라 라디오버튼 기본값을 다르게 설정 
   		String m = "male";
   		if(member_gender.equals(m)){%>
   			<td class="rear"><input type="radio" name="gender" value="male" checked="checked"/>남
   			<input type="radio" name="gender" value="female"/>여</td></tr><%
   		}
   		else{%>
   			<td class='rear'><input type='radio' name='gender' value='male'/>남
   			<input type='radio' name='gender' value='female' checked='checked'/>여</td></tr>
   		<%}
   	%>
   	<tr><td class="front">생년월일</td>
   	<td class="rear"><select name="year">
   	<script> // 저장되어 있는 사용자의 생년월일이 기본값으로 뜨도록 설정 
   		for(var i=2023;i>1920;i--){
   			if(i==<%=birth_y%>){
   				document.write("<option selected='selected'>"+i+"</option>");
   			}
   			else{ document.write("<option>"+i+"</option>");}
   		}
   	</script>
   	</select>년
   	
   	<select name="month">
   	<script>
   		for(var i=1;i<=12;i++){
   			if(i==<%=birth_m%>){
   				document.write("<option selected='selected'>"+i+"</option>");
   			}
   			else{ document.write("<option>"+i+"</option>");}
   		}
   	</script>
   	</select>월
   	
   	<select name="day">
   	<script>
   		for(var i=1;i<=31;i++){
   			if(i==<%=birth_d%>){
   				document.write("<option selected='selected'>"+i+"</option>");
   			}
   			else{ document.write("<option>"+i+"</option>");}
   		}
   	</script>
   	</select>일
   		<% // 양력,음력에 따라 라디오버튼 기본값을 다르게 설정 
   		String k = "양력";
   		if(birth_kind.equals(k)){%>
   			<input type="radio" name="kind" value="양력" checked="checked"/>양력
   			<input type="radio" name="kind" value="음력"/>음력</td></tr><%
   		}
   		else{%>
   			<input type="radio" name="kind" value="양력"/>양력
   			<input type="radio" name="kind" value="음력" checked="checked"/>음력</td></tr>
   		<%}
   	%>
   	
   	<tr><td class="front">휴대폰번호</td>
   	<td class="rear"><select name="first">
   		<%
   		for(int i=0; i<3; i++){
   			if(num[0].equals(tels[i])){%>
   				<option selected="selected"><%=tels[i]%></option><% 
   			}else{%>
   				<option><%=tels[i]%></option><%
   			}
   		}
   		%>
   	</select>
   	<input type="text" name="second" value=<%=num[1]%>>
   	<input type="text" name="third" value=<%=num[2]%>><br>
   	<% 
   		String y = "yes";
   		if(sms_al.equals(y)){%> <!-- 사용자의 SMS 수신 여부에 따라 체크박스 디폴트값 변경 -->
   			<input type="checkbox" name="sms_al" value="yes" id="input_yes1" checked="checked"/>SMS 광고 수신을 동의합니다.
   			<input type="hidden" name="sms_al" value="no" id="input_no1"/></td></tr>
   	  <%}else{%>
   			<input type="checkbox" name="sms_al" value="yes" id="input_yes1"/>SMS 광고 수신을 동의합니다.
   	   		<input type="hidden" name="sms_al" value="no" id="input_no1"/></td></tr>
   	  <%}
   	%>
   	<script>	/* SMS 수신 동의 체크 안할 시 no를 전달하기 위함 */
	if(document.getElementById("input_yes1").checked){
		document.getElementById("input_no1").disabled = true;
	}</script>
   	<tr><td class="front">이메일</td>
   	<td class="rear"><%=email %>
   	<%
   		if(email_al.equals(y)){%> <!-- 사용자의 이메일 수신 여부에 따라 체크박스 디폴트값 변경 -->
   			<input type="checkbox" name="email_al" value="yes" id="input_yes2" checked="checked"/>E-mail 광고 수신을 동의합니다.
   			<input type="hidden" name="email_al" value="no" id="input_no2"/></td></tr>
   	  <%}else{%>
   			<input type="checkbox" name="email_al" value="yes" id="input_yes2"/>E-mail 광고 수신을 동의합니다.
   			<input type="hidden" name="sms_al" value="no" id="input_no2"/></td></tr>
   	  <%}
   	%>
   	
   	<script>/* 이메일 수신 동의 체크 안할 시 no를 전달하기 위함 */
	if(document.getElementById("input_yes2").checked){
			document.getElementById("input_no2").disabled = true;
		}</script>
   	<tr><td class="front">주소</td>
   	<td class="rear">
   	우편번호<br><input type="text" class="textbox" name="addr_post" value=<%=addr_post %>><br>
   	지번 주소<br><input type="text" class="textbox" name="addr_lot" value=<%=addr_lot %>><br>
   	도로명 주소<br><input type="text" class="textbox" name="addr_road" value=<%=addr_road %>><br>
   	나머지 주소<br><input type="text" class="textbox" name="addr_rest"value=<%=addr_rest %>></td></tr>
   	<tr><td class="front">가입일자</td>
    <td class="rear"><%=reg_date %></td></tr>
</table>
    
   	<input type="submit" value="수정하기"/>
</form>
<%
} 
%>
</body>
</body>
</html>