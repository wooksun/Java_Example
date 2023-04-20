package com.tjoeun.inheritance;

import java.util.Calendar;

// 자바는 일반적으로 파일 1개에 1개의 클래스를 만들어 사용하지만, 필요에 따라서 1개의 파일에 여러개의 클래스를 만들어 사용할 수 있다.
// 1개의 파일에 여러개의 클래스를 만들면 "*.java" 파일은 1개가 만들어지지만, 
// 컴파일된 "*.class" 파일은 각각 독립적으로 생상된다.

// 현재 java 파일의 이름과 같은 이름의 클래스에만 public을 붙일 수 있다.
// 기본생성자가 실행되면 현재 날짜로 필드를 초기화하고 년,월,일을 넘겨받는 생성자가 실행되면,
// 넘겨받은 년,월,일로 필드를 초기화하는 클래스를 만든다.
class Date { // 날짜를 기억하는 클래스
	private int year;
	private int month;
	private int day;

//	2023년 04월 20일 
	public Date() {
//		java.util.Date date = new java.util.Date();
//		year = date.getYear() + 1900;
//		month = date.getMonth() +1;
//		day = date.getDate();

		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DATE);
	}

	public Date(int year, int month, int day) { // 초기화
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return String.format("%4d년 %02d월 %02d일", year, month, day);
	}

}

// 기본생성자가 실행되면 현재 날짜로 필드를 초기화하고 시,분,초를 넘겨받는 생성자가 실행되면,
// 넘겨받은 시,분,초로 필드를 초기화하는 클래스를 만든다.
class Time { // 시간을 기억하는 클래스
	private int hour;
	private int minute;
	private int second;

//	12:39:25
	public Time() {
//		java.util.Date date = new java.util.Date();
//		hour = date.getHours();
//		minute = date.getMinutes();
//		second = date.getSeconds();
		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
	}

	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

}

// 자바는 다중 상속을 허용하지 않기 때문에 class Now extends Date, Time과 같이 두개의 부모를 가지면 에러가 발생된다.
// 다중 상속 효과를 내기 위해 클래스 포함 또는 인터페이스를 사용한다.
//class Now extends Date{ //가능
//	
//}

class Now {
//	클래스 포함이란 필드로 다른 클래스 객체를 선언해서 사용하는 것을 말한다.
	private Date date; // 클래스 포함
	private Time time; // 클래스 포함

//	기본 생성자가 실행되면 현재 날짜와 시간으로 초기화한다.
	public Now() {
		date = new Date();
		time = new Time();
	}

//	 날짜와 시간 데이터를 넘겨받아 초기화시키는 생성자
	public Now(Date date, Time time) {
		this.date = date;
		this.time = time;
	}

//	 년,월,일,시,분,초를 넘겨받아 초기화시키는 생성자
	public Now(int year, int month, int day, int hour, int minute, int second) {
		date = new Date(year, month, day);
		time = new Time(hour, minute, second);
	}

	@Override
	public String toString() {
		return "Now [date=" + date + ", time=" + time + "]";
	}

}

public class ClassIncludeTest {

	public static void main(String[] args) {
//		Date
		Date date = new Date();
		System.out.println(date);
		Date date2 = new Date(2023, 11, 22);
		System.out.println(date2);

//		Time
		Time time = new Time();
		System.out.println(time);
		Time time2 = new Time(18, 0, 1);
		System.out.println(time2);

//		Now
		Now now = new Now();
		System.out.println(now);
		Now now2 = new Now(date2, time2);
		System.out.println(now2);
		Now now3 = new Now(2023, 11, 22, 18, 0, 1);
		System.out.println(now3);

	}

}
