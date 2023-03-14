package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2_창고_다각형_2304 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, top, curH;
	static int[][] tower;
	static Stack<int[]> stack;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	// 풀이
	// 1. 앞에서부터 증가하는 타워의 넓이를 구함.
	// 2. 뒤에서부터 증가하는 타워의 넓이를 구함.
	// 3. 위의 2개의 넓이를 더한 값 - 시작부터 끝까지 최대 높이의 합(직사각형) = 정답
	private static void sol() {
		Arrays.sort(tower, (o1, o2) -> o1[0] - o2[0]);
		int height = 0;
		int x = 0;
		int frontSize = 0; // 앞에서부터 증가하는 타워의 넓이를 셈
		// 앞에서부터
		for (int i = 0; i < N; i++) {
			frontSize += (tower[i][0] - x) * height;
			x = tower[i][0];
			if (height < tower[i][1])
				height = tower[i][1];
		}
		frontSize += height; // 마지막 한줄은 세지 못해서

		height = 0;
		x = 1000;
		int backSize = 0;
		// 뒤에서부터
		for (int i = N - 1; i >= 0; i--) {
			backSize += (x - tower[i][0]) * height;
			x = tower[i][0];
			if (height < tower[i][1])
				height = tower[i][1];
		}
		backSize += height; // 역시 마지막 한줄을 세지 못함

		int totalSize = (tower[N - 1][0] + 1 - tower[0][0]) * height; // 최대 높이로 잰 넓이
		System.out.println(frontSize + backSize - totalSize); // 정답
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tower = new int[N][2]; // 0: 인덱스, 1: 높이
		stack = new Stack<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			tower[i][0] = Integer.parseInt(st.nextToken());
			tower[i][1] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}