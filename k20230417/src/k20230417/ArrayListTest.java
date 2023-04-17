package k20230417;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {

//		배열은 한번 선언하면, 프로그램에서 크기를 변경할 수 없다.
		int[] data = new int[10];
		for (int i = 0; i < 10; i++) {
			data[i] = i + 1;
		}
		for (int i = 0; i < 10; i++) { ////출력문
			System.out.printf("data[%d] = %d\n", i, data[i]); //data[0] = 1, data[1] = 2 ...data[9] = 10
		}
//		for (int i=10; i<20; i++) { //오류 
//			data[i] = i + 1;
//		}
		
//		배열은 인덱스가 배열의 범위를 벗어나면 ArrayIndexOutOfBoundsException이 발생된다.
		System.out.println("====================================");
		
		
//		★ ArrayList
//		ArrayList : 데이터가 삽입되면 자동으로 크기가 커지고, 제거되면 자동으로 크기가 작아진다.
//		중간에 데이터가 삽입되면, 삽입되는 위치부터 모든 데이터가 모두 뒤로 이동되고,
//		중간의 데이터가 제거되면 제거된 데이터 다음 위치부터 모든 데이터가 앞으로 이동된다.
		
//		ArrayList list = new ArrayList(); //JDK1.4버전 이전
//		ArrayList<Integer> list = new ArrayList<Integer>(); //JDK 1.5 버전 이후
		
//		<E> : 제네릭이라 부르며, ArrayList에 저장할 데이터의 타입을 반드시 클래스로 적어야한다.
//		=> 기본 자료형을 사용할 수 없다.(boolean, int, char..) => 기본 자료형 데이터를 저장하는 ArrayList를 만들어야 할 경우,
//		기본 자료형을 클래스화 시켜놓은 랩퍼 클래스를 사용해야 한다. => 랩퍼 클래스는 기본 자료형의 첫 문자만 대문자로 바꾸면 된다.
//		단, int는 Integer로, char는 Character를 사용한다.
		
		ArrayList<Integer> list = new ArrayList(); //JDK 1.7 버전 이후
		for(int i=0; i<10; i++) {
			list.add(i + 1);
		}
		for (int i = 0; i < 10; i++) { //출력문
			System.out.printf("list.get(%d) = %d\n", i, list.get(i)); //list.get(0) = 1, list.get(1) = 2 ... list.get(9) = 10
		}
		System.out.println("====================================");
		
		
		for (int i=10; i<20; i++) { //위에서 배열은 오류가 나지만, Array는 오류가 나지않음.
			list.add(i + 1);
		}
		for (int i = 10; i < 20; i++) { //출력문
			System.out.printf("list.get(%d) = %d\n", i, list.get(i)); //list.get(10) = 11, list.get(11) = 12 ... list.get(19) = 20
		}
		
//		ArrayList도 인덱스 범위가 벗어나면, IndexOutOfBoundsException이 발생된다.
//		System.out.println(list.get(20));

	}

}
