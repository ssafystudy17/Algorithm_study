package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14247_나무_자르기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[][] tree;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		int cnt = 0;

		Arrays.sort(tree, (o1, o2) -> o1[1] - o2[1]); // 자라는 길이 순서로 정렬
		for (int i = 0; i < tree.length; i++) {
			System.out.println(Arrays.toString(tree[i]));
		}
		for (int i = 0; i < tree.length; i++)
			cnt += tree[i][0] + tree[i][1] * i; // 자라는 길이가 작은 순으로 자르는게 가장 최적의 방법
		System.out.println(cnt);
	} // end of sol

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N][2];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			tree[i][0] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			tree[i][1] = Integer.parseInt(st.nextToken());
	} // end of input
}
