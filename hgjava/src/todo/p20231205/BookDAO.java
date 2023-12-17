package todo.p20231205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
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
	List<Book> bookList(){
		getConn();
		List<Book> books = new ArrayList<Book>();
		String sql = "select * from book order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookName(rs.getString("book_name"));
				book.setWriter(rs.getString("writer"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}	// end 목록
	
	// 추가
	boolean addBook(Book book) {
		getConn();
		String sql = "insert into book values(?, ?, ?, ?, ?)";
		try {
			conn.setAutoCommit(false);	// 자동커밋 실행 여부
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookCode());
			psmt.setString(2, book.getBookName());
			psmt.setString(3, book.getWriter());
			psmt.setString(4, book.getPublisher());
			psmt.setInt(5, book.getPrice());
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				conn.commit();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	// end 추가
	
	// 단건조회
	Book getBook(String no) {
		getConn();
		String sql = "select * from book where book_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookName(rs.getString("book_name"));
				book.setWriter(rs.getString("writer"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	// end 단건조회
	
	// 수정
	boolean modifyBook(String bookCode, int price) {
		getConn();
		String sql = "update book set price = ? where book_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, price);
			psmt.setString(2, bookCode);
			
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
	boolean removeBook(String code) {
		getConn();
		String sql = "delete from book where book_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	// end 삭제
	
}	// end class
