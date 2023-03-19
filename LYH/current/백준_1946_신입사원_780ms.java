// 2���� �迭��� -> �����ϴµ� �ð� ���� �ҿ�
// 3164ms
// 1���� �ε������ -> ���� �ʿ� X
// 780ms


/***
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ����_1946_���Ի��_ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] applicants;
		int maxInterviewRank;
		int res; // ���� �ο�
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
			// ���� ��
			
			maxInterviewRank = applicants[0][1]; // ù ��° ������� �ʱ�ȭ
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

// 1�����迭 -> �ε����� ��� : ���� �ð��Ҹ�X, �޸𸮵� �Ƴ� ����

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_1946_���Ի��_780ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int[] applicants;
		int maxInterviewRank;
		int res; // ���� �ο�
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			applicants = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				applicants[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken()); // i��° ����� ù ��° �ɷ��� �������� �����ϴ� ��
			}
			res = N;
			// ���� ��
			
			maxInterviewRank = applicants[0]; // ù ��° ������� �ʱ�ȭ
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