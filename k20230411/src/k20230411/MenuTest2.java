package k20230411;

import java.util.Scanner;

public class MenuTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int menu;
		while(true) { //while(true)는 무한루프 => 무한루프를 탈출할 수 있는 조건과 break를 이용해서 탈출할 수 있어야 한다.
			
			do {
				System.out.println("========================================");
				System.out.println(" 1.입력 2.목록보기 3.수정 4.삭제 5.종료");
				System.out.println("========================================");
				System.out.print("원하는 메뉴를 입력하세요: ");
				menu = sc.nextInt();
			}while(menu<1 || menu>5); //while 조건을 만족하면 다시 do로 올라감
			
//		여기까지 왔다면 menu에 1~5 사이의 정수가 입력되었다는 것을 의미.
			switch(menu) {
			case 1:
				System.out.println("입력: ");
				break;
			case 2:
				System.out.println("목록보기: ");
				break;
			case 3:
				System.out.println("수정: ");
				break;
			case 4:
				System.out.println("삭제: ");
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); //프로그램 강제종료 코드
				break;
			}
//			case 5 : 를 쓰지 않았다면, if문으로 가능
//			if(menu == 5) {
//				break;
//			}
			
		}
		
		
	}

}
