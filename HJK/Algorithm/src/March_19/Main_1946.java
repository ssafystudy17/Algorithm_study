package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			int tmpCnt =0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				int a = arr[i][1] = Integer.parseInt(st.nextToken());
				if(a==1)tmpCnt=arr[i][0];
			}
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}

			});
//			for (int i = 0; i < N; i++)
//				System.out.println(Arrays.toString(arr[i]));
			
			if(arr[0][0]==arr[0][1]) {
				sb.append(1).append("\n");
				continue;
			}//최적인 경우라.
			int tmpVal=arr[0][1];
			int ans=tmpCnt;
//			System.out.println(tmpVal + "tmpVal");
//			System.out.println(tmpCnt + " tmpCnt");
			for(int i=1;i<tmpCnt;i++) {
//				System.out.println("for " + arr[i][0] + " "+ arr[i][1]);
				if(tmpVal>arr[i][1]) {
					tmpVal = arr[i][1];
//					System.out.println(arr[i][0] + " "+ arr[i][1]);
				}else {
					ans--;
//					System.out.println("tmpCnt--, now: " +i );
					
				}
			}
			sb.append(ans).append("\n");
			
		}
		System.out.println(sb.toString());

	}
}
