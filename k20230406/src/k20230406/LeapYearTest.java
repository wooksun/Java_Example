package k20230406;

import java.util.Scanner;

public class LeapYearTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("윤년, 평년을 판단할 년도를 입력하세요: ");
		int year = sc.nextInt();

//		윤녕, 평년 반별식
//		년도가 4로 나눠 떨어지고(year%4==0), 100으로 나눠 떨어지지(100 != 0) 않거나(||) 400으로 나눠 떨어지면(year%400==0)윤년
//		그렇지 않으면 평년

//		2023년 평년, 2024년 윤년, 2000년 윤년, 2100년 평년
		/*
		 * if(year % 4==0 && year % 100!=0 || year % 400==0) { if(year % 4==0 && year %
		 * 100!=0 || year % 400==0) { System.out.println(year + "년은 윤년입니다."); } else {
		 * System.out.println(year + "년은 평년입니다."); }
		 */

//		프로그램에서 여러번 사용되는 값은 변수에 저장해서 사용하면 편리하다.
//		논리값을 기억하는 변수나 리턴 타입이 논리값인 메소드의 이름은 "is"로 시작하는게 관행이다.
		boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

		if (isLeapYear) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				System.out.println(year + "년은 윤년입니다.");
			} else {
				System.out.println(year + "년은 평년입니다.");
			}

//		삼항 연산자( ?: )
//		삼항 연산자는 조건식을 비교한 후, 참이나 거짓일 때, 실행할 문장이 각각 1문장일 때 사용하면 편리
//		형식 : 조건식 ? 참일 때 실행할 문장 : 거짓일 때 실행할 문장

			System.out.println(
					year + "년은 " + (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "윤" : "평") + "년입니다.");
//		(year % 4==0 && year % 100!=0 || year % 400==0 ? "윤" : "평") -> 삼항연산자 / year + "년은 "에 조건연산자가 우선순위에서 밀리기 때문에
//		삼항연산자에 괄호를 둬, 우선순위를 최상위로 한다.

//		위의 예제를 printf로 나타낼 때, ','로 대체 가능하여 ( )가 필요없음
			System.out.printf("%d년은 %s년입니다.\n", year, year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "윤" : "평");
//		위의 %s를 %c(char)로 바꿀 때, "윤","평"에 ""를 ''로 바꿔주기만 하면 된다.
			System.out.printf("%d년은 %c년입니다.\n", year, year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? '윤' : '평');
			
			long time = System.currentTimeMillis();
			System.out.println(time);

		}
	}

}
