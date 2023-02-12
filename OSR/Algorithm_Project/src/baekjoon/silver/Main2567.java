package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		// 색종이가 올라가있는 위치를 다 1로 초기화 하면, 0의 주변에 있는 1의 개수 == 도화지의 둘레라는 것을 이용한 풀이
		// 도화지는 100 * 100칸임. 도화지 주변을 1칸씩 더 늘리기 위해 102 * 102칸의 배열을 만듦.
		// 결국 도화지에 올라가는 색종이의 위치는 (1,1) ~ (101, 101)의 범위 내에 올라가야함.
		int[][] board = new int[102][102];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startC = Integer.parseInt(st.nextToken()) + 1; // 실제 입력된 위치보다 1씩 늘려서 위치함.
			int startR = Integer.parseInt(st.nextToken()) + 1;

			// 색종이가 올라간 부분을 1로 초기화
			for (int r = startR; r < startR + 10; r++) {
				for (int c = startC; c < startC + 10; c++) {
					board[r][c] = 1;
				}
			}
		}

		int cnt = 0;
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		for (int r = 0; r < 102; r++) {
			for (int c = 0; c < 102; c++) {
				if (board[r][c] == 0) {
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						// 범위 내에 있고, 주변이 1이라면 cnt 1 증가
						if (0 <= nr && nr <= 102 && 0 <= nc && nc <= 102 && board[nr][nc] == 1)
							cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	} // end of main
}
