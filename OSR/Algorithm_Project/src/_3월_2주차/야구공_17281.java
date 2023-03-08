package _3월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야구공_17281 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, answer;
	static int[][] ining;
	static int[] numbers; // 1~8까지의 숫자(인덱스)를 담는 순열
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		input();
		permutation(0);
		System.out.println(answer);
	}

	private static void permutation(int index) {
		if (index == 8) {
			answer = Math.max(answer, countScore());
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (isSelected[i])
				continue;

			numbers[index] = i + 2; // 2번타자부터 9번타자까지 배치하기 위해
			isSelected[i] = true;
			permutation(index + 1);
			isSelected[i] = false;
		}

	}

	private static int countScore() {
		int outCount = 0;
		int[] order = new int[10]; // order[i] : i번째 타차는 order[i]번 선수이다
		int[] base = new int[5]; // 1~3번 : 1~3번 베이스, 4: 홈
		int i = 1;
		int in = 1;

		makeOrder(order); // 1번 선수를 4번타자로 배치

		while (true) {
			if (in > N) // 이닝이 N보다 커지면 끝
				break;

			int hit = ining[in][order[i++]];
			if (hit == 0)
				outCount++;
			else
				moveBase(base, hit); // 베이스 이동

			if (outCount == 3) {
				outCount = 0;
				in++;
				resetBase(base); // 이닝이 끝나면 base 초기화
			}

			if (i > 9) // 9번타자까지 있기 때문에
				i = 1;
		}
		return base[4];
	}

	private static void makeOrder(int[] order) {
		for (int o = 1, n = 0; o <= 9; o++, n++) {
			if (o == 4) { // 4번타자는 1번 선수여야 함.
				order[o] = 1;
				n--; // numbers의 인덱스는 그대로 유지해야되기 때문에
			} else
				order[o] = numbers[n];
		}
	}

	private static void resetBase(int[] base) {
		for (int i = 0; i <= 3; i++)
			base[i] = 0;
	}

	private static void moveBase(int[] base, int n) {
		base[0] = 1; // 안타
		for (int from = 3; from >= 0; from--) { // 3루부터 0루(타석) 순으로 진루
			int to = Math.min(from + n, 4); // n만큼 진루, 최대로 갈 수 있는 곳은 4번 베이스(홈)
			base[to] += base[from]; // 베이스 이동
			base[from] = 0; // 이동한 곳은 0으로 초기화
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		answer = 0;
		ining = new int[N + 1][10]; // N개의 이닝, 1~9번까지의 선수
		numbers = new int[8]; // 2~9를 담을 순열
		isSelected = new boolean[8];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++)
				ining[i][j] = Integer.parseInt(st.nextToken());
		}
	} // end of input
}