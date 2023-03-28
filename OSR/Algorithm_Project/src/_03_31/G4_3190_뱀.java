package _03_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class G4_3190_뱀 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K, L, time;
	static int[][] board, moves;
	static int[] dr = { 0, 1, 0, -1 }; // 오, 아래, 왼, 위
	static int[] dc = { 1, 0, -1, 0 };
	static Deque<int[]> snake;

	public static void main(String[] args) throws IOException {
		input();
		sol();
		System.out.println(time);
	}

	private static void sol() {
		snake.add(new int[] { 0, 0 });

		int r = 0, c = 0, d = 0, m = 0; // d: dr,dc의 인덱스 / m: moves의 인덱스
		while (true) {
			// moves[m][1] : 'D'이면 1, 'L'이면 -1
			if (m < L && time == moves[m][0]) {
				d = ((4 + d) + moves[m][1]) % 4; // 0 -> -1로 가는 경우를 방지하기 위해 4를 더함
				m++;
			}

			// 위치 이동 및 시간 증가
			r += dr[d];
			c += dc[d];
			time++;

			// 범위 밖으로 넘어가거나 충돌하면 끝
			if (r < 0 || r >= N || c < 0 || c >= N || isColide(r, c))
				return;

			snake.addFirst(new int[] { r, c }); // 머리 전진
			if (board[r][c] == 1) { // 위치에 사과가 있으면 꼬리 그대로 놔두고 사과 삭제
				board[r][c] = 0;
				continue;
			}
			snake.pollLast(); // 꼬리 삭제
		}
	} // end of solution

	private static boolean isColide(int r, int c) {
		int cnt = 0;
		int n = snake.size();

		while (cnt++ < n) { // cnt == n이 되면 모든 좌표를 탐색했다는 뜻임.
			int[] pos = snake.poll();
			if (pos[0] == r && pos[1] == c) // r, c가 있다면 충돌했다 => true
				return true;
			snake.add(pos);
		}

		return false;
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		board = new int[N][N];
		snake = new ArrayDeque<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		L = Integer.parseInt(br.readLine());
		moves = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			moves[i][0] = Integer.parseInt(st.nextToken());
			char k = st.nextToken().charAt(0);
			moves[i][1] = (k == 'D') ? 1 : -1;
		}
	} // end of input
}