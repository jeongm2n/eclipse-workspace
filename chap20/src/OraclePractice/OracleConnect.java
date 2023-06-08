package OraclePractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleConnect {

		public static void main(String[] args) {
			Connection conn = null;
			try {

				/*if(true)
				{
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521/xe",
							"jeongmin",
							"skrt07006"
							);
					
					System.out.println("Oracle Connected");
				
				}*/
				//else //mysql 사용시 
				//{
				if(true) {
					
					String dbURL = "jdbc:mysql://localhost:3306/campus?userSSL=false&screrverTimezone=UTC";
					String dbID = "root";
					String dbPassword = "campus";
					
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				
	               //stmt = con.createStatement(); 


                   System.out.println("Mysql Connected");
				}
				//}
				
				


				String sql = "INSERT INTO users(userid, username, userpassword, userage, useremail)" + " VALUES(?, ?, ?, ?, ?)";
					
	
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, "winter3");
					pstmt.setString(2, "김범용");
					pstmt.setString(3, "23456");
					pstmt.setInt(4, 25);
					pstmt.setString(5, "winter3@mycompany.com");
					
		
					int rows = pstmt.executeUpdate();
					System.out.println("수행된 열수: " + rows);



				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(conn != null) {
					try {
			
						conn.close();
						System.out.println("Connect Success Filnally");
					} catch (SQLException e) {}
				}
			}
		}
}
