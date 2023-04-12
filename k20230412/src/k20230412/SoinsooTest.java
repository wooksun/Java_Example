package k20230412;

import java.util.Scanner;

public class SoinsooTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("소인수 분해 할 숫자를 입력하세요 : ");
			int n = sc.nextInt();
			if (n < 2) {
				break;
			}
			
//		소인수 분해
			int[] s = new int[20];
			int number = n;
			int c = 0; // s 배열의 인덱스. 소인수의 개수
			
			while(true) {
				int k = 2; //소인수 분해를 시작하는 숫자 초기화
				
				while(true) {
					int r = n % k;
					if(r == 0) { //소인수 분해가 되었는가?
						break;
					}
//					소인수 분해가 되지 않았다면 k를 1증가 시킨 후 , 다시 소인수 분해를 실행
					k++;
				}
				
//				소인수 분해가 되었으면 s배열에 소인수를 넣어준다.
				s[c++] = k;
				
//				다음 소인수를 얻기위해 n에 n을 k로 나눈 몫을 넣어준다.
				n /= k;
				if(n==1) { //소인수분해가 끝났는가? 5/5 나눠 몫이 1일 경우
					break;
				}
			}
			
//			n이 소수면 소수라고 출력, 소수가 아니면 분해된 소인수 출력
//			소인수의 개수(c)가 1개라면, 자기 자신으로 나눠 떨어진 것을 의미 = 소수이다.
			if(c==1) { //n이 소수인가?
				System.out.println(number + "는(은) 소수입니다.");
			}else {
//				소수가 아니면, 소인수 출력
				System.out.print(number + " = ");
				for(int y=0; y<c-1; y++) {
					System.out.print(s[y] + " * ");
				}
				System.out.println(s[c-1]);
			}
			
			
//			n 20 => 2*2*5
//			n		k 		몫		나머지 		s[c]=k
//			20	/	2	=	10	...		0		s[0]=2
//			10	/	2	=	5	...		0		s[1]=2
//			5	/	2	=	2	...		1		나머지가 1 -> 소인수분해가 되지않음. k+1
//					3	=	1	...		2		k+1
//					4	=	1	...		1		k+1
//					5 	=	1	...		0		s[2]=5
			
//			n		k 		몫		나머지 		s[c]=k
//			132	/	2	=	66	...		0		s[0]=2
//			66	/	2	=	33	...		0		s[1]=2
//			33	/	2	=	16	...		1		나머지가 1 -> 소인수분해가 되지않음. k+1
//					3	=	11	...		0		s[2]=3
//			11	/	2	=	5	...		1		k+1 / 반복에서 k=2로 돌아감
//					3	=	3	...		2		
//					4	=	2	...		3		
//					5	=	2	...		1		
//					6	=	1	...		5		
//					7	=	1	...		4		
//					8	=	1	...		3		
//					9	=	1	...		2		
//					10	=	1	...		1		
//					11	=	1	...		0		s[3]=11		

		}
		System.out.println("프로그램 종료");
	}

}
