package com.tjouen.syncronizedMethodTest;

import java.util.ArrayList;
// 도서관
public class Library {

	//도서관에 보유한 책 목록 ArrayList로 시작
	ArrayList<String> bookList = new ArrayList<>();
	
	public Library() {
		bookList.add("다빈치 코드");
		bookList.add("천사와 악마");
		bookList.add("디지털 포트리스");
//		bookList.add("라스트 심볼");
//		bookList.add("타나토노트");
//		bookList.add("개미");
	}
	
//	도서 대여 메소드
//	동기화 메소드는 synchronized 예약어를 사용해서 선언한다.
//	메소드가 실행되는 모든 내용이 종료될 때까지 다른 스레드가 실행되지 않도록 한다.
	public synchronized String lendBook() {
		
		//currentThread() : 현재 스레드의 정보를 얻어온다.
		Thread thread = Thread.currentThread(); 
		
//		대여할 책이 없으면, 책이 반납될 때 까지 스레드를 일시적으로 멈춘다.
		if(bookList.size() == 0) {
			try {
				System.out.println(thread.getName() + " 대기 시작");
//			returnBook() 메소드에서 notify() 메소드를 실행해서 일시정지된 스레드를 깨울 때 까지 멈춘다.
				wait();
				System.out.println(thread.getName() + " 대기 종료");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
//		if문을 통과해 여기까지 왔다면 도서관에 대여할 책이 있다는 의미이므로 도서를 대여한다.
		
		
		try {
			String book = bookList.remove(0);
			System.out.println(thread.getName() + " : " + "'" + book + "'"  + " 대여");
			return book;
		} 
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println(thread.getName() + "는(은) 책을 빌리지 못했습니다.");
			return null;
		}
	}
	
//	도서 반납 메소드
	public synchronized void returnBook(String book) {
		Thread thread = Thread.currentThread();
		
//		반납된 도서를 도서관에 넣는다.
		bookList.add(book);
//		도서관에 책이 없어서 일시적으로 멈춰있던 스레드를 깨운다.
		notify();
		System.out.println(thread.getName() + " : " +  "'" + book + "'"  + " 반납");
		
	}

}
