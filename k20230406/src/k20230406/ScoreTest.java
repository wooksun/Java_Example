package k20230406;

import java.util.Scanner;

public class ScoreTest {

	public static void main(String[] args) {
		
		//세 과목 점수 합산 코드
//		Scanner sc = new Scanner(System.in);
//		System.out.println("세 과목의 점수를 합산하시오.");
//		System.out.print("국어점수: ");
//		int kuk = sc.nextInt();
//		System.out.print("영어점수: ");
//		int eng = sc.nextInt();
//		System.out.print("수학점수: ");
//		int su = sc.nextInt();
//		
//		int sum = kuk+eng+su;
//		
//		if(sum > 50) {
//			System.out.println("합격입니다");
//		} else {
//			System.out.println("불합격입니다.");
//		}
		
		
//		세 과목의 점수를 입력받아, 입력받은 값의 총점과 평균을 구하는 식
//		Scanner sc = new Scanner(System.in);
//		System.out.println("세 과목의 점수를 합산하시오.");
//		System.out.print("국어점수: ");
//		int kuk = sc.nextInt();
//		System.out.print("영어점수: ");
//		int eng = sc.nextInt();
//		System.out.print("수학점수: ");
//		int su = sc.nextInt();
//		
//		int total = kuk+eng+su;
//		double average = total / 3.; //전체 더한 값 total은 정수형 int이므로, 3.으로 소숫점을 나타내기 혹은 변수 앞에 (double) total로 텍스팅
//		System.out.println("총점: " + total + "점, 평균: " + average);
		
		
//		
		Scanner sc = new Scanner(System.in);
		System.out.println("세 과목의 점수를 합산하시오.");
		System.out.print("국어점수: ");
		int kuk = sc.nextInt();
		System.out.print("영어점수: ");
		int eng = sc.nextInt();
		System.out.print("수학점수: ");
		int su = sc.nextInt();
		
		int total = kuk+eng+su;
		double average = total / 3.; 
		
		System.out.println("총점: " + total + "점, 평균: " + average);
		/* if문
		 * // 평균 점수가 90점 이상이면 A if(average >= 90) { System.out.println("A"); }
		 * // 평균 점수가 90점 미만, 80점 이상이면 B if(average < 90 && average >= 80 ) {System.out.println("B"); } 
		 * // 평균 점수가 80점 미만, 70점 이상이면 C if(average < 80 &&average >= 70 ) { System.out.println("C"); } 
		 * // 평균 점수가 70점 미만, 60점 이상이면 D if(average < 70 && average >= 60 ) { System.out.println("D"); } 
		 * // 평균 점수가 60점 미만이면F if(average < 60) { System.out.println("F"); }
		 */
		
//		if문 ex1
//		if (average >= 90) {
//			System.out.println("A");
//		} else if(average >= 80) {
//			System.out.println("B");
//		} else if(average >= 70) {
//			System.out.println("C");
//		} else if(average >= 60) {
//			System.out.println("D");
//		} else {
//			System.out.println("F");
//		}
		
		
		
		
	}

}
