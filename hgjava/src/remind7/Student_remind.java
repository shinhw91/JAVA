package remind7;

import lombok.Data;

@Data
public class Student_remind {
	// 속성(필드)
	private String studentNo;
	private String studentName;
	private int eng;
	private int math;
	
	// 생성자
	Student_remind(String studentNo, String studentName, int eng, int math) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.eng = eng;
		this.math = math;
	}
	
	void ShowInfo() {
		System.out.println("이름 : " + studentName + ", 영어점수 : " + eng + ", 수학점수 : " + math);
	}
}
