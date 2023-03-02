import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_13702_�̻��Ѽ���_�ǹ�3_�̿���_132ms {
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
		// ���� ��
		
		// �̺�Ž�� ����
		long left = 0, right = Integer.MAX_VALUE;
		int mid;
		while(left <= right) {
			mid = (int) ((left+right)/2);
			
			if(check(mid)) { // ������ �� ������ �� Ž��
				left = mid + 1;
				res = mid;
			}
			else right = mid-1;
		}
		
		System.out.println(res);
	}
	
	// ���ɸ��뷮 x�϶� K���� ������ �� �ִ���
	public static boolean check(int x) {
		if(x == 0) return false;
		long cnt = 0;
		for (int i = 0; i < N; i++)
			cnt += mak[i]/x;
		
		return cnt >= K;
	}
}
