/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-06-02 08:51:14 UTC
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Regist_005fok_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.time.format.DateTimeFormatter");
    _jspx_imports_classes.add("java.time.LocalDateTime");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h1>회원가입 완료</h1>\n");


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
	
      out.write("\n");
      out.write("<br>\n");
      out.write("ID:&nbsp;&nbsp;");
      out.print(usr_id );
      out.write("<br>\n");
      out.write("PASSWORD:&nbsp;&nbsp;");
      out.print(usr_pwd );
      out.write("<br>\n");
      out.write("BIRTH:&nbsp;&nbsp;");
      out.print(year);
      out.write('년');
      out.write(' ');
      out.print(month );
      out.write('월');
      out.write(' ');
      out.print(day );
      out.write("일<br> \n");
      out.write("GENDER:&nbsp;&nbsp;");
      out.print(gender );
      out.write("<br>\n");
      out.write("PHONE NUMBER:&nbsp;&nbsp;");
      out.print(tel );
      out.write("<br>\n");
      out.write("SMS:&nbsp;&nbsp;");
      out.print(sms_al );
      out.write("<br>\n");
      out.write("EMAIL:&nbsp;&nbsp;");
      out.print(email );
      out.write("<br>\n");
      out.write("EMAIL_ADD:&nbsp;&nbsp;");
      out.print(email_al );
      out.write("<br>\n");
      out.write("POST NUMBER:&nbsp;&nbsp;");
      out.print(addr_post );
      out.write("<br>\n");
      out.write("LOT NUMBER ADDRESS:&nbsp;&nbsp;");
      out.print(addr_lot );
      out.write("<br>\n");
      out.write("ROAD ADDRESS:&nbsp;&nbsp;");
      out.print(addr_road );
      out.write("<br>\n");
      out.write("DETAIL ADDRESS:&nbsp;&nbsp;");
      out.print(addr_rest );
      out.write("<br>\n");
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