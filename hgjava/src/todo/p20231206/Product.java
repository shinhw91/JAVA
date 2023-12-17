package todo.p20231206;

import lombok.Data;

@Data
public class Product {
	// 속성(필드)
	private String productCode;
	private String title;
	private int price;
	private int stock;
	
	// 생성자
	Product(String productCode, String title, int price) {
		this.productCode = productCode;
		this.title = title;
		this.price = price;
		this.stock = 0;
	}
	
	void ShowInfo() {
		System.out.printf("%s\t %s\t %d\n", productCode, title, price);
	}
	
	void ShowStock() {
		System.out.printf("%s\t %s(개)\n", productCode, stock);
	}


}
