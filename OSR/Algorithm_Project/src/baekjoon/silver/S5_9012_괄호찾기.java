package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_9012_괄호찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		loop: for (int i = 0; i < N; i++) {
			int cnt = 0;
			String str = br.readLine();
			for (int k = 0; k < str.length(); k++) {
				if (str.charAt(k) == '(')
					cnt++;
				else
					cnt--;
				if (cnt < 0) {
					System.out.println("NO");
					continue loop;
				}
			}

			if (cnt == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
