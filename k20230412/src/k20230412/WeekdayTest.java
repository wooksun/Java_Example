package k20230412;

import java.util.Scanner;

public class WeekdayTest {

	public static void main(String[] args) {

//		요일을 계산할 년, 월, 일을 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.println("서기 1년 1월 1일부터 요일을 계산하기 위해 입력한 날짜까지 지난 날짜수를 계산");
		System.out.print("계산할 년도 :");
		int year = sc.nextInt();
		System.out.print("계산할 월 :");
		int month = sc.nextInt();
		System.out.print("계산할 일 :");
		int day = sc.nextInt();

//		서기 1년 1월 1일부터 요일을 계산하기 위해 입력한 날짜까지 지난 날짜수를 계산한다.
		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;

		/* switch문을 이용
		for (int i = 1; i < month; i++) {
//			2월, 짧은달(4,6,9,11), 긴달(1,3,5,7,8,10,12)
			switch(i) {
			case 2:
				sum += year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
				break;
			case 4: case 6: case 9: case 11: //짧은달
				sum+= 30;
				break;
			default: //긴달
				sum += 31;
			}
		}
		*/
		
//		각 달의 마지막 날짜를 기억하는 배열을 선언
		int[] m= {31,0,31,30,31,30,31,31,30,31,30,31};
//		2월의 마지막 날짜를 확정한다.
		m[1] = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
		for (int i = 1; i < month; i++) {
			sum += m[i-1];
		}
		
//		전 달까지 지난 날짜에 일을 더한다.
		sum += day;
		
//		요일을 출력한다. (계산된 날짜를 7로 나눈 나머지가 0이면 일요일, 1이면 월요일, ...5면 금요일, 6이면 토요일)
		/* switch문 사용
		 * switch(sum % 7) { case 0 : System.out.println("일요일"); break; case 1 :
		 * System.out.println("월요일"); break; case 2 : System.out.println("화요일"); break;
		 * case 3 : System.out.println("수요일"); break; case 4 :
		 * System.out.println("목요일"); break; case 5 : System.out.println("금요일"); break;
		 * case 6 : System.out.println("토요일"); break; }
		 */
		
		String[] week = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		System.out.println(week[sum%7]);
		

	}
}
