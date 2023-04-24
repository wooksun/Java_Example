package com.tjoeun.collectionTest;

import java.util.HashMap;

public class HashMapTest2 {

	public static void main(String[] args) {
		
		
		HashMap<String, Integer> hmap = new HashMap<>(); //HashMap 객체 생성 
		
		hmap.put("apple", 1000);		
		hmap.put("banana", 2000);
		hmap.put("orange", 3000);
		hmap.put("melon", 20000);
		hmap.put("watermelon", 15000);
		System.out.println(hmap.size() + " : " + hmap); 
		
//		keySet() 메소드는 HashMap에 저장된 데이터의 key만 얻어온다.
		System.out.println(hmap.keySet());
//		values() 메소드는 HashMap에 저장된 데이터의 vlaue만 얻어온다.
		System.out.println(hmap.values());

		
//		HashMap에 저장된 데이터의 key만 얻어와서 ArrayList에 저장하기
//		HashMap에 저장된 데이터의 value만 얻어와서 ArrayList에 저장하기
//		HashMap에 저장된 데이터의 key를 이용해서 value를 얻어와 ArrayList에 저장하기
	}

}
