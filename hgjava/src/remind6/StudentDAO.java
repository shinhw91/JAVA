package remind6;
//저장공간 : Oracle DB
//추가, 수정, 삭제, 목록, 단건조회

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 목록
	Student[] getStudentList() {
		getConn();
		Student[] students = new Student[10];
		String sql = "select * from student order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setStudentNo(rs.getString("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setEng(rs.getInt("eng"));
				student.setMath(rs.getInt("math"));
				
				// 배열의 빈 곳에 한 건 저장
				for(int i = 0; i < students.length; i++) {
					if(students[i] == null) {
						students[i] = student;
						break;	// for 반복문 종료
						
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}	// end 목록
	
	//추가
	boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStudentNo());
			psmt.setString(2, std.getStudentName());
			psmt.setInt(3, std.getEng());
			psmt.setInt(4, std.getMath());
			
			int r = psmt.executeUpdate();	// 처리된 건수 반환
			if(r == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	// end 추가
	
	// 단건조회
	Student getStudent(String sno) {
		getConn();
		String sql = "select * from student where student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Student student = new Student();
				student.setStudentNo(rs.getString("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setEng(rs.getInt("eng"));
				student.setMath(rs.getInt("math"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	// 조회된 값이 없으면 null 값 반환
	}	// end 단건조회
	
	// 수정
	boolean modifyStudent(String no, int eng, int math) {
		getConn();
		String sql = "update student set eng = ?, math = ? where student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, math);
			psmt.setString(3, no);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	// end 수정
	
	// 삭제
	boolean removeStudent(String name) {
		getConn();
		String sql = "delete from student where student_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	// 삭제
	
}	// end class
