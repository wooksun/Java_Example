package k20230412;

import java.util.Scanner;

public class SosooTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("소수인가 판단할 숫자를 입력하세요 : ");
		int n = sc.nextInt();
		
//		모든 수는 1로 나눠 떨어지기 때문에 2부터 떨어질 때 까지 나눠본다.
		int i; //반복문에 초기치 설정에서 int를 제외 -> for문 밖에 if문에서 n==i에서 오류를 없앰.
		for(i=2; i<=n; i++) {
			if(n % i == 0) {
//				나눠서 떨어지면, 소수인가 판단하기 위해 반복을 탈출.
				break; //break를 만나면 i라는 변수의 값을 유지한 채로 강제종료 됨 -> 밑에 if문 i값으로 들어가게 됨.
			}
		}
		
//		소수인가 판단.
		if(n == i) {
			System.out.println(n + "은(는) 소수입니다.");
		}else {
			System.out.println(n + "은(는) 소수가 아닙니다.");
			
		}
	}

}
