package k20230410;

import java.util.Arrays;

public class RankingTest {

	public static void main(String[] args) {

		int[] score = { 80, 100, 70, 100, 90 };
//		석차를 기억하는 기억장소는 1로 초기화 시킨다.
		int[] rank = new int[score.length]; // 위의 점수가 바뀌면, 자동으로 배열의 크기도 바뀜.
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;

		}
//		System.out.println(Arrays.toString(rank));

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score.length; j++) {
//				내림차순 석차(큰 점수가 1등) , j번째가 크면 i번째가 1증가
				if (score[i] < score[j]) { // 오름차순 석차(작은 점수가 1등)로 하려면 부등호만 바꿔주면 됨
					rank[i]++;
				}
			}
		}

		for (int i = 0; i < score.length; i++) {
			System.out.printf("%3d점은 %d등 입니다.\n", score[i], rank[i]);
		}

	}

}
