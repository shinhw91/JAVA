package chap4;

import java.util.Scanner;

public class Game3_guess {

	public static void main(String[] args) {
		// 숫자 추측 게임
		
		int computer = (int)(Math.random() * 100) + 1;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int myNum = sc.nextInt();
			if(myNum == computer) {
				System.out.println("축하합니다!!");
				break;
			}
			if(myNum > computer) {
				System.out.println("down하세요!!");
			} else {
				System.out.println("up하세요!!");
			}
		}
		
		sc.close();
		

	}	// end main

}	// end class
