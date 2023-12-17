package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		List<Emp2> emps = new ArrayList<>();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
//				System.out.println("사번 이름 전화번호 입사일자 급여");
//				String input = sc.nextLine();
//				String[] inpAry = input.split(" ");
//				
//				int comNum = Integer.parseInt(inpAry[0]);
//				String name = inpAry[1];
//				String tel = inpAry[2];
//				String hireDate = inpAry[3];
//				int income = Integer.parseInt(inpAry[4]);
//				
//				emps.add(new Emp2(comNum, name, tel, hireDate, income));
//				System.out.println("저장되었습니다.");
//				break;
				
				System.out.print("1) 사번 입력>> ");
				int comNum = Integer.parseInt(sc.nextLine());
				System.out.print("2) 이름 입력>> ");
				String name = sc.nextLine();
				System.out.print("3) 전화번호 입력>> ");
				String tel = sc.nextLine();
				System.out.print("4) 입사일자 입력>> ");
				String hireDate = sc.nextLine();
				if(hireDate == "") {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					hireDate = sdf.format(new Date());
				}
				System.out.print("5) 급여 입력>> ");
				int income = Integer.parseInt(sc.nextLine());
				
				emps.add(new Emp2(comNum, name, tel, hireDate, income));
				System.out.println("저장되었습니다.");
				break;
				
			case 2 :
				System.out.printf("%s  %s  %s  %s  %s\n", "사번", "이름", "전화번호", "입사일자", "급여");
				for(int i = 0; i < emps.size(); i++) {
					emps.get(i).ShowInfo();
				}
				break;
				
			case 3 :
				System.out.print("1) 사번 입력>> ");
				comNum = Integer.parseInt(sc.nextLine());
				System.out.print("2) 급여 입력>> ");
				income = Integer.parseInt(sc.nextLine());
				
				for(int i = 0; i < emps.size(); i++) {
					if(emps.get(i).getComNum() == comNum) {
						emps.get(i).setIncome(income);
						System.out.println("수정되었습니다.");
					}
				}
				break;
				
			case 4 :
				System.out.print("1) 사번 입력>> ");
				comNum = Integer.parseInt(sc.nextLine());
				
				for(int i = 0; i < emps.size(); i++) {
					if(emps.get(i).getComNum() == comNum) {
						emps.remove(i);
						i--;
						System.out.println("삭제되었습니다.");
					}
				}
				break;
				
			case 5 :
				System.out.print("1) 입사일자 입력>> ");
				hireDate = sc.nextLine();
				System.out.printf("%s  %s  %s  %s  %s\n", "사번", "이름", "전화번호", "입사일자", "급여");
				
				for(int i = 0; i < emps.size(); i++) {
					if(emps.get(i).getHireDate().equals(hireDate)) {
						emps.get(i).ShowInfo();
					}
				}
				break;
			
			}	// end switch
			
		}	// end while

	}	// end main

}	// end class
