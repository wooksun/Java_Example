package k20230407;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

//		1 ~ 40000 사이의 완전수와 완전수의 합.
//		내가 짠 완전수 코드
//		Scanner sc = new Scanner(System.in);
//		System.out.print("1부터 40000 사이의 숫자를 입력하세요: ");
//		int num = sc.nextInt();
//
//		int sum = 0;
//		for (int i = 1; i <= 40000 / 2; i++) {
//			if (num % i == 0) {
//				sum += i;
//				System.out.println("완전수 : " + i);
//			}
//		} // for
//		
//		int total = 0;
//		for(int i=0; i<=total; i++) {
//			System.out.println("완전수의 합: " + (total+sum));
//		}
//
//		if (num == sum) {
//			System.out.println(num + "는 완전수입니다.");
//		} else {
//			System.out.println(num + "는 완전수가 아닙니다.");
//		}
//		모든 수가 완전수가 아니라고 나옴. (다시)
		
		
		
		
		
//		4 ~ 10000까지의 완전수
//		강사님이 짠 코드
		int lm = 0; //완전수의 개수를 기억할 변수
		
		for(int i=4; i<=10000; i++) { //완전수인가 판단할 수
			int sum = 0; //자신을 제외한 약수의 합계를 기억할 변수
			int k = i / 2; //자신의 절반을 넘지 않도록
			
			for(int j=1; j<=k; j++) {
//				완전수인가 판단할 수(i)의 약수를 판단하기 위해 j로 나눈 나머지를 계산
				int r = i % j;
				if(r == 0) { //j가 n의 약수인가?
//					j가 n의 약수면 n의 약수의 합계를 계산한다.
					sum += j; //sum = sum+j;
				} else {
					
				}
			}//for(j)
//		완전수인가 판단한다.
			if (i == sum) { // i가 완전수인가?
				System.out.printf("%d번째 완전수 => %4d\n", lm+1, i);
				lm++; //완전수의 개수를 1증가 시킨다.
			}
		}//for(i) //약수의 합계를 구하는 식.
		
		System.out.printf("4 ~ 10000 사이의 완전수는 %d개 입니다.\n", lm);
		
		
		
	}// main

}
