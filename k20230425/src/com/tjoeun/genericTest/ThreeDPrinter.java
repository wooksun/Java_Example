package com.tjoeun.genericTest;

// 재료로 Powder와 Plastic을 사용하는 3D 프린터, 겸용 프린터 => Object 클래스 사용
public class ThreeDPrinter {
	
//	겸용 3D 프린터는 Powder와 Plastic을 모두 재료로 받을 수 있어야 하기 때문에
//	Powder와 Plastic의 부모 클래스는 Object이므로 Object 타입으로 재료 필드를 선언한다.
//	Powder와 Plastic 클래스가 Object 클래스인 ThreeDPrinter로 오는 즉, 부모 클래스로 오는 UpCasting이 됨.
	private Object material; //powder와 plastic의 값이 들어감

	public Object getMaterial() {
		return material;
	}
	public void setMaterial(Object material) {
		this.material = material;
	}
	
	
	
}
