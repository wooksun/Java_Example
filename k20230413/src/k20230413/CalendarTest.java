package k20230413;

import java.util.Scanner;

public class CalendarTest {

//	메소드의 형식 []로 묶는 내용은 생략이 가능하다.
//	[접근 권한 지정자] [static] 리턴타입 메소드이름([인수,...]) {   //메소드의 머리
//		메소드가 실행할 문장;
//		...;
//		[return 값;]
//	}   //{ }블록을 메소드의 몸통이라고 함.

//	접근 권한 지정자
//	private : 현재 클래스 '외부에서' 실행할 수 없다. / (나만, 내전용 메소드)
//	protected : 현재 클래스와, 현재 클래스를, '상속받은 자식 클래스에서만' 실행할 수 있다. / (가족만 쓸 수 있는 메소드)
//	package : 접근 권한 지정자를 생략하면 package 권한으로 간주한다.
//			  같은 패키지에서는 public처럼 사용되고, 다른 패키지에서는 private처럼 사용된다. / (우리건물은 사용가능, 다른건물은 사용불가)
//	public : 현재 클래스 '내부, 외부 어디에서나' 자유롭게 실행할 수 있다. 

//	static(정적) : '메소드가 작성된 클래스 객체를 생성하지 않고', '클래스 이름에 "."을 찍어서' 실행할 수 있다.
//	=> 자주 사용하는 메소드들은 정적 메소드로 만들어 사용하면 편리하다.

//	리턴 타입은 메소드가 실행되고 난 후, 결과의 자료형을 적는다.
//	메소드를 실행한 후 결과가 없다면, return을 생략할 수 있다. return을 생략하면, 리턴타입에는 "void"라고 적어준다.

//	(간단한 참고용)
//	=> JVM은 자바 프로그램이 실행되기 전에 static으로 선언된 함수(메소드)나 변수를 메모리에 올려준다.
//	모든 메소드는 메소드가 실행되기 전에 메모리에 적재되어야 한다.
//	main메소드가 메모리에 적재되어있지 않으면, 프로그램의 시적점은 main() 메소드를 호출할 수 없으므로 프로그램을 실행할 수 없다.
//	그래서 main() 메소드는 누군가 호출하기 전에 JVM이 메모리에 적재시킨다.
	
	
//	( 예 제 )
//	년도를 인수로 넘겨받아 윤년, 평년을 판단해 윤년이면 true, 평년이면 false를 리턴하는 메소드
//	true, false 입력 -> boolean
//	논리값을 기억하는 변수나 논리값을 리턴하는 메소드의 이름이 "is"로 시작하는것이 관행이다.
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0; // 윤년, 평년식
	}

//	년, 월을 인수로 넘겨받아 그 달의 마지막 날짜를 리턴하는 메소드
	public static int lastDay(int year, int month) {
//		각 달의 마지막 날짜를 기억하는 배열을 선언한다.
		int[] m = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//		2월의 마지막 날짜를 확정한다.
		m[1] = isLeapYear(year) ? 29 : 28; //isLeapYear를 불러와 삼항연산자로 코드를 줄임.
//		마지막 날짜를 리턴한다.
		return m[month-1];
	}
	
	
//	년, 월, 일을 인수로 넘겨받아 1년 1월 1일부터 지난 날짜의 합계를 계산해 리턴하는 메소드
	public static int totalDay(int year, int month, int day) {
//		전년도 12월 31일까지 지난 날짜의 합계를 계산
		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
//		전년도 12월 31일까지 지난 날짜의 합계에 전달까지 지난 날짜를 더한다.
		for (int i = 1; i < month; i++) {
			sum += lastDay(year, i);
		}
//		전달까지 지난 날짜의 합계에 1을 더해서 리턴시킨다.
		return sum + day;
	}
	
	
//	년, 월, 일을 인수로 넘겨받아 요일을 숫자로 계산해 리턴하는 메소드
//	일요일 0, 월요일1, 화요일2, 수요일3, 목요일4, 금요일5, 토요일6
	public static int weekDay(int year, int month, int day) {
		return totalDay(year, month, day) % 7;
	}

	public static void main(String[] args) {
//	=> static 메소드는 static 메소드에만 접근할 수 있다.
//		System.out.println(isLeapYear(2023)); // 데이터 복사되어 (int year)에 들어감 / public static boolean isLeapYear에서 static을 지우면 오류
//		System.out.println(lastDay(2023, 4));
//		System.out.println(totalDay(2023, 4, 13)); //(2023, 4, 13) % 7 => 4
//		System.out.println(weekDay(2023, 4, 13));
		
		
		
		
//		달력을 출력할 년, 월을 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.println("달력을 출력할 년, 월을 입력하세요.");
		System.out.print("년 : ");
		int year = sc.nextInt();
		System.out.print("월 : ");
		int month = sc.nextInt();
		
		System.out.println("===========================");
		System.out.printf("        %4d년%2d월\n", year, month);
		System.out.println("===========================");
		System.out.println(" 일  월  화  수  목  금  토 "); //(공백)일(공백)(공백)월~(공백)(공백)금(공백)(공백)토(공백)
		System.out.println("===========================");
		
//		1일이 출력될 위치(요일)를 맞추기 위해 1일의 요일만큼 반복하며 빈 칸(날짜당 4칸)을 출력한다.
		for(int i=1; i<=weekDay(year, month, 1); i++) {
			System.out.print("    ");
		}
		
//		1일부터 달력을 출력할 달의 마지막 날짜까지 반복하며 달력을 출력한다.
		for(int i=1; i<=lastDay(year, month); i++) {
			System.out.printf(" %2d ", i);
//			출력한 날짜(i)가 토요일이고, 그 달의 마지막 날짜가 아니면 줄을 바꾼다.
//			if(i % 6 == 0) { //토요일에 줄바꿈이 되지만, 매월 1일이 일요일이 됨
			if(weekDay(year, month, i) == 6 && i != lastDay(year, month)) { 
				//i != lastDay(year, month) 코드가 없다면, 토요일이 마지막날이면, for문을 벗어나 공백줄이 생김.
				System.out.println();
			}
			
		}
		System.out.println("\n===========================");
		
		
		

	}

}
