package web04.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	private static  String dbURL = "";
	private static  String dbID = "";
	private static  String dbPassword = "";
	
	private static  String driver = "";
	private Statement stmt;
	
	public List<MemberVO> listMembers() {
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		try {
			try {
				connDB();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String query = "select * from t_member order by joinDate desc";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String img = rs.getString("img");
				Date joinDate = rs.getDate("joinDate");
				
				
				MemberVO memberVO = new MemberVO(id, pwd, name, email, img, joinDate);
				membersList.add(memberVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersList;
	}
	
	public void addMember(MemberVO m) {
		try {
			
			try {
				
				connDB();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			String img = m.getImg();
			String query = "INSERT INTO t_member(id, pwd, name, email, img)" + " VALUES('"+id+"','"+pwd+"','"+name+"','"+email+"','"+img+"')";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void connDB() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/campus?useSSL=false&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "campus";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
