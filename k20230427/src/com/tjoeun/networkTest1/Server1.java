package com.tjoeun.networkTest1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
	public static void main(String[] args) {
		
		ServerSocket server = null; //서버소켓
		Socket socket = null; //통신소켓
		Scanner sc = null; //클라이언트에서 전송되는 데이터를 읽는 스캐너
		PrintWriter printWriter = null; //클라이언트로 데이터를 전송하는 PrintWriter
		
		try {
//			서버를 만든다.
//			192.168.219.106의 ip 주소를 가지는 10004번 포트를 열어 서버 소켓 생성
			server = new ServerSocket(10004);
			System.out.println("서버 시작 : " + server);
			
//			클라이언트가 접속하기를 무한정 기다린다.
//			accept() 메소드는 지정된 포트로 클라이언트가 접속하기를 기다리며 무한 대기한다.
			socket = server.accept();
			System.out.println("클라이언트 접속 확인");
			
//			서버에서 클라이언트로 데이터를 전송하기 위해서 전송용 객체를 선언한다.
			printWriter = new PrintWriter(socket.getOutputStream());
			
//			서버에서 클라이언트로 메시지를 전송한다. => 반드시 끝에 개행 문자(\n)를 붙여준다.
			printWriter.write("어서와 클라이언트야 오래 기다렸어...\n");
			
//			flush() 메소드로 출력 버퍼가 가득차지 않았더라도 데이터를 전송한다.
			printWriter.flush();
			
//			클라이언트에서 전송되는 데이터를 수신하기 위해 수신용 객체를 생성한다.
			sc = new Scanner(socket.getInputStream());
			
//			클라이언트에서 전송된 데이터를 읽어서 출력한다.
			System.out.println(sc.nextLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			클라이언트와 통신이 종료되면 통신에 사용한 ServerSocket, Socket 객체를 닫는다.
			if(socket != null) { try { socket.close(); } catch (IOException e) { e.printStackTrace(); } }
			if(server != null) { try { server.close(); } catch (IOException e) { e.printStackTrace(); } }
		}
	}
}
