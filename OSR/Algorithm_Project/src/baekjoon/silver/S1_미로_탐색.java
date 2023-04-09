package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_미로_탐색 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1 }; // 동, 서, 북, 남
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(bfs());
	}

	private static int bfs() {
		visited[0][0] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, 1 });

		while (!queue.isEmpty()) {
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			int d = queue.poll()[2];

			if (r == N - 1 && c == M - 1)
				return d;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
					if (board[nr][nc] == 1) {
						visited[nr][nc] = true; // 일단 방문 처리
						queue.add(new int[] { nr, nc, d + 1 });
					}
				}
			}
		} // end of while

		return -1;
	} // end of bfs

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				board[i][j] = str.charAt(j) - '0';
		}
	} // end of input
}