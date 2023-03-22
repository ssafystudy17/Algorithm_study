package _03_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G4_2015_수들의_합_4 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K;
	static int[] arr;
	static long answer;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		int prefixSum = 0; // 누적합
		int diff = 0; // K와의 차이
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];
			diff = prefixSum - K; // diff값이 있다면 있는 개수만큼 더해줌
			if (map.keySet().contains(diff))
				answer += map.get(diff);

			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}
		System.out.println(answer);
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		arr = new int[N];
		map.put(0, 1); // 0:1을 넣어줘야 첫 배열을 시작할 때 자기 자신이 K인 경우를 셀 수 있음

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
	} // end of input
}