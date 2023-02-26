package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13702_이상한_술집 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K;
	static int[] mak;
	static long start = 0;
	static long end = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	} // end of main

	private static void sol() {
		if (end == 0) {
			System.out.println(0);
			return;
		}

		while (start <= end) {
			long mid = (start + end) / 2;
			int count = 0; // mid 용량으로 나눠줄 수 있는 사람의 수
			for (int i = 0; i < mak.length; i++)
				count += mak[i] / mid;

			if (count < K) // 나눠줄 수 있는 막걸리가 K명보다 적으면
				end = mid - 1;
			else // K와 같거나 크다면 용량을 더 늘려볼 수 있음.
				start = mid + 1;
		}
		System.out.println(end);
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mak = new int[N];
		for (int i = 0; i < mak.length; i++) {
			mak[i] = Integer.parseInt(br.readLine());
			end = Math.max(mak[i], end); // 막걸리 중 최소값이 최대의 막걸리 용량(end) 후보 중 가장 큰 값
		}
	} // end of input
} // end of class
