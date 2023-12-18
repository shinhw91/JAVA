package remind6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainExe {
	static Connection conn;
	public static void main(String[] args) {
		// JDBC lib
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");	// 1
			conn = DriverManager.getConnection(url, "dev", "dev");	// 2
			System.out.println("연결성공!");
//			select();
			
			// 입력
			String sql = "INSERT INTO student (student_no, student_name, eng, math) "
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);	// 3
			psmt.setString(1, "23-003");
			psmt.setString(2, "박씨");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);
			
			// 입력, 수정, 삭제 => executeUpdate();
			int r = psmt.executeUpdate();
			if(r == 1) {
				System.out.println("입력성공");
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
//			System.out.println("Driver 없음");
		}
		

	}	// end main
	
	// 조회
	public static void select() throws Exception {
		String sql = "select * from student";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			System.out.println("번호 : " + rs.getString("student_no")
								+ ", 이름 : " + rs.getString("student_name")
								+ ", 영어 : " + rs.getInt("eng")
								+ ", 수학 : " + rs.getInt("math"));
		}
	}

}	// end class
