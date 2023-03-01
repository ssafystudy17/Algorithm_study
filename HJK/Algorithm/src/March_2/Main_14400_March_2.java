package silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int[] xArr = new int[T];
		int[] yArr = new int[T];
		long ans = 0;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			xArr[i] = Integer.parseInt(st.nextToken());
			yArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(xArr);
		Arrays.sort(yArr);
		for (int i = 0; i < T; i++) {
			ans += Math.abs(xArr[i]-xArr[T / 2]) + Math.abs(yArr[i]-yArr[T / 2]);
		}
		System.out.println(ans);
	}
}