package k20230412;

import java.util.Scanner;

public class ConvertTest4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("16진수로 변환할 10진수를 입력하세요 : ");
		int dec = sc.nextInt();
		
		System.out.print("변환할 진법을 입력하세요 : ");
		int n = sc.nextInt(); //사용자로부터 입력받은 숫자를 진법화 함
		
		int number = dec;
		int[] bin = new int[8];
		int index = 0;
		
		while (true) {
			int m = dec / n; // 사용자로부터 입력받은 진법의 수 n을 넣는다.
			int r = dec % n; // 사용자로부터 입력받는 진법의 수 n을 넣는다.
			bin[index++] = r; // 2진수를 기억할 배열에 나머지를 넣어준다.

			if (m == 0) {
				break;
			}
			dec = m;
		}
		
		System.out.print(number + "를(을) " + n + "진수로 변환하면 ");
		for (int i = index - 1; i >= 0; i--) {
			if(bin[i] < 10) {
//				bin 배열요소에 저장된 값이 10 미만이면, bin 배열 요소에 저장된 값을 그대로 출력.
				System.out.print(bin[i]);
			} else {
//				bin 배열 요소에 저장된 값이 10 이상이면, 영문자로 변환해서 출력.
//				System.out.print((char) (bin[i] + 55)); //bin[i]는 숫자, 55는 문자로 변환하게 해주는 수
				System.out.printf("%c",bin[i] + 55); 
			}
		}
		System.out.println(" 입니다.");
	}

}
