package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2250_트리의_높이와_너비 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] input;
	static int[] depths;
	static int N, idx, depth, answer;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		inorder(findRoot(), 1);
		for (int i = 1; i <= N; i++) {
			int leftDepth = depths[i]; // 왼쪽 깊이를 저장
			int r = N;
			// 왼쪽 깊이와 같은 깊이를 가지고있는 좌표를 오른쪽부터 찾음
			while (i <= r) {
				if (leftDepth == depths[r])
					break;
				r--;
			}
			int width = r - i + 1; // 해당 깊이를 갖는 가장 왼쪽 좌표와 가장 오른쪽 좌표의 너비
			if (answer < width || answer == width && leftDepth < depth) { // 너비가 같으면 깊이가 작은거로 초기화
				depth = leftDepth;
				answer = width;
			}
		}
		System.out.println(depth + " " + answer);
	}

	// 중위 순회를 통해 가장 왼쪽부터 깊이를 채워넣음
	private static void inorder(int v, int d) {
		if (input[v][0] != -1)
			inorder(input[v][0], d + 1);
		depths[++idx] = d;
		if (input[v][1] != -1)
			inorder(input[v][1], d + 1);

	}

	// input의 자식들을 다 확인 => 만약 1~N중 없는 값이 있다면 그 값이 root
	private static int findRoot() {
		loop: for (int child = 1; child <= N; child++) {
			for (int i = 1; i <= N; i++) {
				// 자식으로 있다? 넌 루트가 아니야. continue
				if (input[i][0] == child || input[i][1] == child)
					continue loop;
			}
			return child; // input의 자식들 중 child값이 없다면 이녀석이 root
		}
		return 1;
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N + 1][2];
		depths = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			input[p][0] = Integer.parseInt(st.nextToken());
			input[p][1] = Integer.parseInt(st.nextToken());
		}

	} // end of input

} // end of class