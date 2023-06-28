package date0530;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Showmember
 */
@WebServlet("/listshow")
public class Showmember extends HttpServlet {
	
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
			response.setContentType("text/html;charset=utf-8");
			connDB();
			
			PrintWriter out = response.getWriter();
			
			String sql = "SELECT * FROM usrregist,dept WHERE usrregist.dept_no=dept.dept_no";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			out.print("<html><body><h1>회원목록보기</h1>");
			out.print("<table><tr align='center' bgcolor=#B6B6B4><th>아이디</th><th>비밀번호</th><th>이름</th><th>성별</th><th>부서</th><th>출생년도</th><th>출생월</th><th>출생일</th><th>양력/음력</th>"
					+ "<th>폰 번호</th><th>이메일</th><th>수신동의</th><th>우편번호</th><th>지번주소</th><th>도로명주소</th><th>상세주소</th><th>가입일자</th><th>수정/삭제</th></tr>");
			while(rs.next()) {
				out.print("<tr><td>"+rs.getString("member_id")+"</td><td>"+rs.getString("member_pwd")+"</td><td>"+rs.getString("member_name")+"</td>"
						+ "<td>"+rs.getString("member_gender")+"</td><td>"+rs.getString("dept_name")+"</td><td>"+rs.getString("birth_y")+"</td>"
						+ "<td>"+rs.getString("birth_m")+"</td><td>"+rs.getString("birth_d")+"</td><td>"+rs.getString("birth_kind")+"</td>"
						+ "<td>"+rs.getString("tel")+"</td><td>"+rs.getString("email")+"</td><td>"+rs.getString("sms_al")+","+rs.getString("email_al")+"</td>"
						+ "<td>"+rs.getString("addr_post")+"</td><td>"+rs.getString("addr_lot")+"</td><td>"+rs.getString("addr_road")+"</td>"
						+ "<td>"+rs.getString("addr_rest")+"</td><td>"+rs.getString("reg_date")+"</td></tr>");
			}
			out.print("</table></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
