package k20230411;

public class WhileTest {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i=1; i<=10; i++) {
			sum+= i;
		}
		System.out.println("1부터 10의 합계 :" + sum);
		
//		반복 최초 진입시 조건이 거짓이면 {} 블록을 실행하지 않음.
//		while(조건식) {
//			조건식이 참인 동안 반복할 문장;
//			...;
//		}
		
		sum = 0;
		int i = 1;
		while(i<=10) {
			sum += i;
			i++;
//			sum += i++; 간략히 가능
		}
		System.out.println("1부터 10의 합계 :" + sum);
		
//		반복 최초 진입 시, 조건이 거짓이라도 do{ }블록을 한번은 실행한다.
//		=> i=1; i>10 조건이 있을 때, while은 조건이 맞지않아 반복을 실행하지 않아 0이 찍힌다.
//		=>do while은 최초 진입 시 i의 값이 1이기에, 1이 한번찍힌 상태로 조건을 봄 -> do while은 결과 1이 찍힘
//		do {
//			조건식이 참인 동안 반복할 문장;
//			...;
//		} while(조건식); 
		
		sum = 0;
		i = 1;
		do {
			sum += i++;
		} while(i<=10);
		System.out.println("1부터 10의 합계 :" + sum);
		
	}

}
