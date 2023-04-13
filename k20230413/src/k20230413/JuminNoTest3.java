package k20230413;

import java.util.Scanner;

public class JuminNoTest3 {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("주민번호 13자리를 '-'없이 입력 : ");
		String jumin = sc.nextLine().trim(); //trim() 공백없앰.
		
//		주민등록번호의 각 자리의 숫자에 가중치를 곱한 합계를 계산한다.
		String check = "234567892345"; //가중치
		int sum = 0; 
		for(int i=0; i<12; i++) {
//			sum += (jumin.charAt(i) - '0') * (check.charAt(i) - 48);
//			System.out.printf("%d * %d = %d\n", (int) jumin.charAt(i), (int) check.charAt(i) - 48,
//					(jumin.charAt(i) - '0') * (check.charAt(i) - 48));
			
			sum += Integer.parseInt(jumin.charAt(i) + "") * Integer.parseInt(check.charAt(i) + "");
		}
		System.out.println(sum); //143
		
//		주민등록번호의 각 자리 숫자와 가중치를 곱한 합계를 11로 나눈 나머지를 11에서 뺀다.
//		뺀 결과가 10 이상이면, 10의 자리는 버리고 1의 자리만 취한다.
		int result = (11 - sum % 11) % 10;
		
//		위 식의 결과를 주민등록번호의 마지막 자리와 비교해서 같으면 정상, 그렇지 않으면 오류
		if(result == jumin.charAt(12) - 48) {
			System.out.println("정상");
		}else {
			System.out.println("오류");
		}
		
		
		
	}

}
