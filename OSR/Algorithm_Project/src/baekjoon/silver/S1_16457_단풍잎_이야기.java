package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S1_16457_단풍잎_이야기 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, K, answer;
	static int[][] skills;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		input();
		combination(0, 1);
		System.out.println(answer);
	}

	private static void combination(int index, int skillNo) {
		if (index == N) {
			int cnt = 0;
			loop: for (int i = 0; i < M; i++) {
				for (int j = 0; j < K; j++) {
					if (!set.contains(skills[i][j]))
						continue loop;
				}
				cnt++;
			}
			answer = Math.max(answer, cnt);
			return;
		}

		for (int n = skillNo; n <= 2 * N; n++) {
			set.add(n);
			combination(index + 1, n + 1);
			set.remove(n);
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		skills = new int[M][K];
		answer = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < K; j++)
				skills[i][j] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}
