package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Emp {
	// 속성(필드)
	private int comNum;
	private String name;
	private String tel;
	private String hireDate;
	private int income;
	private Date today = new Date();
	
	// 생성자
	Emp(int comNum, String name, String tel) {
		this.comNum	 = comNum;
		this.name = name;
		this.tel = tel;
		this.hireDate = new Date();
	}
	
	Emp(int comNum, String name, String tel, Date hireDate){
		this.comNum = comNum;
		this.name = name;
		this.tel = tel;
		this.hireDate = hireDate;
	}
	
	void ShowInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.printf("%d  %s  %s  %s  %d\n", comNum, name, tel, sdf.format(hireDate));
	}
}
