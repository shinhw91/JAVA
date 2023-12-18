package chap4;

import java.util.Scanner;

public class exam160 {

	public static void main(String[] args) {
		// 문제 2 : 3의 배수 합
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;				
			} else continue;
		}
		System.out.println(sum);
		
		// 문제 3	
		while(true) {
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;
			System.out.printf("(%d, %d) \n", num1, num2);
			if(num1 + num2 ==5) break;
		}
		System.out.println("종료");
		
		// 문제 4
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%d, %d) \n", x, y);
				}
			}
		}
		
		// 문제 5
		String star = "";
		for(int i = 0; i < 4; i++) {
			star += "*";
			System.out.println(star);
		}
		
		// 문제 6
		String stars = "";
		for(int i = 0; i < 4; i++) {
			for(int b = 0; b < (3-i); b++) {
				stars += "_";
			}
			for(int s = 0; s <= i ; s++) {
				stars += "*";
			}
			stars += "\n";
		}
		System.out.println(stars);
		
		// 문제 7
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2.출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.print("선택> ");
			
			int select = scanner.nextInt();
			switch(select) {
			case 1: 
				System.out.println("예금액> " );
				int money = scanner.nextInt();
				balance += money;
				break;
			case 2: 
				System.out.println("출금액> ");
				money = scanner.nextInt();
				if(money > balance) {
					System.out.println("잔액이 부족합니다");
				} else {
					balance -= money;
				}
				break;
			case 3:
				System.out.println("잔고> " + balance);
				break;
			case 4:
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		
		scanner.close();
		
		
		
		
	}	// end main

}	// end class
