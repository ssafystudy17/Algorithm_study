// 2차원 배열사용 -> 정렬하는데 시간 많이 소요
// 3164ms
// 1차원 인덱스사용 -> 정렬 필요 X
// 780ms


/***
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1946_신입사원_ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] applicants;
		int maxInterviewRank;
		int res; // 선발 인원
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			applicants = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				applicants[i][0] = Integer.parseInt(st.nextToken());
				applicants[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(applicants, (a, b) -> a[0] - b[0]);
			res = N;
			// 세팅 끝
			
			maxInterviewRank = applicants[0][1]; // 첫 번째 사람으로 초기화
			for (int i = 1; i < N; i++) {
				if(maxInterviewRank < applicants[i][1])
					res--;
				else maxInterviewRank = applicants[i][1];
			}
			
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	} // end of main
} // end of class
*/

// 1차원배열 -> 인덱스를 사용 : 정렬 시간소모X, 메모리도 아낌 개꿀

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1946_신입사원_780ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int[] applicants;
		int maxInterviewRank;
		int res; // 선발 인원
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			applicants = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				applicants[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken()); // i번째 사원의 첫 번째 능력을 기준으로 정렬하는 셈
			}
			res = N;
			// 세팅 끝
			
			maxInterviewRank = applicants[0]; // 첫 번째 사람으로 초기화
			for (int i = 1; i < N; i++) {
				if(maxInterviewRank < applicants[i])
					res--;
				else maxInterviewRank = applicants[i];
			}
			
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	} // end of main
} // end of class