package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2467_두_용액 {
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

		int l = 0, r = N - 1;
		answer[0] = arr[l];
		answer[1] = arr[r];
		result = Math.abs(arr[r] + arr[l]); // 일단 l, r번 용액 합으로 초기화
		while (l < r) {
			int sum = arr[l] + arr[r];

			if (Math.abs(sum) < result) { // 현재 최소값(result)보다 작으면 변경
				result = Math.abs(sum);
				answer[0] = arr[l];
				answer[1] = arr[r];
			}

			if (sum < 0) // 합이 음수다? 음수부분(왼쪽)을 키워야함
				l++;
			else // 합이 양수다? 양수부분(오른쪽)을 낮춰야함
				r--;
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