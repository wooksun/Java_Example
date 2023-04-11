package homework;

import java.util.Random;
import java.util.Scanner;

public class LottoTest2 {

	public static void main(String[] args) {

		Random random = new Random();
		int[] lotto = new int[45];
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = i+1;
		}

//		복권 구매 금액을 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("복권 구매 금액입력: ");
		int num = sc.nextInt();
		
//		입력한 금액만큼 반복하며, 자동 로또번호를 생성한다
		for(int j=0; j<num/1000; j++) {
			for(int i=0; i<1000000; i++) {
				int r = random.nextInt(44)+1; 
				
				int tmp = lotto[0];
				lotto[0] = lotto[r];
				lotto[r] = tmp;
			}
			
			System.out.printf("%3d GAME: ", j+1);
			for(int k=0; k<6; k++) {
				System.out.printf("%2d ", lotto[k]);
			}
			System.out.println();
			if((j+1)% 5 == 0) {
				System.out.println("======================"); //5천원(5줄)단위째에 ====가 뜸.
			}
		}
		
			
		
	}

}
