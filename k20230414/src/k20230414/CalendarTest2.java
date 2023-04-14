package k20230414;

import java.util.Date;
import java.util.Scanner;

public class CalendarTest2 {

	public static void main(String[] args) { // MyCalendar 클래스에 있는 객체들을 가져와 사용하기

//		MyCalendar calendar = new MyCalendar(); //MyCalendar(); -> 생성자
//		System.out.println(calendar.isLeapYear(2023)); //객체를 생성해서 calendar를 찍어 가져오기
//		System.out.println(MyCalendar.isLeapYear(2023)); //직접 MyCalendar로 가서 객체 가져오기.

		Scanner sc = new Scanner(System.in);
		System.out.print("이번달(1), 특정달(2) : ");
		int confirm = sc.nextInt();

		int year, month;
		if (confirm == 1) {
			Date date = new Date();
			year = date.getYear() + 1900;
			month = date.getMonth() + 1;
		} else {
			System.out.println("달력을 출력할 년, 월을 입력하세요.");
			System.out.print("년 : ");
			year = sc.nextInt();
			System.out.print("월 : ");
			month = sc.nextInt();
		}

		System.out.println("===========================");
		System.out.printf("        %4d년%2d월\n", year, month);
		System.out.println("===========================");
		System.out.println(" 일  월  화  수  목  금  토 "); // (공백)일(공백)(공백)월~(공백)(공백)금(공백)(공백)토(공백)
		System.out.println("===========================");

//		1일이 출력될 위치(요일)을 맞추기 위해 요일만큼 반복하며 빈 칸(날짜당 4칸)을 출력한다.
//		for (int i = 1; i <= MyCalendar.weekDay(year, month, 1); i++) { //MyCalendar 클래스 사용
//			System.out.print("    ");
//		}

//		1일이 출력될 위치(요일)을 맞추기 위해 요일만큼 반복하며 전달 날짜를 출력한다.
		int week = MyCalendar.weekDay(year, month, 1);
		int start;
		if (month == 1) {
//			start = MyCalendar.lastDay(year - 1, 12) - week; //정석 1월
			start = 31 - week; // 매년 12월의 마지막은 31일이니까, 코드 길게 처리하지않고, 31일로 적어도 가능.
		} else {
			start = MyCalendar.lastDay(year, month - 1) - week + 1; // 2월 ~ 12월

		}
		for (int i = 1; i <= week; i++) { // MyCalendar 클래스 사용
			System.out.printf(" %2d ", start++); // start++을 해야 전달의 숫자들이 1씩 증가.
		}

		for (int i = 1; i <= MyCalendar.lastDay(year, month); i++) { // MyCalendar 클래스 사용
			System.out.printf(" %2d ", i);
			if (MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) { // MyCalendar 클래스 사용
				System.out.println();
			}

		}

//		날짜를 다 출력하고, 남은 빈칸에 다음달 1일의 요일부터 토요일까지 반복하며 다음달 날짜를 출력한다.
//		week = MyCalendar.weekDay(year, month+1, 1); //month+1 다음달
//		if(week != 0)
//			start = 1; //매 달 무조건 1일
//			for (int i = week; i <= 6; i++) { 
//				System.out.printf(" %2d ", start++);
//			}
//		}

		week = MyCalendar.weekDay(year, month, MyCalendar.lastDay(year, month)) + 1; //다음날 1일의 요일 구하기
		start = 1; 
		for (int i = week; i <= 6; i++) { //토요일(6)에 +1 하면 7 => 반복불가
			System.out.printf(" %2d ", start++);
		}

		System.out.println("\n===========================");

	}

}
