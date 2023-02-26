package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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

		for (int i = 0; i < N; i++) {
			Arrays.sort(tree, new Comparator<int[]>() { // 오름차순 정렬
				public int compare(int[] o1, int[] o2) {
					return o2[0] - o1[0];
				}
			});

			for (int j = 0; j < N; j++)
				tree[j][0] += tree[j][1];

			cnt += tree[0][0];
			tree[0][0] = 0;
		}
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
