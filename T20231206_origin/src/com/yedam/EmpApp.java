package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
//		List<Employee> employees = new ArrayList<>();
		EmpDAO dao = new EmpDAO();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회 6.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				System.out.print("사번입력>> ");
				String coNum = sc.nextLine();
				System.out.print("이름입력>> ");
				String name = sc.nextLine();
				System.out.print("전화번호입력>> ");
				String tel = sc.nextLine();
				System.out.print("입사일입력>> ");
				String hireDate = sc.nextLine();
				System.out.print("급여입력>> ");
				int pay = Integer.parseInt(sc.nextLine());
				
//				employees.add(new Employee(coNum, name, tel, hireDate, pay));
//				System.out.println("등록되었습니다.");
//				break;
				
				Employee employee = new Employee(coNum, name, tel, hireDate, pay);
				if(dao.addEmployee(employee)) {
					System.out.println("사원이 등록되었습니다.");
				} else {
					System.out.println("사원 등록에 실패하였습니다.");
				}
				break;
				
			case 2 :
				System.out.printf("%s\t %s\t %s\t\t %s\n", "사번", "이름", "전화번호", "급여");
//				for(int i = 0; i < employees.size(); i++) {
//					employees.get(i).ShowList();
//				}
//				break;
				
				for(Employee list : dao.employeeList()) {
					list.ShowList();
				}
				break;
				
			case 3 :
				System.out.println("사번 급여>> ");
				String input = sc.nextLine();
				String[] inpAry = input.split(" ");
				
				coNum = inpAry[0];
				pay = Integer.parseInt(inpAry[1]);
				
//				for(int i = 0; i < employees.size(); i++) {
//					if(employees.get(i).getCoNum().equals(coNum)) {
//						employees.get(i).setPay(pay);
//						System.out.println("급여가 수정되었습니다.");
//					}
//				}
//				break;
				
				if(dao.modifyEmployee(coNum, pay)) {
					System.out.println("급여가 수정되었습니다.");
				} else {
					System.out.println("급여 수정에 실패하였습니다.");
				}
				break;
				
			case 4 :
				System.out.print("사번>> ");
				coNum = sc.nextLine();
				
//				for(int i = 0; i < employees.size(); i++) {
//					if(employees.get(i).getCoNum().equals(coNum)) {
//						employees.remove(i);
//						System.out.println("사원이 삭제되었습니다.");
//					}
//				}
//				break;
				
				if(dao.removeEmployee(coNum)) {
					System.out.println("사원이 삭제되었습니다.");
				} else {
					System.out.println("사원 삭제에 실패하였습니다.");
				}
				break;
				
			case 5 :
				System.out.print("입사일자>> ");
				hireDate = sc.nextLine();
				System.out.printf("%s\t %s\t %s\n", "사번", "이름", "입사일자");
				
//				for(int i = 0; i < employees.size(); i++) {
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//					try {
//						if(employees.get(i).getHireDate().equals(hireDate) ||
//								sdf.parse(employees.get(i).getHireDate()).after(sdf.parse(hireDate))) {
//							employees.get(i).ShowInfo();
//						}
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				break;
				
				if(hireDate != null) {
					dao.hireDateList(hireDate);
				} else {
					System.out.println("조회에 실패하였습니다.");
				}
				break;
				
			case 6 :
				System.out.println("프로그램이 종료되었습니다.");
				run = false;
				
				
			}
			
		}

	}	// end main

}	// end class
