package k20230410;

public class StarTest {

	public static void main(String[] args) {
		
//		* 찍기
		
		for(int i=0; i<5; i++) { //전체 줄 수를 제어
			for(int j=0; j<=i; j++) {
//				System.out.printf("i = %d, j = %d\n", i, j); 
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============================");
		
		
//		* 찍기 역순
		for(int i=0; i<5; i++) { 
			for(int j=0; j<=4-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============================");
		
		
		
//		    *
//		   **
//		  ***
//		 ****
//		*****
		for(int i=0; i<5; i++) { 
//			공백
			for(int j=0; j<=3-i; j++) { //4-i가 되면 -1, j=0을 만족하지 못함.
				System.out.print(" ");
			}
			
//			별
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============================");
		
		
//		*****
//		 ****
//		  ***
//		   **
//		    *
		
		for(int i=0; i<5; i++) { 
			for(int j=0; j<=i-1; j++) { 
				System.out.print(" ");
			}
			for(int j=0; j<=4-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============================");
		
		
//		*        *   8칸 10-8
//		**      **   6칸 10-6
//		***    ***	 4칸 10-4
//		****  ****	 2칸 10-2
//		**********	 10칸 10
		
		for(int i=0; i<5; i++) { 
//			별
			for(int j=0; j<=i; j++) { 
				System.out.print("*");
			}
//			공백
			for(int j=0; j<7-i*2; j++) {
				System.out.print(" ");
			}
//			별
			for(int j=0; j<=i; j++) {
				if(j != 4) { //if문을 쓰지 않으면 마지막 별에 한개가 더 찍히게 됨.
					System.out.print("*");					
				}
			}
			System.out.println();
		}
		System.out.println("==============================");
		
	}

}
