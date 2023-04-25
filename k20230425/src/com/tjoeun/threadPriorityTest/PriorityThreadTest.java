package com.tjoeun.threadPriorityTest;

public class PriorityThreadTest {

	public static void main(String[] args) {
		/*
//		스레드 우선 순위 : 1 ~ 10 사이를 지정할 수 있다.
//		우선 순위가 높은 스레드가 CPU에 할당을 받을 확률이 높다.
//		System.out.println(Thread.MAX_PRIORITY); //10
//		System.out.println(Thread.MIN_PRIORITY); //1
//		System.out.println(Thread.NORM_PRIORITY); //5, 기본값
		
		PriorityThread pt1 =  new PriorityThread();
		PriorityThread pt2 =  new PriorityThread();
		PriorityThread pt3 =  new PriorityThread();
		
//		setPriority() 메소드로 스레드의 우선순위를 지정할 수 있다.
		pt1.setPriority(Thread.MAX_PRIORITY);
		pt2.setPriority(Thread.NORM_PRIORITY);
		pt3.setPriority(Thread.MIN_PRIORITY);
		
		pt1.start();
		pt2.start();
		pt3.start();
		*/
		
//		MIN_PRIORITY = 1 , MAX_PRIORITY = 10
		for (int i=Thread.MIN_PRIORITY; i<=Thread.MAX_PRIORITY; i++) {
			PriorityThread pt = new PriorityThread("스레드-" + i);
			if(i == 5) {
				pt.setPriority(Thread.MAX_PRIORITY); 
			}else {
				pt.setPriority(Thread.MIN_PRIORITY); 
			}
			pt.start();
		}
		
	}

}
