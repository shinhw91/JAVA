package chap7;

import lombok.Data;
import lombok.ToString;

// 부모 : 이름, 연락처, showInfo()
@Data
public class Friend {	// extends Object 
	// 필드
	private String name;
	private String phone;
	
	// 기본 생성자
	public Friend() {
		super();
	}
	
	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	// 메소드.
	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + "]";
	}
	
	
	public String showInfo() {
		return "이름은 " + name + " 연락처는 " + phone;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}


}
