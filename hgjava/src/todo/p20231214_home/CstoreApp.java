package todo.p20231214_home;

import java.util.Scanner;

public class CstoreApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		CstoreDAO dao = new CstoreDAO();
		
		// 메인메뉴
		while(run) {
			System.out.println("1.로그인 2.계정관리 3.종료");
			int menu = Integer.parseInt(sc.nextLine());
			boolean exist = false;
			
			switch(menu) {
			// 메인메뉴 - 1.로그인
			case 1 :
				System.out.print("1) 사원코드 입력 : ");
				String accountCode = sc.nextLine();
				System.out.print("2) 비밀번호 입력 : ");
				String accountPw = sc.nextLine();
				
				if(dao.login(accountCode, accountPw)) {
					System.out.println("로그인되었습니다.");
					exist = true;
					
				} else {
					System.out.println("로그인에 실패하였습니다.");
				}
				
				if(exist) {
					System.out.println("1.상품관리 2.상품입고 3.상품판매 4.내역관리 5.재고관리");
					int subMenu = Integer.parseInt(sc.nextLine());
					
					switch(subMenu) {
						// 메인메뉴 - 1.로그인 - 1.상품관리
						case 1 :
							System.out.println("1.상품등록 2.상품수정 3.상품조회 4.상품삭제 5.상품목록");
							int subMenu2 = Integer.parseInt(sc.nextLine());
							
							switch(subMenu2) {
							// 메인메뉴 - 1.로그인 - 1.상품관리 - 1.상품등록
							case 1 :
								System.out.print("1) 상품코드 입력 : ");
								String productCode = sc.nextLine();
								System.out.print("2) 상품명 입력 : ");
								String productName = sc.nextLine();
								System.out.print("3) 가격 입력 : ");
								int productprice = Integer.parseInt(sc.nextLine());
							}
					}
				}
			
			// 메인메뉴 - 2.계정관리
			case 2 :
				System.out.println("1.계정등록 2.계정수정 3.계정삭제 4.계정목록");
				int subMenu = Integer.parseInt(sc.nextLine());

				switch(subMenu) {
				// 메인메뉴 - 2.계정관리 - 1.계정등록
				case 1 :
					System.out.print("1) 사원코드 입력 : ");
					accountCode = sc.nextLine();
					System.out.print("2) 사원명 입력 : ");
					String accountName = sc.nextLine();
					System.out.print("3) 사원구분 입력 : ");
					String accountGrade = sc.nextLine();
					System.out.print("4) 비밀번호 입력 : ");
					accountPw = sc.nextLine();
					
					if(dao.addAccount(accountCode, accountName, accountGrade, accountPw)) {
						System.out.println("계정이 등록되었습니다.");
					} else {
						System.out.println("계정등록에 실패하였습니다.");
					}
					continue;
				
				// 메인메뉴 - 2.계정관리 - 2.계정수정
				case 2 :
					System.out.print("1) 사원코드 입력 : ");
					accountCode = sc.nextLine();
					System.out.print("2) 사원구분 입력 : ");
					accountGrade = sc.nextLine();
					
					if(dao.modifyAccount(accountCode, accountGrade)) {
						System.out.println("계정이 수정되었습니다.");
					} else {
						System.out.println("계정 수정에 실패하였습니다.");
					}
					continue;
					
				// 메인메뉴 - 2.계정관리 - 3.계정삭제
				case 3 :
					System.out.print("1) 사원코드 입력 : ");
					accountCode = sc.nextLine();
					System.out.print("2) 비밀번호 입력 : ");
					accountPw = sc.nextLine();
					
					if(dao.removeAccount(accountCode, accountPw)) {
						System.out.println("계정이 삭제되었습니다.");
					} else {
						System.out.println("계정 삭제에 실패하였습니다.");
					}
					continue;
					
				// 메인메뉴 - 2.계정관리 - 4. 계정목록
				case 4 :
					System.out.printf("%-15s %-15s %-15s\n", "사원코드", "사원명", "사원구분");
					
					for(Account list : dao.accountList()) {
						list.showInfo();
					}
					continue;
					
				}
				
			// 메인메뉴 - 3.종료	
			case 3 :
				System.out.println("프로그램을 종료합니다.");
				run = false;
				
			}	// end 메인메뉴 switch
			
		}	// end 메인메뉴
		
	}	// end main

}	// end class
