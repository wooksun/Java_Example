package k20230407;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {

//		약수 출력과, 완전수 구하기 예제
		Scanner sc = new Scanner(System.in);
		System.out.print("완전수인가 판단할 숫자를 입력하세요: ");
		int number = sc.nextInt();

//		약수 출력
//		for (int i = 1; i <= number; i++) {
//			int r = number % i;
//			if (r == 0) { // number를 i로 나누었을 때 나머지가 0이 참이라면
//				System.out.println(i);
//			}
//		}
		
		

//		모든 숫자는 자기 자신을 제외하고 나눠서 떨어뜨릴 수 있는 가장 큰 수는 자신의 절반을 넘지 않는다.
		int sum = 0; // 자기 자신을 제외한 약수의 합계를 기억할 변수
		for (int i = 1; i <= number / 2; i++) { // number / 2 -> 자신을 제외한, 가장 큰 약수는 절반을 넘지 않기때문에 /2로 함
//			입력한 숫자의 약수 판단
			if(number % i == 0) {
//				System.out.println(i);
				sum += i; //약수의 합계 계산.
			}
		} //for

//		완전수인가(자신을 제외한 약수의 합이 자기 자신과 같은가) 판단한다.
		if(number == sum) {
			System.out.println(number + "는 완전수입니다.");
		}else {
			System.out.println(number + "는 완전수가 아닙니다.");
		}
		
		

	}
}
