// 인스턴스 멤버 : 객체마다 다른 필드값

package todo.p20231128;
// 깃허브 충돌 test
// 나도 변경 test

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	// 속성(필드)
	private int boardNum;	// boardNum, board_num
	private String title;
	private String writer;
	private String contents;
	private String date;
	
	
	// 생성자
	public Board() {
		
	}
	
	public Board(int boardNum, String title, String writer, String contents){
		Date today = new Date();	// 시스템 시간을 기준으로 생성
//		int year = today.getYear();
//		int month = today.getMonth() + 1;
//		int date = today.getDate();
		
		// Date -> String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.boardNum = boardNum;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.date = sdf.format(today);
	}
	
	public Board(int boardNum, String title, String writer, String contents, String date){
//		this();	// 기본 생성자
		this(boardNum, title, writer, contents);
		
//		this.boardNum = boardNum;
//		this.title = title;
//		this.writer = writer;
//		this.contents = contents;
		this.date = date;
	}
	
	
	// 기능(메소드)
	public void showList() {
		System.out.println(boardNum + " " + title + " " + writer);
	}
	
	public void showAllInfo() {
		System.out.println("번호 : " + boardNum + " / 제목 : " + title);
		System.out.println("작성자 : " + writer);
		System.out.println("내용 : " + contents);
		System.out.println("일시 : " + date);
	}
	
	public String showInfo() {
		return boardNum + " " + title + " " + writer + " " + date;
	}
	
	public String showDetailInfo() {
		String result = "번호 : " + boardNum + " / 제목 : " + title;
		result += "\n작성자 : " + writer;
		result += "\n내용 : " + contents;
		result += "\n일시 : " + date;
		return result;
	}
	
	
	// setter
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	// getter
	public int getBoardNum() {
		return boardNum;
	}

	public String getTitle() {
		return title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getContents() {
		return contents;
	}
	
	public String getDate() {
		return date;
	}
	
	
}	// end class
