package chap5;

public class ArrayExe3 {

	public static void main(String[] args) {
		String[] nameAry = {"홍길동", "김길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		int count = 0;
		// for반복문 활용
		for(int i = 0; i < nameAry.length; i++) {
			if(nameAry[i].equals(search)) {
				count++;
			}
		}
		
		int count1 = 0;
		for(String name : nameAry) {
			if(name.equals(search)) {
				count1++;
			}
		}
			
		System.out.println(search + "은 총" + count + "명 입니다.");
		System.out.println(search + "은 총" + count1 + "명 입니다.");
		
		// 최대값 찾기
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		for(int score : scores) {
			if(score > maxScore) {
				maxScore = score;
			}
		}

		System.out.println("가장 큰 값 : " + maxScore);
		
	}	// end main

}	// end class
