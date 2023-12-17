package chap10;

public class ExceptionExe {

	public static void main(String[] args) {
		
		// 일반예외 : 예외를 처리
		try {
			test();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("end of prog");

	}

	public static void test() throws ClassNotFoundException {
		Class.forName("java.lang.String");
		
	}
}
