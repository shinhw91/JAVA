package todo.p20231205;

import lombok.Data;

@Data
public class Emp2 {
	// 속성(필드)
	private int comNum;
	private String name;
	private String tel;
	private String hireDate;
	private int income;
	
	// 생성자
	Emp2(int comNum, String name, String tel, String hireDate, int income) {
		this.comNum	 = comNum;
		this.name = name;
		this.tel = tel;
		this.hireDate = hireDate;
		this.income = income;
	}
	
	void ShowInfo() {
		System.out.printf("%d  %s  %s  %s  %d\n", comNum, name, tel, hireDate, income);
	}
}
