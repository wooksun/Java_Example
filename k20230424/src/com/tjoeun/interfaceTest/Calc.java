package com.tjoeun.interfaceTest;

// 인터페이스는 클래스나 프로그램이 제공하는 기능을 명시적으로 선언한다.
// 일종의 클라이언트 코드와의 약속이며, 클래스나 프로그램이 제공하는 기능들의 명세
// 클라이언트 프로그램은 인터페이스에 선언된 메소드나 명세만 보고 이를 구현한 클래스를 사용할 수 있다.
// 인터페이스로 구현한 다양한 객체를 생성한다. => 다형성

public interface Calc {
	
//	인터페이스
	public static final double PI = 3.141592; //상수 (final)
	int ERROR = -9999999; //public static final을 하지 않아도 자동적으로 상수가 된다.
	
//	기능제공
	public abstract int add(int num1, int num2); //덧셈
	int sub (int num1, int num2); //뺄셈 => public abstract 생략 가능 => 자동
	int mul (int num1, int num2); //곱셈
	int div (int num1, int num2); //나눗셈
	
	
}
