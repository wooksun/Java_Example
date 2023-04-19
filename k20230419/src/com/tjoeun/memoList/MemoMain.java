package com.tjoeun.memoList;

import java.util.Scanner;

public class MemoMain {

//	글 목록을 저장하는 MemoList 클래스 객체는 MemoMain 클래스의 여러 메소드에서 사용해야 하기 때문에,
//	MemoMain 클래스의 필드로 선언해야 한다.
	private static MemoList memoList = new MemoList(); // static은 static만 접근할 수 있음 -> main()과 insert()에는 static이기 때문에
														// static을 붙여줌

	public static void main(String[] args) {

//		MemoVO memo1 = new MemoVO("홍길동", "1111","1등입니다.");
//		System.out.println(memo1);
//		MemoVO memo2 = new MemoVO("임꺽정", "2222","2등입니다.");
//		System.out.println(memo2);
//		MemoVO memo3 = new MemoVO("장길산", "3333","3등입니다.");
//		System.out.println(memo3);

//		1. 입력
//		2. 목록보기
//		3. 수정
//		4. 삭제
//		5. 종료 / 5번 누르면 종료

		Scanner sc = new Scanner(System.in);
		int menu = 0;

		while (menu != 5) {
			while (true) {
				System.out.println("========================================");
				System.out.println(" 1.입력 2.목록보기 3.수정 4.삭제 5.종료");
				System.out.println("========================================");
				System.out.print("원하는 메뉴를 입력하세요: ");
				menu = sc.nextInt();

				if (menu >= 1 && menu <= 5) {
					break;
				}
				System.out.println("메뉴는 1 ~ 5 사이로 입력해야 합니다.");
			}

			switch (menu) {
			case 1:
				// 데이터를 저장하는 메소드를 실행한다
				insert();
				break;
			case 2:
				// 데이터 목록을 출력하는 메소드를 실행한다.
				System.out.print(memoList);
				break;
			case 3:
				// 데이터를 수정하는 메소드를 실행한다.
				update();
				break;
			case 4:
				// 데이터를 삭제하는 메소드를 실행한다.
				delete();
				break;

			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

//	키보드로 "수정"할 글번호를 입력받아, 수정할 글 1건을 얻어와 화면에 표시하고, 비밀번호와 수정할 내용을 입력받아
//	memoList라는 ArrayList에 저장된 글 1건을 수정한다.
	private static void update() {
		Scanner sc = new Scanner(System.in);

		System.out.println("수정할 게시글 번호 입력");
		System.out.print("글 번호 : ");
		int idx = sc.nextInt();

//		memoList라는 ArrayList에 저장된 글 1건을 얻어오는 메소드를 실행하고, 얻어온 결과를 MemoVO 클래스 객체에 저장한다.
		MemoVO original = memoList.selectMemo(idx);

//		수정할 글번호의 해당되는 글이 존재하면 글을 수정하고, 존재하지 않으면 메시지를 출력한다.
		if (original == null) { // 글이 존재하는가?
//			글번호에 해당되는 글이 존재하지 않으면, 메시지 출력한다.
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
//			글번호에 해당되는 글이 존재하므로 화면에 출력한다.
			System.out.println("수정할 글 확인");
			System.out.println(original);

//			수정할 글의 비밀번호를 입력받는다.
			System.out.println("수정할 글의 비밀번호를 입력하세요 : ");
			sc.nextLine(); // 키보드 버퍼를 비운다.
			String pw = sc.nextLine().trim();

//			수정하기 위해 입력한 비밀번호(pw)와 수정할 글의 비밀번호(original.getPw())를 비교한다.
			if (pw.equals(original.getPwd())) { // 비밀번호가 일치하면 수정

//			비밀번호가 일치하므로, 수정할 내용을 입력받는다.
				System.out.print("수정할 메모를 입력하세요: ");
				String memo = sc.nextLine().trim();

//			비밀번호가 일치하므로 memoList라는 ArrayList에 저장된 글을 수정하는 메소드를 실행한다.
				memoList.updateMemo(idx, memo);
				System.out.println(idx + "번 글 수정완료!");
			} else {
//				비밀번호가 일치하지 않으면, 메시지 출력
				System.out.println("비밀번호가 일치하지 않습니다.");

			}

		}

	}

//	키보드로 "삭제"할 글번호를 입력받아, 삭제할 글 1건을 얻어와 화면에 표시하고, 비밀번호를 입력받아 memoList라는 ArrayList에 저장된 글 1건을 삭제한다.
	private static void delete() {
		Scanner sc = new Scanner(System.in);

//		키보드로 삭제할 글 번호를 입력받는다.
		System.out.println("삭제할 게시글 번호 입력");
		System.out.print("글 번호 : ");
		int idx = sc.nextInt();

//		memoList라는 ArrayList에 저장된 글 1건을 얻어오는 메소드를 실행하고, 얻어온 결과를 MemoVO 클래스 객체에 저장한다.
		MemoVO original = memoList.selectMemo(idx);

//		삭제할 글번호의 해당되는 글이 존재하면 글을 삭제하고, 존재하지 않으면 메시지를 출력한다.
		if (original == null) { // 글이 존재하는가?
//			글번호에 해당되는 글이 존재하지 않으면, 메시지 출력한다.
			System.out.println(idx + "번 글이 존재하지 않습니다.");

		} else {
//			글번호에 해당되는 글이 존재하므로 화면에 출력한다.
			System.out.println("삭제할 글 확인");
			System.out.println(original);

//			삭제할 글의 비밀번호를 입력받는다.
			System.out.println("삭제할 글의 비밀번호를 입력하세요 : ");
			sc.nextLine(); // 키보드 버퍼를 비운다.
			String pw = sc.nextLine().trim();

//			삭제하기 위해 입력한 비밀번호(pw)와 삭제할 글의 비밀번호(original.getPw())를 비교한다.
			if (pw.equals(original.getPwd())) { // 비밀번호가 일치하면 삭제
//				비밀번호가 일치하므로 memoList라는 ArrayList에 저장된 글을 삭제하는 메소드를 실행한다.
				memoList.deleteMemo(idx);
				System.out.println(idx + "번 글 삭제완료!");
			} else {
//				비밀번호가 일치하지 않으면, 메시지 출력
				System.out.println("비밀번호가 일치하지 않습니다.");

			}

		}

	}

//	1. 입력 눌렀을 때 보이는 것.
//	키보드로 이름, 비밀번호, 메모를 입력받아 MemoVO 클래스 객체에 저장하고 ArrayList에 저장하는 메소드를 호출하는 메소드
	private static void insert() {
		Scanner sc = new Scanner(System.in);
//		키보드로 이름, 비밀번호, 메모를 입력받는다.
		System.out.println("게시판에 저장할 글 입력");
		System.out.print("이름 : ");
		String name = sc.nextLine().trim();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine().trim();
		System.out.print("메모 : ");
		String memo = sc.nextLine().trim();

//		MemoVO 클래스 객체에 입력받은 내용을 저장한다.
		MemoVO vo = new MemoVO(name, pw, memo);
//		System.out.println(vo);

//		MemoVO 클래스 객체를 MemoList 클래스의 ArrayList에 저장하는 메소드를 실행한다.
		memoList.addMemo(vo);
		System.out.println("저장완료.");

	}

}
