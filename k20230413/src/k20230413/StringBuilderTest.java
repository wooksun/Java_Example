package k20230413;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		String java = new String("java");
		System.out.println(System.identityHashCode(java)); //1239731077 -> 잘 쓰이지 않지만, 데이터 객체 구분할 때 사용
		
		String jsp = new String("jsp");
		System.out.println(System.identityHashCode(jsp)); //557041912
		System.out.println("============================");
		
		
//		String을 연결하면 기존의 String에 연결되는 것이 아니고 새로운 String 객체가 생성된다.
		java += jsp; //javajsp
		System.out.println(java);
		System.out.println(System.identityHashCode(java)); //1134712904 -> hashCode가 바뀜
		System.out.println("============================");
		
		
//		concat("문자열") : 문자열을 이어주는 문장
		java = java.concat(jsp); //javajspjsp
		System.out.println(java); 
		System.out.println(System.identityHashCode(java)); //985922955 -> hashCode가 바뀜
		System.out.println("============================");
		
//		실행시간
		String str = "";
		long start = System.currentTimeMillis(); //시작시간
		for (int i=0; i<100000; i++) { 
			str += "꽝";
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis() - start)); //(실제 꽝이 100000번 실행되어 찍히는 시간)실행시간 : 2039
		System.out.println("String을 사용해서 꽝 10만번");
		System.out.println("============================");
		
//		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
//		StringBuilder 클래스는 내부적으로 가변적인 char[] 배열을 멤버변수로 가진다.
//		문자열을 연결할 때, String 클래스처럼 문자열을 새로 만들지 않고, char[] 배열을 변경한다. -> 매번 new가 되는 개념
		String html = new String("html");
		String css = new String("css");
		
		StringBuilder builder = new StringBuilder(html); //html
		System.out.println(builder);
		System.out.println(System.identityHashCode(builder)); //1435804085
		
//		append() 메소드로 StringBuilder 클래스 객체에 문자열을 연결한다.
		builder.append(css); //htmlcss
		System.out.println(builder);
		System.out.println(System.identityHashCode(builder));  //1435804085 -> hashCode가 같음
		System.out.println("============================");
		
//		실행시간
		StringBuilder str2 = new StringBuilder("");
		str = "";
		start = System.currentTimeMillis(); //시작시간
		for (int i=0; i<100000; i++) { 
			str2.append("꽝");
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis() - start)); //실행시간 : 1
		System.out.println("StringBuilder를 사용해서 꽝 10만번");
		System.out.println("============================");
		
//		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		StringBuffer는 멀티 스레드 프로그램에서 동기화(순서를 정한다.)를 보장하므로(순서를 보장)
//		멀티스레드 프로그램은 StringBuffer를 사용하고, 싱글(단일) 스레드 프로그램은 StringBuilder를 사용하는 것을 권장한다.
		StringBuffer str3 = new StringBuffer("");
		start = System.currentTimeMillis(); //시작시간
		for (int i=0; i<100000; i++) { 
			str3.append("꽝");
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis() - start)); //실행시간 : 3
		System.out.println("StringBuffer를 사용해서 꽝 10만번");
		System.out.println("============================");
		
//		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		String str4 = "개울가에\n올챙이\n한마리\n꼬물꼬물\n헤엄치다"; 
		System.out.println(str4);
		System.out.println("============================");
//		text block = > JDK13에서 추가
//		문자열을 """와 """사이에 입력하면 \n을 사용하지 않고도 줄바꿈되는 여러줄 문자열을 만들 수 있다.
		String strBlock = """
				개울가에
				올챙이
				한마리
				꼬물꼬물
				헤엄치다""";
		System.out.println(strBlock);
		
		
	}

}
