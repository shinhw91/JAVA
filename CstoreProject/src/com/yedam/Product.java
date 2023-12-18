package com.yedam;

import lombok.Data;

@Data
public class Product {
	// 필드(속성)
	private String productCode;
	private String productName;
	private int productPrice;
	private int productRemain;
	
	private int historyNumber;
	private String historyDate;
	private int productCount;
	private int saleIncome;
	private String saleSort;
	private String historySort;
	
	
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
		System.out.printf(" %-18s %-18s %,d원\n", productCode, productName, productPrice);
	}

	void remainInfo() {
		System.out.printf(" %-18s %-18s %,d개\n", productCode, productName, productRemain);
	}

	void enterInfo() {
		System.out.printf(" %,5d      %-18s %-18s %-16s %,d원 %,13d개          %-18s\n", historyNumber, historyDate, productCode, productName, productPrice, productCount, historySort);
	}
	
	void outInfo() {
		System.out.printf(" %,5d      %-18s %-18s %-16s %,d원 %,13d개 %,16d원          %-18s %-18s\n", historyNumber, historyDate, productCode, productName, productPrice, productCount, saleIncome, saleSort, historySort);
	}
	
	

	
	
}
