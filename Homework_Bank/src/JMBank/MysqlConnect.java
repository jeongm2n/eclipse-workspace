package JMBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlConnect {
	private Connection conn;
	
	public MysqlConnect() {
		
		try {
			String dbURL = "jdbc:mysql://localhost:3306/bank?useSSL=false&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "campus";
			Class.forName("com.mysql.jdbc.Driver");
				
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
				
			System.out.println("BANK를 찾아주셔서 감사합니다. 은행업무를 시작합니다.");
			//sql연결이 잘 됐다면 은행업무 시작.
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("연결에 실패했습니다.");
		}
	}
	
	public ArrayList<Account> getBank() {  //DB에 들어있는 값들을 모두 가져오기 위한 함수 
		ArrayList<Account> accs = new ArrayList<Account>();
		
		String sql = "SELECT * FROM BANK";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				accs.add(new Account(rs.getString("accNum"),rs.getString("userName"),rs.getString("password"),rs.getInt("money")));
				//SELECT로 가져온 모든 정보를 accs에 담
			}
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
		return accs; //accs를 리턴 
	}
	
	public void insertBANK(Account acc) { //계좌 개설하여 BANK테이블에 추가하는 함수 
		
		String sql = "INSERT INTO BANK(accNum, userName, password, money)" + " VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, acc.getAccNum());
			pstmt.setString(2, acc.getName());
			pstmt.setString(3, acc.getPwd());
			pstmt.setInt(4, acc.getMoney());
			pstmt.executeUpdate();
			
			System.out.println(acc.getName() + "의 계좌가 개설되었습니다.");
			
		} catch (SQLException e) {
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
	}
	
	public void update(Account acc) { //입금,출금이 일어날 때마다 계좌의 잔액 갱신하여 BANK테이블에 업데이트하는 함수 
		String sql = "UPDATE BANK SET money=? WHERE accNum=?";
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, acc.getMoney());
			pstmt.setString(2, acc.getAccNum());
			pstmt.executeUpdate();
			
			System.out.println(acc.getName() + "의 계좌가 업데이트 되었습니다.");
			
		} catch (SQLException e) {
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
	}
	
	public void delete(Account acc) { //계좌 삭제하여 BANK테이블의 해당 계좌 삭제하는 함수 
		String sql = "DELETE FROM BANK WHERE accNum=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getAccNum());
			pstmt.executeUpdate();
			System.out.println("[" + acc.getName() + "]의 계좌 삭제 완료 !");
			
		} catch (SQLException e) {
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
	}
	
	public ArrayList<Record> getRecord(){ //거래내역 테이블 정보 모두 가져오기 
		ArrayList<Record> recs = new ArrayList<Record>();

		String sql = "SELECT * FROM RECORD";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				recs.add(new Record(rs.getString("accNum"),rs.getString("name"),rs.getInt("cost"),rs.getString("what")));
			}
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
		return recs;
	}
	
	public void insertRECORD(String accNum, String name, String what, int cost) { //거래내역 추가하는 함수 
		String sql = "INSERT INTO RECORD(accNum, name, what, cost)" + " VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, accNum); //BANK 테이블의 accNum을 외래키로 참조하는 RECORD 테이블의 accNum
			pstmt.setString(2, name); //상대방 계좌인지 내 통장인지 표시  
			pstmt.setString(3, what); // 입금,출금 중 
			pstmt.setInt(4, cost); //입금,출금한 금액 
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
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
	}
	
	public ArrayList<Record> joinRECORD(ArrayList<Record> r, Account acc) { 
		String sql = "SELECT * FROM RECORD,BANK WHERE RECORD.accNum=BANK.accNum AND RECORD.accNum=" + acc.getAccNum();
		//BANK테이블과 RECORD테이블을 조인하여 해당 계좌번호의 거래내역만을 뽑아옴 
		//굳이 조인 안해도 되지만 accNum을 외래키로 묶어놔서 조인 시켰습니
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				r.add(new Record(rs.getString("accNum"),rs.getString("name"),rs.getInt("cost"),rs.getString("what")));
			}
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
		return r;
	}
}
