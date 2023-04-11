package k20230411;

import java.util.Scanner;

public class EuclidTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("두개의 수를 입력하세요: ");

		int a = sc.nextInt();
		int b = sc.nextInt();
		int r = 1;

		int high, low;
		if (a > b) {
			high = a;
			low = b;
		} else {
			high = b;
			low = a;
		}

		while (r > 0) {
			r = high % low; // 큰수를 작은수로 나눈 나머지를 계산.
			high = low; // 큰수 기억장소 -> 작은수
			low = r; // 작은수 기억장소 -> 나머지 r
		}
		int l = a * b / high;
//		최대공약수와 최소공배수를 출력.
		System.out.printf("최대공약수 : %d, 최소공배수 : %d\n", high, l);

	}

}
