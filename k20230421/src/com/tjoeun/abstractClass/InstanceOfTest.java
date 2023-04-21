package com.tjoeun.abstractClass;

import java.util.ArrayList;

abstract class Animal {
	
//	public void move() {
//		System.out.println("동물이 움직입니다.");
//	}
	public abstract void move(); //추상 메소드
	public void eating() { //일반 메소드
		
	}
	
}

// Human 클래스는 Animal 클래스를 상속받아 만든다.
class Human extends Animal {
	@Override
	public void move() { //부모에게 받는 공통적인 것
		System.out.println("사람이 두 발로 걷습니다.");
	}
	
	public void readBooks() { //사람만 할 수 있는 Human만의 객체
		System.out.println("사람이 책을 읽습니다.");
	}
}

// Tiger 클래스는 Animal 클래스를 상속받아 만든다.
class Tiger extends Animal {
	@Override
	public void move() {
		System.out.println("호랑이가 네 발로 걷습니다.");
	}
	
	public void hunting() { //호랑이만 할 수 있는 Tiger만의 객체
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

// Eagle 클래스는 Animal 클래스를 상속받아 만든다.
class Eagle extends Animal {
	@Override
	public void move() {
		System.out.println("독수리가 하늘을 날아갑니다.");
	}
	
	public void flying() { //독수리만 할 수 있는 Eagle만의 객체
		System.out.println("독수리가 날개를 폅니다");
	}
}


public class InstanceOfTest {

	public static void main(String[] args) {
		
//		 PolymorphismTest 클래스에서는 이런식으로 실행했었다.
		Animal[] animals = { new Human(), new Tiger(), new Eagle() };
		animals[0].move();
		animals[1].move();
		animals[2].move();
		System.out.println("=================================");
		
		
//		upcasting, 자식클래스를 부모클래스에 넣어주는 것.
		Animal hAnimal = new Human(); //자식(Human)이 부모(Animal)에게 넣음
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
//		main()이라는 static 메소드에서 moveAnimal() 바로 실행하기 때문에, moveAnimal() 메소드는 반드시 static으로 선언된 메소드여야 한다.
		moveAnimal(hAnimal);
		moveAnimal(tAnimal);
		moveAnimal(eAnimal);
//		moveAnimal 객체가 private static void moveAnimal(Animal animal)로 이동해, animal.move();를 실행
		System.out.println("=================================");
		
		
//		static 사용하지 않고 사용하기
		InstanceOfTest test = new InstanceOfTest(); //자신의 클래스 객체를 만든다.
		System.out.println("Static으로 사용하지 않기");
		test.moveAnimal2(hAnimal);
		test.moveAnimal2(tAnimal);
		test.moveAnimal2(eAnimal);
//		현재 클래스 자신의 객체를 생성해서 moveAnimal2() 메소드를 실행하게 되면 static 메소드를 사용하지 않고도 실행 가능하다.
		System.out.println("=================================");
		
		
//		ArrayList를 사용하기.
		ArrayList<Animal> animalList = new ArrayList<>(); //제네릭<>에 부모 클래스
		System.out.println("ArrayList 사용");
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);
		for(Animal animal : animalList) {
			animal.move();
		}
		System.out.println("=================================");
		
		
//		downcasting을 이용
		for(int i=0; i<animalList.size(); i++) {
			Animal animal = animalList.get(i); //Human -> Tiger -> Eagle순
//			downcasting : upcasting된 클래스를 다시 원래의 타입으로 형변환 시키는 것.
//			instanceof 연산자를 사용해서 형변환이 가능한지 확인한 후 downcasting을 실행한다.
			if(animal instanceof Human) {
				Human human = (Human) animal; //downcasting, 부모에 저장된 자식 객체 => 자식으로 보냄
				human.readBooks();
			} else if(animal instanceof Tiger){
				Tiger tiger = (Tiger) animal;
				tiger.hunting();
			} else if(animal instanceof Eagle) {
				Eagle eagle = (Eagle) animal;
				eagle.flying();
			} else {
				System.out.println("downcasting 불가능");
			}
		}
		
		
		
	}


//	main()이라는 static 메소드에서 moveAnimal() 바로 실행하기 때문에, moveAnimal() 메소드는 반드시 static으로 선언된 메소드여야 한다.
	private static void moveAnimal(Animal animal) { 
		animal.move();
	}

//	moveAnimal2
	private void moveAnimal2(Animal animal) {
		animal.move();
		
	}

	
}
