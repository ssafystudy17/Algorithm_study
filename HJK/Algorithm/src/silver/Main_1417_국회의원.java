package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1417_국회의원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N-1];
		int mine = Integer.parseInt(br.readLine());
		for (int i = 0; i < N-1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans=0;
		Arrays.sort(arr);
		while((N-2)>=0&&arr[N-2]>=mine) {
			mine++;
			arr[N-2]--;
			ans++;
			Arrays.sort(arr);
			
		}

		System.out.println(ans);
	}
}
