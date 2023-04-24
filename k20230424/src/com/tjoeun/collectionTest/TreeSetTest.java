package com.tjoeun.collectionTest;

import java.util.TreeSet;
import java.util.Random;

public class TreeSetTest {

	public static void main(String[] args) {
		
//		TreeSet은 HashSet과 달리 입력되는 순서와 관계없이 기본적으로 오름차순 정렬되서 저장된다.
//		=> 그 외에는 HashSet과 차이점이 없이, 똑같은 기능을 가진다.
		
		TreeSet<Integer> tset = new TreeSet<>();
		
		tset.add(500);
		
		System.out.println(tset.size() + " : " + tset);
		tset.add(100);
		System.out.println(tset.size() + " : " + tset);
		tset.add(999);
		System.out.println(tset.size() + " : " + tset);
		tset.add(5);
		System.out.println(tset.size() + " : " + tset);
		
		
		tset.remove(500);
		System.out.println(tset.size() + " : " + tset); //3 :[100, 5, 999] => 500이 제거됨
		
		tset.clear();
		System.out.println(tset.size() + " : " + tset); //0 : [] => 전체 제거
		System.out.println("===============================");
		
//		로또 1등 번호
		Random random = new Random();
		
		while(true) {
			int lotto = random.nextInt(45)+1;
			System.out.println(lotto);
			tset.add(lotto);
			if(tset.size() == 6) {
				break;
			}
		}
		System.out.println("1등 번호 : " + tset);
		
//		보너스번호
		int bonus;
		while(true) {
			bonus = random.nextInt(45) + 1;
			System.out.println(bonus);
			tset.add(bonus); //넣기
			if(tset.size() == 7) {
				break;
			}
		}
		tset.remove(bonus); //빼기(제거)
		System.out.println("1등 번호 : " + tset + " 보너스 번호 : " + bonus);
		System.out.println("===============================");
		
		
		while(true) {
			bonus = random.nextInt(45) + 1;
			System.out.println(bonus);
			if(!tset.contains(bonus)) { // " ! " 중요
				break;
			}
		}
		System.out.println("1등 번호 : " + tset + " 보너스 번호 : " + bonus);
	}

}
