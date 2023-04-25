package com.tjoeun.threadPriorityTest;

public class PriorityThread extends Thread{
	
	public PriorityThread() { }
	
	public PriorityThread(String name) {
//		스레드 이름을 지정하려면, 스레드 이름을 넘겨받는 생성자를 만들고 Thread(부모클래스)의 생성자를 호출해서 넣어주면 된다.
		super(name);
	}
	@Override
	public void run() {
		
//		currentThread() : 현재 스레드 객체를 만든다.
		Thread thread = Thread.currentThread();
		
//		setName() 메소드로 스레드 이름을 지정할 수 있다.
//		thread.setName("최진욱"); //스레드 이름이 같아진다.
		
		int sum = 0;
		for(int i=1; i<=1000000; i++) {
			sum += i;
		}
		
//		getName() 메소드로 스레드 이름을 얻어올 수 있다.
//		getPriority() 메소드로 스레드의 우선 순위를 얻어올 수 있다.
		System.out.println(thread.getName() + " 우선 순위 : " + thread.getPriority());
		
	}
	
	
	
}
