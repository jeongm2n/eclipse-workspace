<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="dbconn.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정민's PAGE</title>
<link rel="stylesheet" href="mycss.css">
<style>
	@import url(//fonts.googleapis.com/earlyaccess/jejuhallasan.css);
	
</style>
</head>
<body>
<div id="wrapper">
	<header class="shadow"><font style="position:relative;top:20%">&lt;&lt;서정민의 페이지입니다.&gt;&gt;</font></header>
	
	<nav>
		<ul class="menu">
			<li><a href="#jeongmin" class="link">프로필</a></li>
			<li><a href="#lan" class="link">사용 언어</a></li>
			<li><a href="#cer" class="link">보유 자격증</a></li>
			<li><a href="#sche" class="link">스케줄</a></li>
			<li><a href="#mbti" class="link">MBTI</a></li>
			<li><a href="https://github.com/jeongm2n" class="link">Git Hub</a></li>
		</ul>
	</nav>
	
	<aside>
		<form action="./jdbc.jsp" name="guestbook" target="param">
			<fieldset>
				<legend>방명록</legend>
				내용&nbsp;&nbsp;&nbsp;<input type=text style="width:200px" id="content" name="content" maxlength="15"><br>
				작성자&nbsp;&nbsp;&nbsp;<input type=text id="usrname" name="usrname" maxlength="10">
				<input type="submit" value="작성하기">
			</fieldset>
		</form>
		
		<table id="line" border=1>
			<tr><th>작성자</th><th>내용</th></tr>
			<% 
			String sql2 = "SELECT * FROM guestbook";
			PreparedStatement pstmt2 = null;
			
			
			pstmt2 = conn.prepareStatement(sql2);
			
			ResultSet rs = null;
			// 4) 실행
			rs = pstmt2.executeQuery();
		
			// 5) 결과를 테이블에 출력
			while (rs.next()) {
				String usrName = rs.getString("usrName");
				String contents = rs.getString("contents");
				String wrDate = rs.getString("wrDate");
			%>
			<tr>
				<td style="font-size:11pt"><%=usrName%></td>
				<td style="font-size:11pt"><%=contents%></td>
			</tr>
			<tr>
				<td colspan=2 style="font-size:9pt"><%=wrDate%></td>
			</tr>
			<%
			}
			%>
		
		</table>

	</aside>
	
	<section>
		<a name="jeongmin">
		<div class="div">
			<div style="float:left;padding-left:50px;width:35%;height:98%">
				<img src="https://avatars.githubusercontent.com/u/90256754?v=4" class="profile"/>
			</div>
			<div style="float:right;width:55%;height:98%">
				<ul class="ul">
					<li><p><font class="jm-font">이름 : 서정민</font></p></li>
					<li><p><font class="jm-font">생년월일 : 1998-08-11</font></p></li>
					<li><p><font class="jm-font">주소 : 대구광역시 달서구</font></p></li>
					<li><p><font class="jm-font">최종학력 : 계명대학교 컴퓨터공학과 졸업</font></p></li>
				</ul>
			</div>
			
		</div>
		</a>
		
		<a name="lan">
		<div class="div">
			<ul class="ul">
				<li>
					<b class="shadow" style="font-size:14pt">사용 언어</b>
					<ol class="ul">
						<li><p>JAVA<img src="https://velog.velcdn.com/images/kwakwoohyun/post/54115a5c-7718-4011-af00-76173389b9f2/image.png" style="width:80px;height:30px;vertical-align:sub"/></p>
						</li>
						<li><p>C/C#<img src="https://i.namu.wiki/i/woL6fmqV97CQDYlB-KTI5M0etUehnM0imjPQl6zYZOPARY-VtOxnGe3OIgB8Dr-V7iB1szZKJGd4C3ZkbILs54Uyi5wTGTrr0SPcPLfKGik80taQ_7jYqnXFrcIYfMxw9-rlcJY-gnxZVxYvBU3cKQ.svg" style="width:50px;height:20px;vertical-align:sub"/></p>	
						</li>
						<li><p>PYTHON<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f8/Python_logo_and_wordmark.svg/1280px-Python_logo_and_wordmark.svg.png" style="width:80px;height:30px;vertical-align:sub"/></p>
						</li>
					</ol>
				</li>
			</ul>
		</div>
		</a>
		
		<a name="cer">
		<div class="div">
			<ul class="ul">
				<li>
					<b class="shadow" style="font-size:14pt">보유 자격증</b>
					<ol class="ul">
					<li><p>정보처리기능사</p></li>
					<li><p>정보처리기사</p></li>
					</ol>
				</li>
			</ul>
		</div>
		</a>
		
		<a name="mbti">
		<div class="div">
			<div style="width:34%;height:99%;float:left">
				<div style="margin-left:50px;margin-top:20px">
				<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpuCxXjuSjCMjfjeeRkuTKnVjnQKfWS3WNQy9FwzHs79Ywhgl7zkgRxjUvrc7h3IrV64E&usqp=CAU" style="width:200px;height:250px;"/>
				</div>
				<div style="margin-left:50px;margin-top:5px">
				<b class="shadow mbti">MBTI - ESFJ</b>
				</div>
			</div>
			<div style="width:57%;height:99%;float:right">
				<ul class="ul">
				<li>
					<b style="font-size:15pt">MBTI로 보는 나의 성격</b>
					<ol style="list-style:disc">
					<li><p>다른 사람에게 관심을 쏟으며 나눔과 베품을 중시한다.</p></li>
					<li><p>동료애가 많고 친절하며 능동적인 구성원이다.</p></li>
					<li><p>참을성이 많고 다른 사람들을 잘 도와준다.</p></li>
					<li><p>타인을 본인의 편으로 잘 끌어들이며 <br>사회적인 관계를 형성하는데 매우 능숙하다.</p></li>
					</ol>
				</li>
			</ul>
				
			</div>
		</div>
		</a>
		
		<a name="sche">
		<div class="div" style="text-align:center;padding-top:20px">
			<table border="1" style="width:400px;height:60px;margin-left: auto; margin-right: auto;text-align:center;">
			<caption><b class="shadow" style="font-size:14pt">5월 스케줄</b></caption>
				<thead>
					<tr class="day">
						<th>월</th>
						<th>화</th>
						<th>수</th>
						<th>목</th>
						<th>금</th>
						<th>토</th>
						<th>일</th>
					</tr>
				</thead>
				<tbody>
					<tr class="day">
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
						<td>5</td>
						<td>6</td>
						<td><font color="red">7</font></td>
					</tr>
					<tr style="background : #E5E4E2">
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>알 바</td>
						<td>알 바</td>
						<td>알 바</td>
					</tr>
					<tr class="day">
						<td>8</td>
						<td>9</td>
						<td>10</td>
						<td>11</td>
						<td>12</td>
						<td>13</td>
						<td><font color="red">14</font></td>
					</tr>
					<tr style="background : #E5E4E2">
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>알 바</td>
						<td>알 바</td>
					</tr>
					<tr class="day">
						<td>15</td>
						<td>16</td>
						<td>17</td>
						<td>18</td>
						<td>19</td>
						<td>20</td>
						<td><font color="red">21</font></td>
					</tr>
					<tr style="background : #E5E4E2">
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>서 울</td>
						<td>서 울</td>
					</tr>
					<tr class="day">
						<td>22</td>
						<td>23</td>
						<td>24</td>
						<td>25</td>
						<td>26</td>
						<td>27</td>
						<td><font color="red">28</font></td>
					</tr>
					<tr style="background : #E5E4E2">
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>수 업</td>
						<td>알 바</td>
						<td>알 바</td>
					</tr>
					<tr class="day">
						<td><font color="red">29</font></td>
						<td>30</td>
						<td>31</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr style="background : #E5E4E2">
						<td>휴 일</td>
						<td>수 업</td>
						<td>수 업</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		</a>
	</section>
</div>
</body>
</html>