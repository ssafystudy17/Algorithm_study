package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[101][101];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());

			for (int r = startR; r < startR + 10; r++) {
				for (int c = startC; c < startC + 10; c++) {
					board[r][c] = 1;
				}
			}
		}

		int cnt = 0;
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if (board[r][c] == 1)
					cnt++;
			}
		}
		
		System.out.println(cnt);
	} // end of main
}
