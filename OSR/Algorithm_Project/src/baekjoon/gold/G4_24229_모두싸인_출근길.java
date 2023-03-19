package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_24229_모두싸인_출근길 {
	static BufferedReader br;
	static StringTokenizer st;
	static int T, N, max;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		sol();
	}

	private static void sol() {
		int maxDistance = arr[0];
		int curIdx = 0;

		System.out.println();
		for (int i = 0; i < max; i++) {
			if (maxDistance < arr[i]) {
				maxDistance = arr[i];
				curIdx = i;
			}
			if (maxDistance < i)
				break;
		}

		System.out.println(curIdx);
	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[2000000001];
		max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start] = end;
			arr[end] = end + (end - start);
			max = Math.max(max, end);
		}
	} // 1000000000
}
