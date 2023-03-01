package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1407_2로_몇번나누어질까 {
	static BufferedReader br;
	static StringTokenizer st;
	static long A, B, answer;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	} // end of main

	private static void sol() {
		System.out.println(function(B) - function(A - 1));
	}
	
	// x까지 더한 값
	private static long function(long x) {
		long n = 1;
		long sum = 0;
		// 1은 1이후로 2의 간격으로 등장
		// 2는 2 이후로 4의 간격으로 등장
		// 4는 4 이후로 8의 간격으로 등장...
		// n번째에 한번 등장한 후 n*2의 간격으로 등장
		// x 이전에 등장한 n의 개수 : 1 + (x - n) / (n * 2)
		while (x >= n) {
			long cnt = 1 + (x - n) / (n * 2); // x 이전까지 등장한 n의 개수
			sum += n * cnt; // 최종 값에 더함
			n *= 2;
		}
		return sum;
	}

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
	}
}