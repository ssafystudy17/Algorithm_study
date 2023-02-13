package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2527 {
	static int x1, y1, p1, q1, x2, y2, p2, q2;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		p1 = Integer.parseInt(st.nextToken());
		q1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		q2 = Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 4; i++) {
			input();
			if (check_d()) {
				System.out.println("d");
			} else if (check_c()) {
				System.out.println("c");
			} else if (check_b()) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	} // end of main

	// 1을 기준으로, 아래, 오, 위, 왼
	public static boolean check_b() {
		if (y1 == q2 || p1 == x2 || q1 == y2 || x1 == p2)
			return true;
		return false;
	}

	// 점이 같은지 확인
	public static boolean check_c() {
		if ((x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2) || (p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2))
			return true;
		return false;
	}

	// 1을 기준으로, 오 or 위 or 왼 or 아래
	// p1 < x2 or q1 < y2 or p2 < x1 or q2 < y1
	public static boolean check_d() {
		if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1)
			return true;
		return false;
	}
}
