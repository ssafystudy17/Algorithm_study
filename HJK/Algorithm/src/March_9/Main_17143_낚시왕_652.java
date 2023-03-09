package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17143_낚시왕_652 {
	// 상어의 방향과 크기를 저장할 클래스 혹은 배열
	// 상어의 정보를
	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s; // 속력
			this.d = d; // 이동방향
			this.z = z;// 크기
		}
	}

	static List<Shark> arr;
	static int ans = 0;
	static int man = 0;
	static int R, C, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<Shark>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = 0, c = 0, s = 0, d = 0, z = 0;
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			//s = leastS(s, d);
			arr.add(new Shark(r, c, s, d, z));
		}

		while (man <= C) {
			man++;
			catchShark();
			if (man == C)
				break;
			sharkLoc();
			eatShark();

		}
		System.out.println(ans);

	} // end of main

	public static int leastS(int s, int d) {
		int tempS = 0;
		// if(s==0) return 0;
		if (d == 1 || d == 2) { // 위아래
			tempS = (s) % (R * 2 - 2);
		} else {
			tempS = (s) % (C * 2 - 2);

		}
		return tempS;

	}

	public static void eatShark() {
		Shark[][] sh = new Shark[R + 1][C + 1];

//		for (Shark sha : arr) {
//			System.out.printf("먹히기 전 상어의 위치들 : 행, 열, 크기 (%d, %d, %d)\n", sha.r, sha.c, sha.z);
//		}
//		System.out.println();

		for (int i = 0; i < arr.size(); i++) {
			int[] temp = new int[] { arr.get(i).r, arr.get(i).c };
			int goR = temp[0];
			int goC = temp[1];
			if (sh[goR][goC] == null) {
				int newR = arr.get(i).r;
				int newC = arr.get(i).c;
				int newS = arr.get(i).s;
				int newD = arr.get(i).d;
				int newZ = arr.get(i).z;
				sh[goR][goC] = new Shark(newR, newC, newS, newD, newZ);
			} else {
				if (sh[goR][goC].z < arr.get(i).z) {
					int newR = arr.get(i).r;
					int newC = arr.get(i).c;
					int newS = arr.get(i).s;
					int newD = arr.get(i).d;
					int newZ = arr.get(i).z;
					sh[goR][goC] = new Shark(newR, newC, newS, newD, newZ);
				}
			}
		}

		arr.clear();

		for (int i = 0; i < R + 1; i++) {
			for (int j = 0; j < C + 1; j++) {
				if (sh[i][j] == null)
					continue;
				Shark temp = new Shark(sh[i][j].r, sh[i][j].c, sh[i][j].s, sh[i][j].d, sh[i][j].z);
				arr.add(temp);
			}
		}

//		for (Shark sha : arr) {
//			System.out.printf("먹히기 후 상어의 위치들 : 행, 열, 크기 (%d, %d, %d)\n", sha.r, sha.c, sha.z);
//		}
//
//		System.out.println();
//		System.out.println();
	}

	public static void catchShark() {
		int min_r = R + 3;
		int index = -1;
		for (int i = 0; i < arr.size(); i++) { // 상어가 잡아먹히면서 arr의 크기가 변화하므로 M을 arr.size()로 수정하였습니다
			if (arr.get(i).c == man) {
				if (arr.get(i).r <= min_r) {
					min_r = arr.get(i).r;
					index = i;
				}
			}
		}

		if (index > -1) {
			ans += arr.get(index).z;
			arr.remove(index);
		}
	}

	public static void sharkLoc() {
		for (Shark shark : arr) {
			int tmp = 0;
			switch(shark.d) {
			case 1: //상
				tmp = (shark.r - shark.s - 2*R + 2) % (2*R - 2);
				tmp *= -1;
				
				if (tmp < R) {
					shark.d = 2;
					shark.r = tmp;
				}else {
					shark.r = 2*R - 2 - tmp;
				}
				break;

			case 2: //하
				tmp = (shark.r + shark.s) % (2*R - 2);

				if (tmp < R) {
					shark.r = tmp;
				}else {
					shark.d = 1;
					shark.r = 2*R - 2 - tmp;
				}
				break;

			case 3: //오
				tmp = (shark.c + shark.s) % (2*C - 2);

				if (tmp < C) {
					shark.c = tmp;
				}else {
					shark.d = 4;
					shark.c = 2*C - 2 - tmp;
				}
				break;

			case 4: //왼
				tmp = (shark.c - shark.s - 2*C + 2) % (2*C - 2);
				tmp *= -1;
				
				if (tmp < C) {
					shark.d = 3;
					shark.c = tmp;
				}else {
					shark.c = 2*C - 2 - tmp;
				}
				break;
			}
		}

	}
} // end of class
