package k20230411;

public class Stn {

	public static void main(String[] args) {
		
		int[] data = { 4, 1, 3, 5, 2 };		
//		최대값과 최소값을 기억할 기억장소에 각각 데이터가 저장된 배열의 0번째 인덱스 요소의 값으로 초기화 함.
		int max = data[0];
		int min = data[0];
		
//		i가 1부터 시작하는 이유: data[0]번째부터 시작하기 때문에, 자기 자신끼리 비교해봐야 최대값과 최소값을 판별하는데 전혀 도움되지 않기 때문.
		for(int i=1; i<data.length; i++) {
			if(data[i] > max) {
				max = data[i];
			}else if (data[i] < min) {
				min = data[i];
			}
		}
		System.out.printf("최대값 : %d, 최소값 : %d\n", max, min);
		
//		전체 데이터의 합계를 계산한 후 최대값과 최소값을 뺀다.
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i]; //1,2,3,4,5의 합계
		}
		sum = sum - max - min;
//		sum = sum - (max + min);
//		sum -= max + min;
//		같은 값 9가 나온다.
		double avg = (double)sum / (data.length-2);
		System.out.printf("합계 : %d, 평균 : %f\n", sum, avg);
		

	}

}
