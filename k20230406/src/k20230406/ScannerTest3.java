package k20230406;

import java.util.Scanner;

public class ScannerTest3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		키보드로 1문자 입력받기.
		System.out.println("continue?(y/n) ");
		char confirm = sc.nextLine().charAt(0);
//		char는 nextLine으로 입력받을 때, nextLine은 문자열만 받으니까, .charAt(0);을 추가로 입력한다.
		System.out.println(confirm);
		
		
	}

}
