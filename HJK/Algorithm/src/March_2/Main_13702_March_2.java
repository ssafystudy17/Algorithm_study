package silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] alcohol = new int[N];
		long high = 0;
		long low = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			high += alcohol[i] = Integer.parseInt(br.readLine());
			if (low > alcohol[i])
				low = alcohol[i];
		}
		high /= K; // 가장 많아봐야..
		low /= K;

		long mid;

		while (low <= high) {
			int cnt = 0;
			mid = (low + high) / 2;

			for (int i = 0; i < N; i++) {
				cnt += (alcohol[i] / mid);
			}
			if (cnt < K) {
				high = mid - 1;
			} else if (cnt >= K) {
				low = mid + 1;
			}
		}

		System.out.println(high);
	}

}