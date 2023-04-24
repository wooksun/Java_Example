package com.tjoeun.interfaceTest3;

public interface Calc {
	
//	상수
	public static final double PI = 3.141592; //상수 (final)
	int ERROR = -9999999; //public static final을 하지 않아도 자동적으로 상수가 된다.
	
//	추상 메소드
	public abstract int add(int num1, int num2); 
	int sub (int num1, int num2); 
	int mul (int num1, int num2); 
	int div (int num1, int num2); 
	
//	default 메소드 => JDK 8에서 추가
//	default 메소드는 구현부 { }블록을 가지는 메소드로 default 예약어를 사용해서 선언한다.
//	인터페이스를 구현받는 클래스들에서 공통으로 사용할 수 있는 메소드로 상속 또는 구현 시 Override가 가능하다
	default void description(int number) {
		System.out.println("정수 계산기를 구현합니다.");
		myMethod(number); //private이 default 메소드에서 사용하도록 함.
	}
	
//	static 메소드 => JDK 8에서 추가
//	static 메소드는 구현부 { }블록을 가지는 메소드로 static 예약어를 사용해서 선언한다.
//	인터페이스 객체를 생성하지 않고 인터페이스 이름에 "."을 찍어 실행할 수 있다.
	static int total(int[] arr) {
		int total = 0;
		for(int i : arr) {
			total += i;
		}
		myStaticMethod(); //private static 메소드
		return total;
	}
	
	
//	private 메소드 => JDK 9에서 추가
//	인터페이스 내부의 default 메소드에서 사용하기 위해 만드는 메소드로, 인터페이스를 구현한 클래스(외부)에서 사용할 수 없다. Override 불가.
	private void myMethod(int number) {
		for(int i=0; i<number; i++) {
			System.out.println("private method");
		}
	}
	
//	private static 메소드 => JDK 9에서 추가
//	인터페이스 내부의 static 메소드에서 사용하기 위해 만드는 메소드로, 인터페이스를 구현한 클래스(외부)에서 사용할 수 없다. Override 불가.
	private static void myStaticMethod() {
		System.out.println("private static method");
	}
	
}
