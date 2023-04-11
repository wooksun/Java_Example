package k20230410;

import java.util.Arrays;

public class SelectionSortTest {

	public static void main(String[] args) {

//		i	j
//		0	1	2	3	4
//		1		2	3	4
//		2			3	4
//		3				4

//		for(int i=0; i<4; i++) {
//			for(int j=i+1; j<5; j++) {
//				System.out.printf("i = %d, j = %d\n", i, j);
//			}
//			System.out.println();
//		}

//		내가 짠 코드 (맞았음)

		int[] data = { 8, 3, 4, 9, 1 };
		for (int i = 0; i < data.length - 1; i++) { // 선택 위치, 회전수
			for (int j = i + 1; j < data.length; j++) { // 선택 위치의 데이터와 비교할 대상이 되는 데이터 위치

//				오름차순 정렬 [1,3,4,8,9]
//				앞(i번째)의 데이터가 뒤(j번째)의 데이터보다 크다면 두 기억장소의 값을 교환한다. 

//				내림차순 정렬 [9,8,4,3,1]
//				앞(i번째)의 데이터가 뒤(j번째)의 데이터보다 작다면 두 기억장소의 값을 교환한다.
//				부등호가 ">"면 오름차순 정렬, "<"면 내림차순 정렬이 된다.

				if (data[i] > data[j]) {
					int tmp = data[i];
					data[i] = data[j];
					data[j] = tmp;
				}
				System.out.println(Arrays.toString(data));
			} // 회전종료
			System.out.println(i + 1 + "회전 결과:" + Arrays.toString(data));
		} // 정렬종료
	}

}
