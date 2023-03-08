package _3월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Three_dots_13423 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, answer;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
	}

	private static void sol() {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(arr[i]);

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if ((arr[i] + arr[j]) % 2 == 0 && set.contains((arr[i] + arr[j]) / 2))
					answer++;
			}
		}
	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			sol();
			System.out.println(answer);
		}
	} // end of input

}