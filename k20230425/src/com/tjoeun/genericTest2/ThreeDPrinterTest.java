package com.tjoeun.genericTest2;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		
	
//		Powder와 Plastic을 모두 재로로 사용하는 3D 프린터를 만든다. => Generic
		GenericPrinter<Powder> genericPricter = new GenericPrinter<>(); 
		genericPricter.setMaterial(new Powder());
		System.out.println(genericPricter.getMaterial());
		Powder powder = genericPricter.getMaterial(); //Generic은 형변환이 필요없음
		
		GenericPrinter<Plastic> genericPricter2 = new GenericPrinter<>(); 
		genericPricter2.setMaterial(new Plastic());
		System.out.println(genericPricter2.getMaterial());
		Plastic plastic = genericPricter2.getMaterial();
		System.out.println("======================================");
		
		Water water = new Water();
//		GenericPrinter<Water> genericPricter3 = new GenericPrinter<>(); //에러 => GenericPrinter<M extends Material>에 extends Material 때문.
		

		
	}

}
