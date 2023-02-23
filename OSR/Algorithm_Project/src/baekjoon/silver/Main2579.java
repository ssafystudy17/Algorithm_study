package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++)
			stairs[i] = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(stairs[1]);
			return;
		}

		dp[1] = stairs[1];
		dp[2] = stairs[1] + stairs[2];
		for (int i = 3; i <= N; i++)
			// 현재 위치 직전의 계단을 밟고 오냐 or 점프해서 오냐
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];

		System.out.println(dp[N]);

	} // end of main
}
