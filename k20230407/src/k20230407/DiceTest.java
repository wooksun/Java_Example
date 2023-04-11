package k20230407;

import java.util.Arrays;
import java.util.Random;

public class DiceTest {

	public static void main(String[] args) {

		Random random = new Random();
//		num[0]=> 1의개수, num[1]=> 2의 개수, ..., num[5] => 6의개수
		int num[] = new int[6];
		
		for (int i = 0; i < 10; i++) {

			int dice = random.nextInt(6) + 1;
			System.out.println(dice);

			/*
			 * switch (dice) { case 1: num[0]++; break; case 2: num[1]++; break; case 3:
			 * num[2]++; break; case 4: num[3]++; break; case 5: num[4]++; break; case 6:
			 * num[5]++; }
			 */
			
//			위의 switch문에서의 규칙은 case와 num이 -1 차이가 난다. -> 발생한 규칙을 파악하여, 배열로 코드를 줄임.
			num[dice - 1]++;
			
			
			

		} // for

		System.out.println("===================");
//		System.out.println("1의 개수 : " + num[0]);
//		System.out.println("2의 개수 : " + num[1]);
//		System.out.println("3의 개수 : " + num[2]);
//		System.out.println("4의 개수 : " + num[3]);
//		System.out.println("5의 개수 : " + num[4]);
//		System.out.println("6의 개수 : " + num[5]);
//		위의 코드를 반복문으로.
		for(int i=0; i<num.length; i++) {
		System.out.println(i + 1 + "의 개수 : " + num[i]);
			
		}
	}

}
