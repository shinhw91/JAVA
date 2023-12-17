package chap4;

import java.util.Scanner;

public class Game2_coin {

	public static void main(String[] args) {
		// 동전 교환 프로그램
		// Game7_369 유사
		
		Scanner sc = new Scanner(System.in);
		System.out.print("##교환할 금액 : ");
		int money = sc.nextInt();
		
		System.out.printf("500원짜리 : %d개 \n", money / 500);
		int remoney = money % 500;
		System.out.printf("100원짜리 : %d개 \n", remoney / 100);
		remoney = remoney % 100;
		System.out.printf("50원짜리 : %d개 \n", remoney / 50);
		remoney = remoney % 50;
		System.out.printf("10원짜리 : %d개 \n", remoney / 10);
		remoney = remoney % 10;
		System.out.printf("교환 금액 : %d원 \n", money - remoney);
		System.out.printf("남은 금액 : %d원 \n", remoney);
		
//		int coin500 = 0;
//		int coin100 = 0;
//		int coin50 = 0;
//		int coin10 = 0;
	
//		coin500 = money / 500;
//		coin100 = (money % 500) / 100;
//		coin50 = (money % 500 % 100) / 50;
//		coin10 = (money % 500 % 100 % 50) / 10;
		
//		System.out.printf("500원짜리 : %d개 \n", coin500);
//		System.out.printf("100원짜리 : %d개 \n", coin100);
//		System.out.printf("50원짜리 : %d개 \n", coin50);
//		System.out.printf("10원짜리 : %d개 \n", coin10);
//		System.out.printf("교환 금액 : %d개 \n", (coin500*500) + (coin100*100) + (coin50*50) + (coin10*10));
//		System.out.printf("남은 금액 : %d원 \n", money - ((coin500*500) + (coin100*100) + (coin50*50) + (coin10*10)));
		
		sc.close();

	}	// end main

}	// end class
