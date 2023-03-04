package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15652_NM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, R;
	static int[] numbers;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		input();
		combination(0, 0);
		System.out.println(sb.toString());
	}

	private static void combination(int cnt, int idx) {
		if (cnt == R) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			numbers[cnt] = i + 1;
			combination(cnt + 1, i);
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[R];
		selected = new boolean[R];
	} // end of input
}
