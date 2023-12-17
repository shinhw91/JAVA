package chap8;

// 추상클래스처럼 추상메소드
// Oracle : insert(), update() / MySQL : add(), modify()

public interface DatabaseService {
	public static final String name = "";	// 상수만 사용가능
	
	// 입력, 수정, 삭제
	public abstract void add();
	public void modify();
	public void remove();
}
