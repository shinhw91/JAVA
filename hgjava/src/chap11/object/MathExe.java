package chap11.object;

public class MathExe {

	public static void main(String[] args) {
//		long result = Math.round(-1.4);
//		long result2 = (long) Math.rint(-1.4);
//		
//		
//		System.out.println("round : " + result);
//		System.out.println("rint : " + result2);
//		
//		for(int i = 0; i <= 10; i++) {
//			double r1 = Math.random();	// 0 <= x < 1
//			int r2 = (int) (Math.random() * 10);	// 0 <= x < 10
//			int r3 = 1 + (int) (Math.random() * 10);	// 1 <= x < 11
//			int r4 = 61 + (int) (Math.random() * 40);	// 61 <= x < 101
//			System.out.println(r4);
//		}
		
		// 1 ~ 6까지 수
		int[] numbers = new int[5];
		// 중복되지 않은 값을 배열에 저장
//		for(int i = 0; i <= 100; i++) {
//			int number = 1 + (int) (Math.random() * 6);
//			for(int temp : numbers) {
//				if(temp != number) {
//					numbers[i] = number;
//				}
//			}
//			System.out.println(numbers[i]);
//		}
		
		for(int i = 0; i < numbers.length; i++) {
			boolean exist = false;
			int no = 1 + (int) (Math.random() * 6);
			for(int j = 0; j < i; j++) {
				if(numbers[j] == no)
					exist = true;
			}
			if (exist) {
				i--;
				continue;
			}
			numbers[i] = no;
			System.out.println(numbers[i]);
		}

	}	// end main

}	// end class
