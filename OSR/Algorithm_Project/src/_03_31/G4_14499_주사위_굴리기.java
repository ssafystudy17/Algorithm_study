package _03_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_14499_주사위_굴리기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, r, c, K;
	static int[][] board;
	static int[] dice, upDown, leftRight, order;
	static int[] dr = { 0, 0, 0, -1, 1 }; // 동, 서, 북, 남
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		int startR = r, startC = c;

		for (int i = 0; i < order.length; i++) {
			int nr = r + dr[order[i]];
			int nc = c + dc[order[i]];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M) // 범위 밖이면 무시
				continue;

			rollDice(order[i]);
			System.out.println(dice[upDown[0]]);
			if (board[nr][nc] != 0) {
				dice[upDown[2]] = board[nr][nc];
				board[nr][nc] = 0;
			} else if (board[nr][nc] == 0 && nr != startR && nc != startC) {
				board[nr][nc] = dice[upDown[2]];
			}
			r = nr;
			c = nc;
		}

	} // end of solution

	private static void rollDice(int d) {
		int tmp;
		switch (d) {
		case 1: // 동쪽으로 구르기
			tmp = leftRight[3];
			for (int i = 3; i > 0; i--)
				leftRight[i] = leftRight[i - 1];
			leftRight[0] = tmp;

			// 수직방향 숫자들은 위, 아래만 바뀜
			upDown[0] = leftRight[0];
			upDown[2] = leftRight[2];
			break;

		case 2: // 서쪽으로 구르기
			tmp = leftRight[0];
			for (int i = 0; i < 3; i++)
				leftRight[i] = leftRight[i + 1];
			leftRight[3] = tmp;

			upDown[0] = leftRight[0];
			upDown[2] = leftRight[2];
			break;

		case 3: // 북쪽으로 구르기
			tmp = upDown[3];
			for (int i = 3; i > 0; i--)
				upDown[i] = upDown[i - 1];
			upDown[0] = tmp;

			leftRight[0] = upDown[0];
			leftRight[2] = upDown[2];
			break;

		case 4: // 남쪽으로 구르기
			tmp = upDown[0];
			for (int i = 0; i < 3; i++)
				upDown[i] = upDown[i + 1];
			upDown[3] = tmp;

			// 수직방향 숫자들은 위, 아래만 바뀜
			leftRight[0] = upDown[0];
			leftRight[2] = upDown[2];
			break;
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		dice = new int[7];
		upDown = new int[] { 1, 2, 6, 5 }; // 위를 기준으로 북쪽 방향
		leftRight = new int[] { 1, 3, 6, 4 }; // 위를 기준으로 동쪽 방향
		order = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}
