package com.tjouen.syncronizedMethodTest;

import java.util.ArrayList;

public class LibraryMain {

	//Library의 대여,반납,책 목록 등 main이 실행되기 전에 받아올 수 있도록, main 위에 씀
	public static Library library = new Library();
	
	public static void main(String[] args) {
		/*
		//Library 클래스를 가져와 객체화 하기.
		Library library = new Library();
		System.out.println(library.bookList);
		
//		ArrayList의 remove(index) remove(object) 메소드를 실행하면 
//		remove(index) 메소드를 실행하면 삭제할 index의 데이터를 리턴하고 삭제한다. => String book = library.bookList.remove(0);
//		remove(object) 메소드를 실행하면 삭제할 객체가 있으면 true, 없으면 false를 리턴한다. => boolean book = library.bookList.remove("다빈치코드");
		String book = library.bookList.remove(0); //remove(0)-> 0번째 인덱스 지워짐 / remove("다빈치코드") -> 다빈치코드가 지워짐
//		ArrayList<String>에 String 타입이라 String book으로 함.
		System.out.println(library.bookList);
		*/
		
		
		Student student1 = new Student("홍길동");
		Student student2 = new Student("임꺽정");
		Student student3 = new Student("장길산");
		Student student4 = new Student("일지매");
		Student student5 = new Student("이몽룡");
		Student student6 = new Student("성춘향");
		
		student1.start();
		student2.start();
		student3.start();
		student4.start();
		student5.start();
		student6.start();
		
		
	}

}
