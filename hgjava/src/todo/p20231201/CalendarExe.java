package todo.p20231201;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		int year = 2023;
		int month = 11;
		
		Calendar today = Calendar.getInstance();
		
		// 10월 달력 작성
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, month - 1);
		today.set(Calendar.DATE, 1);
		
		// 12월 달력 작성
		String[] days = {"Sun", "Mon", "Thu", "Wed", "Thr", "Fri", "Sat"};
		
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		// 빈공백 생성
		int blank = today.get(Calendar.DAY_OF_WEEK) - 1;
		for(int i = 0; i < blank; i++) {
			System.out.printf("%4s", "");
		}
		
		int lastday = today.getActualMaximum(Calendar.DATE);
		for(int i = 1; i <= lastday; i++) {
			System.out.printf("%4d", i);
			if((i + blank) % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println("\n=========== the end ============");
		
		
		
		
	}	// end main
}	// end class
