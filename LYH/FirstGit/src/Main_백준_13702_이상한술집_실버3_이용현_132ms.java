import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_13702_이상한술집_실버3_이용현_132ms {
	static int N, K;
	static int[] mak;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		mak = new int[N];
		int res = 0;
		for (int i = 0; i < N; i++)
			mak[i] = Integer.parseInt(br.readLine());
		// 세팅 끝
		
		// 이분탐색 시작
		long left = 0, right = Integer.MAX_VALUE;
		int mid;
		while(left <= right) {
			mid = (int) ((left+right)/2);
			
			if(check(mid)) { // 나눠줄 수 있으면 더 탐색
				left = mid + 1;
				res = mid;
			}
			else right = mid-1;
		}
		
		System.out.println(res);
	}
	
	// 막걸리용량 x일때 K명에게 나눠줄 수 있는지
	public static boolean check(int x) {
		if(x == 0) return false;
		long cnt = 0;
		for (int i = 0; i < N; i++)
			cnt += mak[i]/x;
		
		return cnt >= K;
	}
}
