package com.yedam;

import lombok.Data;

@Data
public class Product {
	// 필드(속성)
	private String productCode;
	private String productName;
	private int productPrice;
	private int productRemain;
	
	
	// 생성자
	public Product() {}
	
	public Product(String productCode, String productName, int productPrice, int productRemain) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productRemain = productRemain;
	}
	
	
	// 메소드
	void showInfo() {
		System.out.printf("%-18s %-18s %-18s\n", productCode, productName, productPrice);
	}
	

	
	
}
