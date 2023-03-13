package _3월_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_보석상자_2792 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, answer;
	static int[] jewels;

	public static void main(String[] args) throws IOException {
		input();
		binarySearch();
	}

	// M개의 종류의 구슬을 N명에게 분배.
	// 각각 한 종류의 구슬만 가질 수 있음.
	// 분배했을 때의 최대 구슬의 개수가 최소가 되는 경우의 구슬의 수를 구하자.
	// 최대 mid개의 구슬을 나눠준다고 가정했을 경우
	// 1) N명보다 많다? -> mid값을 늘려야 함.
	// 2) N명보다 적거나 같다? -> mid값을 줄여봐야 함
	private static void binarySearch() {
		long start = 0;
		long end = 4;

		while (start <= end) {
			long tmpStuents = 0;
			long mid = (start + end) / 2;
			for (int i = 0; i < jewels.length; i++)
				tmpStuents += Math.ceil((double) jewels[i] / mid);

			if (N < tmpStuents)
				start = mid + 1;
			else
				end = mid - 1;
		} // end of while

		System.out.println(start);
	} // end of binarySearch

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		jewels = new int[M];
		for (int i = 0; i < M; i++)
			jewels[i] = Integer.parseInt(br.readLine());
	} // end of input
}
