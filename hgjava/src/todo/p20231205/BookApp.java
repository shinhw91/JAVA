package todo.p20231205;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
//		List<Book> books = new ArrayList<>();
		BookExe exe = new BookExe();
		BookDAO dao = new BookDAO();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				System.out.print("1) 도서코드입력>> ");
				String bookCode = sc.nextLine();
				System.out.print("2) 도서명입력>> ");
				String bookName = sc.nextLine();
				System.out.print("3) 저자입력>> ");
				String writer = sc.nextLine();
				System.out.print("4) 출판사입력>> ");
				String publisher = sc.nextLine();
				System.out.print("5) 가격입력>> ");
				int price = Integer.parseInt(sc.nextLine());
				
//				books.add(new Book(bookCode, bookName, writer, publisher, price));
//				System.out.println("저장되었습니다.");
//				break;
				
				Book book = new Book(bookCode, bookName, writer, publisher, price);
				if(dao.addBook(book)) {
					System.out.println("저장되었습니다.");
				} else {
					System.out.println("저장에 실패하였습니다.");
				}
				break;
				
			case 2 :
				System.out.printf("%-10s %-10s %-10s %-10s\n", "도서코드", "도서명", "저자", "가격");
//				for(int i = 0; i < books.size(); i++) {
//					books.get(i).ShowInfo();
//				}
//				break;
				
				for(Book list : dao.bookList())	{
					list.ShowInfo();
				}
				break;
								
			case 3 :
				System.out.print("1) 도서코드입력>> ");
				bookCode = sc.nextLine();
				System.out.print("2) 가격입력>> ");
				price = Integer.parseInt(sc.nextLine());
				
//				for(int i = 0; i < books.size(); i++) {
//					if(books.get(i).getBookCode().equals(bookCode))	{
//						books.get(i).setPrice(price);
//						System.out.println("수정되었습니다.");
//					}
//				}
//				break;
				
				if(dao.modifyBook(bookCode, price)) {
					System.out.println("수정되었습니다.");
				} else {
					System.out.println("수정에 실패하였습니다.");
				}
				break;
				
			case 4 :
				System.out.print("1) 도서코드입력>> ");
				bookCode = sc.nextLine();
				
//				for(int i = 0; i < books.size(); i++) {
//					if(books.get(i).getBookCode().equals(bookCode)) {
//						books.remove(i);
//						System.out.println("삭제되었습니다.");
//					}
//				}
//				break;
				
				if(dao.removeBook(bookCode)) {
					System.out.println("삭제되었습니다.");
				} else {
					System.out.println("삭제에 실패하였습니다.");
				}
				break;
				
			case 5 :
				System.out.print("조회할 책 코드 : ");
				String no = sc.nextLine();

				book = dao.getBook(no);
				if(book != null) {
					book.ShowInfo();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;
				
			case 6 :
				System.out.println("종료되었습니다.");
				run = false;
				

			}	// end switch
		}	// end while

	}	// end main

}	// end class
