package k20230406;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("세 과목의 점수를 합산하시오.");
		System.out.print("국어점수: ");
		int kuk = sc.nextInt();
		System.out.print("영어점수: ");
		int eng = sc.nextInt();
		System.out.print("수학점수: ");
		int su = sc.nextInt();

		int total = kuk + eng + su;
		double average = total / 3.;

//	key에는 정수를 기억하는 변수 또는 연산 결과가 정수인 수식을 사용한다.
//	JDK1.7 부터는 key에 문자열도 사용할 수 있다.
//	key 값과 일치하는 value의 case에 해당되는 문장부터 나머지 모든 문장을 실행한다.

//	switch(key) {
//		case value: // ":"임에 주의한다.
//			key와 value가 일치하면, 실행할 문장;
//			...;
//			[break;] //필요에 따라 생략 가능하다.
//		...
//		[default: //기타 등등 케이스
//			key와 일치하는 value가 없을 경우, 실행할 문장;
//			...;
//			break;]
//	}
		
		//average는 실수, switch에는 정수와 문자열만 들어올 수 있어서 int로 형변환을 시켜줌.
//		switch((int) average / 10) {
//			case 10: //평균점수가 100점인 case -> average를 10으로 나누면 100/10 -> 나머지 case도 마찬가지 100/90, 100/80...
//				System.out.println("A");
//				break; //break는 제어문 (if문 제외)의 {} 블록을 탈출한다. <=> continue는 제어문의 {}블록을 다시 실행.
//			case 9:
//				System.out.println("A");
//				break;
//			case 8:
//				System.out.println("B");
//				break;
//			case 7:
//				System.out.println("C");
//				break;
//			case 6:
//				System.out.println("D");
//				break;
//				
//				default: 
//					System.out.println("F");
		
		switch((int)average / 10) {
		case 10:
			System.out.println("참잘했어요"); //break를 찍지 않아서 참잘했어요를 찍고, case 9의 A까지 같이 출력
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default : 
			System.out.println("F");
					
		} //break 혹은 default로 탈출

	}

}
