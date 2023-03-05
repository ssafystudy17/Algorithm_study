package SWEA.SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_벌꿀채취_2115 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, C, revC, answer, rev; // 전체 벌통 크기, 채취할 수 있는 벌통 개수, 최대 용량
	static int[][] board;
	static int[][] revenue; // 해당 위치에서 얻을 수 있는 최대 수익
	static int[] numbers;
	static int[] tmp;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		input();
	}

	private static void sol() {
		for (int r = 0; r < N; r++)
			for (int c = 0; c < revC; c++)
				revenue[r][c] = maxRev(r, c);
		combination(0, 0);
	} // end of solution

	private static void combination(int idx, int cnt) {
		if (cnt == 2) {
			int r1 = numbers[0] / revC;
			int c1 = numbers[0] % revC;
			int r2 = numbers[1] / revC;
			int c2 = numbers[1] % revC;
			if (r1 == r2 && c2 < c1 + M) // r1,c1와 r2,c2가 겹치면 안되기 때문에
				return;
			answer = Math.max(answer, revenue[r1][c1] + revenue[r2][c2]);
			return;
		}

		for (int i = idx; i < N * revC; i++) {
			numbers[cnt] = i;
			combination(i + 1, cnt + 1);
		}
	}

	// i, j에서 채취할 수 있는 벌꿀의 최대 양
	private static int maxRev(int r, int c) {
		tmp = new int[M];
		isSelected = new boolean[M];
		rev = 0;
		for (int i = 0; i < M; i++) {
			tmp[i] = board[r][c + i];
		}

		subSet(0);
		return rev;
	}

	// 부분 집합
	public static void subSet(int index) {
		if (index == M) {
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				if (isSelected[i]) {
					sum += tmp[i] * tmp[i];
					cnt += tmp[i];
				}
			}
			if (C < cnt)
				return;
			rev = Math.max(rev, sum);
			return;
		}

		isSelected[index] = true;
		subSet(index + 1);
		isSelected[index] = false;
		subSet(index + 1);
	}

	private static void input() throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			answer = 0;
			revC = N - M + 1;
			board = new int[N][N];
			revenue = new int[N][revC]; // r, c부터 r, c+M-1까지의 벌통에서의 최대 채취 양
			numbers = new int[2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sol();
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
