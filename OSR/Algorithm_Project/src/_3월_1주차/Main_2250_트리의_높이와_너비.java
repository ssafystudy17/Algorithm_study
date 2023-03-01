package _3월_1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2250_트리의_높이와_너비 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] tree;
	static int[][] input;
	static int[] nodePos;
	static int N, idx;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {
		makeTree();
		inorder(1);
		System.out.println(Arrays.toString(nodePos));
	}

	private static void inorder(int i) {
		System.out.println(tree[i]);
		if (tree[i] == -1)
			return;
		inorder(i * 2);
		nodePos[++idx] = tree[i];
		inorder(i * 2 + 1);

	}

	private static void makeTree() {
		loop: for (int child = 1; child <= N; child++) {
			for (int i = 0; i < N; i++) {
				if (input[i][0] == child || input[i][1] == child)
					continue loop;
			}
			tree[1] = child;
			break;
		}

		for (int i = 1; i <= 20001; i++) {
			if (tree[i] == -1 || tree[i] == 0)
				continue;

			int parent = tree[i];
			tree[i * 2] = input[parent][0];
			tree[i * 2 + 1] = input[parent][1];
		}
//		System.out.println(Arrays.toString(tree));
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[20002];
		nodePos = new int[N + 1];
		input = new int[N + 1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			input[p][0] = Integer.parseInt(st.nextToken());
			input[p][1] = Integer.parseInt(st.nextToken());
		}
	} // end of input

} // end of class
