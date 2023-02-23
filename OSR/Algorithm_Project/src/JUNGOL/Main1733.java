package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1733 {
	static int[][] board;
	static int[] dr = { 1, 1, 0, -1 };
	static int[] dc = { 1, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		input();
		pro();
	} // end of main

	private static void pro() {
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (board[i][j] != 0 && isOmok(board[i][j], i, j)) {
					System.out.println(board[i][j]);
					System.out.println(i + " " + j);
					return;
				}
			}
		}
		System.out.println(0);
	}

	private static boolean isOmok(int color, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int cnt = 1;
			int r = x + dr[i];
			int c = y + dc[i];
			while (1 <= r && r < 20 && 1 <= c && c < 20 && board[r][c] == color) {
				cnt++;
				r += dr[i];
				c += dc[i];
			}
			if (cnt == 5) { // 해당 방향으로 오목이 됐더라도, 반대 방향에 다른 돌이 있는지 확인해야 함.
				int nr = x - dr[i];
				int nc = y - dc[i];
				if (1 <= nr && nr < 20 && 1 <= nc && nc < 20 && board[nr][nc] == color)
					continue;
				return true;
			}
		}
		return false;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[20][20];
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < 20; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	} // end of method
} // end of class
