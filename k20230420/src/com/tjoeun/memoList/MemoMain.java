package com.tjoeun.memoList;

import java.util.Scanner;

public class MemoMain {

	private static MemoList memoList = new MemoList();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menu = 0;

		while (menu != 7) {
			while (true) {
				System.out.println("=====================================================================");
				System.out.println(" 1.입력 2.목록보기 3.수정 4.삭제 5.파일로 저장 6.파일에서 읽기 7.종료");
				System.out.println("=====================================================================");
				System.out.print("원하는 메뉴를 입력하세요: ");
				menu = sc.nextInt();

				if (menu >= 1 && menu <= 7) {
					break;
				}
				System.out.println("메뉴는 1 ~ 7 사이로 입력해야 합니다.");
			}

			switch (menu) {
			case 1:
				insert();
				break;
			case 2:
				System.out.print(memoList);
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				fileWrite();
				break;
			case 6:
				fileRead();
				break;

			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

//	키보드로 텍스트 파일이름을 입력받아 텍스트 파일의 데이터를 읽어서 MemoList 클래스의 memoList ArrayList에 저장하는 메소드를 실행하는 메소드
	private static void fileRead() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("읽어올 텍스트 파일 이름을 입력하세요: ");
		String filename = sc.nextLine().trim();
		
//		텍스트 파일의 데이터를 읽어 MemoList 클래스의 memoList ArrayList에 저장하는 메소드를 실행한다.
		memoList.readMemo(filename);
	}
	

//	키보드로 텍스트 파일이름을 입력받아 MemoList 클래스의 memoList ArrayList에 저장된 데이터를 '텍스트 파일'로 저장하는 메소드를 실행하는 메소드
	private static void fileWrite() {
		Scanner sc = new Scanner(System.in);
		
//		텍스트 파일의 이름을 입력받는다.
		System.out.print("저장할 텍스트 파일 이름을 입력하세요: ");
		String filename = sc.nextLine().trim();
		
//		MemoList 클래스의 memoList ArrayList에 저장된 데이터를 텍스트 파일로 저장하는 메소드를 실행한다.
		memoList.writeMemo(filename);
		
		
		
	}

	private static void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("수정할 게시글 번호 입력");
		System.out.print("글 번호 : ");
		int idx = sc.nextInt();

		MemoVO original = memoList.selectMemo(idx);

		if (original == null) { // 글이 존재하는가?
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
			System.out.println("수정할 글 확인");
			System.out.println(original);

			System.out.println("수정할 글의 비밀번호를 입력하세요 : ");
			sc.nextLine(); // 키보드 버퍼를 비운다.
			String pw = sc.nextLine().trim();

			if (pw.equals(original.getPwd())) { // 비밀번호가 일치하면 수정

				System.out.print("수정할 메모를 입력하세요: ");
				String memo = sc.nextLine().trim();

				memoList.updateMemo(idx, memo);
				System.out.println(idx + "번 글 수정완료!");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");

			}

		}

	}

	private static void delete() {
		Scanner sc = new Scanner(System.in);

		System.out.println("삭제할 게시글 번호 입력");
		System.out.print("글 번호 : ");
		int idx = sc.nextInt();

		MemoVO original = memoList.selectMemo(idx);

		if (original == null) {
			System.out.println(idx + "번 글이 존재하지 않습니다.");

		} else {
			System.out.println("삭제할 글 확인");
			System.out.println(original);

			System.out.println("삭제할 글의 비밀번호를 입력하세요 : ");
			sc.nextLine();
			String pw = sc.nextLine().trim();

			if (pw.equals(original.getPwd())) {
				memoList.deleteMemo(idx);
				System.out.println(idx + "번 글 삭제완료!");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");

			}

		}

	}

	private static void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("게시판에 저장할 글 입력");
		System.out.print("이름 : ");
		String name = sc.nextLine().trim();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine().trim();
		System.out.print("메모 : ");
		String memo = sc.nextLine().trim();

		MemoVO vo = new MemoVO(name, pw, memo);

		memoList.addMemo(vo);
		System.out.println("저장완료.");

	}

}
