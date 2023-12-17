package todo.p20231128;

import java.util.Scanner;
// M(odel) : Board, BoardExe
// V(iew) : html
// C(ontrol): BoardApp


import chap6.User;
import chap6.UserExe;

public class BoardApp {
	//	static BoardExe exe = new BoardExe();
	// 데이터마다 다른 정보를 담을 필요가 없는 클래스는 static 멤버 선언
	private Scanner sc = new Scanner(System.in);
	private String id = null;
	
	// 싱글톤 방식의 인스턴스 생성
	private static BoardApp instance = new BoardApp();	// 싱글톤 생성(3)
	
// 생성자
	private BoardApp() {	// 싱글톤 생성(1)
		
	}
	
	public static BoardApp getInstance() {	// 싱글톤 생성(2)
		return instance;
	}
	
	private void boardAdd() {
		System.out.println("<게시글 등록>");
//		System.out.print("번호 : ");
//		int number = Integer.parseInt(sc.nextLine());
		System.out.print("제목 : ");
		String title = sc.nextLine();
//		System.out.print("작성자 : ");
//		String writer = sc.nextLine();
		System.out.print("내용 : ");
		String contents = sc.nextLine();
		System.out.print("작성일시 : ");
		String date = sc.nextLine();

		Board board = new Board(BoardExe.getSequence(), title, id, contents, date);

//		for(int i = 0; i < boards.length; i++) {
//			if(boards[i] == null) {
//				boards[i] = board;
//				break;
//			}
//		}
		
		if(BoardExe.addBoard(board)) {
			System.out.println("입력 성공!");
		} else {
			System.out.println("처리 실패!");
		}
	}	// end boardAdd
	
	private void boardList() {
		Board[] boardAry = BoardExe.boardList();
		showList(boardAry, 1);
		while(true) {
			int page = Integer.parseInt(sc.nextLine());
			if(page == 0) {
				break;
			}
			showList(boardAry, page);
		}
	}	// end boardList
	
	private void getBoard() {
		int number = 0;
		while(true) {
			System.out.println("상세조회 게시글 번호 : ");
			try {
				number = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException en) {
				System.out.println("정확한 번호를 선택하세요");
			}
		}
		
//		for(int i = 0; i < boards.length; i++) {
//			if(boards[i] != null && boards[i].getBoardNum() == number) {
//				boards[i].showAllInfo();
//			}
//		}
		
		Board result = BoardExe.getBoard(number);
		if(result != null) {
//			result.showAllInfo();
			System.out.println(result.showDetailInfo());
		} else {
			System.out.println("조회된 내용이 없습니다");
		}
	}	// end getBoard
	
	private void boardEdit() {
		System.out.println("수정할 게시글 번호 :");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 내용 : ");
		String contents = sc.nextLine();
		// 권한 체크
		if(!BoardExe.checkResponsibility(id, number)){
			System.out.println("권한이 없습니다 ...");
//			continue;
			return;
		}
		
		if(BoardExe.modBoard(number, contents)) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패!");
		}
	}	// end boardEdit
	
	private void boardDel() {
		System.out.println("삭제할 게시글 번호 :");
		int number = Integer.parseInt(sc.nextLine());
		// 권한 체크
		if(!BoardExe.checkResponsibility(id, number)){
			System.out.println("권한이 없습니다 ...");
//			continue;
			return;
		}
		
		if(BoardExe.remBoard(number)) {
			System.out.println("삭제 완료!");
		} else {
			System.out.println("삭제 실패!");
		}
	}	// end boardDel
	
//	public static void main(String[] args) {
	public void start() {
		boolean run = true;
		
		//		Board[] boards = new Board[100];
		
		UserExe uexe = new UserExe();
		
		while(true) {
			System.out.print("ID 입력 : ");
			id = sc.nextLine();
			System.out.print("PW 입력 : ");
			String pw = sc.nextLine();
			
			User user = uexe.logIn(id, pw);
			if(user != null) {
				System.out.println(user.getUserName() + "님 환영합니다");
				break;
			} else {
				System.out.println("ID, PW를 확인하세요");
			}
		}	// 로그인 처리
		
		
		// 초기값 생성
		BoardExe.initData();
		
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
			int menu = 0;
			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("정확한 메뉴를 선택하세요");
				continue;
			}
			
			switch(menu) {
			case 1 :	// 글 등록
				boardAdd();
//				System.out.println("<게시글 등록>");
////				System.out.print("번호 : ");
////				int number = Integer.parseInt(sc.nextLine());
//				System.out.print("제목 : ");
//				String title = sc.nextLine();
////				System.out.print("작성자 : ");
////				String writer = sc.nextLine();
//				System.out.print("내용 : ");
//				String contents = sc.nextLine();
//				System.out.print("작성일시 : ");
//				String date = sc.nextLine();
//
//				Board board = new Board(BoardExe.getSequence(), title, id, contents, date);
//
////				for(int i = 0; i < boards.length; i++) {
////					if(boards[i] == null) {
////						boards[i] = board;
////						break;
////					}
////				}
//				
//				if(BoardExe.addBoard(board)) {
//					System.out.println("입력 성공!");
//				} else {
//					System.out.println("처리 실패!");
//				}
				break;
				
			case 2 :	// 목록보기 -> 페이지보기
//				for(int i = 0; i < boards.length; i++) {
//					if(boards[i] != null) {
//						boards[i].showList();
//					}
//				}
				
				boardList();
//				Board[] boardAry = BoardExe.boardList();
//				showList(boardAry, 1);
//				while(true) {
//					int page = Integer.parseInt(sc.nextLine());
//					if(page == 0) {
//						break;
//					}
//					showList(boardAry, page);
//				}
				break;
				
			case 3 :
				getBoard();
//				System.out.println("상세조회 게시글 번호 : ");
//				int number = Integer.parseInt(sc.nextLine());
//				
////				for(int i = 0; i < boards.length; i++) {
////					if(boards[i] != null && boards[i].getBoardNum() == number) {
////						boards[i].showAllInfo();
////					}
////				}
//				
//				Board result = BoardExe.getBoard(number);
//				if(result != null) {
////					result.showAllInfo();
//					System.out.println(result.showDetailInfo());
//				} else {
//					System.out.println("조회된 내용이 없습니다");
//				}
				break;

			case 4 :	// 수정
				boardEdit();
//				System.out.println("수정할 게시글 번호 :");
//				number = Integer.parseInt(sc.nextLine());
//				System.out.println("수정할 내용 : ");
//				contents = sc.nextLine();
//				// 권한 체크
//				if(!BoardExe.checkResponsibility(id, number)){
//					System.out.println("권한이 없습니다 ...");
//					continue;
//				}
//				
//				if(BoardExe.modBoard(number, contents)) {
//					System.out.println("수정 완료!");
//				} else {
//					System.out.println("수정 실패!");
//				}
				break;
				
			case 5 :
				boardDel();
//				System.out.println("삭제할 게시글 번호 :");
//				number = Integer.parseInt(sc.nextLine());
//				// 권한 체크
//				if(!BoardExe.checkResponsibility(id, number)){
//					System.out.println("권한이 없습니다 ...");
//					continue;
//				}
//				
//				if(BoardExe.remBoard(number)) {
//					System.out.println("삭제 완료!");
//				} else {
//					System.out.println("삭제 실패!");
//				}
				break;
				
			case 6 :
				System.out.println("프로그램을 종료합니다");
				run = false;
				
				
			}	// end switch
		}	// end while
		System.out.println("end of prog");

	}	// end main
	
	private void showList(Board[] boardAry, int page) {
		// 페이징 처리
		Board[] pageAry = BoardExe.pageList(boardAry, page);
		System.out.println("글번호 제목\t 작성자");
		System.out.println("====================");
//		for(Board brd : boardAry) {
		for(Board brd : pageAry) {	
			if(brd != null) {
				System.out.println(brd.showInfo());
			}
		}
		
		// 전체페이지 계산하고 출력
		int cnt = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0);
		
		for(int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n페이지 선택 : (종료를 원하시면 0을 입력하세요)");
	}

} // end class
