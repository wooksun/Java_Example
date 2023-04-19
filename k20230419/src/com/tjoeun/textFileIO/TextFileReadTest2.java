package com.tjoeun.textFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TextFileReadTest2 {

	public static void main(String[] args) {
		Scanner sc = null; // 텍스트 파일에서 읽어들이는 스캐너

		String filepath = "./src/com/tjoeun/textFileIO/input.txt";

		try {
			sc = new Scanner(new File(filepath)); // 위의 두줄 최소화
			while (sc.hasNextLine()) { // 읽어들일 데이터가 있는동안 반복한다.
				String str = sc.nextLine();
//				System.out.println(str);
				System.out.println(Arrays.toString(str.split(" ")));
				
				int i = 0;
				boolean b = false;
				double d = 0;
				String s = "";
				
//				String 뱐수에 저장된 문자열을 읽어들이는 스캐너
//				Scanner 클래스의 객체를 만들 때 생성자의 인수로 String 변수를 넘기면 String 변수에 저장된 데이터를 읽어들인다.
				Scanner scan = new Scanner(str); //문자열에서 데이터를 읽어들이는 스캐너
				
//				hasNextLine() : 스캐너에 지정된 '파일'에서 읽어들일 다음 데이터가 있으면 true, 없으면 false를 리턴한다.
//				hasNext() : 메소드는 스캐너로 지정된 '문자열'에서 '공백'을 경계로 읽어들일 데이터가 있으면 true, 없으면 false를 리턴한다.
				while(scan.hasNext()) {
					if(scan.hasNextInt()) { //스캐너로 읽을 데이터가 int면 true, 아니면 false를 리턴한다.
						i = scan.nextInt();
					}else if(scan.hasNextBoolean()) { //스캐너로 읽을 데이터가 boolean이면 true, 아니면 false
						b = scan.nextBoolean();
					}else if(scan.hasNextDouble()) { //스캐너로 읽을 데이터가 double면 true, 아니면 false
						d = scan.nextDouble();
					}else {
						s = scan.next();
						
					}
				}
				System.out.println("i: " + i);
				System.out.println("b: " + b);
				System.out.println("d: " + d);
				System.out.println("s: " + s);
				
			}
			System.out.println("텍스트 파일에서 읽기 완료");

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일경로가 잘못되었거나, 파일이 존재하지 않습니다.");
		}

	}

}
