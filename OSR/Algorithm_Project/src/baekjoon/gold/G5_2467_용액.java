package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2467_용액 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K, result;
	static int[] arr, answer;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		Arrays.sort(arr); // 냅다 정렬부터 하고 시작.
		answer[0] = arr[0];
		answer[1] = arr[1];

		int l = 0, r = 1, diff;
		result = Math.abs(arr[0] + arr[1]); // 일단 0, 1번 용액 합으로 초기화
		while (l < N && r < N) {
			diff = Math.abs(arr[l] + arr[r]);

			if (l + 1 == r)
				r++;

			if (diff < result) {
				result = diff;
				answer[0] = arr[0];
				answer[1] = arr[1];
				r++;
			} else {
				l++;
			}

		}

		System.out.println(answer[0] + " " + answer[1]);
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		answer = new int[2];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
	} // end of input
}