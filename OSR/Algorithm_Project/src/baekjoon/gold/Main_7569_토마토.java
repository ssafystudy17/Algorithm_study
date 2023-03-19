package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static BufferedReader br;
	static StringTokenizer st;
	static int R, C, H, total, day; // total : 안익은 토마토의 개수
	static int[][][] board;
	static Queue<int[]> queue; // 익은 토마토의 정보를 담을 큐 (bfs에서 사용)
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		if (total == 0)
			System.out.println(day);
		else
			System.out.println(-1);
	}

	private static void bfs() {
		boolean[][][] visited = new boolean[H][R][C];

		while (!queue.isEmpty()) {
			int h = queue.peek()[0];
			int r = queue.peek()[1];
			int c = queue.peek()[2];
			int d = queue.poll()[3];

			visited[h][r][c] = true;
			day = d;

			for (int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (0 <= nh && nh < H && 0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nh][nr][nc]) {
					visited[nh][nr][nc] = true;

					if (board[nh][nr][nc] == 0) {
						queue.add(new int[] { nh, nr, nc, d + 1 });
						total--;
					}
				}
			}
		}
	} // end of bfs

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][R][C];
		queue = new ArrayDeque<>();
		total = 0;
		day = 0;

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					board[h][r][c] = Integer.parseInt(st.nextToken());

					if (board[h][r][c] == 1) // 익은 토마토면 큐에 넣고 day는 0
						queue.add(new int[] { h, r, c, 0 });
					if (board[h][r][c] == 0) // 안익은 토마토의 개수를 파악 할 total
						total++;
				}
			}
		}

	} // end of input
} // end of class
