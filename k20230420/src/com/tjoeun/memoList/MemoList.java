package com.tjoeun.memoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MemoList {

	private ArrayList<MemoVO> memoList = new ArrayList<>();

	public ArrayList<MemoVO> getMemoList() {
		return memoList;
	}

	public void setMemoList(ArrayList<MemoVO> memoList) {
		this.memoList = memoList;
	}

	@Override
	public String toString() {
		String str = "";

		if (memoList.size() == 0) {
			str += "저장된 메모가 없습니다.";

		} else {
			for (int i = memoList.size() - 1; i >= 0; i--) {
				str += memoList.get(i) + "\n";
			}

		}

		return str;
	}

	public void addMemo(MemoVO vo) {
		memoList.add(vo);
	}

	public MemoVO selectMemo(int idx) {
		try {
			return memoList.get(idx - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public void deleteMemo(int idx) {
		memoList.remove(idx - 1);

		for (int i = 0; i < memoList.size(); i++) {
			memoList.get(i).setIdx(i + 1);
		}

		MemoVO.count = memoList.size();

	}

	public void updateMemo(int idx, String memo) {
		memoList.get(idx - 1).setMemo(memo);
	}

//	MemoMain클래스에서 호출되는 텍스트 파일의 이름을 넘겨받아, memoList ArrayList에 저장된 데이터를 텍스트 파일로 출력하는 메소드
	public void writeMemo(String filename) {

		PrintWriter printWriter = null;

//		텍스트 파일의 경로와 이름을 연결한다.
//		String filepath = "./src/com/tjoeun/memoList/" + filename + ".txt";
		String filepath = String.format("./src/com/tjoeun/memoList/%s.txt", filename);
//		System.out.println(filepath);

		try {
			printWriter = new PrintWriter(filepath);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

//			ArrayList에 저장된 데이터를 공백으로 구분해서 텍스트 파일에 1줄로 연결하여 출력한다.
			
//			일반 for
			/*
			for (int i = 0; i < memoList.size(); i++) {
//				System.out.println(memoList.get(i));
				MemoVO vo = memoList.get(i);
//				String str = "";
//				str += vo.getIdx() + " "; //데이터 구분하기 위한 구분자(공백)
//				str += vo.getName().replace(" ", "`") + " "; //홍 길동 -> 홍`길동
//				str += vo.getPwd() + " ";
//				str += vo.getMemo().replace(" ", "`") + " "; 
//				str += sdf.format(vo.getWriteDate());

				String str = String.format("%d %s %s %s %s", vo.getIdx(), vo.getName().replace(" ", "`"), vo.getPwd(),
						vo.getMemo().replace(" ", "`"), sdf.format(vo.getWriteDate()));
//				System.out.println(str);
				printWriter.write(str + "\n");

			}
			*/
			
//			향상된 for
			for(MemoVO vo : memoList) {
				String str = String.format("%d %s %s %s %s", vo.getIdx(), vo.getName().replace(" ", "`"), vo.getPwd(),
						vo.getMemo().replace(" ", "`"), sdf.format(vo.getWriteDate()));
				printWriter.write(str + "\n");
			}
			System.out.println(filename + ".txt 파일에 쓰기 완료.");

		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일 또는 경로 이름이 옳바르지 않습니다.");
		} finally {
			if(printWriter != null) {
				printWriter.close();
			}
		}
	}

	
//	MemoMain클래스에서 호출되는 텍스트 파일의 이름을 넘겨받아, 텍스트 파일의 데이터를 읽어 memoList ArrayList에 저장하는 메소드
	public void readMemo(String filename) {
		Scanner sc = null;
		
//		텍스트 파일의 경로와 이름을 연결한다.
		String filepath = String.format("./src/com/tjoeun/memoList/%s.txt", filename);
		
		try {
			sc = new Scanner(new File(filepath));
			
//			텍스트 파일에 저장된 데이터를 마지막 줄까지 읽어서 memoList ArrayList에 저장한다. 
			while(sc.hasNextLine()) {
//				텍스트 파일에서 1줄을 읽는다.
				String str = sc.nextLine().trim();
//				System.out.println(str);
				
//				읽어들인 데이터를 공백을 경계로 읽어(나눠)서 각각의 변수에 저장한다.
				Scanner scan = new Scanner(str);
				int idx = scan.nextInt();
				String name = scan.next().replaceAll("`", " ");
				String pwd = scan.next();
				String memo = scan.next().replaceAll("`", " ");;
				String tmp = scan.nextLine().trim();
				
//				텍스트 파일에서 읽어들인 문자열로 변환되서 저장된 날짜 데이터를 Date클래스 객체를 사용해서 날짜 데이터로 변환한다.
//				System.out.println(tmp.substring(0, 4));
//				int year = Integer.parseInt(tmp.substring(0, 4)) - 1900;
//				int month = Integer.parseInt(tmp.substring(5, 7)) - 1;
//				int day = Integer.parseInt(tmp.substring(8, 10));
//				int hour = Integer.parseInt(tmp.substring(11, 13));
//				int minute = Integer.parseInt(tmp.substring(14, 16));
//				int second = Integer.parseInt(tmp.substring(17)); //끝까지
//				Date writeDate = new Date(year, month, day, hour, minute, second);
				
//				split() 메소드의 구분자를 "."으로 지정하면 제대로 동작되지 않는다.
//				split() 메소드의 구분자로 "."을 사용해야 한다면 1. "\\." 2."[.]" 의 두가지 방법이 있다.
//				String[] date = tmp.split("."); //에러
//				String[] date = tmp.split("\\.");
				String[] date = tmp.split("[.]");
//				System.out.println(Arrays.toString(date));
				int year = Integer.parseInt(date[0]) - 1900;
				int month = Integer.parseInt(date[1]) - 1;
				int day = Integer.parseInt(date[2]);
				int hour = Integer.parseInt(date[3]);
				int minute = Integer.parseInt(date[4]);
				int second = Integer.parseInt(date[5]); //끝까지
				
				Date writeDate = new Date(year, month, day, hour, minute, second);
//				System.out.println(writeDate);
				
				
//				ArrayList에 저장하기 위해 MemoVO 클래스 객체를 만들어 넣어준다.
//				MemoVO vo = new MemoVO();
//				vo.setIdx(idx);
//				vo.setName(name);
//				vo.setPwd(pwd);
//				vo.setMemo(memo);
//				vo.setWriteDate(writeDate);
				
//				MemoVO vo = new MemoVO(name, pwd, memo);
//				vo.setIdx(idx);
//				vo.setWriteDate(writeDate);
				
				MemoVO vo = new MemoVO(idx, name, pwd, memo, writeDate); //List에 먼저 vo로 만들어주고, VO에 생성자 필드 선언
//				System.out.println(vo);
				
//				MemoVO 클래스 객체에 저장된 데이터를 memoList ArrayList에 저장한다.
				memoList.add(vo);
				
			}
			System.out.println(filename + ".txt 파일에서 읽기 완료.");
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("파일 또는 경로 이름이 옳바르지 않습니다."); //읽어들이는건 close() 필요 x
		}
		
		
	}

}
