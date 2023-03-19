import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_13423_ThreeDots_2040ms {
	static int N;
	static int[] combi;
	static int[] dotLoc;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			combi = new int[3];
			dotLoc = new int[N];
			res = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				dotLoc[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(dotLoc); // 정렬해서 앞부터 조합짬
			
			int firstDiff;
			for (int i = 0; i < N-2; i++) {
				for (int j = i+1; j < N-1; j++) {
					firstDiff = dotLoc[j]-dotLoc[i]; // 앞에두개 차이 미리 저장
					for (int k = j+1; k < N; k++) {
						if(firstDiff == dotLoc[k] - dotLoc[j]) { // 같으면 답이지
							res++;
							break;
						} else if (firstDiff < dotLoc[k] - dotLoc[j]) // 커지면 뒤에껀 그냥 다 안됨
							break;
					}
				}
			}
			
			
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}