package com.tjoeun.ThreadTerminate;

import java.util.Scanner;

public class ThreadTerminateTest {

	public static void main(String[] args) {

		ThreadTerminate terminateA = new ThreadTerminate("A");
//		System.out.println(terminateA.getName());
		ThreadTerminate terminateB = new ThreadTerminate("B");
//		System.out.println(terminateB.getName());
		ThreadTerminate terminateC = new ThreadTerminate("C");
//		System.out.println(terminateC.getName());
		
		terminateA.start();
		terminateB.start();
		terminateC.start();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("스레드 종료하기");
		
		while(true) { //스레드를 종료 시키는것은 메소드를 실행시키는 것이 아닌, 무한루프를 탈출시켜 메소드를 종료시키는 것이 전부이다.
			char ch = sc.nextLine().charAt(0); //키보드로 한 글자 입력
			if(ch == 'A') {
				terminateA.setFlag(false); //flag(true)로 시작해서 false로 탈출하는
			}else if(ch == 'B') {
				terminateB.setFlag(false); 
			}else if(ch == 'C') {
				terminateC.setFlag(false); 
			}else if(ch == 'M') {
				terminateA.setFlag(false); //flag(true)로 시작해서 false로 탈출하는
				terminateB.setFlag(false); //flag(true)로 시작해서 false로 탈출하는
				terminateC.setFlag(false); //flag(true)로 시작해서 false로 탈출하는
				break;
			}
		}
		
	}

}
