package k20230417;

import java.util.Scanner;

public class MagicSquareTest2 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			System.out.print("마방진을 출력할 행렬의 차수를 3이상인 홀수로 입력하세요 : ");
			n = sc.nextInt();
			if(n >= 3 && n % 2==1 ) { // n % 2==1  홀수 판별
				break; //while 탈출
			}
			System.out.println("3이상인 홀수를 입력하세요."); //홀수라면 조건식을 벗어나 이 출력물이 찍힘 -> 다시 무한루프로 올라감
		}
		
//		n행 n열인 2차원 배열을 선언한다.
		int [][] a = new int[n][n];
		
//		최초의 "1"이 채워질 자리를 계산한다.
		int i=0, j=n / 2; //0행 2열
		
		for(int k=1; k<=Math.pow(n, 2); k++) {  //k<=Math.pow(n, 2) , n*n => n의 제곱까지 조건이 이루어져야 함 (3*3, 5*5 ..)
			a[i][j] = k;
			if(k % n == 0) {
				i++; //행이 커짐
			}else {
				if(--i == -1) {
					i = n-1; //정해진 숫자가 아닌, n의 배열까지니까 n-1
				}
				if(++j == n) {
					j = 0;
				}
				
			}
			
		}
		
		for (i = 0; i < a.length; i++) { // 출력하는 코드
			for (j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}
		
	}

}
