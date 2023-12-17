package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {

	public static void main(String[] args) {
		// 회원등록(회원번호, 이름, 포인트)
		// 1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료
		Scanner sc = new Scanner(System.in);
		String memberNo = null, memberName = null;
		int point = 0;
		List<Member> members = new ArrayList<>();
		
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				System.out.println("<회원등록>");
//				System.out.print("회원번호 : ");
//				memberNo = sc.nextLine();
//				System.out.print("이름 : ");
//				memberName = sc.nextLine();
//				System.out.print("포인트 : ");
//				point = Integer.parseInt(sc.nextLine());
				System.out.println("회원번호 이름 포인트");
				String input = sc.nextLine();
				String[] inAry = input.split(" ");
				System.out.println(inAry[0]);
				System.out.println(inAry[1]);
				System.out.println(inAry[2]);
				
//				members.add(new Member(memberNo, memberName, point));
				members.add(new Member(inAry[0], inAry[1], Integer.parseInt(inAry[2])));
				
				break;
				
			case 2 :
				System.out.println("<이름조회>");
				System.out.print("이름 : ");
				memberName = sc.nextLine();
				boolean exists = true;
				
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberName().equals(memberName)) {
						System.out.println(members.get(i).getMemberNo()
								+ "번 회원이름 : " + members.get(i).getMemberName()
								+ ", 포인트 : " + members.get(i).getPoint());
						exists = false;
					}
				}
				if(exists) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
				
			case 3 :
				System.out.println("<포인트변경>");
				System.out.print("회원번호 : ");
				memberNo = sc.nextLine();
				exists = true;
				
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberNo().equals(memberNo)) {
						System.out.print("변경할 포인트 입력 : ");
						members.get(i).setPoint(Integer.parseInt(sc.nextLine()));
						exists = false;
					}
				}
				if(exists) {
					System.out.println("찾는 회원번호가 없습니다.");
				}
				break;
				
			case 4 :
				System.out.println("<삭제>");
				System.out.print("이름 : ");
				memberName = sc.nextLine();
				exists = true;
				
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberName().equals(memberName)) {
						members.remove(i);
						exists = false;
						i--;
					}
				}

				if(exists) {
					System.out.println("찾는 이름이 없습니다.");
				} else {
					System.out.println("삭제되었습니다.");
				}
				break;
				
			case 5 :
				System.out.println("종료합니다.");
				run = false;
				
			}
		}
	}	// end main

}	// end class
