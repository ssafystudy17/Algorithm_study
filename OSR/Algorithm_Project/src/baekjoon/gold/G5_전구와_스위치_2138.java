package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_전구와_스위치_2138 {
	static BufferedReader br;
	static int N, answer;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		if (arr.length == 2) {
			if (arr[0] == arr[1]) {
				System.out.println(arr[0]);
			} else
				System.out.println(answer);
			return;
		}

		if (arr[0] == 1) {
			arr[0] ^= 1; // 0번 스위치 클릭
			arr[1] ^= 1;
			onOff(1);
			arr[2] ^= 1; // 1번 스위치 클릭
			onOff(1);
		} else {
			onOff(0); // 하나도 클릭 x
			arr[2] ^= 1; // 0번, 1번 스위치 클릭
			onOff(2);

		}
		System.out.println(answer);
	}

	private static void onOff(int cnt) {
		int[] target = Arrays.copyOfRange(arr, 0, N);

		for (int i = 1; i < N - 2; i++) {
			if (target[i] == 1) {
				cnt++;
				for (int j = i; j < i + 3; j++)
					target[j] ^= 1;
			}
		}

		if (target[N - 1] == target[N - 2]) {
			cnt += target[N - 1];
			answer = answer == -1 ? cnt : Math.min(answer, cnt);
		}

	} // end of onoff

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		answer = -1;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		String c = br.readLine();
		String t = br.readLine();
		for (int i = 0; i < N; i++) {
			if (c.charAt(i) != t.charAt(i))
				arr[i] = 1;
		}
	} // end of input
}
