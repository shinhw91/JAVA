package chap7.abstracts;

public class Bird extends Animal {

	@Override
	public void sound() {
		// 추상클래스를 상속하는 자식클래스는 추상메소드 구현
		System.out.println("짹짹");
		
	}
	
}
