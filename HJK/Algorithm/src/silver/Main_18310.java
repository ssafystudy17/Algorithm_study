package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18310 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		int min = Integer.MAX_VALUE;
//		int ans = 0;
//		for (int i = 0; i < N; i++) {
//			int temp = 0;
//			for (int j = 0; j < N; j++) {
//				temp += Math.abs(arr[i] - arr[j]);
//			}
//			if (temp < min) {
//				ans = i;
//				min = temp;
//			}
//		}
		Arrays.sort(arr);
		N-=1;
		System.out.println(arr[N/2]);
	}
}
