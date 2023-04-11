package k20230406;

import java.util.Random;
import java.util.Scanner;

public class MukJiiBba {

	public static void main(String[] args) {
//		이기는 경우: cpu=1, user=2 / cpu=2, user=3 / cpu=3, user=1
//		지는 경우 : cpu=1, user=3 / cpu=2, user=1 / cpu=3, user=2
//		가위(1), 바위(2), 보(3)
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(1), 바위(2), 보(3): ");
		int user = sc.nextInt();
		
		Random random = new Random();
		int cpu = random.nextInt(3)+1;
		System.out.println(cpu);
		
//		내가 짠 코드
		if(user == cpu) {
			System.out.println("비겼습니다.");
		} else if(user == 1 && cpu == 2) {
			System.out.println("당신이 졌습니다.");
		} else if(user == 2 && cpu ==3) {
			System.out.println("당신이 졌습니다.");
		} else {
			System.out.println("당신이 이겼습니다.");
		}
		
//		강사님 코드
		if(cpu == user) {
			System.out.println("비겼다.");
		} else if (cpu==1 && user==2 || cpu==2 && user==3 || cpu==3 && user==1) {
			System.out.println("이겼다.");
		} else {
			System.out.println("졌다.");
		}
			
	
		
		
	}

}
