package k20230412;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
//		현재 컴퓨터 시스템의 날짜와 시간을 얻어온다. = Date
		Date date = new Date();
		System.out.println(date); //Wed Apr 12 14:38:23 KST 2023
		
//		날짜, 시간 서식 지정하기
//		서식 문자를 제외한 나머지 문자는 입력한 그대로 출력된다.
//		형식 : SimpleDateFormat sdf = new SimpleDateFormat("날짜/시간 서식");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초"); //2023년 04월 12일 수요일 14시 38분 23초
		System.out.println(sdf.format(date));
		SimpleDateFormat sdf2 = new SimpleDateFormat("yy.MM.dd(E) a h:mm:ss.SSS"); //23.04.12(수) 오후 2:38:23.317
		System.out.println(sdf2.format(date));
		System.out.println("===================================");
		
		
//		날짜, 시간 데이터에서 년, 월, 일, 시, 분, 초 얻오오기
//		Date 클래스는 1900년을 기준으로 날짜를 처리하므로, 년도는 얻어와서 1900을 더해야 한다.
		System.out.println("년:" + (date.getYear()+1900));
//		Date 클래스는 0~11월을 처리하므로 월은 얻어와서 1을 더해야한다.
		System.out.println("월:" + (date.getMonth()+1));
		System.out.println("일:" + date.getDate()); 
		System.out.println("요일:" + date.getDay()); //요일을 숫자로 얻어온다.
		System.out.println("시:" + date.getHours()); 
		System.out.println("분:" + date.getMinutes()); 
		System.out.println("초:" + date.getSeconds()); 
//		getTime() : 1970년 1월 1일 자정부터 이 메소드가 실행되는 순간까지 지나온 시간을 밀리초 단위로 얻어온다.
//		=> 13자리의 정수를 얻어온다.
		System.out.println(date.getTime());
		System.out.printf("밀리초: %03d\n" , date.getTime() % 1000);
		System.out.println("===================================");
		
		
//		Calendar 클래스 객체를 이용해서 날짜/시간을 출력하려면 getTime() 메소드 실행하여 날짜/시간 정보만 얻어온 후 서식 적용
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println(calendar.getTime());
		System.out.println(sdf.format(calendar.getTime()));
		
		System.out.println("년 : " + calendar.get(Calendar.YEAR));
		System.out.println("월 : " + calendar.get(Calendar.YEAR));
		System.out.println("일 : " + calendar.get(Calendar.DATE));
		System.out.println("일 : " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("요일 : " + calendar.get(Calendar.DAY_OF_WEEK)); //일(1) 월(2) 화(3) 수(4) 목(5) 금(6) 토(7)
		System.out.println("시(12시각) : " + calendar.get(Calendar.HOUR));
		System.out.println("시(24시각) : " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : " + calendar.get(Calendar.MINUTE));
		System.out.println("초 : " + calendar.get(Calendar.SECOND));
		System.out.println("밀리초 : " + calendar.get(Calendar.MILLISECOND));
		System.out.println("===================================");
		
		
//		currentTimeMillis() : 1970년 1월 1일 자정부터 이 메소드가 실행되는 순간까지 지난 시간을 밀리초 단위로 얻어옴.
//		currentTimeMillis() 메소드 실행 결과는 12자리의 정수, int 타입의 변수에 저장시킬 수 없음. -> long 타입 변수에 저장하여 사용해야 함.
		System.out.println(System.currentTimeMillis());
		
//		int start = System.currentTimeMillis(); //에러
		long start = System.currentTimeMillis(); //시작 시간
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis(); //종료 시간(start와 최소 1000이상 시간 차이가 남)
		System.out.println("실행 시간 : "+(end - start) / 1000. +"초");
		SimpleDateFormat sdf4 = new SimpleDateFormat("실행 시간 : HH:mm:ss.SSS초");
//		currentTimeMillis() 메소드를 이용해서 얻어온 시간 데이터를 연산할 경우 일반적인 사칙연산만 실행할 경우 문제 X
//		연산 결과에 SimpleDateFormat 클래스 객체를 사용해 서식을 지정하면, offset 값이 포함된 시간으로 서식이 적용 => 연산 결과에서 offset 값을 빼면 됨
		System.out.println(sdf4.format(end - start - 32400000));
		
		
		
	}

}
