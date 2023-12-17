package com.yedam;

import lombok.Data;

@Data
public class Employee {
	// 속성(필드)
	private String coNum;
	private String name;
	private String tel;
	private String hireDate;
	private int pay;
	
	// 생성자
	Employee(String coNum, String name, String tel, String hireDate, int pay) {
		this.coNum = coNum;
		this.name = name;
		this.tel = tel;
		this.hireDate = hireDate;
		this.pay = pay;
	}
	
	void ShowList() {
		System.out.printf("%s\t %s\t %s\t %d\n", coNum, name, tel, pay);
	}
	
	void ShowInfo() {
		System.out.printf("%s\t %s\t %s\n", coNum, name, hireDate);
	}
}
