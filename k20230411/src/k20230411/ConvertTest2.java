package k20230411;

import java.util.Scanner;

public class ConvertTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("2진수로 변환할 10진수를 입력하세요 : ");
		int dec = sc.nextInt();
		int number = dec; 
		
		int[] bin = new int[8]; //결과를 기억할 배열
		int index = 0; //배열의 인덱스로 사용할 변수
		
//		입력되는 10진수의 크기에 따라 반복횟수가 달라지므로 무한루프로 처리.
		while(true) {
			int m = dec / 2; //몫
			int r = dec % 2; //나머지
			bin[index++] = r; //2진수를 기억할 배열에 나머지를 넣어준다.
//			bin[index++] -> bin[index] , index++; 결합
			
//			dec에 저장된 10진수를 2로 나눈 몫이 0이되면 무한루프 탈출.
			if(m == 0) {
				break;
			}
//			이전 작업의 몫인 m이 다음 작업의 dec가 된다.
			dec = m;
		}
		System.out.print(number + "를 2진수로 변환하면"); //00011010 -> 앞자리 000 모두 출력
		for(int i=bin.length-1; i>=0; i--) {//i는 7로 시작해서 i-- -> 6,5,4,...로 줄어듦
			System.out.print(bin[i]);
		}
		System.out.println(" 입니다.");
		
		System.out.print(number + "를 2진수로 변환하면");//11010 -> int i = index-1을 사용하여, 앞자리 000을 없애줌
		for(int i=index - 1; i>=0; i--) {//i는 7로 시작해서 i-- -> 6,5,4,...로 줄어듦
			System.out.print(bin[i]);
		}
		System.out.println(" 입니다.");
	}

}
