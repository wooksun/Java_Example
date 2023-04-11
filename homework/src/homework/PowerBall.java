package homework;

import java.util.Random;

public class PowerBall {

	public static void main(String[] args) {

//		파워볼 1~60번까지 5개 랜덤, 1~20번 중 1개 랜덤

//		추첨기를 만든다. (배열 lotto 1~45)
		int[] lotto = new int[60];
		int[] power = new int[20];

//		추첨기에 공을 넣는다.
		System.out.println("==========섞기 전=========");
		System.out.println("======파워볼 1~60=========");
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("%2d ", lotto[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}

		System.out.println("======파워볼 1~20=========");

		for (int i = 0; i < power.length; i++) {
			power[i] = i + 1;
		}

		for (int i = 0; i < power.length; i++) {
			System.out.printf("%2d ", lotto[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}

//		섞는다.
		System.out.println("\n==========섞은 후=========");
		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			int r = random.nextInt(59) + 1; // +1을 하지 않으면, 섞었을 때 51은 섞이지 않고, 고정적으로 끝에 머물게 됨.
			int p = random.nextInt(19) + 1;

			int tmp = lotto[0];
			lotto[0] = lotto[r];
			lotto[r] = tmp;

			int pow = power[0];
			power[0] = power[p];
			power[p] = pow;
		}
		
		System.out.println("=====1~60번=====");
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("%2d ", lotto[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}

		System.out.println("=====1~20번=====");
		for (int i = 0; i < power.length; i++) {
			System.out.printf("%2d ", power[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}

		System.out.println("\n==========1등번호 출력=========");

//		1등 번호를 출력한다. (앞에 6개 1등번호, 7번째 인덱스 보너스)
		System.out.print("1~60번 번호: ");
		for (int i = 0; i < 5; i++) {
			System.out.printf("%2d ", lotto[i]);

		}
		System.out.printf(", 1~20번 번호: %2d ", power[0]);

	}

}