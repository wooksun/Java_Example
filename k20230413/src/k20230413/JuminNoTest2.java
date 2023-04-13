package k20230413;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class JuminNoTest2 {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("주민번호 13자리를 '-'없이 입력 : ");
		String jumin = sc.nextLine().trim(); //trim() 공백없앰.
		
		System.out.println(jumin.substring(0, 2)); //입력한 주민번호 앞자리 둘 (99)
		System.out.println("===============================");
		
		int year = (jumin.charAt(0) - '0') * 10 + (jumin.charAt(1) - 48); //입력한 주민번호 앞자리 둘 (99)
		System.out.println(year);
		System.out.println("===============================");
		
		
		
//		★ Integer.parseInt(인수, 인수) : 인수로 지정된 문저열을 정수로 변환한다. ★
//		Double.parseDouble(인수, 인수) : 인수로 지정된 문자열을 실수로 변환한다.
		year = Integer.parseInt(jumin.substring(0, 2)); ///입력한 주민번호 앞자리 둘 (99)
		System.out.println(year);
		System.out.println("===============================");
		
//		if(jumin.charAt(6) <= '2') { //조건 만족-> 1900년생, 만족 x -> 2000년생
//			year += 1900;
//		}else {
//			year += 2000;
//		}
//		System.out.println(year); //1999
		
		year += jumin.charAt(6) <= '2' ? 1900 : 2000; //삼항연산자 (식 다시 공부)로 위의 식을 줄임
		System.out.println(year); //1999
		
		
//		컴퓨터의 날짜 데이터를 얻어와서 년도만 꺼낸다
		Date date = new Date();
		System.out.println("나이 : " + (date.getYear() + 1900 - year)); //만 나이
		Calendar calendar = Calendar.getInstance();
		System.out.println("나이 : " + (calendar.get(Calendar.YEAR) - year)); //만 나이
		
		
		
		
	}

}
