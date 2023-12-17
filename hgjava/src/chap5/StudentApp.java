package chap5;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		String[] names = null;
		
		// 1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료
		boolean run = true;
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료");
			int menu = sc.nextInt();	// Enter 앞까지 처리
			sc.nextLine();	// Enter 처리
			
			switch(menu) {
			case 1 : 
				System.out.println("학생수입력>>");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
			case 2 :
				System.out.println("점수입력>>");
				// for 반복
				for(int i = 0; i < scores.length; i++) {
					System.out.print("name[" + i + "]>> ");
					names[i] = sc.nextLine();
					System.out.print("scores[" + i + "]>> ");
					scores[i] = sc.nextInt();
					sc.nextLine();
				}
				break;
			case 3 :
				System.out.println("목록출력>>");
				for(int i = 0; i < scores.length; i++) {
					System.out.print("이름은 " + names[i] + ", 점수는 " + scores[i] + "\n");
				}
				break;
			case 4 :
				System.out.println("분석>>");
				// 최고점수 출력
				int maxScore = 0;
				String maxName = "";
				double avg = 0;
				int sum = 0;
				
//				for(int score : scores) {
//					sum += score;
//					if(score > maxScore) {
//						maxScore = score;
//					}
//				}
				
				int score = 0;
				for(int i = 0; i < scores.length; i++) {
					sum += score;	// sum = sum + score;
					if(scores[i] > maxScore) {
						maxScore = scores[i];
						maxName = names[i];
					}
				}
				
				avg = sum * 1.0 / scores.length;
				System.out.println(maxName + "최고점수 : " + maxScore + ", 평균 : " + avg);
				break;
			case 5 :
				System.out.println("종료>>");
				run = false;
				break;
			}	// end of switch
		}	// end of while
		System.out.println("end of prog");
		
	}	// end main

}	// end class
