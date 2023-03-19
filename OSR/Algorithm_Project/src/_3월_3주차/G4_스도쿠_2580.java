package _3월_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_스도쿠_2580 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static boolean isFinished;
	static ArrayList<int[]> posList;

	public static void main(String[] args) throws IOException {
		input();
		dfs(0);
	}

	private static void dfs(int index) {
		if (isFinished) // 다 채웠으면 더이상 볼 필요 없음(정답이 되는 것 중 아무거나 출력하면 됨)
			return;

		if (index == posList.size()) { // 다 채워졌다면 출력하고 isFinished = true
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
			isFinished = true;
			return;
		}

		int r = posList.get(index)[0];
		int c = posList.get(index)[1];

		for (int num = 1; num <= 9; num++) {
			if (possible(r, c, num)) { // r,c가 num이 될 수 있다면
				board[r][c] = num; // num으로 초기화
				dfs(index + 1);
				board[r][c] = 0; // 원상 복구
			}
		}
	} // end of dfs

	private static boolean possible(int r, int c, int num) {

		// 가로
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == num)
				return false;
		}

		// 세로
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == num)
				return false;
		}

		// 네모
		int nr = 0, nc = 0;
		for (int i = 0; i < 9; i++) {
			nr = i / 3;
			nc = i % 3;
			if (board[r / 3 * 3 + nr][c / 3 * 3 + nc] == num)
				return false;
		}

		return true;
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		posList = new ArrayList<int[]>();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0)
					posList.add(new int[] { i, j });

			}
		}
	} // end of input
}