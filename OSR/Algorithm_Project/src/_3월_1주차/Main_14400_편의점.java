package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14400_편의점 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] x;
	static int[] y;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	// 일단 고객들 위치를 정렬한 후 가운데에 있는 고객의 위치에 있어야 거리의 합이 최소가 됨.
	// 그림으로 그려보면 이해하기 쉬움.
	// x와 y 좌표를 나눠서 고려함.
	private static void sol() {
		Arrays.sort(x);
		Arrays.sort(y);

		long distance = 0; // long 제발!!!
		// 만약 한 점(x)이 두 점 x1, x2 사이에 있다면, x1과 x, x2와 x의 거리의 합은 x2-x1이다
		// 그리고 최소가 되는 점이 무조건 사이에 있기 때문에
		for (int i = 0; i < N / 2; i++) {
			distance += x[N - i - 1] - x[i];
			distance += y[N - i - 1] - y[i];
		}
		System.out.println(distance);
	} // end of sol

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		x = new int[N];
		y = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}