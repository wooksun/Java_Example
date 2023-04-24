package homework;

import java.util.HashSet;
import java.util.Random;

public class HashSetLotto {

	public static void main(String[] args) {
		
		HashSet<Integer> hset = new HashSet<>(); //객체 생성
		
		hset.add(500); //1개 추가 값은 500
//		hset의 크기(.size()) + ":" + hset에 저장된 값(500)
		System.out.println(hset.size() + " : " + hset);
		hset.add(100);
		System.out.println(hset.size() + " : " + hset);
		hset.add(999);
		System.out.println(hset.size() + " : " + hset);
		hset.add(5);
		System.out.println(hset.size() + " : " + hset);
		
		hset.remove(500);
		System.out.println(hset.size() + " : " + hset);
		
//		로또 1등 번호
		Random random = new Random();
		
		while(true) {
			int lotto = random.nextInt(45)+1;
			System.out.println(lotto);
			hset.add(lotto);
			if(hset.size() == 6) {
				break;
			}
		}
		System.out.println("1등 번호 : " + hset);
		
//		보너스 번호
		int bonus;
		while(true) {
			bonus = random.nextInt(45)+1;
			System.out.println(bonus);
			hset.add(bonus);
			if(hset.size() == 7) {
				break;
			}
		}
		hset.remove(bonus);
		System.out.println("1등 번호 : " + hset + "보너스 번호 : " + bonus);
		
		while(true) { 
			bonus = random.nextInt(45)+1;
			System.out.println(bonus);
			if(!hset.contains(bonus)) {
				break;
			}
		}
		System.out.println("1등 번호 : " + hset + "보너스 번호 : " + bonus);
		
		
	}

}
