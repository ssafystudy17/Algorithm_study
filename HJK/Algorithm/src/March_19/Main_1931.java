package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[T][2];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}

		});
		
		int end = -1;
		int ans =0;
		for(int i=0;i<T;i++) {
			if(arr[i][0]>=end) {
				end = arr[i][1];
				ans +=1;
			}
		}
		System.out.println(ans);
//		for (int i = 0; i < T; i++)
//			System.out.println(Arrays.toString(arr[i]));

	}
}
