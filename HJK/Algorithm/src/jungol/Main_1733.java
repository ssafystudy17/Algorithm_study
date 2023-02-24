package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1733 {
	public static void main(String[] args) throws Exception {
		int[][] board = new int[21][21];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 20; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dr = { 0, 1, 1, -1 };
		int[] dc = { 1, 0, 1, 1 };
		int cnt = 0;
		int ans = 0;
		int rAxis = 0, cAxis = 0;
		ex: for (int winner = 1; winner <= 2; winner++) {
			/* ex: */ for (int r = 1; r < 20; r++) {
				for (int c = 1; c < 20; c++) {
					if (board[r][c] == winner) {
						for (int a = 0; a < 4; a++) {
							int nr = r;
							int nc = c;
							cnt = 0;
							while (board[nr][nc] == winner) {
								cnt++;
								nr += dr[a];
								nc += dc[a];

							}
							if (cnt == 5 && (board[r - dr[a]][c - dc[a]] != winner)) {
								ans = winner;
								cAxis = c;
								break ex;

							} else {
								ans = 0;
							}
						}
					}

				}
			}
		}
		System.out.println(ans);
		if (ans != 0) {
			System.out.println(rAxis + " " + cAxis);
		}
	}
}