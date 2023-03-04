package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_N_Queen {
	static int N;
	static int[] queen; // 퀸의 위치 (r, c) => (r, queen[r])
	static int cnt;

	public static void dfs(int row) {
		if (row == N) {
			cnt++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (!checkQueen(row, c))
				continue;
			queen[row] = c;
			dfs(row + 1);
		}
	} // end of dfs

	private static boolean checkQueen(int row, int col) {
		for (int r = 0; r < row; r++) {
			// 같은 열이거나, 좌하향(r+c가 같음), 우하향(r-c가 같음)과 겹친다면 false
			if (queen[r] == col || r + queen[r] == row + col || r - queen[r] == row - col)
				return false;
		}
		return true;
	} // end of checkQueen

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		N = Integer.parseInt(br.readLine());
		queen = new int[N];
		dfs(0);
		System.out.println(cnt);
	}

}