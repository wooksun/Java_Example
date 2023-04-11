package k20230407;

public class ForTest {

	public static void main(String[] args) {
		
//		for { } 블록을 조건이 만족하는 동안 반복해서 실행한다. 
//		반복횟수가 알려져있는 경우 주로 사용한다.
//		반복문 {} 밖에 코드작성 시, 빨간줄이 뜨고 remove라고 뜨면 반복문의 '무한루프'가 도는것.
		
//		형식 : for (자료형 변수이름=초기치; 조건식; 증감치) {
//			조건이 참(true)인 동안 실행할 문장;
//			...;
//		}
		
		int sum = 0;
		for(int i=1; i<=10; i++) {
//			System.out.println(i);
//			대입연산자 : "="과 같이 사용한다. +=, -=, *=, /=, %= ...
			sum += i; //대입연산자, sum = sum+i;와 같다.
		}
		System.out.println("1 ~ 10의 합계 = " + sum);
		
//		증감연산자 : ++(1증가), --(1감소) => 단항 연산자
//		a++ : 사용 후 1증가, a 변수에 저장된 값을 사용(연산)하고, ";"만나서 문장이 종료될  때 1증가.
//		++a : 1증가 후 사용, a에 저장된 값을 1증가 시키고, 사용한다.
//		a-- : 사용 후 1감소
//		--a : 1감소 후 사용
//		참고용 사이트 : https://hs0955.tistory.com/165
		
		int a = 1, b, c; //int b; int c;를 한줄로 
		b = a++;
		c = ++a;
		System.out.println("a = " + a + ", b = " + b + ", c = " + c); //내 답: a=1 b=1 c=2
//		실행결과 : a=3, b=1, c=3
		
		int d = 1, e;
		e = ++d + ++d + ++d + ++d;
		System.out.println("d = " + d + ", e = " + e);
		
	}

}
