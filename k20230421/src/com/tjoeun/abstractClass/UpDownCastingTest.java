package com.tjoeun.abstractClass;

class Base{
	
//	pakage 접근 권한은 같은 package에서는 public처럼 사용되고 다른 package에서는 private처럼 사용된다.
	
//	package 접근 권한 : 같은 패키지에서는 public처럼 사용 가능하지만, 다른 package에서는 private처럼 사용됨
//	protectde 접근 권한 : 부모 자식간에만 사용 가능한 권한
//	private 접근 권한 : 같은 클래스 내에서만 사용 가능한 권한
//	public 접근 권한 : 어디서든지 사용 가능한 접근 권한
	
	String name; //접근 권한을 생략하면 package 권한을 의미한다.
	void say() { //package 권한으로 만듦
		System.out.println(name + "님 안녕하세요");
	}
	
}

class Sub extends Base { //Base 부모, Sub 자식
	
	int age;

	@Override //이 애너테이션은 오버라이드 된 메소드이다 / 부모에게 상속받은 메소드를 사용해야 한다.
	void say() { //Base 클래스에 있는 say()를 오버라이드 함.
		System.out.println(name + "님은 " + age + "살 입니다.");
	}
	
}


public class UpDownCastingTest {

	public static void main(String[] args) {
		
//		부모 클래스 타입으로 부모 클래스 객체를 만들어 사용하면 아무 문제없이 처리된다.
		Base base = new Base();
		base.name = "최진욱";
		base.say();
		System.out.println("===================");
		
//		자식 클래스 타입으로 자식 클래스 객체를 만들어 사용하면 아무 문제없이 처리된다.
		Sub sub = new Sub();
		sub.name = "김문선"; //부모객체를 물려받아 name을 사용 가능
		sub.age = 20;
		sub.say();
		System.out.println("===================");
		
		
//		결론 => 부모 클래스가 자식 클래스를 제어할 수는 있지만, 자식 클래스가 부모 클래스를 제어할 수는 없다.
//		부모 클래스 타입에 자식 클래스 타입의 객체가 생성된 주소를 대입하면 아무 문제없이 처리된다. (부모에 따라 자식을 넣어준다.)
		
//		Base b = new Sub(); //Base 부모의 b객체에 Sub(); 자식 클래스 생성자를 대입한다.
//		b.say(); //자식 클래스의 say()가 실행됨. => null님은 0살 입니다.
		
		
//		자식 클래스 타입에 부모 클래스 타입의 객체가 생성된 주소를 대입하면 에러가 발생한다. 
//		Sub s = new Base(); //new Base();에 빨간줄 -> 부모를 자식객체에 넣으려고 하니 에러 발생
		
//		upcasting : 부모 클래스 타입의 객체에 '자식 클래스 타입의 객체가 생성된 주소'를 대입한다.
//		downcasting : 부모 클래스 타입으로 'upcasting된 자식 클래스를 다시 자식 클래스 타입'으로 변환하는 것을 말한다.
		Base b = sub;
//		b는 부모 클래스 타입의 객체지만 자식 클래스 타입의 객체가 생성된 주소를 대입해으므로, 
//		say() 메소드를 실행하면 부모 클래스의 say() 메소드가 아닌 자식 클래스의 say() 메소드가 실행된다.
		b.say();
		System.out.println("===================");

		
//		자식 클래스 타입의 객체에 부모 클래스 타입의 객체가 생성된 주소를 대입한다.
//		Sub s = base; //에러 발생
		
//		자식 클래스 타입에 부모 클래스 타입의 객체나 객체가 생성된 주소를 대입하면 에러가 발생되는데,
//		이 때, casting 시켜서 대입하면 대입은 가능하고 정상적인 downcasting이 아닌 경우 문법적으로 오류는 발생하지 않지만,
//		ClassCastException이 발생된다.
//		Sub s = (Sub) base; //casting 시키면 '문법적인 에러'는 발생되지 않는다. Sub s = base; -> Sub s = (Sub) base;
//		=> 실행하면 ClassCastException이 발생 
		
//		instanceof 연산자 : 객체가 instanceof 뒤에 지정한 클래스 타입으로 안전하게 형변환이 가능한지 검사한다.
		if(sub instanceof Base) {
			System.out.println("Sub 클래스 타입의 객체는 Base 클래스 타입으로 형변환 가능");
			Base base2 = (Base) sub;
			base2.say();
		} else {
			System.out.println("Sub 클래스 타입의 객체는 Base 클래스 타입으로 형변환 불가능");
		}
		
		if(base instanceof Sub) {
			System.out.println("Base 클래스 타입의 객체는 Sub 클래스 타입으로 형변환 가능");
			
		}else {
			System.out.println("Base 클래스 타입의 객체는 Sub 클래스 타입으로 형변환 불가능");
			
		}
		
		try {
			Sub sub2 = (Sub) base;
			sub2.say();
		} catch(ClassCastException e) { 
			System.out.println("Base 클래스 타입의 객체는 Sub 클래스 타입으로 형변환 불가능");
		}
		System.out.println("===================");
		

		
//		정상적인 downcasting 
		Base base2 = sub; // 부모 클래스 타입에 자식 클래스 타입을 대입한다.
//		Sub sub2 = base2; => Sub sub2 = (Sub) base2;
//		★ downcasting은 부모 클래스 타입으로 upcasting된 것을, 다시 자식 클래스 타입에 넣어주는 것을 말한다. ★
		if (base2 instanceof Sub) { //downcasting 확인차 if문 활용
			Sub sub2 = (Sub) base2;
			sub2.say();
		} else {
			System.out.println("downcasting 불가능");
		}
		
	}

}
