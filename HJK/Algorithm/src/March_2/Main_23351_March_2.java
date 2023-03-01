import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int temp = K;
		int cnt=0;
		em: while(true) {
			for(int i=0;i<N/A;i++) {
				if(temp==0) break em;
				temp--;
				cnt++;
			}
			temp +=B;
		}
		System.out.println(cnt);
	}
}