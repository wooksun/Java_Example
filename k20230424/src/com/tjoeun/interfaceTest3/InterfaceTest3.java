package com.tjoeun.interfaceTest3;

public class InterfaceTest3 {

	public static void main(String[] args) {
		
		Calc calc = new ComplateCalc();
		int num1 = 10;
		int num2 = 2;
		
		System.out.printf("%d + %d = %2d\n", num1, num2, calc.add(num1, num2));
		System.out.printf("%d - %d = %2d\n", num1, num2, calc.sub(num1, num2));
		System.out.printf("%d * %d = %2d\n", num1, num2, calc.mul(num1, num2));
		System.out.printf("%d / %d = %2d\n", num1, num2, calc.div(num1, num2));
		
//		Calc 인터페이스에서 정의한 default 메소드를 실행한다.
		calc.description(5);
		
//		Calc 인터페이스에서 정의한 static 메소드를 실행한다.
		int[] arr = {1,2,3,4,5};
		int sum = Calc.total(arr);
		System.out.println("sum : " + sum);
		
//		Calc 인터페이스에서 정의한 private 메소드는 인터페이스 외부에서 실행할 수 없다.
//		calc.myMethod(5); //오류 => private 메소드라서 실행불가

//		Calc 인터페이스에서 정의한 private static 메소드는 인터페이스 외부에서 실행할 수 없다.
//		Calc.myStaticMethod(); //오류
		
	}

}
