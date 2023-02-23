package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int myVote = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(0);
			return;
		}
		
		// 우선순위 큐에서 나보다 득표가 많은 사람의 득표수 -1 한 뒤 다시 우선순위 큐에 넣음
		// 내 득표수가 최대가 된다면 return
		PriorityQueue<Integer> voteQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N - 1; i++)
			voteQueue.add(Integer.parseInt(br.readLine()));

		int cnt = 0;
		while (true) {
			int first = voteQueue.poll();
			if (first < myVote) {
				System.out.println(cnt);
				return;
			}

			myVote++;
			cnt++;
			voteQueue.add(first - 1);
		}

	} // end of main
}
