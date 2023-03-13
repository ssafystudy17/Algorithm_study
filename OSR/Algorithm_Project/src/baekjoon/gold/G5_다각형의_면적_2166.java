package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_다각형의_면적_2166 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, answer;
	static int[][] pos;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		int l = 100000, r = -100000, b = 100000, t = -100000;

		for (int i = 0; i < pos.length; i++) {
			l = Math.min(l, pos[i][0]);
			r = Math.max(r, pos[i][0]);
			b = Math.min(b, pos[i][1]);
			t = Math.max(t, pos[i][1]);
		}

		// 왼쪽 아래
		int tmpT = t, tmpR = r;
		for (int i = 0; i < pos.length; i++) {
			if (l == pos[i][0] && pos[i][1] < tmpT)
				tmpT = pos[i][1];

			if (b == pos[i][1] && pos[i][0] < tmpR)
				tmpR = pos[i][0];
		}
		System.out.println(tmpT + " " + tmpR);
	} // end of sol

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pos = new int[4][2];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}
