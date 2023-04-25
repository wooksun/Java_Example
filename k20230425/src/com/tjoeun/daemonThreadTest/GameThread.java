package com.tjoeun.daemonThreadTest;

public class GameThread {

	public static void main(String[] args) {
		
		BGMThread bgmThread = new BGMThread();
		
//		daemon 스레드는 다른 스레드가 모두 종료되면 같이 종료되는 스레드를 말한다.
//		setDaemon() 메소드의 인수를 true로 지정하면 스레드가 daemon 스레드가 된다.
		bgmThread.setDaemon(true); //배경음악의 무한루프가 되지않는다.
		bgmThread.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("신나게 게임을 하는 중.....");
			
			if(i == 7) {
				System.out.println("앗...엄마다...");
				System.out.println("엄마가 오셔서 게임을 종료합니다. . .");
				break;
			} 
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		
		
	}

}
