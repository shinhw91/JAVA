package remind7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp_remind {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		List<Student_remind> students = new ArrayList<>();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회(학생정보) 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				System.out.println("<학생 등록>");
				System.out.println("번호 이름 영어점수 수학점수");
				String input = sc.nextLine();
				String[] inAry = input.split(" ");
				
				students.add(new Student_remind(inAry[0], inAry[1], Integer.parseInt(inAry[2]), Integer.parseInt(inAry[3])));
				break;
				
			case 2 :
				for(int i = 0; i < students.size(); i++) {
					students.get(i).ShowInfo();
				}
				break;
				
			case 3 :
				System.out.println("조회할 학생 번호 : ");
				String no = sc.nextLine();
				boolean exist = true;
				
				for(int i = 0; i < students.size(); i++) {
					if(students.get(i).getStudentNo().equals(no)) {
						students.get(i).ShowInfo();
						exist = false;
					}
				}
				if(exist) {
					System.out.println("등록 정보가 없습니다.");
				}
				break;
				
			case 4 :
				System.out.println("수정할 학생 번호 : ");
				no = sc.nextLine();
				exist = true;
				
				for(int i = 0; i < students.size(); i++) {
					if(students.get(i).getStudentNo().equals(no)) {
						System.out.println("영어점수 수학점수");
						String score = sc.nextLine();
						String[] ary = score.split(" ");
						
						students.get(i).setEng(Integer.parseInt(ary[0]));
						students.get(i).setMath(Integer.parseInt(ary[1]));
						System.out.println("수정완료!");
						exist = false;
					}
				}
				
				if(exist) {
					System.out.println("등록 정보가 없습니다.");
				}
				break;
				
			
			
			}	// end switch
		}	// end while
	}	// end main

}	// end class
