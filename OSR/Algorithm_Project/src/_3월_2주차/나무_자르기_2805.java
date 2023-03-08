package _3월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무_자르기_2805 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, answer;
	static int[] tree;
	static long start, end;

	public static void main(String[] args) throws IOException {
		input();
		solution();
	}

	private static void solution() {
		start = 0;
		end = Integer.MAX_VALUE;

		while (start <= end) {
			long mid = (start + end) / 2; // 높이
			long sum = 0; // 수확한 나무의 개수
			for (int i = 0; i < N; i++) {
				if (mid < tree[i])
					sum += tree[i] - mid;
			}

			if (sum < M) // 나무가 적으면 높이를 낮춰야 함
				end = mid - 1;
			else // 나무가 많거나 같으면 높이를 높여봄 (같을 경우도 최대 높이를 구해야 함)
				start = mid + 1;
		}

		System.out.println(end);
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			tree[i] = Integer.parseInt(st.nextToken());
	} // end of input
}