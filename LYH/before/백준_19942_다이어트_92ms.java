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
	static int res = Integer.MAX_VALUE; // 최소로 초기화 하기 위해 최댓값 초기화
	static ArrayList<String> resList; // 최소 값들에 대해 순서를 String값으로 받아들인 후 나중에 정렬 -> 사전순
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
		
		subSet(0, new int[] {0,0,0,0,0}, 0); // 탐색
		
		if(res == Integer.MAX_VALUE) System.out.println(-1); // res가 갱신이 안되었으면 최소 영양수치를 못넘었으니 -1
		else {
			Collections.sort(resList); // 사전순 정렬
			sb = new StringBuilder();
			sb.append(res).append("\n").append(resList.get(0).toString()); // 첫 번째놈 꺼내기
			System.out.println(sb.toString());
		}
	}

	// 부분집합 뽑기부터 하고 가자
	public static void subSet(int idx, int[] sum, int flag) {
		if(idx == N) { // 다 뽑았다
			// 여기는  최소 영양수치를 다 넘었나 확인하는 곳
			boolean can = true;
			for (int i = 0; i < 4; i++) {
				if(min[i] > sum[i]) {
					can = false;
					break;
				}
			}
			
			if(can) { // 최소치를 만족했다 ?
				if(res > sum[4]) { // 지금 구한게 최소비용이 더 작으면
					res = sum[4]; // 저장하고
					resList = new ArrayList<String>(); // 새로운 최솟값이니 리스트 새로 만들어서
					staticSb = new StringBuilder(); // String넣은 공간도 만들어서
					for (int i = 0; i < N; i++) {
						if((flag & 1<<i) != 0) // 쓴 것들을
							staticSb.append(i+1).append(" "); // 한 칸씩 띄워서 저장
					}
					resList.add(staticSb.toString()); // 리스트에 저장
				} else if(res == sum[4]) { // 이전 최솟값이랑 같으면 나중에 사전순 따져야하니까 넣어줄래
					staticSb = new StringBuilder(); // String공간만 만들어줘서 똑같이 해서
					for (int i = 0; i < N; i++) {
						if((flag & 1<<i) != 0)
							staticSb.append(i+1).append(" ");
					}
					resList.add(staticSb.toString()); // 리스트 저장
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