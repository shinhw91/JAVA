package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe {

	public static void main(String[] args) {
		String[] strs = {"Mon", "The", "10"};
		strs[0] = null;
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		
		List<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		
		list.remove(0);	// 삭제
		list.remove("Banana");	// 삭제
		list.set(0, "바나나");	// 변경
		list.clear();	// 전체 요소 삭제
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 컬렉션의 크기 변경
		for(int i = 0; i < 100; i++) {
			list.add("" + i);
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 이름저장
		List<String> names = new ArrayList<String>();
		names.add("홍길동");	// 0 : 첫번째
		names.add("김길동");	// 1 : 두번째
		names.add("박철수");	// 2 : 세번째
		
		String search = "길동";
		int cnt = 0;
		for(int i = 0; i < names.size(); i++) {
			int index = names.get(i).indexOf(search);
			if(index != -1) {
				cnt++;
			}
		}
		System.out.println(search + "은 " + cnt + "명입니다.");
		
	}	// end main

}	// end class
