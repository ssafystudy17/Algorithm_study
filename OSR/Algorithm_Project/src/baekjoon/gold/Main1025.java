package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1025 {
	static int[][] board;
	static int N;
	static int M;
	static int answer = -1;

	public static void sol() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for (int dr = -N + 1; dr < N; dr++) {
					for (int dc = -M + 1; dc < M; dc++) {
						if (dr == 0 && dc == 0) {
							canSqrt(board[r][c]);
							continue;
						}

						int nr = r;
						int nc = c;
						int tmp = 0;
						while (0 <= nr && nr < N && 0 <= nc && nc < M) {
							tmp = tmp * 10 + board[nr][nc];
							canSqrt(tmp);
							nr += dr;
							nc += dc;
						}
					} // end of dc
				} // end of dr
			} // end of c
		} // end of r
	}

	public static void canSqrt(int num) {
		if (answer < num && (int) Math.sqrt(num) == Math.sqrt(num)) {
			answer = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine()); // Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		sol();
		System.out.println(answer);
	} // end of main
} // end of class
