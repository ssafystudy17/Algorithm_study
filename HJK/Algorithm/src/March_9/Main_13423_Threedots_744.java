package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13423_Threedots_744 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans = 0;
			Arrays.sort(arr);
			for (int i = 0; i < N - 2; i++) {
				int index = i + 2; //최소 3개니까.c
			em: 	for (int j = i + 1; j < N - 1; j++) {
					int diff = arr[j] - arr[i]; //a-b
					
					while (index < N) { //마지막 값 c 되기 전까지

						if (((arr[index] - arr[j]) < diff))
							index++; //마지막 값 -중간값. 작으면 더 키워야하니깐. 
						else
							break; //정렬한거라 반대는 없다
					}

					if (index == N)
						break em; //마지막 인덱스

					if (arr[index] - arr[j] == diff) 
						ans++; //가능한 경우니까 ++
//					System.out.println("diff" + diff);
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
