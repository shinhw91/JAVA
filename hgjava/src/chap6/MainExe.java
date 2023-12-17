package chap6;

public class MainExe {

	public static void main(String[] args) {
		
		String[] strs = {"1.aaa", "2.bbb", "3.ccc", "4.ddd", "5.eee", "6.fff", "7.ggg", "8.hhh"};
		int page = 1;
		int start = (page - 1) * 5;
		int end = page * 5;
		
		for(int i = 0; i < strs.length; i++) {
			if(i >= start && i < end) {
				System.out.println(strs[i]);
			}
		}
		
		int cnt = 36;
		
		int totalPage = (int) Math.ceil(cnt / 5.0);
		System.out.println(totalPage);
		
		for(int i = 1; i < totalPage; i++) {
			System.out.print(i + " ");
		}
		
	}

}
