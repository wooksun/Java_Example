package k20230410;

import java.util.Scanner;

public class FibonacciTest {

	public static void main(String[] args) {
	
		int a = 1; //1번째 항의 값 초기화 => 피보나치 수열의 n-2번째 항의 값
		int b = 1; //2번째 항의 값 초기화 => 피보나치 수열의 n-1번쨰 항의 값
		int y = 2; //1번쨰 항과 2번째 항의 값을 더한 합계 => n번째 항까지의 피보나치 수열 합계를 기억하는 변수.
		
//		피보나치 수열의 합계를 계산할 항을 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("피보나치 수열의 합계를 계산할 항수를 입력하세요: ");
		int n = sc.nextInt();
		
//		1항과 2항의 값은 위에서 이미 합계까 계산된 상태. 3번째 항부터 n번째 항까지 합계를 누적.
		for(int k=3; k<=n; k++) {
			int c = a+b; //피보나치 수열의 n-2번째 항과 n-1번째 항을 더해서 n번째 항 값을 계산한다.
			y += c; //피보나치 수열의 합계를 계산한다.
			
//			피보나치 수열의 다음 항 값을 계산하기 위해, 변수값을 수정하는 작업.
			a=b; //현재 작업의 n-1번째 항의 값을, 다음 작업의 n-2번째 항으로 넣어준다.
			b=c; //현재 작업의 n번째 항의 값을 다음 작업의 n-1번째 항으로 넣어준다.
		}
		
		System.out.println("피보나치 수열의 " + n + "번째 항 까지의 합계 : " + y );
		
	}

}
