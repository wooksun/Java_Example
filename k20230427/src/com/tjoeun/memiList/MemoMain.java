package com.tjoeun.memiList;

import java.util.Scanner;

public class MemoMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menu = 0;

		while (menu != 5) {
			while (true) {
				System.out.println("=======================================");
				System.out.println(" 1.입력 2.목록보기 3.수정 4.삭제 5.종료");
				System.out.println("=======================================");
				System.out.print("원하는 메뉴를 입력하세요: ");
				menu = sc.nextInt();

				if (menu >= 1 && menu <= 5) {
					break;
				}
				System.out.println("메뉴는 1 ~ 5 사이로 입력해야 합니다.");
			}

			switch (menu) {
			case 1:
//				MemoService 클래스의 테이블에 저장할 데이터를 입력받아 DAO 클래스로 넘겨주는 메소드를 호출한다.
				MemoService.insert();
				break;
			case 2:
//				MemoService 클래스의 테이블에 저장된 글 목록을 최신글부터 얻어오는 메소드를 실행한다.
				MemoService.select();
				break;
			case 3:
//				MemoService 클래스의 삭제할 글번호를 입력받아 테이블에서 글을 수정하는 메소드를 호출한다.
				MemoService.update();
				break;
			case 4:
//				MemoService 클래스의 삭제할 글번호를 입력받아 테이블에서 글을 삭제하는 메소드를 호출한다.
				MemoService.delete();
				break;

			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

}
