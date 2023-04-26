package com.tjouen.syncronizedMethodTest;

public class Student extends Thread{

//	생성자를 통해서 스레드 이름(도서를 대여할 학생 이름)을 넣어준다.
	public Student() { } //습관적 기본 생성자 생성
	public Student(String name) { //학생(스레드)이름
		super(name); //스레드 클래스 생성자에 name을 넘겨받도록 함.
	}
	
	
	@Override
	public void run() {
		try {
//		도서 대여
			String book = LibraryMain.library.lendBook();
			if(book == null) { //만약 book이 null이라면
				return; //스레드가 끝난다.
			}
			sleep(2500); //대여 기간(2.5초간 대여)
//		도서 반납
			LibraryMain.library.returnBook(book);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	
}
