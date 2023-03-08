import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_19942_다이어트_92ms {
	static int N;
	static int[] min;
	static int[][] ingre;
	static int[] dotLoc;
	static int res = Integer.MAX_VALUE;
	static ArrayList<String> resList;
	static StringBuilder staticSb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		min = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++)
			min[i] = Integer.parseInt(st.nextToken());
		ingre = new int[N][5];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++)
				ingre[i][j] = Integer.parseInt(st.nextToken());
		}
		// 세팅 끝
		
		subSet(0, new int[] {0,0,0,0,0}, 0);
		
		if(res == Integer.MAX_VALUE) System.out.println(-1);
		else {
			Collections.sort(resList);
			sb = new StringBuilder();
			sb.append(res).append("\n").append(resList.get(0).toString());
			System.out.println(sb.toString());
		}
	}

	public static void subSet(int idx, int[] sum, int flag) {
		if(idx == N) {
			boolean can = true;
			for (int i = 0; i < 4; i++) {
				if(min[i] > sum[i]) {
					can = false;
					break;
				}
			}
			if(can) {
				if(res > sum[4]) {
					res = sum[4];
					resList = new ArrayList<String>();
					staticSb = new StringBuilder();
					for (int i = 0; i < N; i++) {
						if((flag & 1<<i) != 0)
							staticSb.append(i+1).append(" ");
					}
					resList.add(staticSb.toString());
				} else if(res == sum[4]) {
					staticSb = new StringBuilder();
					for (int i = 0; i < N; i++) {
						if((flag & 1<<i) != 0)
							staticSb.append(i+1).append(" ");
					}
					resList.add(staticSb.toString());
				}
			}
			return;
		}
		
		// 안넣고 가기
		subSet(idx+1, sum, flag);
		// 넣고 가기
		int[] newSum = new int[5];
		for (int i = 0; i < 5; i++)
			newSum[i] = sum[i] + ingre[idx][i];
		subSet(idx+1, newSum, flag|1<<idx);
	}
}