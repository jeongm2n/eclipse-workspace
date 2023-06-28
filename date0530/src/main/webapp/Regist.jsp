<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./dbconn.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="./Newcss.css">
<style>
@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Jua&display=swap');
	
</style>

<script>
	
	/* 아이디 확인 */
	 function checkId(id){
		var cnt = 0;
		
		var regex = /^[A-Za-z0-9+]*$/;
		
		if(id.length>8 || id.length<5){
			document.Registform.usr.focus();
			alert('아이디는 5자리 ~ 8자리여야 합니다.');
			return false;
		}
		else{
			if(regex.test(id)){
				return true;
			}
			else{
				document.Registform.usr.focus();
				alert('아이디를 다시 확인하세요');
				return false;
			}
		}
	}
	
	 /* 1차 2차 비밀번호 같은지 다른지 확인 */
	function checkPwd(pwd1,pwd2){

		if(pwd1==pwd2){
			return true;
		}
		else{
			return false;
		}
	}
	 /* 이메일 select 박스에서 선택했을 때 @ 뒤의 text박스에 값 넣기 */
	function handleonChange(e){
		var v=e.value;
		document.Registform.rear.value=v;
	}
	
	function validateForm(){
    	//console.log('확인');
    	
		var id = document.Registform.usr.value;
		var pwd1 = document.Registform.pword.value;
		var pwd2 = document.Registform.pss.value;
		var usrname = document.Registform.usrname.value;
		var gender = document.Registform.gender.value;
		var dept = document.getElementById('dept').value;
		var year = document.Registform.year.value;
		var month = document.Registform.month.value;
		var day = document.Registform.day.value;
		var kind = document.Registform.kind.value;
		var first = document.Registform.first.value;
		var second = document.Registform.second.value;
		var third = document.Registform.third.value;
		var front = document.Registform.front.value;
		var rear = document.Registform.rear.value;
		var addr_post = document.Registform.addr_post.value;
		var addr_lot = document.Registform.addr_lot.value;
		var addr_road = document.Registform.addr_road.value;
		var addr_rest = document.Registform.addr_rest.value;
		
		if(checkId(id)){
			if(!checkPwd(pwd1,pwd2)){
				alert('비밀번호를 다시 확인해주세요');
				return false;
			}
		}else{
			return false;
		}
		
		/* SMS 수신 동의 체크 안할 시 no를 전달하기 위함 */
		if(document.getElementById("input_yes1").checked){
			document.getElementById("input_no1").disabled = true;
		}
		
		/* 이메일 수신 동의 체크 안할 시 no를 전달하기 위함 */
		if(document.getElementById("input_yes2").checked){
			document.getElementById("input_no2").disabled = true;
		}
		
		/* 모든 항목 중에 입력안한 곳이 있을 시 alert 출력 */
		if(!id || !pwd1 || !pwd2 || !usrname || !gender || !dept || !year || !month || !day || !kind || !first ||
				!second || !third || !front || !rear || !addr_post || !addr_lot || !addr_road || !addr_rest){
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
<div id="wrapper">
<header>회원&nbsp;가입&nbsp;페이지</header>
<section>
<h1 style="color:#659EC7;margin-left:auto;margin-right:auto">필수입력사항</h1>
<form name="Registform" action=regist method=get onSubmit="return validateForm();">
<table class="tab" border=1>
	<tr><td class="front">아이디</td>
    <td class="rear"><input type="text" class="textbox" name="usr" id="usr" placeholder="5~8자리의 영문/숫자만 입력하세요.">
    <tr><td class="front">비밀번호</td>
    <td class="rear"><input type="text" class="textbox" name="pword" placeholder="password"></td></tr>
   	<tr><td class="front">비밀번호 확인</td>
   	<td class="rear"><input type="text" class="textbox" name="pss"></td></tr>
   	<tr><td class="front">이름</td>
   	<td class="rear"><input type="text" name="usrname"></td></tr>
   	<tr><td class="front">성별</td>
   	<td class="rear"><input type="radio" name="gender" value="male"/>남
   	<input type="radio" name="gender" value="female"/>여</td></tr>
   	<tr><td class="front">부서</td>
   	<td class="rear">
   	<%
   		String sql = "SELECT * FROM dept";
	   	PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){%>
			<input type="radio" name="dept" value="<%=rs.getInt("dept_no") %>"/><%=rs.getString("dept_name") %>
		<%}
   	%>
   	</td></tr>
   	<tr><td class="front">생년월일</td>
   	<td class="rear"><select name="year">
   	<script>
   		for(var i=2023;i>1920;i--){
   			document.write("<option>"+i+"</option>");
   		}
   	</script>
   	</select>년
   	
   	<select name="month">
   	<script>
   		for(var i=1;i<=12;i++){
   			document.write("<option>"+i+"</option>");
   		}
   	</script>
   	</select>월
   	
   	<select name="day">
   	<script>
   		for(var i=1;i<=31;i++){
   			document.write("<option>"+i+"</option>");
   		}
   	</script>
   	</select>일
   	<input type="radio" name="kind" value="양력"/>양력
   	<input type="radio" name="kind" value="음력"/>음력</td></tr>
   	<tr><td class="front">휴대폰번호</td>
   	<td class="rear"><select name="first">
   		<option selected="selected" value="null">선택하세요</option>
   		<option>010</option>
   		<option>016</option>
   		<option>011</option>
   	</select>
   	<input type="text" name="second"/>
   	<input type="text" name="third"/><br>
   	<input type="checkbox" name="sms_al" value="yes" id="input_yes1"/>SMS 광고 수신을 동의합니다.
   	<input type="hidden" name="sms_al" value="no" id="input_no1"/></td></tr>
   	<tr><td class="front">이메일</td>
   	<td class="rear"><input type="text" class="textbox" name="front"/>
   	@<input type="text" class="textbox" name="rear"/>
   	<select name="rear2" onchange="handleonChange(this);">
   	<option selected="selected" value="null">직접입력</option>
   	<option value="naver.com">naver.com</option>
   	<option value="nate.com">nate.com</option>
   	<option value="gmail.com">gmail.com</option>
   	</select><br>
   	<input type="checkbox" name="email_al" value="yes" id="input_yes2"/>E-mail 광고 수신을 동의합니다.
   	<input type="hidden" name="email_al" value="no" id="input_no2"/></td></tr>
   	<tr><td class="front">주소</td>
   	<td class="rear">
   	우편번호<br><input type="text" class="textbox" name="addr_post"/><br>
   	지번 주소<br><input type="text" class="textbox" name="addr_lot"/><br>
   	도로명 주소<br><input type="text" class="textbox" name="addr_road"/><br>
   	나머지 주소<br><input type="text" class="textbox" name="addr_rest"/></td></tr>
   	
</table>
    <input type="submit" style="width:150px;height:50px;margin-left:auto;margin-right:auto" value="가입하기!"/>
</form>
<button onclick='listshow'>목록보기</button>
</section>
</div>
</body>
</html>