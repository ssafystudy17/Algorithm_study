package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S1_부분수열의_합_14225 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(subset());
	}

	private static int subset() {
		int size = (int) Math.pow(2, N);
		Set<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		for (int flag = 1; flag < size; flag++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0)
					sum += numbers[i];
			}
			set.add(sum);
		}

		for (Integer k : set)
			arrList.add(k);

		Collections.sort(arrList);
		for (int n = 1; n < arrList.get(arrList.size() - 1); n++) {
			if (n != arrList.get(n - 1))
				return n;
		}
		return arrList.get(arrList.size() - 1) + 1;

	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
	} // end of input
}
