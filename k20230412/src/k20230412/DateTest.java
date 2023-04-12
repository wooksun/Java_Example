package k20230412;

import java.text.SimpleDateFormat;
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
		
		
		
	}

}
