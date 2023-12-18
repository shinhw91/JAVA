package chap6;

// 회원관리 앱
// 회원번호, 회원이름, 연락처, 성별
// public <-> private

public class Member {
	// 속성(필드)
	private int memberNo;	// 자바에서는 두단어 이상의 조합 : CamelCase
	private String memberName;
	private String phone;	// 010-1234-5678
	private String gender;	// Men or Women => M, W
		
	// 생성자 : 필드의 초기값을 지정
	// 기본생성자 컴파일러가 생성
	Member() {
		
	}
	
	// 생성자(매개변수)
	Member(int memberNo, String memberName){
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
	
	public Member(int memberNo, String memberName, String phone, String gender) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}

	// 기능(메소드)
	void showInfo() {	// void : 반환값 없음
		System.out.println("이름은 " + memberName + "이고 연락처는 " + phone + "입니다.");
	}
	
	String showAllInfo() {	// String : 반환값
		String result = "이름은 " + memberName + "이고 번호는 " + memberNo + "이고 연락처는 " + phone + "이고 성별은 " + gender + "입니다.";
		return result;
	}
	
	// memberNo의 값을 지정하는 메소드
	void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// getter
	int getMemberNo() {
		return memberNo;
	}

	String getMemberName() {
		return memberName;
	}

	String getPhone() {
		return phone;
	}

	String getGender() {
		return gender;
	}


}