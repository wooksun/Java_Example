package com.tjoeun.abstractClass;

// 1개 이상의 추상 메소드를 포함한 클래스를 추상 클래스라 부르며, abstract 예약어를 사용해서 만든다.
// 추상 클래스는 불완전한 메소드인 추상 메소드를 포함하고 있기 때문에, 불완전한 클래스이므로 객체를 만들어서 사용할 수 없다. => new 할 수 없다.

// 추상 클래스는 '상속을 목적'으로 사용하는 클래스로 추상 클래스를 상속받은 자식 클래스는
// 추상 클래스의 모든 추상 메소드를 반드시 Override 시켜서 사용해야 한다. => 다형성 구현에 사용한다.
abstract class Product {
	
//	추상 메소드는 아무런 일도 하지 않는 { } 블록을 가지지 않는 메소드를 말한다.
//	추상 메소드는 abstract 예약어를 사용해 선언하며 { } 블록을 가지지 않는, '불완전한 메소드'로 추상 메소드가 포함된 클래스를 상속받는 자식 클래스에서
//	반드시 Override 시켜서 사용해야하는 메소드이다. => 프로그래머에게 반드시 Override를 해서 사용하게끔 강제한다.
	
//	자식 클래스에서 반드시 Override  시켜서 사용해야 한다는 강제성을 프로그래머에게 부여하고
//	추상 메소드의 { } 블록에 코딩해봐야 자식 클래스에서 Override를 하게되면, 부모 클래스에서 정의한 메소드 내용은 무시되므로 { }블록의 내용을
//	코딩해봐야 어차피 무시될 거 { }블록을 아예 코딩하지 않는다.
	
//	public void kindOf() { } //아무런 일도 하지 않는 일반 메소드
	public abstract void kindOf(); //추상 메소드
	
	
	
}

// Product 클래스를 상속받아 Camera 클래스를 만든다.

class Camera extends Product {

	@Override
	public void kindOf() {
		
	}
	
}

public class AbstractClassTest {
	
	public static void main(String[] args) {
		
//		Product product = new Product(); //에러
//		추상 클래스는 객체를 만들어 사용할 수 없기 떄문에 에러가 발생한다.
		
		
	}

}
