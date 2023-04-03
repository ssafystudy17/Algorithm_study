package _04_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_14502_연구소 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, answer;
	static int[][] origin, board;
	static boolean[][] visited;
	static ArrayList<int[]> binList, virusList;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		int size = binList.size();
		// nC3 => 3개를 뽑고 그 위치에 벽을 세움
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					answer = Math.max(answer, virusStart(i, j, k));
				}
			}
		}
		System.out.println(answer);
	} // end of solution

	private static int virusStart(int i1, int i2, int i3) {
		visited = new boolean[N][M];
		board = new int[N][M];
		for (int i = 0; i < N; i++)
			board[i] = origin[i].clone();

		// 해당 위치에 벽 세우기
		board[binList.get(i1)[0]][binList.get(i1)[1]] = 1;
		board[binList.get(i2)[0]][binList.get(i2)[1]] = 1;
		board[binList.get(i3)[0]][binList.get(i3)[1]] = 1;

		int spreadCount = 3; // 얼마나 바이러스가 퍼졌는지 세는 변수 (벽을 3개 쳤기때문에 3부터 시작)
		for (int[] pos : virusList) // 모든 바이러스가 있는 위치부터 시작
			spreadCount += bfs(pos[0], pos[1]);

		return binList.size() - spreadCount;
	} // end of bfs

	private static int bfs(int r, int c) {
		int cnt = 0; // 퍼진 바이러스 개수
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });

		while (!queue.isEmpty()) {
			r = queue.peek()[0];
			c = queue.poll()[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 범위 내이고, 방문 안했고, 0이라면 갈 수 있다.
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && board[nr][nc] == 0) {
					visited[nr][nc] = true;
					cnt++;
					queue.add(new int[] { nr, nc });
				}
			}
		} // end of while
		return cnt;
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		origin = new int[N][M];
		binList = new ArrayList<>();
		virusList = new ArrayList<>();
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if (origin[i][j] == 0) // 0이면 빈 공간
					binList.add(new int[] { i, j });
				if (origin[i][j] == 2) // 2면 바이러스
					virusList.add(new int[] { i, j });
			}
		}
	} // end of input
}
