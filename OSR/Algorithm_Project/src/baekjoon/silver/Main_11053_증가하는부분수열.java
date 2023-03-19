package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11053_증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		int[] arr = new int[N];
		int[] dp = new int[N]; // dp[i] : arr[i]까지의 최장 길이 부분 수열
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.fill(dp, 1); // 최소 1의 길이를 가질 수 있음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				// j번째 값보다 내(i)가 더 커야함, 현재 나(i)한테 저장된 값보다 dp[j]+1이 커야함
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	} // end of main
}
