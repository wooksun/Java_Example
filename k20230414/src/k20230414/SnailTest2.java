package k20230414;

import java.util.Scanner;

public class SnailTest2 {

	public static void main(String[] args) {

//		달팽이 예제 중앙부터 3시방향으로 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("행렬의 차수를 입력하세요: ");
		int row = sc.nextInt();

		int[][] a = new int[row][row];
		int n = 1; // 배열에 채워질 숫자를 1씩 증가시킬 변수
		int s = 1; // 행과 열이 1또는 -1씩 증가 및 감소 처리에 사용할 변수
		int i = row / 2; // 행 %2
		int j = row / 2; // 열 %2
		int k = 0; // 반복문의 반복 횟수 제어에 사용하는 변수
		a[i][j] = n;
//		boolean flag = false;

		EXIT: //while (true)반복에 레이블을 지정한다. => boolean flag = false;와 flag = true; /  if (flag) { }를 주석처리 해주고, break EXIT;를 넣어 실행
		while (true) {
			k++; // 0이면 for문 조건 만족하지 못하기 때문에 k++; / 세시방향부터 채우기
			for (int p = 1; p <= k; p++) { // 행 방향 숫자 채우기
				if (++n > Math.pow(row, 2)) {
//					flag = true;
//					break; //for (int p = 1; p <= k; p++) 반복을 탈출 => if(flag)로 감
					break EXIT; //break뒤에 레이블을 적어주면 레이블이 지정된 반복을 탈출한다. => while(true)를 탈출
				}
				j += s;
				a[i][j] = n;
			}

//			if (flag) { // flag는 위의 if문에서 true로 나온 값이기 때문에 if(falg) = if(true)와 같다.
//				break;
//			}

			for (int p = 1; p <= k; p++) {// 열 방향 숫자 채우기
				i += s;
				a[i][j] = ++n;
			}
			s *= -1; // 부호 변경
//			k++; //3시 방향부터 채우기 k++ 주석 지우면, 9시 방향부터 채우기
		}

		for (i = 0; i < a.length; i++) { // 출력하는 코드
			for (j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

	}

}
