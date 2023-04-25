package com.tjoeun.syncronizedBlockTest;

// 잔액 출력 스레드
public class PrintThread extends Thread{
	
	ShaerArea shaerArea;
	
	public PrintThread() { }
	
	public PrintThread(ShaerArea shaerArea) {
		this.shaerArea = shaerArea;
	}
	public ShaerArea getShaerArea() {
		return shaerArea;
	}
	public void setShaerArea(ShaerArea shaerArea) {
		this.shaerArea = shaerArea;
	}

	@Override
	public void run() {
		synchronized (shaerArea) {
			for(int i=0; i<3; i++) {
				int sum = shaerArea.lee.money + shaerArea.hong.money;
				System.out.println("예금 합계 : " + sum);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	
	
}
