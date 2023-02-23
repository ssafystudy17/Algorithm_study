package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int[] B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		int aIdx = 0;
		int bIdx = 0;
		int rIdx = 0;
		int[] result = new int[N + M];

		while (aIdx < N && bIdx < M) {
			if (A[aIdx] < B[bIdx])
				result[rIdx++] = A[aIdx++];
			else
				result[rIdx++] = B[bIdx++];
		}
		while (bIdx < M) {
			result[rIdx++] = B[bIdx++];
		}
		while (aIdx < N) {
			result[rIdx++] = A[aIdx++];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb.toString());

	} // end of main
}
