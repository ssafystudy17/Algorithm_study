package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지_안녕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board;
	static int R, C, T, topR, botR, answer; // topR, botR: 공기청정기 위, 아래쪽 인덱스
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		input();
		for (int t = 0; t < T; t++) {
			spread(); // 전체적인 먼지 확산
			rotateLeft(); // 위쪽 청정기 작동
			rotateRight(); // 오른쪽 청정기 작동
		}
		countDust(); // 먼지 개수 세기
		System.out.println(answer);
	}

	private static void countDust() {
		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				answer += board[r][c];

		answer += 2; // 공기청정기로 2가 빠진거 더해주기
	}

	private static void rotateLeft() {
		// 왼 (공기청정기는 제외)
		for (int r = topR - 1; r > 0; r--)
			board[r][0] = board[r - 1][0];
		// 위
		for (int c = 0; c < C - 1; c++)
			board[0][c] = board[0][c + 1];
		// 오
		for (int r = 0; r < topR; r++)
			board[r][C - 1] = board[r + 1][C - 1];
		// 아래 (공기청정기는 제외)
		for (int c = C - 1; c > 1; c--)
			board[topR][c] = board[topR][c - 1];

		// 공기청정기 바로 오른쪽을 0으로 바꿔줘야 함.
		board[topR][1] = 0;
	}

	private static void rotateRight() {
		// 왼 (공기청정기는 제외)
		for (int r = botR + 1; r < R - 1; r++)
			board[r][0] = board[r + 1][0];
		// 아래
		for (int c = 0; c < C - 1; c++)
			board[R - 1][c] = board[R - 1][c + 1];
		// 오
		for (int r = R - 1; r > botR; r--)
			board[r][C - 1] = board[r - 1][C - 1];
		// 위 (공기청정기는 제외)
		for (int c = C - 1; c > 1; c--)
			board[botR][c] = board[botR][c - 1];

		// 공기청정기 바로 오른쪽을 0으로 바꿔줘야 함.
		board[botR][1] = 0;
	}

	private static void spread() {
		int[][] tmp = new int[R][C]; // tmp 배열에 먼지의 증감을 넣어주고, 나중에 board열에 더함.

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c] >= 5) { // 5보다 작으면 확산이 안됨
					int dust = board[r][c] / 5; // 확산될 먼지의 양
					int cnt = 0; // 확산될 주변 칸의 개수
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (0 <= nr && nr < R && 0 <= nc && nc < C && board[nr][nc] != -1) {
							tmp[nr][nc] += dust;
							cnt++;
						}
					}
					tmp[r][c] -= cnt * dust;
				}
			}
		}

		// 확산된 먼지를 계산
		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				board[r][c] += tmp[r][c];

	} // end of spread

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		answer = 0;
		board = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < R; r++) {
			if (board[r][0] == -1) {
				topR = r;
				botR = r + 1;
				break;
			}
		}
	} // end of input
} // end of class
