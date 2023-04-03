package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1932_정수_삼각형 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[][] pyramid;

	public static void main(String[] args) throws Exception {
		input();
		sol();
	}

	private static void sol() {
		for (int i = 2; i <= N; i++) { // 2층부터 시작
			for (int j = 1; j <= i; j++)
				pyramid[i][j] += Integer.max(pyramid[i - 1][j - 1], pyramid[i - 1][j]);
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Integer.max(pyramid[N][i], answer);
		}
		System.out.println(answer);
	}

	private static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pyramid = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= i; j++)
				pyramid[i][j] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}
