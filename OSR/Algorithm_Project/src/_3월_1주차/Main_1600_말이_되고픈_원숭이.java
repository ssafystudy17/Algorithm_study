package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이_되고픈_원숭이 {
	static BufferedReader br;
	static StringTokenizer st;
	static int K, W, H;
	static int[][] board;
	static boolean[][][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] hr = { -2, -1, 1, 2, 2, 1, -1, -2 }; // 말 방향
	static int[] hc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		bfs();
	} // end of main

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { 0, 0, 0, 0 }); // r, c, 움직인 횟수, 말점프 사용 횟수
		int answer = -1;

		while (!queue.isEmpty()) {
			int[] info = queue.poll();
			int r = info[0];
			int c = info[1];
			int moveCnt = info[2];
			int jumpCnt = info[3];

			if (r == H - 1 && c == W - 1) { // 도착점에 도달하면 break
				answer = moveCnt;
				break;
			}

			if (jumpCnt < K) { // 현재까지 사용한 말점프 횟수가 K보다 작아야 말점프 가능
				for (int i = 0; i < 8; i++) {
					int nr = r + hr[i];
					int nc = c + hc[i];
					// 범위 내, 장애물이 아니고, (말점프 + 1)번을 사용하여 해당 지점 방문을 하지 않았다면 queue에 삽입 
					if (0 <= nr && nr < H && 0 <= nc && nc < W && board[nr][nc] != 1 && !visited[jumpCnt + 1][nr][nc]) {
						visited[jumpCnt + 1][nr][nc] = true;
						queue.add(new int[] { nr, nc, moveCnt + 1, jumpCnt + 1 });
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < H && 0 <= nc && nc < W && board[nr][nc] != 1 && !visited[jumpCnt][nr][nc]) {
					visited[jumpCnt][nr][nc] = true;
					queue.add(new int[] { nr, nc, moveCnt + 1, jumpCnt });
				}
			}
		} // end of while

		System.out.println(answer);
	} // end of bfs

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][W];
		visited = new boolean[K + 1][H][W]; // K: 말점프 횟수에 따른 visited 처리하기 위함
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++)
				board[i][j] = Integer.parseInt(st.nextToken());

		}
	} // end of input
} // end of class
