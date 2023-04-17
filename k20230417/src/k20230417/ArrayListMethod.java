package k20230417;

import java.util.ArrayList;

public class ArrayListMethod {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();

//		add(value) : ArrayList의 맨 뒤에 value를 추가한다.
		list.add("최진욱");
		System.out.println(list); //[최진욱]
		list.add("최진욱1");
		System.out.println(list); //[최진욱, 최진욱1]
		System.out.println("=======================");
		
//		size() : ArrayList에 저장된 데이터의 개수를 얻어온다.
		list.add("최진욱2");
		System.out.println(list.size() + " : " + list); //3 : [최진욱, 최진욱1, 최진욱2] => 중복되는 데이터(최진욱)이 들어와도 가능
		System.out.println("=======================");
		
		
//		add(index, value) : ArrayList의 index번째 위치에 value 삽입. //메서드 이름은 같지만, 위의 add와 인수의 개수가 다르다. (오버로딩)
		list.add(1, "손오공");
		System.out.println(list.size() + " : " + list); //4 : [최진욱, 손오공, 최진욱1, 최진욱2]
		System.out.println("=======================");
		
//		set(index, value) : ArrayList의 index번째 위치에 데이터를 value로 수정한다.
		list.set(1, "저팔계");
		System.out.println(list.size() + " : " + list); //4 : [최진욱, 저팔계, 최진욱1, 최진욱2]
		System.out.println("=======================");
		
//		get(index) : ArrayList의 index번째 위치에 데이터를 얻어온다.
		System.out.println(list.get(1)); //저팔계
		System.out.println("=======================");
		
		
//		일반 for
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)); 
//			최진욱
//			저팔계
//			최진욱1
//			최진욱2
		}
		System.out.println("=======================");
		
//		향상된 for
		for (String str : list) { //(ArrayList의 자료형) String (String 변수) str : list)
			System.out.println(str);
//			최진욱
//			저팔계
//			최진욱1
//			최진욱2
		}
		System.out.println("=======================");
		
		
//		제거
//		remove(index) : ArrayList의 index번째 위치에 데이터를 제거한다.
		list.remove(1);
		System.out.println(list.size() + " : " + list); //3 : [최진욱, 최진욱1, 최진욱2] => 저팔계가 제거됨.
		
//		remove(object) : ArrayList의 인수로 지정된 데이터를 제거한다. + 같은 데이터가 있으면 앞의 데이터가 먼저 제거된다.
		list.remove("최진욱1");
		System.out.println(list.size() + " : " + list); //2 : [최진욱, 최진욱1] => 최진욱2가 제거됨
		System.out.println("=======================");
		
//		clear() : ArrayList의 모든 데이터를 제거한다.
		list.clear();
		System.out.println(list.size() + " : " + list); //0 : []
		
		
		
	}

}
