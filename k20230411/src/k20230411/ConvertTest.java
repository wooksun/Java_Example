package k20230411;

import java.util.Scanner;

public class ConvertTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("8진수로 변환할 10진수를 입력하세요 : ");
		int dec = sc.nextInt();
		int number = dec; 
		
		int[] bin = new int[8]; 
		int index = 0; 
		
		while(true) {
			int m = dec / 8; //몫
			int r = dec % 8; //나머지
			bin[index++] = r; //2진수를 기억할 배열에 나머지를 넣어준다.

			if(m == 0) {
				break;
			}
			dec = m;
		}
		System.out.print(number + "를 8진수로 변환하면"); 
		for(int i=bin.length-1; i>=0; i--) {
			System.out.print(bin[i]);
		}
		System.out.println(" 입니다.");
		
		System.out.print(number + "를 8진수로 변환하면");
		for(int i=index - 1; i>=0; i--) {
			System.out.print(bin[i]);
		}
		System.out.println(" 입니다.");
	}

}
