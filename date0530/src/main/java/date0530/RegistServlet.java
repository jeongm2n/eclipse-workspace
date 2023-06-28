package date0530;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {

	private PreparedStatement pstmt;
	private Connection conn;
	
	public void connDB() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/regist?useSSL=false&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "campus";
			Class.forName("com.mysql.jdbc.Driver");
				
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				
			System.out.println("usrregist 테이블과 연결 성공 ");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			
			connDB();
			
			String usr = request.getParameter("usr");
			String pwd = request.getParameter("pword");
			String name = request.getParameter("usrname");
			String gender = request.getParameter("gender");
			int dept = Integer.parseInt(request.getParameter("dept"));
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String kind = request.getParameter("kind");
			String tel = request.getParameter("first") +"-"+ request.getParameter("second") +"-"+ request.getParameter("third");
			String sms_al = request.getParameter("sms_al");
			String email = request.getParameter("front") + "@" + request.getParameter("rear");
			String email_al = request.getParameter("email_al");
			String addr_post = request.getParameter("addr_post");
			String addr_lot = request.getParameter("addr_lot");
			String addr_road = request.getParameter("addr_road");
			String addr_rest = request.getParameter("addr_rest");
			
			String sql = "INSERT INTO usrregist VALUES('"+usr+"','"+pwd+"','"+name+"','"+gender+"',"+dept+",'"+year+"','"+month+"','"+day+"','"+kind+"','"
					+tel+"','"+sms_al+"','"+email+"','"+email_al+"','"+addr_post+"','"+addr_lot+"','"+addr_road+"','"+addr_rest+"',DEFAULT)";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			out.print("<html><body><table border=1>");
			out.print("<tr><th align='center'>ID</th><td>"+usr+"</td></tr><tr><th align='center'>PassWord</th><td>"+pwd+"</td></tr>");
			out.print("<tr><th align='center'>Name</th><td>"+name+"</td></tr><tr><th align='center'>Gender</th><td>"+gender+"</td></tr>");
			out.print("<tr><th align='center'>Dept_No</th><td>"+dept+"</td></tr><tr><th align='center'>Year</th><td>"+year+"</td></tr>");
			out.print("<tr><th align='center'>Month</th><td>"+month+"</td></tr><tr><th align='center'>Day</th><td>"+day+"</td></tr>");
			out.print("<tr><th align='center'>Kind</th><td>"+kind+"</td></tr><tr><th align='center'>Tel</th><td>"+tel+"</td></tr>");
			out.print("<tr><th align='center'>Email</th><td>"+email+"</td></tr><tr><th align='center'>수신동의</th><td>"+sms_al+"/"+email_al+"</td></tr>");
			out.print("<tr><th align='center'>Post</th><td>"+addr_post+"</td></tr><tr><th align='center'>지번주소</th><td>"+addr_lot+"</td></tr>");
			out.print("<tr><th align='center'>도로명주소</th><td>"+addr_road+"</td></tr><tr><th align='center'>상세주소</th><td>"+addr_rest+"</td></tr>");
			out.print("</table><br><button onclick='location.replace('http://localhost:8060/date0530/Main.jsp');'>확인</button></body></html>");
			
			pstmt.close();
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
