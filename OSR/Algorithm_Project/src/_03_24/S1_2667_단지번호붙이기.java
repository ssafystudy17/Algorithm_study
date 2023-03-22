package _03_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class S1_2667_단지번호붙이기 {
	static BufferedReader br;
	static int N, K;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int danzi;
	static ArrayList<Integer> countList;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					danzi++;
					countList.add(bfs(i, j));
				}
			}
		}

		System.out.println(danzi);
		Collections.sort(countList);
		for (int i = 0; i < danzi; i++)
			System.out.println(countList.get(i));
	} // end of solution

	private static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 1;
		queue.add(new int[] { r, c });
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			r = queue.peek()[0];
			c = queue.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && board[nr][nc] == 1) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		countList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
	} // end of input
}