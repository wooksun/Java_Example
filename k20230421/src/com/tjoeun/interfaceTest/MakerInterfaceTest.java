package com.tjoeun.interfaceTest;

// 표시(marker) 인터페이스는 아무 내용도 가지지 않는 인터페이스를 말한다.
interface Repairable { //SCV가 수리 가능한 유닛 클래스에 구현한다.
//	아무것도 코딩하지 않는다.
}

// 모든 유닛의 최고 조상 클래스 Unit을 만든다.
class Unit {
//	상수 (final로 선언한 필드)는 반드시 선언과 동시에 초기화를 시켜야 한다.
//	<상수를 초기화시키는 방법은 3가지>
//	1번째 방법. 상수 선언시 "=" 사용
//	2번째 방법. 객체가 생상될 때 생성자에서 초기화 시킨다.
//	3번째 방법. static으로 선언한 상수를 초기화하는데 2문장 이상 필요한 경우
//	static{ } 와 같이 초기화 블록을 사용하는 방법이 있다.
	
	final int MAX_HP ; //최대 HP, 상수(값을 바꾸지 못하는 고정치)
	int currentHP; //현재 HP
	
//	생성자를 선언하지 않으면 자바 컴파일러가 아무런 일도 하지않는 기본 생성자를 만들어주지만,
//	기본 생성자가 아닌 다른 생성자를 선언하면 컴파일러는 기본 생성자를 자동으로 만드러주지 않는다.
//	따라서 Unit 클래스에는 기본 생성자가 존재하지 않는다.
	public Unit(int hp) {
//		④ Unit 클래스의 생성자에서 인수로 넘어온 150을 받아서 MAX_HP를 초기화 시킨다.
		MAX_HP = hp;
	}
//	⑤ }로 Unit 클래스의 생성자가 종료되면 Unit 클래스의 생성자를 호출한 곳으로 돌아간다.
}

// Unit 클래스를 상속받아 육상 유닛의 조상 클래스 GroundUnit을 만든다.
class GroundUnit extends Unit {
	public GroundUnit(int hp) { // Unit(int hp)호출 / 부모 클래스에 기본 생성자가 없기 때문에 
//		③ GroundUnit 클래스의 생성자에서 인수로 넘어온 150을 받아서 부모 클래스(Unit)의 생성자 Unit(int hp)를 호출한다.
		super(hp); 
	}
//	⑥ GroundUnit 클래스의 생성자가 종료되면 GroundUnit 클래스의 생성자를 호출한 곳으로 돌아간다.
}

// Unit 클래스를 상속받아 공중 유닛의 조상 클래스 AirUnit을 만든다.
class AirUnit extends Unit {

	public AirUnit(int hp) {
		super(hp);
	}
	
}

// Tank를 만든다.
class Tank extends GroundUnit implements Repairable{

	public Tank() {
//		② Tank 클래스의 기본 생성자가 실행되면 150을 인수로 부모클래스(GroundUnit)의 생성자 GroundUnit(int hp)를 호출한다.
		super(150);
//		⑦ Tank의 MAX_HP가 150으로 초기화되었으므로 현재 HP(상속받는 currentHP)를 MAX_HP로 초기화 시킨다.
		currentHP = MAX_HP;
		System.out.println("Tank의 현재 HP는 : " + currentHP + " 입니다.");
		
	}

	@Override
	public String toString() {
		return "Tank";
	}
}

// Marine를 만든다.
class Marine extends GroundUnit {

	public Marine() {
		super(80);
		currentHP = MAX_HP;
		System.out.println("Marine의 현재 HP는 : " + currentHP + " 입니다.");
	}
	
	@Override
	public String toString() {
		return "Marine";
	}
	
}

//  SCV를 만든다.
class SCV extends GroundUnit implements Repairable {

	public SCV() {
		super(100);
		currentHP = MAX_HP;
		System.out.println("SCV의 현재 HP는 : " + currentHP + " 입니다.");
	}
	
//	수리하는 메소드를 만든다.
//	수리하는 메소드는 유닛별로 만들지 않고, 실제 수리기능을 담당하는 유닛인 이곳에 만든다.
	
//	오퍼랜드(데이터) 오버로드
//	메소드의 인수로 클래스나 인터페이스 객체를 사용하면 인수로 지정된 클래스를 상속받았거나, 
//	인터페이스를 구현받은 모든 클래스 또는 인터페이스 객체를 인수로 받을 수 있다.
//	=> 인수로 부모를 적으면 그 부모의 모든 자식들을 다 넣을 수 있다.
	
	public void repair(Repairable repairable) {
		
//		표시 인터페이스 타입을 수리할 객체를 받았는데, 표시 인터페이스는 내용이 코딩되어있지 않기 때문에
//		인수로 넘겨받은 객체를 실제로 구현한 내용이 들어있는 클래스로 형변환 시킨 수 처리해야 한다.
		
		if(repairable instanceof Unit) {
			Unit unit = (Unit) repairable;
//			수리시작
			unit.currentHP = 100;
			while(unit.currentHP < unit.MAX_HP) {
				unit.currentHP++; //체력 1씩 증가
				System.out.print(".");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("\n" + unit + " 수리완료");
		}else {
			System.out.println("Repairable 인터페이스 객체로 넘어온 객체를 Unit 클래스로 형변환 할 수 없습니다. 수리불가.");
		}
		
	}
	
	@Override
	public String toString() {
		return "SCV";
	}
	
	
}

//  DropShip을 만든다.
class DropShip extends AirUnit implements Repairable {

	public DropShip() {
		super(120);
		currentHP = MAX_HP;
		System.out.println("DropShip의 현재 HP는 : " + currentHP + " 입니다.");
	}
	
	@Override
	public String toString() {
		return "DropShip";
	}
	
}


public class MakerInterfaceTest {

	public static void main(String[] args) {
		
//		①Tank 클래스의 기본 생성자를 호출해서 Tank 클래스의 객체를 만든다.
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropShip = new DropShip();
		
		scv.repair(tank);
		scv.repair(dropShip);
		scv.repair(scv);
		
	}

}
