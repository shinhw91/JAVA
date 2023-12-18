package chap6;

public class Student {
	// 속성(필드)
	private String studentNo;
	private String studentName;
	private int eng;
	private int math;

	// 생성자
	Student(String studentNo, String studentName, int eng, int math) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.eng = eng;
		this.math = math;
	}

	// 기능(메소드)
	void ShowInfo() {
		System.out.println("이름 : " + studentName + ", 영어점수 : " + eng + ", 수학점수 : " + math);
	}

	// setter
	void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	void setEng(int eng) {
		this.eng = eng;
	}

	void setMath(int math) {
		this.math = math;
	}

	// getter
	String getStudentNo() {
		return studentNo;
	}

	String getStudentName() {
		return studentName;
	}

	int getEng() {
		return eng;
	}

	int getMath() {
		return math;
	}

} // end class
