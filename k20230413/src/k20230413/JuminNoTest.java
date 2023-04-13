package k20230413;

import java.util.Scanner;

public class JuminNoTest {

	public static void main(String[] args) {
		
//		주민번호 13자리를 '-'없이 입력받아 성별 판단하기
		Scanner sc =  new Scanner(System.in);
		System.out.print("주민번호 13자리를 '-'없이 입력 : ");
		String jumin = sc.nextLine().trim(); //trim() 공백없앰.
		
//		System.out.println(jumin.charAt(6)); //주민번호 6번째 자리
//		System.out.println((int) jumin.charAt(6));
		
//		숫자와 문자는 표현하는 방법이 다르다
//		문자 '1'(0110001)과 숫자 1(0000001)은 다른 데이터로 취급된다.
//		if(jumin.charAt(6) == 1 || jumin.charAt(6) == 3) { //무조건 여자(false)
		
//		방법1
//		if(jumin.charAt(6) == '1' || jumin.charAt(6) == '3') { 
//			System.out.println("남자");
//		}else {
//			System.out.println("여자");
//		}
		
//		방법2
		if(jumin.charAt(6) % 2 == 1) { 
			System.out.println("남자");
		}else {
			System.out.println("여자");
		}
		
	}

}
