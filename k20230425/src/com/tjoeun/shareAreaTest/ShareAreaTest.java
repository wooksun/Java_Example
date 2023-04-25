package com.tjoeun.shareAreaTest;

public class ShareAreaTest {

	public static void main(String[] args) {
		
//		공유 영역으로 사용할 클래스 객체를 선언한다.
//		기본 자료형을 선언한 변수는 일반 변수, 클래스로 선언한 변수(객체, 인스턴스) 참조 변수라 부른다.
//		일반 변수 : 데이터 자체를 기억
//		참조 변수 : 클래스로 만든 객체는 생성된 크기를 특정지을 수 없으므로, 클래스로 만든 변수는 메모리 어딘가에 객체가 생성되면 그 객체가
//		생성된 시작 주소를 기억한다. 즉 주소를 기억한다.
		ShareArea shareArea = new ShareArea();
		
//		공유 영역을 만드는 1번째 방법
//		공유 영역을 공유해서 사용할 클래스 객체를 선언하고 생성된 공유 영역의 주소를 넣어준다.
//		CalculatorThread calculator = new CalculatorThread(); //공유 영역을 공유해서 사용할 클래스 객체를 선언
//		PrintThread print = new PrintThread(); //공유 영역을 공유해서 사용할 클래스 객체를 선언
		
//		ShareArea shareArea = new ShareArea();의 shareArea가 calculator, print와 같은 주소값
//		calculator.shareArea = shareArea;
//		print.shareArea = shareArea;
		
//		/////////////////////////////////////////////////////////////////////////////////////////////////
//		공유 영역을 만드는 2번째 방법
//		공유 영역을 공유해서 사용할 클래스 객체를 선언할 때 생성자의 인수로 공유 영역의 주소를 넘겨준다.
//		CalculatorThread calculator = new CalculatorThread(shareArea);
//		PrintThread print = new PrintThread(shareArea);
		
//		/////////////////////////////////////////////////////////////////////////////////////////////////
//		공유 영역을 만드는 3번째 방법
//		공유 영역을 공유해서 사용할 클래스 객체를 선언하고 setter 메소드를 사용해서 공유 영역의 주소를 넣어준다.
		CalculatorThread calculator = new CalculatorThread(shareArea);
		PrintThread print = new PrintThread(shareArea);
		calculator.setShareArea(shareArea);
		print.setShareArea(shareArea);
		
		
		
//		공유 영역 테스트
//		System.out.println("print.shareArea.result : " + print.shareArea.result); //print.shareArea.result : 0.0 => 기본 초기화
//		System.out.println("calculator.shareArea.result : " + calculator.shareArea.result); //calculator.shareArea.result : 0.0 => 기본 초기화
//		calculator.shareArea.result = 777; //값 변경
//		//print.shareArea.result : 777.0 => 같은 메모리를 공유하기 때문에 calculator와 값이 같다.
//		System.out.println("print.shareArea.result : " + print.shareArea.result); 
//		System.out.println("calculator.shareArea.result : " + calculator.shareArea.result); //calculator.shareArea.result : 777.0
		
//		스레드를 실핸한다.
		calculator.start();
		print.start();
		
		
	}

}
