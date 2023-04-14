package k20230414;

public class MyCalendar {
	
	public static boolean isLeapYear(int year) { // isLeapYear
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0; // 윤년, 평년식
	}

	public static int lastDay(int year, int month) { //lastDay
		int[] m = { 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		m[1] = isLeapYear(year) ? 29 : 28; // isLeapYear를 불러와 삼항연산자로 코드를 줄임.
		return m[month - 1];
	}

	public static int totalDay(int year, int month, int day) { //totalDay
		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		for (int i = 1; i < month; i++) {
			sum += lastDay(year, i);
		}
		return sum + day;
	}

	public static int weekDay(int year, int month, int day) { //weekDay
		return totalDay(year, month, day) % 7;
	}
	
}
