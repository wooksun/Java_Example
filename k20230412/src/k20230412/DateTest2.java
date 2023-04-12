package k20230412;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest2 {

	public static void main(String[] args) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd(E) a h:mm:ss.SSS");
		System.out.println(sdf.format(date));
		System.out.println("=============================");

//		날짜, 시간 데이터 만들기
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println(sdf.format(date2));
		System.out.println("=============================");
		
		Date date3 = new Date("1983/04/22");
		System.out.println(sdf.format(date3));
		System.out.println("=============================");
		
//		꽤 쓰이는 형태
//		Date 클래스 객체에 년도를 저장할 때는 1900을 빼서 넣어야 하고 월을 저장할 때는 1을 빼서 넣어야한다.
		Date date4 = new Date(2023 - 1900, 11 - 1, 22); //앞부터 년,월,일 형태, 23.11.22(수) 오전 12:00:00.000
//		Date date4 = new Date(2023, 11, 22); //23.12.22(토) 오전 12:00:00.000
		System.out.println(sdf.format(date4));
		System.out.println("=============================");
		
		Date date5 = new Date(123, 10, 22, 18, 1); 
		System.out.println(sdf.format(date5));
		System.out.println("=============================");
		
		Date date6 = new Date(123, 10, 22, 18, 1, 10); 
		System.out.println(sdf.format(date6));
		System.out.println("=============================");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("년, 월, 일을 입력하세요");
		int year = sc.nextInt() - 1900;
		int month = sc.nextInt() - 1;
		int day = sc.nextInt();
		
		Date date7 = new Date(year, month, day); 
		System.out.println(sdf.format(date7));
		System.out.println("=============================");
		
//		날짜, 시간 데이터 수정하기
		date7.setYear(124); //사용자가 지정한(2024) year-1900한 값
		date7.setMonth(11); 
		date7.setDate(25); 
		date7.setHours(12); 
		date7.setMinutes(25); 
		date7.setSeconds(30); 
		System.out.println(sdf.format(date7));
		

	}

}
