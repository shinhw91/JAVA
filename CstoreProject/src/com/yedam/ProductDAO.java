package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
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
	
	// ***************************************************** 1.상품관리
	// 상품등록
	boolean addProduct(String productCode, String productName, int productPrice) {
		getConn();
		String sql = "insert into product(product_code, product_name, product_price) values (?, ?, ?)";
		try {
			psmt = conn.prepareCall(sql);
			psmt.setString(1, productCode);
			psmt.setString(2, productName);
			psmt.setInt(3, productPrice);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 상품수정
	boolean modifyProduct(String productCode, int productPrice) {
		getConn();
		String sql = "update product set product_price = ? where product_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, productPrice);
			psmt.setString(2, productCode);

			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 상품조회
	Product getProduct(String productCode) {
		getConn();
		String sql = "select * from product where product_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Product product = new Product();
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				return product;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// 상품목록
	List<Product> productList() {
		getConn();
		List<Product> products = new ArrayList<Product>();
		String sql = "select * from product order by 1";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				
				products.add(product);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	
	// 상품삭제
	boolean removeProduct(String productCode) {
		getConn();
		String sql = "delete from product where product_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	// ***************************************************** 2.상품입고
	// 상품등록 확인
	boolean confirmProduct(String productCode) {
		getConn();
		String sql = "select * from product where product_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	
//	
//	// 상품입고 (기 등록)
//	boolean enterProduct(String productCode, String productEnterDate, int productCount) {
//		getConn();
//		String sql = "update product set product_enterdate = ?, product_count = ? where product_code = ?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, productEnterDate);
//			psmt.setInt(2, productCount);
//			psmt.setString(3, productCode);
//			
//			int r = psmt.executeUpdate();
//			if(r > 0) {
//				return true;
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	// 내역 테이블
	boolean enterProduct(int historyNumber, String historyDate, String productCode, int productCount, String historySort) {
		getConn();
		String sql = "insert into history(history_number, history_date, product_code, product_count, history_sort) values (?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, historyNumber);
			psmt.setString(2, historyDate);
			psmt.setString(3, productCode);
			psmt.setInt(4, productCount);
			psmt.setString(5, historySort);

			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 상품재고 확인
	int confirmRemain(String productCode) {
		getConn();
		int remain = 0;
		String sql = "select product_remain from product where product_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				remain = rs.getInt("product_remain");
				return remain;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return remain;
	}
	
	
	// 상품 테이블
	boolean updateRemain(String productCode, int productRemain) {
		getConn();
		String sql = "update product set product_remain = ? where product_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, productRemain);
			psmt.setString(2, productCode);
			
			int r = psmt.executeUpdate();
	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	
	
	
	
	
	// ***************************************************** 3.상품판매
	// 내역 테이블
	boolean outProduct(int historyNumber, String historyDate, String productCode, int productCount, int saleIncome, String sale_sort, String historySort) {
		getConn();
		String sql = "insert into history(history_number, history_date, product_code, product_count, sale_income, sale_sort, history_sort) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, historyNumber);
			psmt.setString(2, historyDate);
			psmt.setString(3, productCode);
			psmt.setInt(4, productCount);
			psmt.setInt(5, saleIncome);
			psmt.setString(6, sale_sort);
			psmt.setString(7, historySort);

			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	// 상품가격 확인
	int confirmPrice(String productCode) {
		getConn();
		int price = 0;
		String sql = "select product_price from product where product_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productCode);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				price = rs.getInt("product_price");
				return price;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
	
	
	
	
	
	
	
	
	
	
}
