package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9095 {
	static int count;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			count = 0;
			recursion(0);
			System.out.println(count);
		}
	} // end of main

	public static void recursion(int sum) {
		if (n < sum)
			return;

		if (sum == n) {
			count++;
			return;
		}

		for (int i = 1; i <= 3; i++)
			recursion(sum + i);
	}
}
// dp 문제인건 알겠어
// 점화식을 뭘로 설정할 것인가??
// 단순히 숫자 개수 or 해당 숫자의 개수 or 1~N까지 조합의 수? -> 이거일거같은 느낌

// 모르겠다 깡구현 시작
// 됐네
