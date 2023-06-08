<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./dbconn.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/256/4228/4228714.png">
<title>게시판</title>
<link rel="stylesheet" href="./boardCss.css">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Jua&display=swap');
</style>
</head>
<body>
<div id="wrapper">
<header><b class="shadow">정민's&nbsp;&nbsp;게시판</b></header>
<button style="float:right">글쓰기</button>
<section>
<select><option>번호</option>
<option>제목</option>
<option>작성자</option></select>
<input type="text" name="searchtext" id="searchtext" value="입력하세요.">
<button>검색</button>
<table style="width:100%;border:1px solid #999;border-collapse:collapse">
<tr><td>번호</td><td>제목</td><td>작성자</td><td>작성일자</td></tr>
	<%
		String sql = "SELECT * FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next()){%>
			<tr><td colspan=4>아직 글이 없습니다.</td></tr><%
		}
		else{
			while(rs.next()){
			int num = rs.getInt("num");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String wr_date = rs.getString("wr_date");%>
			
			<tr><td><%=num %></td><td><%=title %></td><td><%=writer %></td><td><%=wr_date %></td></tr><%
			}
		}
	%>
</table>
</section>
</div>
</body>
</html>