package chap5;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner sc = new Scanner(System.in);
	static Student[] students = null;
	
	
	public static void addStudent() {
		System.out.println("학생정보 입력>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student();
			System.out.print("학생 이름 입력>> ");
			student.name = sc.nextLine();
			System.out.print("학생 점수 입력>> ");
			student.score = Integer.parseInt(sc.nextLine());
			System.out.print("남/여 입력>> ");
			student.gender = sc.nextLine();
			
			students[i] = student;
		}		
	}	// end addStudent

	
	public static void searchStudent() {
		System.out.println("조회할 이름입력>> ");
		String name = sc.nextLine();
		boolean exists = false;
		
		// 학생이름 - 점수 출력
		for(Student stu : students) {
			if(name.equals(stu.name)) {
				System.out.println("이름은 " + stu.name + ", 점수는 " + stu.score);
				exists = true;
			}
		}
		
		// 찾는 이름의 존재여부 : exists 확인
		if(!exists) {
			System.out.println("찾는 이름이 없습니다");
		}
		
//		for(int i = 0; i < students.length; i++) {
//			System.out.println(students[i].name + " - " + students[i].score);
//		}
//		break;
		
	}	// end searchStudent
	
	
	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student stu : students) {
			if(stu.gender.equals("남")) {
				sumOfMen += stu.score;
				cntOfMen++;
			} else if (stu.gender.equals("여")) {
				sumOfWomen += stu.score;
				cntOfWomen++;
			}
		}
		System.out.println("남학생의 평균 : " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("여학생의 평균 : " + (sumOfWomen * 1.0 / cntOfWomen));
		
	}	// end analysis
	
	
	public static void modify() {
		// 이름입력 -> 변경점수
		System.out.println("조회할 이름입력>> ");
		String name = sc.nextLine();
		boolean exists = false;

		for(int i = 0; i < students.length; i++) {
			// 조건추가 => 변경점수 입력
			if(name.equals(students[i].name)) {
				System.out.println("변경점수 입력>>");
				students[i].score = Integer.parseInt(sc.nextLine());
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("찾는 이름이 없습니다");
		}

	}	// end modify
	
	
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.조회 4.분석(최고점수, 평균) 5.수정 6.종료");
			int menu = sc.nextInt();	// Enter 앞까지 처리
			sc.nextLine();	// Enter 처리

			switch(menu) {
			case 1 : 
				System.out.println("학생수 입력>> ");
				studentNum = Integer.parseInt(sc.nextLine());	// 문자열 형변환
				students = new Student[studentNum];
				break;
			case 2 :
				addStudent();
				break;
			case 3 :
				searchStudent();
				break;
			case 4 :	// 분석
				analysis();
				break;
			case 5 :	// 수정
				modify();
				break;
			case 6 :
				System.out.println("종료합니다.");
				run = false;
				
			}	// end switch

		}	// end while
		
	}	// end main
}	// end class
