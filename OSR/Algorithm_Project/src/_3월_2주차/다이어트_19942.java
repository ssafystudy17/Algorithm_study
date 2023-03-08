package _3월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다이어트_19942 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] nutrient;
	static int[][] ingredient;
	static int[] numbers;
	static int price;
	static String answerStr;

	public static void main(String[] args) throws IOException {
		input();
		subSetBinaryCounting(); // 부분집합 비트마스킹
	}

	private static void subSetBinaryCounting() {
		int size = (int) Math.pow(2, N);

		for (int flag = 1; flag < size; flag++) {
			int[] tmpNutrient = new int[5]; // 집합에 해당하는 영양분과 가격을 더해서 넣어줄 배열
			String tmpStr = ""; // 뽑은 재료의 인덱스를 붙일 문자열
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					sumNutrient(tmpNutrient, i);
					tmpStr += (i + 1) + " ";
				}
			}
			if (canFood(tmpNutrient)) {
				// answerStr이 0이거나(한번도 안바뀌었으면 그냥 넣자)
				// 가격이 기존 가격보다 싸거나
				// 가격이 같지만 사전순으로 더 빠르면
				// 최종 정답들을 바꿔줌
				if (answerStr.length() == 0 || tmpNutrient[4] < price
						|| (tmpNutrient[4] == price && answerStr.compareTo(tmpStr) > 0)) {
					price = tmpNutrient[4];
					answerStr = tmpStr;
				}
			}
		}

		if (answerStr.length() == 0)
			System.out.println(-1);
		else {
			System.out.println(price);
			System.out.println(answerStr);
		}
	}

	private static boolean canFood(int[] tmpNutrient) {
		for (int i = 0; i < 4; i++) {
			if (tmpNutrient[i] < nutrient[i])
				return false;
		}
		return true;
	}

	private static void sumNutrient(int[] tmpNutrient, int idx) {
		for (int i = 0; i < 5; i++) {
			tmpNutrient[i] += ingredient[idx][i];
		}
	}

	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nutrient = new int[4];
		ingredient = new int[N][5];
		numbers = new int[N];
		price = 0;
		answerStr = "";

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++)
			nutrient[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++)
				ingredient[i][j] = Integer.parseInt(st.nextToken());
			price += ingredient[i][4];
		}
	} // end of input
}