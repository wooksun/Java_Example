package k20230407;

import java.util.Random;

public class CardShuffle {

	public static void main(String[] args) {
		
//		두 기억장소에 저장된 값 교환하기
//		int a = 3, b = 4;
//		System.out.println("a= " + a + ", b = " + b);
		
//		내가 짠거
//		int tmp = 0;
//		tmp = b;
//		b = a;
//		System.out.println("a = " + tmp + ", b = " + b);
		
//		강사님
//		int temp = a;
//		a = b;
//		b = temp;
//		System.out.println("a = " + a + ", b = " + b);
		
		
		
		
//		(문제)
//		card라는 int형 배열을 만들고 0~51로 초기화 한다.
		int[] cards = new int[52];
		for(int i=0; i<cards.length; i++) {
			cards[i] = i;
		}
		
//		카드 출력에 사용할 숫자와 무늬를 기억하는 배열을 만든다.
		String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String[] symbol = {"♠", "◇", "♥", "♧"};
		
		
		
//		섞기 전 상태를 출력한다.
		
//		내가 짠 코드
		/*
		 * // for(int i=0; i<cards.length; i++) { // int k = i / 13; // if(k == 0) { //
		 * System.out.println(i); // } // }
		 */		
				
//		강사님
		System.out.println("==========섞기전=========");
		for(int i=0; i<cards.length; i++) {
//			System.out.printf("%2d ", cards[i]); //"%2d "
			System.out.printf("%s%2s ", symbol[cards[i] / 13], number[cards[i] % 13]);
//			숫자 13개를 출력하고 줄을 바꾼다.
			if((i + 1) % 13 == 0) { //한줄에 n개 이상 출력할 때 쓰기.
				System.out.println();
			}
		}
		
//		카드를 섞는다.
//		cards[0]과 cards[1] ~ cards[51] 사이의 랜덤한 위치를 선택해서 값을 교환한다.
		Random random = new Random();
		for(int i=0; i<1000000; i++) {
			int r = random.nextInt(51)+1; //+1을 하지 않으면, 섞었을 때 51은 섞이지 않고, 고정적으로 끝에 머물게 됨.
			int tmp = cards[0];
			cards[0] = cards[r];
			cards[r] = tmp;
		}
		
		System.out.println("==========섞은 후=========");
//		섞은 후 상태를 출력한다.
		
//		숫자만 섞음
//		for(int i=0; i<cards.length; i++) {
//			System.out.printf("%2d ", cards[i]);
//			if((i + 1) % 13 == 0) { 
//				System.out.println();
//			}
//		}
		
//		특수문자와 함께 섞음
		for(int i=0; i<cards.length; i++) {
//			System.out.printf("%2d ", cards[i]); //"%2d "
			System.out.printf("%s%2s ", symbol[cards[i] / 13], number[cards[i] % 13]);
//			숫자 13개를 출력하고 줄을 바꾼다.
			if((i + 1) % 13 == 0) { //한줄에 n개 이상 출력할 때 쓰기.
				System.out.println();
			}
		}
	}

}
