package feb.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1417 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int[] getArr = new int[N];
		int answer=0;
		for (int i = 0; i < N; i++) {getArr[i]=Integer.parseInt(br.readLine());}
		while(true) {
			//반복문을 돌면서 가장 큰 값들을 탐색하고 0번째 값이 가장 크면 반복문 종료, 아니면 가장 큰 값이 위치하는 인덱스의 값을 빼고 0번째의 값을 늘리고 카운
			int max=getArr[0], maxidx=0;
			for (int i = 0; i < getArr.length; i++) {
				if (max<=getArr[i]) {
					max=getArr[i]; maxidx=i;
				}
			}
			if (maxidx==0) break;
			else {
				getArr[maxidx]--; getArr[0]++; answer++;
			}
		}
		System.out.println(answer);
	}
}
