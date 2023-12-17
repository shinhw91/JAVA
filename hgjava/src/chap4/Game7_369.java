package chap4;

public class Game7_369 {

	public static void main(String[] args) {
		// 1~50 : 369게임

		// 3, 6, 9 갯수 체크 변수
		// 숫자 1~50 반복문
			// 일의 자리에 3, 6, 9 갯수 체크
			// 십의 자리에 3, 6, 9 갯수 체크
		// 갯수가 0 -> 숫자
		// 갯수가 1 -> ♥
		// 갯수가 2 -> ♥♥
		
		for(int i = 1; i <= 50; i++) {
			int count = 0;
			if((i % 10) == 3 || (i % 10) == 6 || (i % 10) == 9) {
				count++;
			}
			if(i / 10 == 3) {
				count++;
			}
				
			switch(count) {
			case 0 : System.out.print(i + "\t"); break;
			case 1 : System.out.print("♥\t"); break;
			case 2 : System.out.print("♥♥\t"); break;	
			}
			if(i % 10 == 0) {
				System.out.println("");
			}
		}
		
		// 깃허브 모르겠어요 교수님
		
		
	}	// end main

}	// end class
