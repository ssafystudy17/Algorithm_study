package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//0 4 6 8 -> +4 -4 -4 -4
//4 0 2 4 -> +2 +2 -2 -2
//6 2 0 2
public class Main18310 {
	static void pro(int[] home, int N) {
		Arrays.sort(home);
		long total = 0;
		int pos = home[0];

		// 초기값
		for (int i = 1; i < home.length; i++) {
			total += home[i] - home[0];
		}

		long curSum = total;
		for (int i = 1; i < home.length; i++) {
			curSum -= (home[i] - home[i - 1]) * (N - i); // i-1과 i까지의 거리가 (N-i)번 줄어듦.
			curSum += (home[i] - home[i - 1]) * i; // i-1과 i까지의 거리가 i번 늘어남

			if (curSum < total) {
				total = curSum;
				pos = home[i];
			}
		}

		System.out.println(pos);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] home = new int[N];
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}

		pro(home, N);
	} // end of main
}
