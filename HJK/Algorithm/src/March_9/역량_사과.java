package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class 역량_사과 {

	public static class Apple implements Comparable<Apple> {
		int x;
		int y;
		int number; // 순서.

		public Apple(int x, int y, int number) {
			super();
			this.x = x;
			this.y = y;
			this.number = number;
		}

		@Override
		public int compareTo(Apple o) {
			return this.number - o.number;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] rotationCnt = { { 2, 3, 1, 3 }, { 3, 1, 3, 2 }, { 1, 2, 3, 3 }, { 3, 3, 2, 1 } };
		int[][] rotDir = { { 1, 3, 2, 3 }, { 2, 3, 2, 0 }, { 1, 3, 0, 0 }, { 1, 1, 2, 0 } };

		int T = Integer.parseInt(br.readLine()); // testCase input.

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 배열 크기. 사과 위치 읽어야 함.
			List<Apple> appleLocationList = new ArrayList<Apple>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken()); // 배열 순으로 들어온거 하나씩만 읽기.
					if (temp == 0)
						continue;
					appleLocationList.add(new Apple(j, i, temp));

				}
			} // 사과 위치랑 순서 받기.

			Collections.sort(appleLocationList); // 사과 입력 순서대로 정리하기.
			int direction = 0; // 방향 down으로 시작.
			int loc = 0;
			int ans = 1; // 첫번째 좌표로 이동은 무조건 1이라서. 이게 출력할 답.
			for (int rot = 0; rot < appleLocationList.size() - 1; rot++) {
				int curX = appleLocationList.get(rot).x;
				int curY = appleLocationList.get(rot).y;
				int nextX = appleLocationList.get(rot + 1).x;
				int nextY = appleLocationList.get(rot + 1).y;

				// 현 위치 기점으로 다음 사과가 사분면 어디에 위치하는지.
				if (curX > nextX && curY > nextY) {
					// 1
					loc = 0;
				} else if (curX < nextX && curY > nextY) {
					// 2
					loc = 1;
				} else if (curX > nextX && curY < nextY) {
					// 3
					loc = 2;
				} else {
					// 4
					loc = 3;
				}

				ans += rotationCnt[direction][loc];
				direction = rotDir[direction][loc];
			}

			sb.append("#").append(testCase).append(" ").append(ans).append("\n");
		} // end of testcase
		System.out.println(sb.toString());

	}// end of main
}// end of class