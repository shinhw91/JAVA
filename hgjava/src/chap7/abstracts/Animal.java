package chap7.abstracts;

// 추상클래스
public abstract class Animal {
	private String name;
	
	public Animal() {
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// 추상메소드 (상속 받는 클래스에서 필수로 정의)
	public abstract void sound();
	
}	// end class
