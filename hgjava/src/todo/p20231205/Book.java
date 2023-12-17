package todo.p20231205;

import lombok.Data;

@Data
public class Book {
	// 속성(필드)
	private String bookCode;
	private String bookName;
	private String writer;
	private String publisher;
	private int price;
	
	// 생성자
	Book(){
		
	}
	
	Book(String bookCode, String bookName, String writer, String publisher, int price) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}
	
	void ShowInfo() {
		System.out.printf("%-10s %-10s %-10s %-10d\n", bookCode, bookName, writer, price);
	}

}
