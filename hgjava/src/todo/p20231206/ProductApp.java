package todo.p20231206;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
//		List<Product> products = new ArrayList<>();
//		List<InOut> inouts = new ArrayList<>();
		ProductExe productExe = new ProductExe();
		InOutExe inoutExe = new InOutExe();
		
		while(run) {
			System.out.println("1.상품관리 2.입출고관리 3.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				System.out.println("1-1)등록 1-2)수정 1-3)목록");
				int subMenu = Integer.parseInt(sc.nextLine());
				
				switch(subMenu) {
				case 1 :
					System.out.print("1) 상품코드 입력 : ");
					String productCode = sc.nextLine();
					System.out.print("2) 상품명 입력 : ");
					String title = sc.nextLine();
					System.out.print("3) 가격 입력 : ");
					int price = Integer.parseInt(sc.nextLine());
					
//					products.add(new Product(productCode, title, price));
//					System.out.println("상품이 등록되었습니다.");
//					break;
					
					Product product = new Product(productCode, title, price);
					if(productExe.addProduct(product)) {
						System.out.println("상품이 등록되었습니다.");
					} else {
						System.out.println("등록에 실패하였습니다.");
					}
					break;
					
				case 2 :
					System.out.print("1) 상품코드 입력 : ");
					productCode = sc.nextLine();
					System.out.print("2) 가격 입력 : ");
					price = Integer.parseInt(sc.nextLine());
					
//					for(int i = 0; i < products.size(); i++) {
//						if(products.get(i).getProductCode().equals(productCode)) {
//							products.get(i).setPrice(price);
//							System.out.println("가격이 수정되었습니다.");
//						}
//					}
//					break;
					
					if(productExe.modifyProduct(productCode, price)) {
						System.out.println("가격이 수정되었습니다.");
					} else {
						System.out.println("수정에 실패하였습니다.");
					}
					break;
					
				case 3 :
					System.out.printf("%s\t %s\t %s\n", "상품코드", "상품명", "가격");
//					for(int i = 0; i < products.size(); i++) {
//						products.get(i).ShowInfo();
//					}
//					break;
					
					for(Product list : productExe.productList()) {
						list.ShowInfo();
					}
					break;
					
				}	// 1.상품관리
				break;
				
			case 2 :
				System.out.println("2-1)판매 2-2)구매 2-3)재고 2-4)내역");
				subMenu = Integer.parseInt(sc.nextLine());
				int stock = 0;
				
				switch(subMenu) {
				case 1 :
					System.out.print("1) 상품코드 입력 : ");
					String productCode = sc.nextLine();
					System.out.print("2) 처리날짜 입력 : ");
					String date = sc.nextLine();
					if(date == "") {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						date = sdf.format(new Date());
					}
					System.out.print("3) 수량 입력 : ");
					int count = Integer.parseInt(sc.nextLine());
					String sale = "판매";

//					for(int i = 0; i < inouts.size(); i++) {
//						if(inouts.get(i).getProductCode().equals(productCode)) {
//							stock = inouts.get(i).getStock();
//							inouts.get(i).setStock(stock - count);
//						} 
//					}
//					
//					System.out.println("판매가 처리되었습니다.");
//					break;
					
					if(inoutExe.productOut(productCode, date, count)) {
						System.out.println("판매가 처리되었습니다.");
					} else {
						System.out.println("판매 처리에 실패하였습니다.");
					}
					break;
					
				case 2 :
					System.out.print("1) 상품코드 입력 : ");
					productCode = sc.nextLine();
					System.out.print("2) 처리날짜 입력 : ");
					date = sc.nextLine();
					System.out.print("3) 수량 입력 : ");
					count = Integer.parseInt(sc.nextLine());
					sale = "구매";

//					for(int i = 0; i < inouts.size(); i++) {
//						if(inouts.get(i).getProductCode().equals(productCode)) {
//							stock = inouts.get(i).getStock();
//							inouts.get(i).setStock(stock + count);
//						} else {
//							inouts.add(new InOut(productCode, date, count, sale));
//						}
//					}
//					
//					System.out.println("구매가 처리되었습니다.");
//					break;
					
					if(inoutExe.productIn(productCode, date, count)) {
						System.out.println("구매가 처리되었습니다.");
					} else {
						System.out.println("구매 처리에 실패하였습니다.");
					}
					break;
					
				case 3 :
					System.out.printf("%s\t %s\n", "상품코드", "재고수량");
//					for(int i = 0; i < inouts.size(); i++) {
//						inouts.get(i).ShowStock();
//					}
//					break;
					
					for(InOut list : inoutExe.stockList()) {
						list.ShowStock();
					}
					break;
					
//				case 4 : 
//					System.out.printf("%s\t %s\t %s\t %s\n", "상품코드", "처리날짜", "수량", "판(구)매");
//					System.out.println("================================");
//					for(int i = 0; i < inouts.size(); i++) {
//						inouts.get(i).ShowInfo();
//					}
					
				}	// 2.입출고관리
				break;
				
			case 3 :
				System.out.println("프로그램이 종료되었습니다.");
				run = false;
	
				
				
				
				
			}	// end switch
			
		}	// end while

	}	// end main

}	// end class
