package chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedGame {

	public static void main(String[] args) {
		String word = "red yellow green blue";
		String[] words = word.split(" ");
//		List<String> list = Arrays.asList(words);
//		for(String str : list) {
//			System.out.println(str);
//		}
		List<String> list = new ArrayList<>();
		for (String str : words) {
			list.add(str);
		}

		// 목록출력
		// Scanner 사용해서 입력값을 저장
		// 사용자 입력값과 컬렉션의 값과 비교해서 같은 단어 있으면 삭제
		// 시작시점 ~ 종료시점 걸린 시간을 초단위로 계산
		// 완료하는데 35초가 걸림
		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}

			System.out.print("\n단어 입력 : ");
			String input = sc.nextLine();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(input)) {
					list.remove(input);
				}
			}

			if (list.size() == 0) {
				System.out.println("게임 성공!");
				run = false;
			}

		} // end while
		System.out.println("end of prog");

	} // end main

} // end class
