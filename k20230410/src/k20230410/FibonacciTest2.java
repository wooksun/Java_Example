package k20230410;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("피보나치 수열의 합계를 계산할 항수를 입력하세요: ");
		int n = sc.nextInt();
		
//		입력받은 피보나치 수열의 합계를 계산할 항의 개수만큼 배열을 만든다.
		int[] fibo = new int[n];
		
//		배열의 0번째, 1번째 인덱스 요소를 각각 1로 초기화시킨다.
		fibo[0] = 1; //fibo[0]번째가 a
		fibo[1] = 1; //fibo[1]번째가 b
		int y = 2;
		
//		피보나치 수열의 각 항 값으로 배열을 채우고, 피보나치 수열의 합계를 계산한다.
		for(int k=3; k<=n; k++) {	
//			코드 두줄, 하나는 y값 구하기, 하나는 y+c값
//			int c = a+b; //피보나치 수열의 n-2번째 항과 n-1번째 항을 더해서 n번째 항 값을 계산한다.
//			y += c; //피보나치 수열의 합계를 계산한다. a=b; b=c;
			
			fibo[k-1] = fibo[k-3] + fibo[k-2];
			y += fibo[k-1];
		}
		System.out.println(y + "," + Arrays.toString(fibo));
		
		System.out.printf("피보나치 수열의 %d번째 항 까지의 합계: %d = " , n, y);
		
//		피보나치 수열의 항들을 +으로 출력하기 1번째
		for(int i=0; i<fibo.length-1; i++) {
			System.out.print(fibo[i] + " + ");
		}
		System.out.println(fibo[fibo.length-1]);
		
		
//		피보나치 수열의 항들을 +으로 출력하기 2번째
//		for(int i=0; i<fibo.length; i++) {
//			if(i > 0) {
//				System.out.print(" + ");
//			}
//			System.out.print(fibo[i]);
//		}
//		System.out.println();
		
	}

}
