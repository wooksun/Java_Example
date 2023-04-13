package k20230413;

import java.util.Scanner;

public class JuminNoTest4 {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("주민번호 13자리를 '-'없이 입력 : ");
		String jumin = sc.nextLine().trim(); //trim() 공백없앰.
//		String check = "234567892345"; //가중치
		
		int sum = 0; 
		for(int i=0; i<12; i++) {
//			sum += Integer.parseInt(jumin.charAt(i) + "") * Integer.parseInt(check.charAt(i) + ""); 
//			sum += Integer.parseInt(jumin.charAt(i) + "") * (i < 8 ? i + 2 :  i - 6);
			sum += Integer.parseInt(jumin.charAt(i) + "") * (i % 8 + 2);
		}
		System.out.println(sum); 
		
		int result = (11 - sum % 11) % 10;
//		if(result == jumin.charAt(12) - 48) {
//			System.out.println("정상");
//		}else {
//			System.out.println("오류");
//		}
		
//		위의 if문을 삼항연산자로 한줄에 처리
		System.out.println(result == jumin.charAt(12) - 48 ? "정상" : "오류");
	}

}
