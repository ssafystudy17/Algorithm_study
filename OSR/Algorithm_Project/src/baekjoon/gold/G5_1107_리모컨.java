package baekjoon.gold;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class G5_1107_리모컨 {
	static BufferedReader br;
	static StringTokenizer st;
	static int M, K, answer;
	static String target;
	static Set<Integer> brokenBtn;

	public static void main(String[] args) throws IOException {
		input();
		sol();
	}

	private static void sol() {

		if (M == 10) { // 다 고장났으면 어차피 위아래 버튼으로만 움직인 값
			System.out.println(answer);
			return;
		} else if (M == 0) { // 고장난 버튼이 없다면 100에서 이동 or target길이만큼 클릭
			System.out.println(Math.min(answer, target.length()));
			return;
		}

		int down, up;
		down = up = Integer.valueOf(target);
		int cnt = 0;
		while (down >= 0) {
			if (canBtn(down)) {
				cnt += Integer.toString(down).length();
				break;
			}
			down--;
			cnt++;
		}
		answer = Math.min(answer, cnt);
//		System.out.println(cnt);

		cnt = 0;
		while (up < 1000000) {
			if (canBtn(up)) {
				cnt += Integer.toString(up).length();
				break;
			}
			up++;
			cnt++;
		}
//		System.out.println(cnt);

		System.out.println(Math.min(answer, cnt));
	} // end of solution

	private static boolean canBtn(int number) {
		String str = Integer.toString(number);
		for (int i = 0; i < str.length(); i++) {
			if (brokenBtn.contains(str.charAt(i) - '0'))
				return false;
		}
		return true;
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		target = br.readLine();
		M = Integer.parseInt(br.readLine());
		brokenBtn = new HashSet<>();

		if (M != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++)
				brokenBtn.add(Integer.parseInt(st.nextToken()));
		}

		answer = Math.abs(Integer.valueOf(target) - 100); // 위아래 버튼으로만 이동한 것
	} // end of input
}