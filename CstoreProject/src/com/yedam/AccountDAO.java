package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
//			System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	// 로그인
	Boolean login(String accountCode, String accountPw) {
		getConn();
		String sql = "select * from account where account_code = ? and account_pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, accountCode);
			psmt.setString(2, accountPw);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 계정등록
	boolean addAccount(String accountCode, String accountName, String accountGrade, String accountPw) {
		getConn();
		String sql = "insert into account values (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, accountCode);
			psmt.setString(2, accountName);
			psmt.setString(3, accountGrade);
			psmt.setString(4, accountPw);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 정보수정
	boolean modifyAccount(String accountCode, String newAccountPw) {
		getConn();
		String sql = "update account set account_pw = ? where account_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, newAccountPw);
			psmt.setString(2, accountCode);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 계정목록
	List<Account> accountList(){
		getConn();
		List<Account> accounts = new ArrayList<Account>();
		String sql = "select * from account order by 1";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Account account = new Account();
				account.setAccountCode(rs.getString("account_code"));
				account.setAccountName(rs.getString("account_name"));
				account.setAccountGrade(rs.getString("account_grade"));
				
				accounts.add(account);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	//계정삭제
	boolean removeAccount(String accountCode, String accountPw) {
		getConn();
		String sql = "delete from account where account_code = ? and account_pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, accountCode);
			psmt.setString(2, accountPw);

			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	
	
	

	

}	// end class
