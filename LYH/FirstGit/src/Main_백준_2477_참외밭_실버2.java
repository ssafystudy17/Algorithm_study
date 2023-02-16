import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 아이디어 - ㄱ모양이면 반복되는 방향이 존재한다
 * 예제(423131)에서는 3131이 반복되는데 그렇다면 그 사이의 1, 3 방향이 가진 넓이를 빼면 된다.
 * 또한 반복되는 곳과 가장 먼 42방향에 해당하는 길이가 전체 ㅁ모양의 넓이이지만
 * 구현의 편의를 위해 3131에서 3의 길이를 합한값과 1의 길이를 합한 값을 큰 ㅁ모양의 길이로 생각하였다.
*/
public class Main_백준_2477_참외밭_실버2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		int[] dir = new int[12]; // 6방향정보 * 2 해줘서 반복구간 존재하도록 저장. 예)423141은 반복구간이 없지만 423141423141 로 해주면 '1414'반복 확인가능
		int[] len = new int[12]; // 사실 6개만하고 %6하면 되지만 %연산 느리다 하셨으니 걍 두배
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = dir[i+6] = Integer.parseInt(st.nextToken());
			len[i] = len[i+6] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0; // 반복구간 시작 인덱스
		for (int i = 0; i < 10; i++) {
			if(dir[i] == dir[i+2] && dir[i+1] == dir[i+3]) {
				idx = i;
				break;
			}
		}
		
		System.out.println(K*((len[idx]+len[idx+2]) * (len[idx+1]+len[idx+3]) - len[idx+1]*len[idx+2]));
	}
}
