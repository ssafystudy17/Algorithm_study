package _3월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결_요소의_개수_11724 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, answer;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		sol();
	}

	private static void sol() {
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				answer++;
				bfs(i);
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (Integer k : graph[v]) {
				if (visited[k])
					continue;
				visited[k] = true;
				queue.add(k);
			}
		}
	} // end of bfs

	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
	} // end of input
} // end of class
