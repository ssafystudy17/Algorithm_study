package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1205 {
	static int N, zeroCount, max, answer;
	static int[] arr, cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input start
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		max = 0;
		zeroCount = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
			if (arr[i] == 0)
				zeroCount++;
		}
		answer = zeroCount;

		cards = new int[max + 1];
		for (int i = 0; i < N; i++)
			cards[arr[i]] = 1;
		// input end

		cards[0] = 0;
		for (int k : arr) {
			if (k == 0 || cards[k - 1] != 0)
				continue;
			answer = Math.max(answer, findMaxLen(k));
		}

		System.out.println(answer);

	} // end of main

	private static int findMaxLen(int k) {
		int availZero = zeroCount;
		int cnt = 1;
		int number = k + 1;
		while (true) {
			if (number == cards.length)
				break;

			if (cards[number] == 0) {
				if (availZero == 0)
					break;
				else
					availZero--;
			}
			cnt++;
			number++;
		}
		return cnt + availZero;
	}
} // end of class
