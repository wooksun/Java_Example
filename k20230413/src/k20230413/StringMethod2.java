package k20230413;

import java.util.Arrays;
import java.util.Scanner;

public class StringMethod2 {

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
		System.out.println("==========================================");
		
//		indexOf(), lastIndexOf() 메소드의 인수로 지정한 문자열이 없으면 -1을 리턴한다.
//		indexOf(), lastIndexOf() 메소드의 실행결과가 0이상이면 인수로 지정된 문자열이 포함되었다는 의미로 사용.
		System.out.println(str.indexOf("It")); //-1
		System.out.println(str.lastIndexOf("IT"));  //-1
		System.out.println("==========================================");
		
		
//		contains() : 문자열에 인수로 지정한 문자열이 포함되어 있으면 true, 없으면 false를 리턴
		str = "itTjoeunit"; 
		System.out.println(str.contains("it")); //true
		System.out.println(str.contains("IT")); //false
		System.out.println("==========================================");
		
		
//		split("구분자") : 
		str = "abc 123 가나다";
		System.out.println(str.split(" ")); //[Ljava.lang.String;@6d78f375
		System.out.println(str.split(" ").length); //3
		System.out.println(Arrays.toString(str.split(" "))); //[abc, 123, 가나다]
		System.out.println(str.split(" ")[0]); //abc
		System.out.println("==========================================");
		
		
//		replace(a,b) : 문자열의 모든 a를 b로 치환한다.		
		str = "itTjoeunit"; 
		System.out.println(str.replace("i", "아이")); //아이tTjoeun아이t
		System.out.println("==========================================");
		
		
//		repeat() : 문자열을 인수로 지정한 개수만큼 반복한다.
		str = "8304223185600";
		System.out.println(str.substring(0, 7) + "*".repeat(6)); //8304223******
		System.out.println("==========================================");

		
//		내가 짠 코드
		str = "123-45678-12345";
		System.out.println(str.substring(0, 4) + "*****" + str.substring(9, 15)); 
		System.out.println(str.substring(0, 4) + "*".repeat(5) + str.substring(9, 15)); 
		System.out.println("==========================================");
		
		
//		강사님코드
		str = "123-45678-12345";
//		준비작업
		System.out.println("앞쪽 '-'의 index : " + str.indexOf("-")); //3
		System.out.println("뒤쪽 '-'의 index : " + str.lastIndexOf("-")); //9
//		String code = str.substring(4, 9); //45678
		String code = str.substring(str.indexOf("-") + 1, str.lastIndexOf("-")); //45678 -> 숫자가 줄거나 늘어나도, - 사이의 값 출력 
		System.out.println(code);
		System.out.println("==========================================");
		
//		본작업 1방법 substring()
		String newCode =  str.substring(0, str.indexOf("-") + 1); //123-
//		for(int i=0; i<code.length();i++) { //123-*****
//			newCode += "*"; //객체가 계속 만들어짐 => 시간소요 
//		}
//		newCode += str.substring(str.lastIndexOf("-")); //123-*****-12345
//		System.out.println(newCode);
//		System.out.println("==========================================");
		

//		본작업 2방법 repeat()
		newCode += "*".repeat(code.length());
		newCode += str.substring(str.lastIndexOf("-")); //123-*****-12345
		System.out.println(newCode);
//		System.out.println("==========================================");
		
		
//		본작업 3방법 split()
		String[] newCode2 = str.split("-"); //'-' 제거
		System.out.println(Arrays.toString(newCode2)); //[123, 45678, 12345]
		System.out.printf("%s-%s-%s\n",newCode2[0], "*".repeat(newCode2[1].length()), newCode2[2]); //123-*****-12345
		newCode = String.format("%s-%s-%s",newCode2[0], "*".repeat(newCode2[1].length()), newCode2[2]); //123-*****-12345
		System.out.println(newCode);
		
	}

}
