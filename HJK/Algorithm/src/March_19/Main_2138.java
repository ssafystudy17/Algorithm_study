package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2138 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N];
		boolean[] ansArr = new boolean[N];
		char[] tmpArr = new char[N];
		tmpArr = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			if (tmpArr[i] == '1')
				arr[i] = true;
		}
		tmpArr = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			if (tmpArr[i] == '1')
				ansArr[i] = true;
		}

		int ansEqualStart = 0;
		int ansDiffStart = 1;
		int ans = 0;
		boolean cnt = false;
		for (int j = 0; j < 2; j++) {
			int tmpAns = 0;
			boolean[] inputArr = arr.clone();
			if (cnt) {
				tmpAns = 1;
				inputArr[0] = !inputArr[0];
				inputArr[1] = !inputArr[1];
			}
			for (int i = 1; i < N - 1; i++) {
				if (inputArr[i - 1] != ansArr[i - 1]) {
					inputArr[i - 1] = !inputArr[i - 1];
					inputArr[i] = !inputArr[i];
					inputArr[i + 1] = !inputArr[i + 1];
					tmpAns++;
				}
			}
			if (inputArr[N - 2] != ansArr[N - 2]) {
				inputArr[N - 2] = !inputArr[N - 2];
				inputArr[N - 1] = !inputArr[N - 1];
				tmpAns++;
			}
			if (inputArr[N - 1] != ansArr[N - 1]) {
				tmpAns = -1;

			}
			if (!cnt)
				ansEqualStart = tmpAns;
			else
				ansDiffStart = tmpAns;
			cnt = true;
		}
		if (ansDiffStart == -1) {
			ans = ansEqualStart;
		} else if (ansEqualStart == -1) {
			ans = ansDiffStart;
		} else {
			ans = Math.min(ansEqualStart, ansDiffStart);
		}

		System.out.println(ans);
	}
}
