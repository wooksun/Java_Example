package k20230410;

import java.util.Random;

public class PowerballTest {

	public static void main(String[] args) {
//		추첨규칙 : 1 ~ 69 중에서 5개 선택, 1~26사이에서 1개
		
//		추첨기를 만든다. (배열 1~69)
		int[] powerball = new int[69];
		
//		추첨기에 공을 넣는다.
		System.out.println("==========섞기 전=========");
		for(int i=0; i<powerball.length; i++) {
			powerball[i] = i+1;
		}
		
		show(powerball); //중복코드 드래그하여 우클릭 -> refactor -> Ex
			
//		섞는다.
		System.out.println("\n==========섞은 후=========");
		Random random = new Random();
		for(int i=0; i<1000000; i++) {
			int r = random.nextInt(68)+1; 
			
			int tmp = powerball[0];
			powerball[0] = powerball[r];
			powerball[r] = tmp;
		}
		
		show(powerball);
		System.out.println("\n==========1등번호 출력=========");
		
//		1등 번호를 출력한다. (앞에 6개 1등번호, 7번째 인덱스 보너스)
		System.out.print("흰공 : ");
		for(int i=0; i<5; i++) {
			System.out.printf("%2d ", powerball[i]);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("빨간공: %2d ", random.nextInt(26)+1); //random.nextInt(26)+1로 함. 
		
	}

	private static void show(int[] powerball) {
		for(int i=0; i<powerball.length; i++) {
			System.out.printf("%2d ", powerball[i]);
			if((i+1)% 10 == 0) {
				System.out.println();
			}
		}
	}
	
//		파워볼 1~60번까지 5개 랜덤, 1~20번 중 1개 랜덤
	

}
