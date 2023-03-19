package _3월_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_2138_전구와_스위치 {
	static BufferedReader br;
	static int N, answer;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		if (arr.length == 2) { // 길이가 2일 경우 11 or 00인 상황만 스위치 가능
			if (arr[0] == arr[1]) {
				System.out.println(arr[0]);
			} else
				System.out.println(answer);
			return;
		}
        
        // 만약 첫번째를 바꿔줘야 한다면
        // 0번 클릭 or 1번 클릭 2가지 경우로 나뉨
		if (arr[0] == 1) { 
			arr[0] ^= 1; // 0번 스위치 클릭
			arr[1] ^= 1;
			onOff(1); // 한 번 클릭했으니 1을 넘겨줌
			arr[2] ^= 1; // 1번 스위치 클릭 (0번은 누르지 않음.)
			onOff(1); // 마찬가지로 한 번 클릭한 상황
		} else {
            // 클릭 안한 경우 or 0번, 1번 둘 다 클릭한 경우
			onOff(0); // 하나도 클릭 x -> 전달인자 0
			arr[2] ^= 1; // 0번, 1번 스위치 클릭
			onOff(2); // 두 번 클릭 -> 전달 인자 2

		}
		System.out.println(answer);
	}

	private static void onOff(int cnt) {
		int[] target = Arrays.copyOfRange(arr, 0, N); // 기존의 배열이 바뀌면 안되기 때문에 복사

		for (int i = 1; i < N - 2; i++) {
			if (target[i] == 1) { // 바꿔줘야하는 값이 있다면 cnt 증가
				cnt++;
				for (int j = i; j < i + 3; j++) // i부터 3개 클릭
					target[j] ^= 1;
			}
		}
        
        // 만약 마지막 2개가 같다면, 마지막 스위치를 눌러서 원하는 전구 만들 수 있음.
		if (target[N - 1] == target[N - 2]) { 
			cnt += target[N - 1];
			answer = answer == -1 ? cnt : Math.min(answer, cnt); // 초기값이면 그냥 바꿔주고 아니면 비교
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
				arr[i] = 1; // 눌러줘야 하는 스위치를 1로 설정함
		}
	} // end of input
}