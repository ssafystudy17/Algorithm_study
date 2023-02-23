package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정올
public class Main1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = -1;
		for (int i = 0; i < board.length; i++) {
			int sum = 0;
			for (int j = 0; j < board.length; j++) {
				sum += board[i][j];
			}
			if (sum % 2 != 0) {
				if (r == -1)
					r = i;
				else {
					System.out.println("Corrupt");
					return;
				}
			}
		}

		int c = -1;
		for (int j = 0; j < board.length; j++) {
			int sum = 0;
			for (int i = 0; i < board.length; i++) {
				sum += board[i][j];
			}
			if (sum % 2 != 0) {
				if (c == -1)
					c = j;
				else {
					System.out.println("Corrupt");
					return;
				}
			}
		}

		if (r == -1 && c == -1)
			System.out.println("OK");
		else
			System.out.printf("Change bit (%d,%d)", r + 1, c + 1);
	} // end of main
}
