package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_23351_물주기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K, A, B; // 화분 개수, 초기 수분, A개의 화분에 B만큼 물을 준다
	static ArrayList<Integer> flower = new ArrayList<Integer>(); // 각각의 화분의 수분량을 담을 리스트

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		int cnt = 0;
		while (!flower.contains(0)) { // 0이 생길때까지 반복
			Collections.sort(flower);
			for (int i = 0; i < A; i++)
				flower.set(i, flower.get(i) + B); // 수분이 적은 친구들부터 B만큼 늘림

			for (int i = 0; i < N; i++)
				flower.set(i, flower.get(i) - 1); // 전체적으로 1 줄임
			cnt++;
		}
		System.out.println(cnt);
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
			flower.add(K);
	} // end of input
}
