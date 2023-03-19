package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 단어_정렬_1181 {
	static BufferedReader br;
	static int N;
	static String[] alphas;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < alphas.length; i++) {
			set.add(alphas[i]);
		}
		String[] str = new String[set.size()];
		int idx = 0;
		for (String string : set) {
			str[idx++] = string;
		}
		Arrays.sort(str, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
		
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		alphas = new String[N];

		for (int i = 0; i < N; i++)
			alphas[i] = br.readLine();

	} // end of input
}
