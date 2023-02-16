package baekjoon.gold;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<int[]> info = new LinkedList<int[]>();
		int K = sc.nextInt(); // 1m^2당 참외 개수
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();
			info.add(new int[] { dir, dis });
		}
		int garo = 0;
		int sero = 0;
		for (int i = 0; i < 6; i++) { // 큰 사각형의 가로, 세로 구하기
			int dir = info.get(i)[0];
			int dis = info.get(i)[1];
			if (dir == 1 || dir == 2)
				garo = Math.max(dis, garo);
			else
				sero = Math.max(dis, sero);
		}

		info.addAll(info); // 지그재그되는 부분을 찾기 위해
		int subSize = 0;
        // 3131 or 1414 or 4242 or 2323
		for (int i = 0; i < info.size() - 4; i++) {
			if (info.get(i)[0] == info.get(i + 2)[0] && info.get(i + 1)[0] == info.get(i + 3)[0]) {
				subSize = info.get(i + 1)[1] * info.get(i + 2)[1];
				break;
			}
		}
		System.out.println((garo * sero - subSize) * K);
	} // end of main
}
