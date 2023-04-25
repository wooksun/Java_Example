package com.tjoeun.genericTest;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		
		//Powder를 재료로 사용하는 3D 프린터를 만든다.
		ThreeDPrinterPowder printerPowder = new ThreeDPrinterPowder();  
		Powder powder = new Powder(); //Powder를 재료로 사용하는 3D 프린터에 사용할 재료를 만든다.
		
		printerPowder.setMaterial(powder); //3D 프린터에 재료를 넣는다.
		System.out.println(printerPowder.getMaterial()); //3D 프린터를 사용한다.
		powder =  printerPowder.getMaterial(); //3D 프린터에서 재료를 꺼낸다.
		System.out.println("======================================");
		
		//Plastic를 재료로 사용하는 3D 프린터를 만든다.
		ThreeDPrinterPlastic printerPlastic = new ThreeDPrinterPlastic();
		Plastic plastic = new Plastic();
		
		printerPlastic.setMaterial(plastic); 
		System.out.println(plastic);
		plastic = printerPlastic.getMaterial();
		System.out.println("======================================");
		
//		Powder와 Plastic을 모두 재로로 사용하는 3D 프린터를 만든다. => Object
		ThreeDPrinter threeDPrinter = new ThreeDPrinter();
		threeDPrinter.setMaterial(powder); //upcasting
		System.out.println(printerPowder.getMaterial());  //Powder
		powder =  (Powder) threeDPrinter.getMaterial(); //Object가 powder로 형변환 -> downcasting(자식을 부모로 넣었다가 다시 자식으로 가는 구조)
//		자식 객체를 부모 객체에 넣을 때 (upcasting) => 형변환x/ 부모객체에 저장된 자식 객체를 다시 자식 객체에 넣을 때 (downcasting) => 반드시 형변환
		
		threeDPrinter.setMaterial(plastic);
		System.out.println(printerPlastic.getMaterial()); //Plastic
		plastic = (Plastic) threeDPrinter.getMaterial();
		System.out.println("======================================");
		
//		Powder와 Plastic을 모두 재로로 사용하는 3D 프린터를 만든다. => Object
		GenericPrinter<Powder> genericPricter = new GenericPrinter<>(); 
		genericPricter.setMaterial(powder);
		System.out.println(genericPricter.getMaterial());
		powder = genericPricter.getMaterial(); //Generic은 형변환이 필요없음
		
		GenericPrinter<Plastic> genericPricter2 = new GenericPrinter<>(); 
		genericPricter2.setMaterial(plastic);
		System.out.println(genericPricter2.getMaterial());
		plastic = genericPricter2.getMaterial();
		System.out.println("======================================");
		
		Water water = new Water();
		threeDPrinter.setMaterial(water);
		System.out.println(threeDPrinter.getMaterial());
		water = (Water) threeDPrinter.getMaterial();
		
		GenericPrinter<Water> genericPrinter3 = new GenericPrinter<>();
		genericPrinter3.setMaterial(water);
		System.out.println(genericPrinter3.getMaterial());
		water = genericPrinter3.getMaterial();
		
	}

}
