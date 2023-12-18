package chap5;

public class ArrayExe2 {

	public static void main(String[] args) {
		// 정수를 담을 수 있는 배열을 생성 (크기는 10개의 정수를 저장)
		// intAry => 10 ~ 100 저장
		// 출력
		
		int[] intAry = new int[10];	// {10, 20, 30, 40, ... , 100}
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (i + 1) * 10;	// i * 10 + 10;
		}
		
		// 확장 for 구문
		int sum = 0;	// 50보다 큰 수를 저장
		double avg = 0;
		int count = 0;
		for(int num : intAry) {
			System.out.println(num);
			if(num > 50) {	//50보다 큰 수를 sum에 누적합
				sum += num;
				count++;
			}
		}
		avg = sum / count;
		System.out.println("50보다 큰 수의 합계 : " + sum);
		System.out.println("50보다 큰 수의 평균 : " + avg);
	}

}
