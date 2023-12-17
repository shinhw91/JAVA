package chap11.object;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		// 1 : YEAR, 2 : MONTH, DAY_OF_WEEK : 일(1), 월(2), ... , 토(7)
		Calendar cal = Calendar.getInstance();
		cal.set(1, 2022);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DATE, 1);
		cal.set(2023, 2, 1);
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		System.out.println("월 : " + cal.get(Calendar.MONTH));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		System.out.println("요일값 : " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("마지막날 : " + cal.getActualMaximum(Calendar.DATE));
		
	}

}
