package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17281_야구_920 {

	static class Inning {
		int playerNumber;
		int[] InningScore;

		public Inning(int playerNumber, int[] inningScore) {
			this.playerNumber = playerNumber;
			InningScore = inningScore;
		}

	}

	static ArrayList<Inning> records = new ArrayList<Inning>();
	static int N;
	static int[] playerOrderArr = new int[9];
	static boolean[] isSelected = new boolean[9];
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] inputArr = new int[N][9];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				inputArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 9; i++) {
			int[] tempArr = new int[N];
			for (int j = 0; j < N; j++) {
				tempArr[j] = inputArr[j][i];
			}
			records.add(new Inning(i + 1, tempArr)); // 저장 완.
		}
		// 이제 순열 생성해서 순서 섞어서 값 찾아볼 차례.먼저 순서를 섞어야하고, 그 다음엔 그 값으로 최대 점수 찾아내야함.
		playerOrderArr[3] = 0;
		isSelected[0] = true;
		permutation(0);

		System.out.println(ans);
	}

	private static void permutation(int cnt) {
		if (cnt == 9) {
//			//순서는 만들어냄.. 이제 이 순서대로 치는 거.
			ans = Math.max(ans, calcScore(playerOrderArr));
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (cnt == 3) {
				cnt++;
				continue;
			}
			if (!isSelected[i]) {
				isSelected[i] = true;
				playerOrderArr[cnt] = i;
				permutation(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	private static int calcScore(int[] order) {
		int tempScore = 0;
		int outCnt = 0;
		int stopedPlayer = 0;
		Queue<Integer> base = new ArrayDeque<Integer>();
		ex: for (int i = 0; i < N; i++) {
			base.clear();
			for (int j = 0; j < 3; j++) {
				base.add(0);
			}
			// order[] //이게 플레이어 번호. 얘의 이닝 값을 불러와야한다.
			// i는 이닝. 몇번째 라운든지.
			int player = stopedPlayer;
			em: while (true) {

				int whichBall = records.get(order[player]).InningScore[i];

				if (whichBall == 0) { // 아웃처리.

					outCnt++;
					player = (player + 1) % 9;
					if (outCnt == 3) {
						stopedPlayer = player;
						outCnt = 0;
						continue ex;
					}
					continue em;
				}

				base.add(1); // 쨋든 1은 넣어야하니까.
				int temp = base.poll();
				if (temp == 1)
					tempScore++;
				for (int k = 0; k < whichBall - 1; k++) { // 4번째로 돌아온 경우는 0으로 바꿔줘야 하는데,,?
					base.add(0);

					temp = base.poll();
					if (temp == 1)
						tempScore++;
				}
				player = (player + 1) % 9;
			}
		}
		return tempScore;
	}

}
