package com.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CstoreApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean login = false;
		boolean manage = false;
		
		AccountDAO aDao = new AccountDAO();
		ProductDAO pDao = new ProductDAO();
		
		
		// ******************************* 메인 메뉴 ******************************
		while(run) {
			System.out.println("1.로그인    2.계정관리    3.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			// 1.로그인
			case 1 :
				System.out.print("사원코드 입력 >> ");
				String accountCode = sc.nextLine();
				System.out.print("비밀번호 입력 >> ");
				String accountPw = sc.nextLine();
				
				if(aDao.login(accountCode, accountPw)) {
					System.out.printf("========== 사원코드 '%s'으로 로그인되었습니다. ==========\n", accountCode);
					System.out.println();
					login = true;
					run = false;
					
				} else {
					System.out.printf("========== 로그인을 실패하였습니다. ==========\n", accountCode);
					System.out.println();
				}
				break;
				
				
			// 2.계정관리
			case 2 :
				manage = true;
				run = false;
				break;
				
				
			// 3.종료
			case 3 :
				System.out.println("========== 프로그램을 종료합니다. ==========");
				System.out.println();
				run = false;
				
			}
			
		}	// end 메인메뉴
		
		
		
		
		// **************************** 로그인 메뉴 *******************************
		while(login) {
			System.out.println("1)상품관리    2)상품입고    3)상품판매    4)내역확인    5)재고확인");
			int menu = Integer.parseInt(sc.nextLine());
			boolean pManage = true;
			boolean hConfirm = true;
			boolean rConfirm = true;
			
			switch(menu) {
				// ***************************************************** 1.상품관리
				case 1 :
					while(pManage) {
						System.out.println("(1)상품등록    (2)상품수정    (3)상품조회    (4)상품목록    (5)상품삭제    (6)이전메뉴로 이동");
						int subMenu = Integer.parseInt(sc.nextLine());
						
						switch(subMenu) {
						// 1.상품등록
						case 1 :
							System.out.print("상품코드 입력 >> ");
							String productCode = sc.nextLine();
							System.out.print("상품명 입력 >> ");
							String productName = sc.nextLine();
							System.out.print("가격 입력 >> ");
							int productPrice = Integer.parseInt(sc.nextLine());
							
							if(pDao.addProduct(productCode, productName, productPrice)) {
								System.out.println("========== 상품이 등록되었습니다. ==========");
								System.out.println();
							} else {
								System.out.println("========== 상품 등록을 실패하였습니다. ==========");
								System.out.println();
							}
							break;
						
							
						// 2.상품수정
						case 2 :
							System.out.print("상품코드 입력 >> ");
							productCode = sc.nextLine();
							System.out.print("수정할 가격 입력 >> ");
							productPrice = Integer.parseInt(sc.nextLine());
							
							if(pDao.modifyProduct(productCode, productPrice)) {
								System.out.println("========== 가격이 수정되었습니다. ==========");
								System.out.println();
							} else {
								System.out.println("========== 가격 수정을 실패하였습니다. ==========");
								System.out.println();
							}
							break;
							
							
						// 3.상품조회
						case 3 :
							System.out.print("상품코드 입력 >> ");
							productCode = sc.nextLine();
							
							Product product = pDao.getProduct(productCode);
							if(product != null) {
								System.out.println(" 《상 품 코 드》       《상 품 명》         《가 격》");
								System.out.println("================================================");
								product.showInfo();
								System.out.println("================================================");
								System.out.println();
							} else {
								System.out.println("========== 존재하지 않는 상품입니다. ==========");
								System.out.println();
							}
							break;
							
							
						// 4.상품목록
						case 4 :
							System.out.println(" 《상 품 코 드》       《상 품 명》         《가 격》");
							System.out.println("================================================");
							
							for(Product list : pDao.productList()) {
								list.showInfo();
							}
							System.out.println("================================================");
							System.out.println();
							break;
							
				
						// 5.상품삭제
						case 5 :
							System.out.println("상품코드 입력 >> ");
							productCode = sc.nextLine();
							
							if(pDao.removeProduct(productCode)) {
								System.out.println("========== 상품이 삭제되었습니다. ==========");
								System.out.println();
							} else {
								System.out.println("========== 존재하지 않는 상품입니다. ==========");
								System.out.println();
							}
							break;
							
							
						// 6.이전메뉴로 이동
						case 6 :
							pManage = false;
							
						}
					}
					break;
					
					
		
				
				// ***************************************************** 2.상품입고
				case 2 :
					// 거래번호 확인
					int historyNumber = 1;
					if(pDao.confirmNumber() > 0) {
						historyNumber = pDao.confirmNumber() + 1;
					}
					
					System.out.print("상품코드 입력 >> ");
					String productCode = sc.nextLine();
					System.out.print("수량 입력 >> ");
					int productCount = Integer.parseInt(sc.nextLine());
					System.out.print("입고일 입력 >> ");
					String historyDate = sc.nextLine();
					if(historyDate.equals("")) {
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						historyDate = sdf.format(date);
					}
					
					String historySort = "입고";
					String saleSort = " - ";
					
					// 상품등록 확인
					if(pDao.confirmProduct(productCode)) {
						// 내역 테이블
						if(pDao.enterProduct(historyNumber, historyDate, productCode, productCount, historySort, saleSort)) {
							// 상품재고
							int productRemain = pDao.confirmRemain(productCode) + productCount;
							// 상품 테이블
							pDao.updateRemain(productCode, productRemain);
							System.out.println("========== 상품이 입고되었습니다. ==========");
							System.out.println();
						} else {
							System.out.println("========== 상품 입고를 실패하였습니다. ==========");
							System.out.println();
						}
						
					} else {
						System.out.println("========== 등록되어 있지 않은 상품은 입고할 수 없습니다. 상품을 등록해주세요. ==========");
						System.out.println();
					}
					break;
					
					
					
					
				// ***************************************************** 3.상품판매
				case 3 :
					// 거래번호 확인
					historyNumber = 1;
					if(pDao.confirmNumber() > 0) {
						historyNumber = pDao.confirmNumber() + 1;
					}
					
					System.out.print("상품코드 입력 >> ");
					productCode = sc.nextLine();
					System.out.print("수량 입력 >> ");
					productCount = Integer.parseInt(sc.nextLine());
					System.out.print("판매일 입력 >> ");
					historyDate = sc.nextLine();
					if(historyDate.equals("")) {
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						historyDate = sdf.format(date);
					}
					
					System.out.print("결제방법(1.현금  2.카드) >> ");
					saleSort = "";
					int num = Integer.parseInt(sc.nextLine());
					if(num == 1) {
						saleSort = "현금";
					} else if (num == 2) {
						saleSort = "카드";
					}
					
					// 상품가격 확인
					int saleIncome = pDao.confirmPrice(productCode) * productCount;
					historySort = "판매";
					
					// 상품등록 확인
					if(pDao.confirmProduct(productCode)) {
						// 내역 테이블
						if(pDao.outProduct(historyNumber, historyDate, productCode, productCount, saleIncome, saleSort, historySort)) {
							// 상품재고
							int productRemain = pDao.confirmRemain(productCode) - productCount;
							// 상품 테이블
							pDao.updateRemain(productCode, productRemain);
							System.out.println("========== 상품이 판매되었습니다. ==========");
							System.out.println();
						} else {
							System.out.println("========== 상품 판매를 실패하였습니다. ==========");
							System.out.println();
						}
						
					} else {
						System.out.println("========== 등록되어 있지 않은 상품은 판매할 수 없습니다. 상품을 등록해주세요. ==========");
						System.out.println();
					}
					break;
					
					
					
					
				// ***************************************************** 4.내역확인
				case 4 :
					while(hConfirm) {
						System.out.println("(1)입고내역    (2)판매내역    (3)전체내역    (4)이전메뉴로 이동");
						int subMenu = Integer.parseInt(sc.nextLine());
						
						switch(subMenu) {
						// 1.입고내역
						case 1 :
							System.out.println(" 《번 호》   《영 업 일 자》       《상 품 코 드》       《상 품 명》         《가 격》         《수 량》       《내 역 구 분》");
							System.out.println("=====================================================================================================================");
						
							for(Product list : pDao.enterList()) {
								list.enterInfo();
							}
							System.out.println("=====================================================================================================================");
							System.out.println();
							break;
							
							
						// 2.판매내역
						case 2 :
							System.out.println(" 《번 호》   《영 업 일 자》       《상 품 코 드》       《상 품 명》         《가 격》         《수 량》       《매 출 액》         《결 제 방 법》         《내 역 구 분》");
							System.out.println("============================================================================================================================================================");
							
							for(Product list : pDao.outList()) {
								list.outInfo();
							}
							System.out.println("============================================================================================================================================================");
							System.out.println();
							break;
							
							
						// 3.전체내역
						case 3 :
							System.out.println(" 《번 호》   《영 업 일 자》       《상 품 코 드》       《상 품 명》         《가 격》         《수 량》       《매 출 액》         《결 제 방 법》         《내 역 구 분》");
							System.out.println("============================================================================================================================================================");
							
							for(Product list : pDao.fullList()) {
								list.outInfo();
							}
							System.out.println("============================================================================================================================================================");
							System.out.println();
							break;	
							
							
						// 4.이전메뉴로 이동
						case 4 :
							hConfirm = false;
							
						}
					}
					break;
					
					
					
					
				// ***************************************************** 5.재고확인
				case 5 :
					while(rConfirm) {
						System.out.println("(1)재고조회    (2)재고목록    (3)이전메뉴로 이동");
						int subMenu = Integer.parseInt(sc.nextLine());
						
						switch(subMenu) {
						// 1.재고조회
						case 1 :
							System.out.print("상품코드 입력 >> ");
							productCode = sc.nextLine();
							
						Product product = pDao.getRemain(productCode);
						if(product != null) {
							System.out.println(" 《상 품 코 드》       《상 품 명》         《재 고》");
							System.out.println("================================================");
							product.remainInfo();
							System.out.println("================================================");
							System.out.println();
						} else {
							System.out.println("========== 존재하지 않는 상품입니다. ==========");
							System.out.println();
						}
						break;
						
						
						// 2.재고목록
						case 2 :
							System.out.println(" 《상 품 코 드》       《상 품 명》         《재 고》");
							System.out.println("================================================");
							
							for(Product list : pDao.remainList()) {
								list.remainInfo();
							}
							System.out.println("================================================");
							System.out.println();
							break;
							
							
						// 3.이전메뉴로 이동
						case 3 :
							rConfirm = false;
						
						}
					}
					break;
					
					
					
			}
		}
		
		
		
		
		// **************************** 계정관리 메뉴 *****************************
		while(manage) {
			System.out.println("1)계정등록    2)정보수정    3)계정목록    4)계정삭제 ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			// 1.계정등록
			case 1 :
				System.out.print("사원코드 입력 >> ");
				String accountCode = sc.nextLine();
				System.out.print("비밀번호 입력 >> ");
				String accountPw = sc.nextLine();
				System.out.print("사원명 입력 >> ");
				String accountName = sc.nextLine();
				System.out.print("사원구분 입력 >> ");
				String accountGrade = sc.nextLine();
				
				if(aDao.addAccount(accountCode, accountName, accountGrade, accountPw)) {
					System.out.println("========== 계정이 등록되었습니다. ==========");
					System.out.println();
				} else {
					System.out.println("========== 계정 등록을 실패하였습니다. ==========");
					System.out.println();
				}
				break;
				
				
			// 2.정보수정
			case 2 :
				System.out.print("사원코드 입력 >> ");
				accountCode = sc.nextLine();
				System.out.print("비밀번호 입력 >> ");
				accountPw = sc.nextLine();
				System.out.print("변경할 비밀번호 입력 >> ");
				String newAccountPw = sc.nextLine();
				
				if(aDao.login(accountCode, accountPw)) {
					if(aDao.modifyAccount(accountCode, newAccountPw)) {
						System.out.println("========== 비밀번호가 변경되었습니다. ==========");
						System.out.println();
					} else {
						System.out.println("========== 비밀번호 변경을 실패하였습니다. ==========");
						System.out.println();
					}
					
				} else {
					System.out.printf("========== 비밀번호 변경을 실패하였습니다(접근권한 없음). ==========\n", accountCode);
					System.out.println();
				}
				break;
				
		
			// 3. 계정목록
			case 3 :
				System.out.println(" 《사 원 코 드》       《사 원 명》         《사 원 구 분》");
				System.out.println("===================================================");
				
				for(Account list : aDao.accountList()) {
					list.showInfo();
				}
				System.out.println("===================================================");
				System.out.println();
				break;
	
				
			// 4.계정삭제
			case 4 :
				System.out.print("사원코드 입력 >> ");
				accountCode = sc.nextLine();
				System.out.print("비밀번호 입력 >> ");
				accountPw = sc.nextLine();
				
				if(aDao.removeAccount(accountCode, accountPw)) {
					System.out.println("========== 계정이 삭제되었습니다. ==========");
					System.out.println();
				} else {
					System.out.println("========== 계정 삭제를 실패하였습니다. ==========");
					System.out.println();
				}
				break;

				
			}
		}
		
		

		
	}	// end main

}	// end class
