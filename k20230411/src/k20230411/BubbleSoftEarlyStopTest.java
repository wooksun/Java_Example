package k20230411;

import java.util.Arrays;

public class BubbleSoftEarlyStopTest {

	public static void main(String[] args) {
		
//		int[] data = { 8, 3, 4, 9, 1 }; -> 4회전
//		정렬이 1회전만 했을 때, 1회전 한 부분만 보이고 '조기종료' 시키도록 하는 예제.
		int[] data = { 9, 1, 3, 4, 8 }; //-> 1회전만 함. 인덱스 0번째에 가장 큰 수가 있으므로.
		
		for (int i = 0; i < data.length - 1; i++) { 
//			flag라는 이름이 변수를 만들어, 0으로 초기화한다.
//			boolean isFlag = true;
			int flag = 0;
			
			
			for (int j = 0; j < data.length - 1 - i; j++) { 
				if (data[j] > data[j+1]) {
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
					
//					값 교환이 이루어지면 flag 변수에 1을 저장한다. (boolean시 1이 아닌, false)
//					isFlag = flase;
					flag = 1;
					
					
				}
			} // 회전종료
			
//			정렬이 완료된 경우 값교환 작업이 진행되지 않기 때문에 flag 변수는 0을 유지한다. 
//			boolean => if(isFlag) {}
			if(flag==0) {
//				정렬이 완료된 상태라면 더 이상 회전할 필요가 없으므로, i반복을 탈출한다.
				break;
			}

			
			System.out.println(i + 1 + "회전 결과:" + Arrays.toString(data));
		} // 정렬종료
		
	}

}
