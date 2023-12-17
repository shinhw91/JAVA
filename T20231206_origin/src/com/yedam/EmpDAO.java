package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	List<Employee> employees = new ArrayList<>();
	List<Employee> hireList = new ArrayList<>();
	
	EmpDAO() {
		employees.add(new Employee("23-11", "홍길동", "943-1234", "2023-10-01", 300));
		employees.add(new Employee("23-12", "김길동", "943-1244", "2023-11-01", 300));
		employees.add(new Employee("23-13", "박길동", "943-1254", "2023-12-01", 300));
		employees.add(new Employee("23-19", "김신입", "943-1264", "2023-12-01", 300));
		employees.add(new Employee("23-20", "박신입", "943-1274", "2023-12-02", 300));
		employees.add(new Employee("23-21", "최신입", "943-1284", "2023-12-03", 300));
	}
	
	// 추가
	boolean addEmployee(Employee employee) {
		return employees.add(employee);
	}
	
	// 목록
	List<Employee> employeeList() {
		return employees;
	}
	
	// 수정
	boolean modifyEmployee(String coNum, int pay) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getCoNum().equals(coNum)) {
				employees.get(i).setPay(pay);
				return true;
			}
		}
		return false;
	}
	
	// 삭제
	boolean removeEmployee(String coNum) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getCoNum().equals(coNum)) {
				employees.remove(i);
				return true;
			}
		}
		return false;
	}	
	
	// 조회
	List<Employee> hireDateList(String hireDate) {
		for(int i = 0; i < employees.size(); i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				if(employees.get(i).getHireDate().equals(hireDate) ||
						sdf.parse(employees.get(i).getHireDate()).after(sdf.parse(hireDate))) {
					employees.get(i).ShowInfo();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employees;
	}

	


}
