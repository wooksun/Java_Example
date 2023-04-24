package com.tjoeun.collectionTest;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetTest2 {

	public static void main(String[] args) {
		
		TreeSet<String> tset = new TreeSet<>();
		
		tset.add("홍길동");
		System.out.println(tset.size() + " : " + tset);
		tset.add("임꺽정");
		System.out.println(tset.size() + " : " + tset);
		tset.add("장길산");
		System.out.println(tset.size() + " : " + tset);
		tset.add("일지매");
		System.out.println(tset.size() + " : " + tset);
		tset.add("홍길동");
		System.out.println(tset.size() + " : " + tset);
		System.out.println("===============================");
		
		ArrayList<String> list = new ArrayList<>();
//		향상된 for를 사용해서 TreeSet이나 TreeSet 객체의 데이터를 1개씩 얻어올 수 있다.
		for(String str : tset) {
			System.out.println("향상된 for 사용 : " + str);
			list.add(str);
		}
		System.out.println("===============================");
		for(int i=0;i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("===============================");
		
		
//		Iterator 인터페이스 : TreeSet이나 TreeSet과 같이 입력하는 순서와 저장되는 순서가 달라서 get(), set() 메소드를 사용할 수 없는 객체를 분리한다. 
//		TreeSet이나 TreeSet 객체에 iterator() 메소드를 실행하면 데이터 단위로 분리된다.
		Iterator<String> iterator = tset.iterator(); //두부를 한모한모 나누는 행위
		
		//hasNext() 메소드는 Iterator 인터페이스 객체에 다음에 읽을 데이터가 있으면 true, 없으면 false를 리턴.
		while(iterator.hasNext()) { //Iterator 인터페이스 객체에 데이터가 있는 동안 반복한다.
//			next()메소드는 Iterator 인터페이스 객체의 다음 데이터를 얻어온다.
			System.out.println("Iterator 인터페이스 객체 사용 : " + iterator.next());
			
		}
		System.out.println("===============================");
		
		tset.remove("홍길동"); //여기 이후로 "홍길동"이 지워짐.
		System.out.println(tset.size() + " : " + tset);
		tset.clear(); //여기 이후로 모든 저장소가 지워짐.
		System.out.println(tset.size() + " : " + tset);
		System.out.println("===============================");
	}

}
