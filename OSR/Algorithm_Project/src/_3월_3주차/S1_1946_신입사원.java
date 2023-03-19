package _3월_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1946_신입사원 {
	static BufferedReader br;
	static StringTokenizer st;
	static int T, N;
	static int[][] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();

	}

	private static void sol() {
		Arrays.sort(rank, (o1, o2) -> o1[0] - o2[0]); // 1차 면접 rank 순으로 정렬
		int cnt = 0;
		int r = N + 1; // 현재 뽑은 사원 중 제일 낮은 rank를 담을 변수 

		for (int i = 0; i < N; i++) {
			if (rank[i][1] < r) { // r보다 더 작다 => 뽑을 수 있는 사람이다
				cnt++;
				r = rank[i][1]; // r을 바꿔줌
			}
		}
		
		System.out.println(cnt);
	} // end of sol

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			rank = new int[N][2];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				rank[j][0] = Integer.parseInt(st.nextToken());
				rank[j][1] = Integer.parseInt(st.nextToken());
			}
			sol();
		}
	}

}
