package k20230414;

import java.util.Arrays;

public class ZigzagTest {

	public static void main(String[] args) {

		int[][] a = new int[4][6]; // [4] 행, [6]열
		System.out.println("행의 개수 : " + a.length);
		System.out.println("열의 개수 : " + a[0].length);
		System.out.println(Arrays.toString(a)); // [[I@49e4cb85, [I@2133c8f8, [I@43a25848, [I@3ac3fd8b]
		System.out.println(Arrays.toString(a[0])); // [0, 0, 0, 0, 0, 0]

//		for(int i=0; i<a.length; i++) {
//			System.out.println(Arrays.toString(a[i]));
////		실행결과:	[0, 0, 0, 0, 0, 0]
////					[0, 0, 0, 0, 0, 0]
////					[0, 0, 0, 0, 0, 0]
////					[0, 0, 0, 0, 0, 0]
//		}
		
//		==============================================================================
		int n = 0; // 배열에 채워질 숫자를 1씩 증가시키는 변수

		for (int i = 0; i < a.length; i++) { //행의 개수만큼 반복
//			짝수 행과, 홀수 행이 숫자가 채워지는 방향이 다르므로 반복문을 별도로 만듦.
			if (i % 2 == 0) {
//				짝수행, j -> 0,1,2,3,4,5
				for(int j=0; j<a[i].length; j++) {
					a[i][j] = ++n;
				}//for
			} else {
//				홀수행, j -> 5,4,3,2,1,0
				for(int j=a[i].length - 1; j >= 0; j--) {
					a[i][j] = ++n;
				} //for
			}//else
			
		}
//		==============================================================================
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.printf("%2d ", a[i][j]);
//				a[0][0} =  0	a[1][0} =  0	a[2][0} =  0
//				a[0][1} =  0	a[1][1} =  0	a[2][1} =  0
//				a[0][2} =  0	a[1][2} =  0	...
//				a[0][3} =  0	a[1][3} =  0
//				a[0][4} =  0	a[1][4} =  0
//				a[0][5} =  0	a[1][5} =  0	a[3][5} =  0
			}	
			System.out.println();
		}

	}//main

}
