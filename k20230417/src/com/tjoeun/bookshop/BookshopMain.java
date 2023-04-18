package com.tjoeun.bookshop;

import java.util.Date;

public class BookshopMain {

	public static void main(String[] args) {

		BookVO vo = new BookVO(); // 클래스이름 객체(변수)이름 = new 생성자();
//		System.out.println(vo);
//		System.out.println(vo.title); //private 권한으로 선언된 변수에 접근하면 에러가 발생된다. 

//		클래스로 만든 객체를 출력하면 자동으로 toString() 메소드가 실행.
//		System.out.println(vo.toString());

//		도서 정보를 만든다.
//		출판일은 날짜 데이터를 만들어서 BookVO 클래스의 writeDate 필드에 넣어주면 다른 곳에서 사용할 일이 없다.
//		이럴경우 익명으로 만들어 사용하면 편리하다.
		BookVO book1 = new BookVO("java", "홍길동", "더조은출판사", new Date(2020 , 5, 13), 35000);
		System.out.println("book1 : " + book1); 
//		 new Date(2020 , 5, 13)는 BookVO에 public BookVO( Date writeDate );에 들어감
		
//		private 권한으로 선언된 필드에 접근하게 위해서 getters & setters 메소드를 만들어 사용한다. => BookVO
//		System.out.println(book1.getTitle()); // java
//		book1.setTitle("spring"); //[title=spring
//		System.out.println(book1);

		BookVO book2 = new BookVO("java", "홍길자", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book3 = new BookVO("java", "홍길숙", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book4 = new BookVO("java", "홍길희", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book5 = new BookVO("java", "홍길영", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book6 = new BookVO("java", "홍길자", "더조은출판사", new Date(2020 , 5, 13), 35000);

		System.out.println("book2 : " + book2); 
		System.out.println("book6 : " + book3); 
		
//		"=="을 사용해서 같은가 비교할 수 있는 데이터는 (기본 자료형 8가지, null)만 가능하다.
//		따라서, 클래스로 만든 객체는 "=="로 비교하면 안된다. => 데이터가 아닌 데이터가 생성된 주소를 비교하기 때문이다.
		if(book1 == book6) { //다르다.
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		
//		String은 단일데이터가 저장되는 클래스라서 equals() 메소드만 사용하면 저장된 내용이 같은가 다른가 비교할 수 있었지만,
//		사용자 정의 클래스 객체는 단일데이터가 아니기 때문에 별도의 설정을 하지 않으면 equals() 메소드로 비교할 수 없다.
		
//		별도의 설정을 하지 않으면 아래의 결과는 "다르다"가 출력된다.
//		클래스 객체를 비교할 때 객체를 구성하는 모든 필드의 내용이 같은가 비교할 수 있도록 equals()메소드를 Override 해야하고, 
//		내용이 동일한 객체는 같은 hashcode를 가질 수 있도록 hashcode() 메소드도 Override를 하면 "같다"가 출력된다.
		if(book2.equals(book6)) { //다르다. -> 주소끼리 비교 ( hashcode가 다름 )
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		
		if(book2.getAuthor().equals(book6.getAuthor())) { //같다.
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		
//		여러권의 책 정보를 기억하는 클래스의 객체를 만든다.
		BookList bookList = new BookList(5);
		
//		도서 정보를 BookList 클래스의 bookList 배열에 저장하는 메소드를 실행한다. / BookList 클래스 5번
		bookList.addBook(book1);
		bookList.addBook(book2);
		bookList.addBook(book3);
		bookList.addBook(book4);
		bookList.addBook(book5);
		bookList.addBook(book6);
		System.out.println(bookList);
	}

}
