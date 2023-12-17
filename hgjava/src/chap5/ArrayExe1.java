package chap5;

import java.util.Iterator;

public class ArrayExe1 {

	public static void main(String[] args) {
		int a = 10;
		int[] ary = {10, 20, 33};
		int sum = 0;
		int sum1 = 0;
		sum = ary[0] + ary[1] + ary[2];
		for(int i = 0; i < ary.length; i++) {
			sum1 += ary[i];
		}
		System.out.println("합계는 " + sum + "입니다.");
		System.out.println("합계는 " + sum1 + "입니다.");
		
		int[] intAry = new int[5];
		double[] heights = new double[3];
		System.out.println(intAry[0]);
		System.out.println(heights[0]);
		
		String[] names = new String[10];
		names[0] = "홍길동";
		names[1] = "김길동";
		System.out.println(names[0]);
		System.out.println(names[2]);
		
		
	}	// end main

}	// end class
