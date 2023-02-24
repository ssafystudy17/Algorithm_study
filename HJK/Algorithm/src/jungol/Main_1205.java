package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1205 {
	static int[] arr;
	static int N, zero, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		zero = 0;
		for (int i = 0; i < N; i++)
			if (arr[i] == 0)
				zero++;

		Arrays.sort(arr);
//		//System.out.println(ans);
//		//System.out.println(Arrays.toString(arr));
//		for(int i=ans;i<N;i++) {
//			if(arr[ans] == arr[ans+1]-1)ans++;
//			
//		}
//		for(int i=ans;i<N;i++) {
//			int cnt=0;
//			while(zero!=0) {cnt++;
//				if(arr[ans] == arr[ans+1]-cnt) ans++;
//				zero--;
//			}
//		}

		for (int i = 0; i < N; i++) {
			if (zero == N) {
				ans = zero;
				break;//전부 제로면 걍 답이 N
			}
			if (arr[i] == 0)
				continue;
			straight(i, 1, zero);
		}

		System.out.println(ans);
	}

	private static void straight(int index, int cnt, int zeros) {
		if (index == N - 1) { // 끝
			ans = Math.max(cnt + zeros, ans); //걍 제로 더한거랑 넣어본거중에 더 큰거
			return;
		} 
		if (arr[index + 1] == arr[index]) { //다음꺼가 값이 같을 때 뺄 순 없으니깐 스킵하깅
			straight(index + 1, cnt, zeros);
		} else if (arr[index + 1] == arr[index] + 1) { //따로 뭐 안해도 이어질때
			straight(index + 1, cnt + 1, zeros);
		} else if (zeros != 0 && arr[index + 1] - arr[index] - 1 <= zeros) { //두 값의 차이가 현 제로 수로 극복 가능할 때
			straight(index + 1, cnt + (arr[index + 1] - arr[index]), zeros - (arr[index + 1] - arr[index] - 1)); //zero사용한만큼 없애서 보내기. 
		} else if (arr[index + 1] != arr[index] + 1) { //이도저도 아니라면? 남은 제로랑 현 카운트랑 더한 거랑 지금까지의 답 중 더 큰걸로 저장하기
			ans = Math.max(cnt + zeros, ans); 
		}

	}
}
