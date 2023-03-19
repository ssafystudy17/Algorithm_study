package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기_672 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int high = arr[N - 1]; //이것보다 높을 순 없으니깐
		int low = 1; //0높인 못짜르니깐
		while (low < high) {
			long val = 0;
			int mid = (low + high) / 2;
			for (int i = 0; i < N; i++) {
				if (arr[i] >= mid)
					val += (arr[i] - mid);
			}
			if (val < M) {
				high = mid;
			} else if(val>=M) {
				low = mid + 1;
			}
			//System.out.println(low + " "+ mid+" "+ high + "low, mid, high");
		}
		System.out.println(high - 1);
	}
}
