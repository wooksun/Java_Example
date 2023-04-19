package com.tjoeun.textFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.lang.model.type.PrimitiveType;

public class TextFileWriteTest {

	public static void main(String[] args) {
		
		Scanner sc = null; //키보드 입력에 사용할 스캐서
		PrintWriter printWriter = null; //텍스트 파일로 출력에 사용할 PrintWriter
		
//		경로 지정 방식은 '절대경로 지정방식'과 '상대경로 지정방식'이 있다.
//		절대경로 지정방식 : 작업중인 파일이 위치한 디스크 드라이브의 최상위(root) 폴더(디렉토리)부터, 작업중인 파일이 위차한 폴더까지의 경로를 말한다.
//		상대경로 지정방식 : 작업중인 파일이 위치한 폴더(".")부터 작업중인 파일이 위치한 폴더까지의 경로를 말한다. ( C://java.src.com. ..)
//		파이썬, c/c++의 "."은 화면에 열려있는 파일이 위치한 폴더를 의미
//		java의 "."은 파일이 포함된 프로젝트 이름의 폴더를 의미
		
//		경로지정 시 경로와 경로, 경로와 파일을 구분하는"\"가 기본이지만, 에러가 발생되면 "\\""나 "/"로 수정한다
		
//		절대경로
//		String filepath = "C:\\k_digital\\java\\workspace\\out.txt";
//		String filepath = "C:/Users/82107/git//upload/k20230419/src/com/tjoeun/textFileIO/out.txt";
		
//		상대경로 
//		String filepath = ".\\src\\com\\tjoeun\\textFileIO\\out.txt";
		String filepath = "./src/com/tjoeun/textFileIO/out.txt"; //workspace에 없어, git 경로
		
//		PrintWriter 클래스의 생성자로 출력파일의 경로와 이름을 지정한다.
		try {
//			PrintWriter 클래스의 생성자로 출력 파일의 경로와 이름을 지정해서 출력 파일을 만든다.
			printWriter = new PrintWriter(filepath); //위의 경로 데이터를 가져온 filepath 
			sc = new Scanner(System.in);
			
//			"QUIT"가 입력될 때 까지 반복하며, 키보드로 입력한 데이터를 파일에 저장한다.
			while(true) {
//				텍스트 파일에 저장할 데이터를 키보드로 입력받는다.
				System.out.print(">>> ");
				String str = sc.nextLine().trim();
				
//				입력받은 내용이 "QUIT"일 경우 무한루프를 탈출한다.
				if(str.toUpperCase().equals("QUIT")) {
					break;
				}
				
//				키보드로 입력받은 내용을 텍스트 파일에 저장한다.
//				write() 메소드로 PrintWriter 클래스 객체로 생성한 파일에 출력한다
//				\r : carriage return, 커서를 그 줄의 맨 앞으로 보낸다.
//				\n : new Line, 줄을 바꾼다.
				if(str.length() != 0) {
					printWriter.write(str + "\n");
				}
			}
			System.out.println("텍스트 파일로 저장 완료");
			
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일경로가 잘못되었거나, 디스크에 파일이 존재하지 않습니다.");
		} finally {
//			출력 파일은 출력 작업이 완료되면 반드시 파일을 close() 메소드로 닫아야 정상적으로 파일이 생성된다.
			if(printWriter != null) {
				printWriter.close();
			}
		}
		
		
	}

}
