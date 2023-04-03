package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_2636_치즈 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, total, answer;
	static int[][] board;
	static boolean[][] visited;
	static Queue<int[]> outsideCheese;
	static int[] dr = { 0, 0, -1, 1 }; // 동, 서, 북, 남
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		while (true) {
			visited = new boolean[N][M];
			outsideCheese = new ArrayDeque<>(); // 바깥 치즈의 위치를 담을 큐
			bfs(0, 0); // 0,0에서 시작하여 이어진 공기는 바깥 공기라는 뜻
			if (total == outsideCheese.size()) // 전체 치즈 개수와 바깥 치즈의 개수가 같다면 끝
				break;
			for (int[] pos : outsideCheese) {
				board[pos[0]][pos[1]] = 0;
				total--;
			}
			answer++;
		}
		System.out.println(answer + 1);
		System.out.println(total);

	} // end of solution

	private static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });

		while (!queue.isEmpty()) {
			r = queue.peek()[0];
			c = queue.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
					visited[nr][nc] = true; // 일단 방문 처리
					if (board[nr][nc] == 0) { // 공기라면 queue에 추가
						queue.add(new int[] { nr, nc });
					} else // 치즈라면 outsideCheese에 추가
						outsideCheese.add(new int[] { nr, nc });
				}
			}
		} // end of while
	} // end of bfs

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		total = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					total++;
			}
		}
	} // end of input
}