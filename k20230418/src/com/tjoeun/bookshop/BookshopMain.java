package com.tjoeun.bookshop;

import java.util.Date;

public class BookshopMain {

	public static void main(String[] args) {

		BookVO vo = new BookVO(); // 클래스이름 객체(변수)이름 = new 생성자();

		BookVO book1 = new BookVO("java", "홍길동", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book2 = new BookVO("java", "홍길자", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book3 = new BookVO("java", "홍길숙", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book4 = new BookVO("java", "홍길희", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book5 = new BookVO("java", "홍길영", "더조은출판사", new Date(2020 , 5, 13), 35000);
		BookVO book6 = new BookVO("java", "홍길자", "더조은출판사", new Date(2020 , 5, 13), 35000);

		System.out.println("book2 : " + book2); 
		System.out.println("book6 : " + book3); 
		

		if(book1 == book6) { //다르다.
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}

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
		
		BookList bookList = new BookList();
		
		bookList.addBook(book1);
		bookList.addBook(book2);
		bookList.addBook(book3);
		bookList.addBook(book4);
		bookList.addBook(book5);
		bookList.addBook(book6);
		System.out.println(bookList);
	}

}
