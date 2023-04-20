package com.tjoeun.inheritance;

// 자식 (하위, 서브, 파생)클래스 
// Child 클래스는 Parent 클래스를 상속받아 만든다.
// 상속이란? 부모클래스에서 정의한 모든 필드와 메소드를 자식클래스가 물려받는 것을 말한다.
// 자식 클래스에서 별도의 선언없이, 부모 클래스의 모든 기능을 사용할 수 있다.
// publiuc class Child extends Parent
public class Child extends Parent {

//	Child 클래스는 Parent 클래스의 모든 필드와 메소드를 사용할 수 있다.
//	Child 클래스에서 필요한 기능을 정의한다.
	private int age;
	private String nickname;

	public Child() {
//		super는 부모 클래스를 의미하고 뒤에 ()가 나오면 부모클래스의 생성자를 의미한다.
//		this는 현재 클래스를 의미하고 뒤에 ()가 나오면 현재 클래스의 생성자를 의미한다.
//		super()는 코딩하지 않아도 자바 컴파일러가 자동으로 만들어준다.
//		super()와 this()는 반드시 생성자의 첫 문장으로 써야한다. => 가장 먼저 실행된다.

//		1. 부모클래스의 생성자가 자식클래스의 생성자보다 먼저 실행된다.
//		2. 부모클래스에서 기본 생성자를 정의하지 않으면, 자식클래스에서 super()가 실행될 때 에러가 발생한다.
		super(); // 자식클래스의 기본 생성자에는 부모클래스의 생성자가 자동으로 들어가게 됨
		System.out.println("자식 클래스의 생성자 실행");
	}

//	부모클래스에서 상속받은 필드의 접근 권한이 private 권한일 경우, 자식 클래스에서 직접 접근할 수 없기 때문에, 
//★★★	1. 부모클래스의 생성자를 호출해서 초기화한다. => 가장 많이쓰임.

	public Child(String name, boolean gender, int age, String nickname) {
		super(name, gender); // Parent(String name, boolean gender)
//		this.name; //에러, 부모클래스에서 private 권한으로 설정된 필드라 접근불가.
//		this.gender; //에러, 부모클래스에서 private 권한으로 설정된 필드라 접근불가.
		this.age = age;
		this.nickname = nickname;
	}

//	2. 부모클래스에서 private 권한으로 설정된 모든 필드에 setter 메소드가 정의되어 있다면, setter는 메소드이므로 public 권한으로 작성되었기 때문에
//	자식클래스에서 실행할 수 있으므로, 부모클래스에서 상속받은 private 권한의 필드를 setter를 이용해 초기화시킬 수 있다.
//	public Child(String name, boolean gender,int age, String nickname) {
//		setName(name);
//		setGender(gender);
//		this.age = age;
//		this.nickname = nickname;
//	}

//	3. Parent 클래스에서 protected로 선언한 name과 gender를 사용하면, this.으로 가능
//	public Child(String name, boolean gender,int age, String nickname) {
//		this.name = name;
//		this.gender = gender;
//		this.age = age;
//		this.nickname = nickname;
//	}

//	@Override(재정의) : 부모 클래스로부터 상속받은 메소드의 기능을 무시하고 다시 만들어 사용한다.
	@Override
	public String toString() {
//		부모 클래스에서 상속받은 private 권한을 가지는 필드는 자식 클래스에서 접근할 수 없으므로
//		부모 클래스에서 상속받은 private 권한을 가지는 필드에 저장된 데이터는 getter 메소드를 사용해서 접근해야 한다.
//		리턴타입이 boolean인 메소드는 "is"로 메소드 이름을 시작하는게 관행이다.

		// Parent의 name과 gender가 private일 때.
		return  getName() + "(" + (isGender() ? "남" : "여") + ") -" + age + ", " + nickname;
		

//		자식 클래스에서 부모 클래스에게 상속받은 메소드의 앞,뒤에 기능을 추가할 수 있다.
//		부모 클래스의 메소드를 실행하려면 부모 클래스를 의미하는 super 뒤에 "."을 찍고, 실행할 메소드 이름을 쓰면 된다.
//		super.toString() : 부모 클래스의 toString() 메소드를 실행한다.
		// Parent의 name과 gender가 private일 때.
//		return super.toString() + " - " + age + ", " + nickname; //부모클래스의 toString을 실행하고 +  " - " + age + ", " + nickname
		

//		부모 클래스에서 상속받은 필드의 접근 권한이 protected일 경우 자식 클래스에서 접근할 수 있으므로 getter를 사용하지 않아도 필드의 내용을 얻어올 수 있다.
		// Parent의 name과 gender가 protected일 때.
//		return name + "(" + (gender ? "남" : "여") + ") -" + age + ", " + nickname;
	}

}
