package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수_612 {
	static ArrayList<Integer>[] adjList;
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// 정점 n개, 간선 m개. 입력 넣기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		adjList = new ArrayList[N]; // head가 모두 null인 상태
		for (int i = 0; i < N; i++)
			adjList[i] = new ArrayList<Integer>();

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken())-1;
			to = Integer.parseInt(st.nextToken())-1;

			// 무향 그래프
			adjList[from].add(to);
			adjList[to].add(from);
		}
		int cnt= 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;}
		}
		System.out.println(cnt);
	}

	private static void dfs(int current) { // current: 탐색 정점
		visited[current] = true;
		// 자신의 인접list 확인: adjlist[current]: Arraylist<integer>
		for (int vertex : adjList[current]) {
			if (!visited[vertex]) {
				dfs(vertex);
			}
		}
	}

}

/*
 * 6 5 1 2 2 5 5 1 3 4 4 6
 */