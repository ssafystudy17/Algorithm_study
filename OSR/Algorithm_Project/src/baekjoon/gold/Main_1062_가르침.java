package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, K;
	static Set<Character>[] setArr;
	static char[] alphabet;
	static char[] learn;
	static int R, answer = 0;

	public static void main(String[] args) throws IOException {
		input();
		if (K < 5) { // antic은 읽을 수 있어야 함.
			System.out.println(0);
			return;
		}

		if (K - 5 >= alphabet.length) { // 단어를 읽기 위해 필요한 모든 문자보다 가르칠 수 있는 문자의 개수가 더 크면 N
			System.out.println(N);
			return;
		}

		R = K - 5; // nCr의 r을 담당
		combination(0, 0);
		System.out.println(answer);

	}

	public static void combination(int index, int start) {
		if (index == R) {
			int cnt = 0;
			Set<Character> learnSet = new HashSet<>(); // setArr[i]의 모든 문자가 learn에 포함되어있는지 확인하기 위한 set
			for (int i = 0; i < learn.length; i++)
				learnSet.add(learn[i]);

			for (int i = 0; i < N; i++) {
				if (learnSet.containsAll(setArr[i]))
					cnt++;
			}

			answer = Math.max(answer, cnt);
			return;
		}

		for (int i = start; i < alphabet.length; i++) {
			learn[index] = alphabet[i];
			combination(index + 1, i + 1);
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		setArr = new HashSet[N]; // 각각의 단어에서 알아야하는 단어를 담을 set (antic 제외 => antic은 이미 배웠다고 처리할 예정)
		Set<Character> alphaSet = new HashSet<>(); // 각각의 단어를 읽기 위해 알아야하는 모든 문자를 담을 set (antic 제외)
		for (int i = 0; i < N; i++) {
			setArr[i] = new HashSet<Character>();
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char k = str.charAt(j);
				if (!"antic".contains(k + "")) { // a,n,t,i,c가 아니라면 삽입
					setArr[i].add(k);
					alphaSet.add(k);
				}
			}
		}

		if (K < 5) // 최소 antic 5개의 단어는 알아야하기 때문에
			return;

		learn = new char[K - 5]; // 배울 수 있는 문자를 담을 예정 (조합 사용)
		alphabet = new char[alphaSet.size()]; // 조합을 사용하기 위해(인덱스 접근) alphaSet을 배열로 변환
		int i = 0;
		for (char c : alphaSet) {
			alphabet[i++] = c;
		}
	}
}