package todo.p20231127;
	// 친구의 정보를 1.친구수 2.입력 3.목록 4.수정 5.종료 (FriendApp)

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {
		boolean run = true;
		int friendNum = 0;
		Friend[] friends = null;
		
		while(run) {
			System.out.println("1.친구수 2.입력 3.목록 4.수정 5.종료");
			Scanner sc = new Scanner(System.in);
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 : 
				System.out.print("친구수 입력>> ");
				friendNum = Integer.parseInt(sc.nextLine());
				friends = new Friend[friendNum];
				break;
				
			case 2 :
				System.out.println("친구정보 입력>> ");
				for(int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.print("친구 이름 입력>> ");
					friend.name = sc.nextLine();
					System.out.print("친구 연락처 입력>> ");
					friend.tel = sc.nextLine();
					System.out.print("친구 혈액형 입력>> ");
					friend.blood = sc.nextLine();

					friends[i] = friend;
				}
				break;
				
			case 3 :
				System.out.println("목록 출력>> ");
				for(int i = 0; i < friends.length; i++) {
					System.out.println("친구 이름 : " + friends[i].name + ", 연락처 : " + friends[i].tel + ", 혈액형 : " + friends[i].blood);
				}
				break;
				
			case 4 :
				System.out.print("조회할 이름입력>> ");
				String name = sc.nextLine();
				boolean exists = true;
				
				for(int i = 0; i < friends.length; i++) {
					if(name.equals(friends[i].name)) {
						System.out.print("변경 연락처 입력>> ");
						friends[i].tel = sc.nextLine();
						exists = false;
					}
				}
				if(exists) {
					System.out.println("찾는 이름이 없습니다");
				}
				break;
				
			case 5 :
				System.out.println("종료합니다");
				run = false;

				
				
			}	// end switch
		}	// end while
		
	}	// end main

}	// end class
