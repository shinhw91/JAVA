package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {

	public static void main(String[] args) {
		// 키 : 값 쌍으로구성
		Map<String, Integer> map = new HashMap<>();
		
		// 추가
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("신혜원", 100);
		map.put("홍길동", 90);

		// 반환
		Integer result = map.get("홍길동");
		
		// 전체목록
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("key : " + key + ", value : " + map.get(key));
		}
		
	}	// end main

}	// end class
