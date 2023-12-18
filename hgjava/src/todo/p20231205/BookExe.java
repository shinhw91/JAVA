package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

public class BookExe {
//	List<Book> books = new ArrayList<>();
	ArrayList<Book> books;
	
	BookExe(){
		books = new ArrayList<Book>();
		books.add(new Book("B001", "이것이 자바다", "신용권", "한빛미디어", 25000));
	}

	// 등록
	boolean addBook(Book book) {
		return books.add(book);
	}

	// 목록
	List<Book> bookList() {
		return books;
	}
	
	// 수정
	boolean modifyBook(String bookCode, int price) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().equals(bookCode))	{
				books.get(i).setPrice(price);
				return true;
			}
		}
		return false;
	}
	
	// 삭제
	boolean removeBook(String bookCode) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().equals(bookCode)) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}

} // end class
