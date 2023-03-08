package _3월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, size, answer, baby_r, baby_c, eat_count;
	static int[][] board;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		while (bfs()) { // bfs가 false를 리턴 => 먹을 수 있는 물고기다 없다는 뜻.
		}
		System.out.println(answer);
	}

	private static boolean bfs() {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		// fishes : 최단 거리에서 먹을 수 있는 물고기을 담을 큐, 높이가 같으면 c를 오름차순으로 정렬, 다르면 r을 오름차순으로 정렬
		PriorityQueue<int[]> fishes = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

		visited[baby_r][baby_c] = true; // 일단 시작 위치 방문 처리
		queue.add(new int[] { baby_r, baby_c, 0 }); // 시작 위치 큐에 삽입
		int prev_d = 0; // 이전 거리
		while (!queue.isEmpty()) {
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			int d = queue.poll()[2];

			if (prev_d < d && !fishes.isEmpty()) { // bfs에서 거리가 커졌고, 먹을 수 있는 물고기가 있을 경우
				move(fishes); // 조건에 맞는 위치로 이동
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
					if (size < board[nr][nc])
						continue;
					else if (board[nr][nc] == 0 || size == board[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc, d + 1 });
					} else {
						fishes.add(new int[] { nr, nc, d + 1 });
					}
				} // end of 분기
			} // end of dr dc
			prev_d = d;
		} // end of while

		if (fishes.size() != 0) { // 가장 멀리 있는 경우도 체크해줘야 함
			move(fishes);
			return true;
		}
		return false;
	}

	private static void move(PriorityQueue<int[]> fishes) {
		int[] fish = fishes.poll(); // 우선순위 큐로 정렬해놨기 때문에 초기화만 하면 됨
		baby_r = fish[0];
		baby_c = fish[1];
		board[baby_r][baby_c] = 0;
		eat_count++;
		if (eat_count == size) {
			size++;
			eat_count = 0;
		}
		answer += fish[2];
	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) { // 아기 상어를 찾았으면 싹 다 초기화해버려
					board[i][j] = 0;
					baby_r = i;
					baby_c = j;
					size = 2;
					answer = 0;
					eat_count = 0;
				}
			}
		}
	} // end of input
}