package k20230413;

import java.util.Scanner;

public class SaupTest {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("사업자번호 10자리를 '-'없이 입력하세요 : ");
		String saup = sc.nextLine().trim(); 
		
//		사업자번호 예시 : 2208162517
		String check = "137137135"; //가중치
		int sum = 0; 
		
		
//		사업자등록번호 9번째 자리까지 각 자리의 숫자와 가중치를 곱한 결과의 1자리 합계를 계산한다.
		for(int i=0; i<9; i++) {
			sum += Integer.parseInt(saup.charAt(i) + "") * Integer.parseInt(check.charAt(i) + "") % 10;
		}
		
		
//		사업자등록번호 9번째 자리에가중치를 곱한 결과의 10의 자리를 더한다.
		sum += Integer.parseInt(saup.charAt(8) + "") * Integer.parseInt(check.charAt(8) + "") / 10;
		System.out.println(sum); //33
		
		
//		사업자등록번호의 가중치와 9번째 자리까지 연산 결과에 사업자등록번호의 10번째 자리의 숫자를 더한다.
		sum += saup.charAt(9) - 48;
		
		
//		최종결과가 10의 배수면 정상, 그렇지 않으면 오류
		System.out.println(sum % 10 == 0 ? "정상" : "오류");
		
	}

}
