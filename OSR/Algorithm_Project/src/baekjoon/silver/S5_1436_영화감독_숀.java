package baekjoon.silver;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S5_1436_영화감독_숀 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K, result;
	static int[] arr, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int num = 666;

		while (cnt < N) {
			int tmp = num;
			while (tmp >= 666) {
				if (tmp % 1000 == 666) {
					cnt++;
					break;
				}
				tmp /= 10;
			}
			num++;
		}

		System.out.println(num - 1);
	}
}