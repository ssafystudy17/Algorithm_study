package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] cumSum = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer = answer < arr[i] * (N - i) ? arr[i] * (N - i) : answer;
		}
		System.out.println(answer);

	} // end of main
}
