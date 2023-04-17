package com.tjoeun.bookshop;

import java.util.Date;

public class BookshopMain {

	public static void main(String[] args) {

		BookVO vo = new BookVO(); // 클래스이름 객체(변수)이름 = new 생성자();
		System.out.println(vo);
//		System.out.println(vo.title); //private 권한으로 선언된 변수에 접근하면 에러가 발생된다. 

//		클래스로 만든 객체를 출력하면 자동으로 toString() 메소드가 실행.
		System.out.println(vo.toString());

//		도서 정보를 만든다.
//		출판일은 날짜 데이터를 만들어서 BookVO 클래스의 writeDate 필드에 넣어주면 다른 곳에서 사용할 일이 없다.
//		이럴경우 익명으로 만들어 사용하면 편리하다.
		BookVO book1 = new BookVO("java", "홍길동", "더조은출판사", new Date(2020 , 5, 13), 35000);
		System.out.println(book1); 
		
//		private 권한으로 선언된 필드에 접근하게 위해서 getters & setters 메소드를 만들어 사용한다. => BookVO

	}

}
