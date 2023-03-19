import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ����_2230_������_276ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		int minDiff = 2000000000;
		int i = 0, j = 1;
		int diff;
		while(i < N && j < N) {
			diff = A[j] - A[i];
			if(minDiff > diff && diff >= M) {
				minDiff = diff;
				continue;
			}
			
			// �پ������� ���̸� Ű������
			if(i + 1 == j) j++;
			// ���̰� M���� ������ ���̸� Ű������
			else if(diff < M) j++;
			// �������� ���̸� �ٿ�����
			else i++;
		}
		System.out.println(minDiff);
	}
}
