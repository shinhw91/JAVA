package todo.p20231205;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		List<Emp> emps = new ArrayList<>();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			
			case 1 :
				System.out.println("사번 이름 전화번호 입사일자 급여");
				String input = sc.nextLine();
				String[] inpAry = input.split(" ");
				
				int comNum = Integer.parseInt(inpAry[0]);
				String name = inpAry[1];
				String tel = inpAry[2];
				int income = Integer.parseInt(inpAry[4]);
				
				Emp emp = null;
				if(inpAry.length == 3) {
					emp = new Emp(comNum, name, tel);
				} else if (inpAry.length == 4) {
					String hireDate = inpAry[3];
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	// 1. import
					try {
						emp = new Emp(comNum, name, tel, sdf.parse(hireDate));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	// 2. String -> Date
				
				emps.add(emp);
				
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
						System.out.println("삭제되었습니다.");
					}
				}
				break;
				
//			case 5 :
//				System.out.print("1) 입사일자 입력>> ");
//				hireDate = sc.nextLine();
//				System.out.printf("%s  %s  %s  %s  %s\n", "사번", "이름", "전화번호", "입사일자", "급여");
//				
//				for(int i = 0; i < emps.size(); i++) {
//					if(emps.get(i).getHireDate().equals(hireDate)) {
//						emps.get(i).ShowInfo();
//					}
//				}
//				break;
			
			}	// end switch
			
		}	// end while

	}	// end main

}	// end class
