package k20230412;

import java.util.Scanner;

public class StringMethod {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = "    tjoeunit    "; //앞뒤 공백 4칸(8), 글자 8
//		length() : 문자열을 구성하는 문자의 개수를 얻어온다.
		System.out.println("문자 개수 : " +str.length());
	
		
//		불필요한 공백제거 : trim()
//		trim() : 문자열 앞, 뒤의 불필요한 빈칸(공백)을 제거한다.
		str = "    tjoeunit    ";
		System.out.println(str.trim());
		System.out.println("불필요한 빈칸을 제거한 문자 개수 : "+str.trim().length());
		System.out.println("==========================================");
		
		
//		System.out.print("문자열 입력 : ");
//		String name = sc.nextLine().trim(); //사용자가 공백을 두고 입력하여도, trim으로 공백제거
//		System.out.println(name);
//		System.out.println("==========================================");
		
		
//		chatAt(index) : 문자열에서 지정된 index번째 위치의 문자를 얻어온다.
//		index는 0부터 시작.
		str = "8304223185600"; //6번째 수는 3
		System.out.println("성별: " + str.charAt(6));
		
//		키보드로 1문자만 입력받으려면 아래와 같이 실행한다.
//		char ch = sc.nextLine().charAt(0); //charat(0) 0번째 문자 출력
//		System.out.println(ch);
		System.out.println("==========================================");
		
//		toUpperCase() : 영문자를 무조건 대문자로 변환
//		toLowerCase() : 영문자를 무조건 소문자로 변환
		str = "TjoeunIT";
		System.out.println("무조건 대문자로 : " + str.toUpperCase());
		System.out.println("무조건 소문자로 : " + str.toLowerCase());
		System.out.println("==========================================");
		
//		substring(a) : 문자열의 a번째 index의 문자부터 문자열의 끝까지 (제한 x) 얻어온다.
//		substring(a,b) :  문자열의 a번째 index의 문자부터 b-1번째 index의 문자까지 얻어온다.
		str = "8304223185600";
		System.out.println("주민등록번호 뒷자리 : " + str.substring(6)); //주민번호 뒷자리만 출력 => 3185600
		System.out.println(str.substring(0, 7) + "*******");  //b-1번째 index의 문자까지라서 (0,7)을 적음 => 8304223*******
		System.out.println("생년 : "+str.substring(0, 2));  
		System.out.println("월 : "+str.substring(2, 4));  
		System.out.println("일 : "+str.substring(4, 6));  
		System.out.println("==========================================");
		
		
//		indexOf() : 문자열의 왼쪽부터 검색해서 인수로 지정한 문자열이 "최초로" 나타나는 index를 얻어온다.
//		lastIndexOf() : 문자열의 오른쪽부터 검색해서 인수로 지정한 문자열이 "최초로" 나타나는 index를 얻어온다.
		str = "itTjoeunit"; //012345678
		System.out.println(str.indexOf("it")); //0
		System.out.println(str.lastIndexOf("it")); //8
		
	}

}
