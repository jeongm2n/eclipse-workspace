/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-06-07 02:08:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/./dbconn.jsp", Long.valueOf(1685605591000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.sql.DriverManager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

	Connection conn = null;
	
	String url = "jdbc:mysql://localhost:3306/regist";
	String id = "root";                  
	String pwd = "campus";
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(url, id, pwd);

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");

String column = request.getParameter("search");
String value = request.getParameter("searchtext");

      out.write("\n");
      out.write("<title>");
      out.print(value );
      out.write(" 검색</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"./Admincss.css\">\n");
      out.write("<style>\n");
      out.write("	@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Jua&display=swap');\n");
      out.write("</style>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.0.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("	function validateDelete(){\n");
      out.write("		if(!confirm('회원을 삭제하시겠습니까?')){\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		else{ return true; }\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("	function validateUpdate(){\n");
      out.write("		var content = document.getElementById('content').value;\n");
      out.write("		if(!content){\n");
      out.write("			alert('변경할 내용을 입력하세요!'));\n");
      out.write("			return false;\n");
      out.write("		}\n");
      out.write("		else { return true;}\n");
      out.write("	}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"wrapper\">\n");
      out.write("<header>회원&nbsp;관리&nbsp;페이지</header>\n");
      out.write("\n");
      out.write("<aside>\n");
      out.write("	<!-- 전체보기 버튼 클릭 시 검색하기 전 전체 데이터를 볼 수 있는 Admin.jsp로 이동 -->\n");
      out.write("	<button onclick=\"location.href='Admin.jsp'\">전체보기</button><br>\n");
      out.write("	회원 삭제\n");
      out.write("	<form action=\"Delete_chk.jsp\" onSubmit=\"return validateDelete();\">\n");
      out.write("	<input type=\"text\" name=\"delete_id\" placeholder=\"삭제할 회원의 ID를 입력하세요.\" style=\"width:170px\"/>\n");
      out.write("	<input type=\"submit\" value=\"회원 삭제\"/>\n");
      out.write("	</form><br>\n");
      out.write("	\n");
      out.write("	회원 정보 변경 \n");
      out.write("	<form action=\"Admin_update.jsp\" onSubmit=\"return validateUpdate();\">\n");
      out.write("	<input type=\"text\" name=\"update_id\" placeholder=\"변경할 회원의 ID를 입력하세요.\" style=\"width:170px\"/><br>\n");
      out.write("	<select name=\"update\" style=\"height:20px\">\n");
      out.write("	<script>\n");
      out.write("		var options = ['ID','비밀번호','이름','출생년도','출생월','전화번호','이메일','우편번호','지번주소','도로명 주소','상세주소'];\n");
      out.write("		var value = ['member_id','member_pwd','member_name','birth_y','birth_month','tel','email','addr_post','addr_lot','addr_road','addr_rest'];\n");
      out.write("		for(var i=0;i<11;i++){\n");
      out.write("			document.write(\"<option value='\"+value[i]+\"'>\"+options[i]+\"</option>\");\n");
      out.write("		}\n");
      out.write("	</script>\n");
      out.write("	</select>\n");
      out.write("	<input type=\"text\" name=\"content\" id=\"content\" placeholder=\"변경할 내용을 입력하세요.\" style=\"width:170px\"/>\n");
      out.write("	<input type=\"submit\" value=\"정보 변경\"/>\n");
      out.write("	</form>\n");
      out.write("	\n");
      out.write("</aside>\n");
      out.write("<section>\n");
      out.write("<table> <!-- 검색한 내용만 화면에 뜨도록 -->\n");
      out.write("	<tr style=\"background-color:#B6B6B4\"><th>아이디</th><th>비밀번호</th><th>이름</th><th>성별</th><th>출생년도</th><th>출생월</th><th>출생일</th><th>양력/음력</th>\n");
      out.write("	<th>폰 번호</th><th>수신동의</th><th>이메일</th><th>수신동의</th><th>우편번호</th><th>지번주소</th><th>도로명주소</th><th>상세주소</th><th>가입일자</th></tr>\n");

 	/* 검색한 내용이 들어간 데이터는 다 화면에 들 수 있게 value 앞뒤로 % 붙임 */
	String sql = "SELECT * FROM usrregist WHERE "+column+" LIKE '%"+value+"%'";
	
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
	

      out.write("\n");
      out.write("	<tr style=\"background-color:#F0F8FF\"><td>");
      out.print(member_id );
      out.write("</td><td>");
      out.print(member_pwd );
      out.write("</td><td>");
      out.print(member_name );
      out.write("</td><td>");
      out.print(member_gender );
      out.write("</td><td>");
      out.print(birth_y );
      out.write("년</td><td>");
      out.print(birth_m );
      out.write("월</td>\n");
      out.write("	<td>");
      out.print(birth_d );
      out.write("일</td><td>");
      out.print(birth_kind );
      out.write("</td><td>");
      out.print(tel );
      out.write("</td><td>");
      out.print(sms_al );
      out.write("</td><td>");
      out.print(email );
      out.write("</td><td>");
      out.print(email_al );
      out.write("</td>\n");
      out.write("	<td>");
      out.print(addr_post );
      out.write("</td><td>");
      out.print(addr_lot );
      out.write("</td><td>");
      out.print(addr_road );
      out.write("</td><td>");
      out.print(addr_rest );
      out.write("</td><td>");
      out.print(reg_date );
      out.write("</td></tr>\n");
      out.write("	");
} 
      out.write("\n");
      out.write("	</table> \n");
      out.write("	\n");
      out.write("</section>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
