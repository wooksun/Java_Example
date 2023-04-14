package k20230414;

import java.util.Arrays;

public class ZigzagTest2 {

	public static void main(String[] args) {

		int[][] a = new int[4][6]; // [4] 행, [6]열
		int n = 0; 
		
		int start = 0; //2차원 배열에 숫자가 채워지기 시작하는 열의 인덱스 , 0으로 시작
		int end = a[0].length - 1; //2차원 배열에 숫자가 채워지는 '마지막 열'의 인덱스 , 5로시작
		int sw = 1; //start부터 end까지 증가치로 사용할 변수
		
//			숫자 채우기
//			i = 0, j = 0,1,2,3,4,5 => i가 0이면 +1
//			i = 1, j = 5,4,3,2,1,0 => i가 1이면 -1
//			i = 2, j = 0,1,2,3,4,5 => i가 2이면 +1
//			i = 3, j = 5,4,3,2,1,0 => i가 3이면 -1
		for(int i=0; i<a.length; i++) {
			for(int j=start; j !=end + sw; j+=sw) { // j !=end + sw (중요)
				a[i][j] = ++n;
			}
			int tmp = start;
			start = end;
			end = tmp;  //start와 end값이 바뀜
			sw *= -1;
			
		}
		
		
		
		for(int i=0; i<a.length; i++) { //출력하는 코드
			for(int j=0; j<a[i].length; j++) {
				System.out.printf("%2d ", a[i][j]);
			}	
			System.out.println();
		}
	}//main

}
