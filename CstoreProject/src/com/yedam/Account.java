package com.yedam;

import lombok.Data;

@Data
public class Account {
	// 필드(속성)
	private String accountCode;
	private String accountName;
	private String accountGrade;
	private String accountPw;
	
	
	// 생성자
	public Account() {}
	
	public Account(String accountCode, String accountName, String accountGrade, String accountPw) {
		this.accountCode = accountCode;
		this.accountName = accountName;
		this.accountGrade = accountGrade;
		this.accountPw = accountPw;
	}
	
	
	// 메소드
	void showInfo() {
		System.out.printf("%-18s %-18s %-18s\n", accountCode, accountName, accountGrade);
	}
	

	
	
}
