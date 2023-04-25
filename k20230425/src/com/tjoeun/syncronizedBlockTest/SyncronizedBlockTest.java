package com.tjoeun.syncronizedBlockTest;

public class SyncronizedBlockTest {

	public static void main(String[] args) {
		
		ShaerArea shaerArea = new ShaerArea();
		
		 TransferThread transfer = new TransferThread(shaerArea);
		 PrintThread print = new PrintThread(shaerArea);
		 
		 transfer.start();
		 print.start();
		 
		
		 
		}
	}


