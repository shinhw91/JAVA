// 정적 멤버(static) : 객체마다 다를 필요가 없는 필드값
// 인스턴스(객체) 생성 필요없음

package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

// 저장소 : boards
public class BoardExe {
	// 배열
	static Board[] boards;

	// 생성자(인스턴스 생성)
	BoardExe() {
//		boards = new Board[100];
	}
	
	// 정적
	static {
		boards = new Board[100];
	}
	
	// 초기값 생성
	public static void initData() {
		boards[0] = new Board(1, "첫번째 글", "user01", "첫번째 글 입력중입니다", "2023-11-27");
		boards[1] = new Board(2, "두번째 글", "user02", "두번째 글 입력중입니다", "2023-11-28");
		// board[2] : 5번 글 등록
		boards[3] = new Board(4, "네번째 글", "user03", "세번째 글 입력중입니다", "2023-11-29");
		boards[2] = new Board(3, "세번째 글", "user03", "세번째 글 입력중입니다", "2023-11-29");
		boards[4] = new Board(5, "다섯번째 글", "user03", "세번째 글 입력중입니다");
		boards[5] = new Board(6, "여섯번째 글", "user03", "세번째 글 입력중입니다");
		boards[6] = new Board(7, "일곱번째 글", "user03", "세번째 글 입력중입니다");
		boards[7] = new Board(8, "여덟번째 글", "user03", "세번째 글 입력중입니다");
		
	}

	// 등록 (글번호, 제목, 작성자, 내용, 작성일시) => 반환값 : boolean
	public static boolean addBoard(Board board) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
//				break;	// 반복문 종료
				return true; // 메소드 끝
			}
		}
		return false;
	}

	// 목록 => 반환값 : 배열
	public static Board[] boardList() {
		// boards => 새로운 배열에 정렬된 값으로 반환
		
		Board temp = null;
		for(int j = 0; j < boards.length - 1; j++) {
			// 위치변경 작업
//			if(boards[i] == null) {
//				System.out.println();
//			}
			for(int i = 0; i < boards.length - 1; i++) {
				if(boards[i] != null && boards[i + 1] != null) {
					if(boards[i].getBoardNum() > boards[i + 1].getBoardNum()) {
						temp = boards[i];
						boards[i] = boards[i + 1];
						boards[i + 1] = temp;
					}					
				}
			}	// 반복문 i
		}	// 반복문 j
		
		return boards;
	}	// end boardList
	
	// 배열, 페이지 => 페이지의 5건을 반환 ???????????????????????????
	public static Board[] pageList(Board[] ary, int page) {
		Board[] resultAry = new Board[5];
		
		int start = (page - 1) * 5;
		int end = page * 5;
		int j = 0;
		for(int i = 0; i < ary.length; i++) {
			if(i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}

	// 단건조회(매개변수 : 글번호) => 반환값 : Board
	public static Board getBoard(int boardNo) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNum() == boardNo) {
				return boards[i];
			}
		}
		return null;
	}

	// 신규번호 : 현재 글번호 + 1
	public static int getSequence() {
		int seqNo = 1;
		// 배열에서 글번호의 max 가져오기
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNum() > max) {
				max = boards[i].getBoardNum();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}
	
	// 수정(매개변수 : 글번호, 내용) => 반환값 : boolean
	public static boolean modBoard(int no, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNum() == no) {
				boards[i].setContents(content);
				boards[i].setDate(sdf.format(today));
				return true;
			}
		}
		return false;
	}
	
	// 삭제(매개변수 : 글번호) => 반환값 : boolean
	public static boolean remBoard(int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNum() == no) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// 사용자가 해당글번호의 수정, 삭제권한 체크 => boolean
	public static boolean checkResponsibility(String id, int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNum() == no && boards[i].getWriter().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	// 게시글을 담고 있는 배열에서 값이 있는 건수를 반환
	public static int getBoardCount() {
		int realCnt = 0;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}
	

} // end class
