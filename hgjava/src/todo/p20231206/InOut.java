package todo.p20231206;

import lombok.Data;

@Data
public class InOut {
	// 속성(필드)
	private String productCode;
	private String date;
	private int count;
	private String sale;
	private int stock;
	
	//생성자
	InOut(String productCode, String date, int count, String sale){
		this.productCode = productCode;
		this.date = date;
		this.count = count;
		this.sale = sale;
		this.stock = 0;
	}
	
	void ShowInfo() {
		System.out.printf("%s\t %s\t %d\t %s\n", productCode, date, count, sale);
	}
	
	void ShowStock() {
		System.out.printf("%s\t %s(개)\n", productCode, stock);
	}
	
	
}
