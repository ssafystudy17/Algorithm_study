package _3월_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2230_수_고르기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		sol();
	}

	private static void sol() {
		if (M == 0) {
			System.out.println(0);
			return;
		}

		Arrays.sort(arr);
		int r = 0, diff = arr[N - 1] - arr[0]; // diff 초기상태 : 차이의 최대값

		// l : 왼쪽 인덱스, r : 오른쪽 인덱스
		for (int l = 0; l < N - 1; l++) {
			if (diff == M) // 차이가 M이라면 더 이상 볼 필요 없음
				break;
			
			// 차이가 M보다 작으면 r을 늘려줌
			// 차이가 M보다 크거나 같다? => arr[l] 기준으로 M보다 크면서 차이가 가장 작은 값 : arr[r] 
			while (r < N && arr[r] - arr[l] < M) 
				r++;

			if (r == N) // r이 끝까지 갔다면 더 이상 차이가 M보다 작은 arr[l]값이 없음
				break;

			diff = Math.min(diff, arr[r] - arr[l]); // 저장되어왔던 diff와 비교
		}
		System.out.println(diff);
	} // end of solution

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());
	} // end of input
}