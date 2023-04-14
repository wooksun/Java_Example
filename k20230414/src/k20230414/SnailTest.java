package k20230414;

import java.util.Scanner;

public class SnailTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("행렬의 차수를 입력하세요: ");
		int row = sc.nextInt();

		int[][] a = new int[row][row];
		int n = 0; // 배열에 채워질 숫자를 1씩 증가시킬 변수
		int s = 1; // 행과 열이 1또는 -1씩 증가 및 감소 처리에 사용할 변수
		int i = 0; // 행
		int j = -1; // 열
		int k = row; // 반복문의 반복 횟수 제어에 사용하는 변수

		while (true) {
			for (int p = 1; p <= k; p++) { //행 방향 숫자 채우기, (1)a[0][4]실행, (3)a[4][3]실행, (5)a[1][1]실행, (7)a[3][2]실행, (9)a[2][2]로 마무리
				j += s;
				a[i][j] = ++n;
			}
			
			if (--k <= 0) {
				break;
			}
			
			for (int p = 1; p <= k; p++) {// 열 방향 숫자 채우기, (2)a[1][4]실행, (4)a[3][0]실행, (6)a[2][3]실행, (8)a[2][1]실행
				i += s;
				a[i][j] = ++n;
			}
			s *= -1; // 부호 변경
		}

		for (i = 0; i < a.length; i++) { // 출력하는 코드
			for (j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

	}

}
