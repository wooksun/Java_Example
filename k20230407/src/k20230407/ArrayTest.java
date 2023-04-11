package k20230407;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

	public static void main(String[] args) {
		
//		배열이란 같은 이름으로 여러개의 기억 장소를 만든다. 기억장소 구분은 인덱스(index)를 이용한다.
		
//		배열을 선언만 한다. 
//		자료형[] 배열이름 = new 자료형[인덱스]; //인덱스로 지정한 크기만큼 배열을 만든다.
//		자료형 배열이름[] = new 자료형[인덱스];
		
//		배열을 선언만하면 기본 초기화가 실행된다.
//		숫자는 0, 문자는 공백, boolean은 false, 기본 자료형을 제외한 나머지(클래스로 만든 객체)는 null * null은 아무것도 없는 것 *
		int[] data = new int[5]; //new 자료형으로 배열을 하게되면, 기본초기화가 실행되어 껍데기만 실행됨(빈내용)
		System.out.println(Arrays.toString(data));
		
//		배열을 선언하고, 초기치로 초기화 한다.
//		자료형 배열이름[] = {초기치}; -> 초기치로 지정된 데이터의 개수만큼 배열을 선언하고 초기화시킨다.
//		자료형[] 배열이름 = {초기치};
		
		System.out.println("==========배열==========");
		String name[] = {"홍길동", "임꺽정", "장길산", "일지매" }; //new 자료형 배열이 아니라서, {} 내용을 읽어들임
		System.out.println(Arrays.toString(name));
		
		System.out.print(name[0] + ", ");
		System.out.print(name[1] + ", ");
		System.out.print(name[2] + ", ");
		System.out.println(name[3]);
		System.out.println("==========for==========");
		
//		★ 위의 print를 하나씪 하는 수고를 덜 수 있게, for(반복문)으로 배열을 출력 ★
//		for(int i=0; i<4; i++) {
//			System.out.println(name[i]);
//		}
		
		
//		배열이름.length : 배열의 크기를 얻어온다. -> 배열이 늘어날 때, for문의 조건식을 수정할 수고가 줄어든다.
		System.out.println("배열의 크기 : " + name.length ); //name[]의 배열 크기
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]);
		}
		
		System.out.println("========향상된 for===========");
		
//		향상된 for : 배열 전체를 대상으로 작업할 경우 사용하면 편리하다.
//		for (배열의 자료형 변수이름 : 배열이름) { 
//			반복할 문장;
//			...;
//		}
		
//		name 배열의 0번째 인덱스에 저장된 데이터가 str 변수에 저장된 후 반복이 시작,
//		name 배열의 마지막 인덱스의 저장된 데이터가 str 변수에 저장된 후 처리되면 반복종료.
		for (String str : name) { 
			System.out.println(str);
		}
		
		
		
		
		System.out.println("=========문제만들기1==========");
		
		
//		주사위를 10번 굴려서 발생된 눈의 개수를 센다.
		Random random = new Random();
//		주사위의 눈의 개수를 기억할 변수를 선언하고, 0으로 초기화한다.
		int  num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
		
		for(int i=0; i<10; i++) {
//			주사위 눈을 무작위로 발생시킨다.
//			System.out.println(random.nextInt(6)+1); //random.nextInt(6)에 +1을 하는 이유는, 0부터 5까지 찍히기 때문.
			
			int dice = random.nextInt(6)+1;
			System.out.println(dice);
			
//			주사위 눈의 개수를 센다.
			/*
			 * if(dice == 1) { // num1 = num1 + 1; // num1 += 1; //num1 = num1 + 1; num1++;
			 * } else if(dice == 2) { num2++; }else if(dice == 3) { num3++; }else if(dice ==
			 * 4) { num4++; }else if(dice == 5) { num5++; }else { num6++; }
			 */
			
			
			switch(dice) {
			case 1: 
				num1++;
				break;
			case 2: 
				num2++;
				break;
			case 3: 
				num3++;
				break;
			case 4: 
				num4++;
				break;
			case 5: 
				num5++;
				break;
			case 6: 
				num6++;
			}
			
			
		} //for
		
		
		
		System.out.println("=========문제만들기2==========");
//		주사위 눈의 개수를 출력한다.
		System.out.println("1의 개수 : " + num1);
		System.out.println("2의 개수 : " + num2);
		System.out.println("3의 개수 : " + num3);
		System.out.println("4의 개수 : " + num4);
		System.out.println("5의 개수 : " + num5);
		System.out.println("6의 개수 : " + num6);
	}

}
