package chap6;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		boolean run = true;
//		Student[] students = new Student[100];
//		students[0] = new Student("23-001", "홍길동", 77, 88);
//		students[1] = new Student("23-002", "김철수", 82, 85);
		
		Scanner sc = new Scanner(System.in);
		StudentExe exe = new StudentExe();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회(학생정보) 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				System.out.println("<학생 등록>");
				System.out.print("번호 : ");
				String no = sc.nextLine();
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("영어점수 : ");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.print("수학점수 : ");
				int math = Integer.parseInt(sc.nextLine());
				
				Student stu = new Student(no, name, eng, math);
				// students 배열에 한건 저장
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] == null) {
//						students[i] = stu;
//						break;
//					}
//				}
				if(exe.addStudent(stu)) {
					System.out.println("저장되었습니다.");
				} else {
					System.out.println("저장 중 오류");
				}
				
				break;
				
			case 2 :	// 목록보기
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null)
//						students[i].ShowInfo();
//				}
				
//				Student[] stdAry = exe.getStudentList();
//				for(Student stdnt : stdAry) {
//					if(stdnt != null) {
//						stdnt.ShowInfo();
//					}
//				}	// Student[] 타입
				
				for(Student stdnt : exe.getStudentList()) {
					if(stdnt != null) {
						stdnt.ShowInfo();
					}
				}	// Student[] 타입
				break;
				
			case 3 :
				System.out.print("조회할 학생 번호 : ");
				no = sc.nextLine();
//				boolean exist = true;
//				
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStudentNo().equals(no)) {
//						students[i].ShowInfo();
//						exist = false;
//					}
//				}
//				if(exist) {
//					System.out.println("등록 정보가 없습니다");
//				}
				Student stnt = exe.getStudent(no);
				if(stnt != null) {
					stnt.ShowInfo();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;
				
			case 4 :
				System.out.println("수정할 학생 번호 : ");
				no = sc.nextLine();
				
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStudentNo().equals(no)) {
//						System.out.print("영어 점수 : ");
//						students[i].setEng(Integer.parseInt(sc.nextLine()));
//						System.out.print("수학 점수 : ");
//						students[i].setMath(Integer.parseInt(sc.nextLine()));
//					}
//				}
				System.out.println("영어 점수 : ");
				eng = Integer.parseInt(sc.nextLine());
				System.out.println("수학 점수 : ");
				math = Integer.parseInt(sc.nextLine());
				
				if(exe.modifyStudent(no, eng, math)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				break;
				
			case 5 :
				System.out.println("삭제할 학생 이름 : ");
				name = sc.nextLine();
				
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStudentName().equals(name)) {
//						students[i] = null;
//					}
//				}
				if(exe.removeStudent(name)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;
				
			case 6 :
				System.out.println("프로그램을 종료합니다.");
				run = false;
			
			
			}	// end switch
		}	// end while

	}	// end main

}	// end class
