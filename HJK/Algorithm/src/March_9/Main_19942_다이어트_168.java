package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_19942_다이어트_168 {
	static class Ingredient {
		int id, price;
		int[] nutrition = new int[4];

		public Ingredient(int id, int[] arr, int price) {
			super();
			this.id = id;
			this.nutrition = arr;
			this.price = price;
		}

	}

	static int N, ans;
	static int[] restriction;
	static boolean[] isSelected;
	static ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	static boolean[] ansArr;
	static String ansString;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		isSelected = new boolean[N];
		// ansArr = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		restriction = new int[4];
		for (int i = 0; i < 4; i++) {
			restriction[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] input = new int[4];
			for (int j = 0; j < 4; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			int p = Integer.parseInt(st.nextToken());
			ingredientList.add(new Ingredient(i + 1, input, p));
		}
		ansString = "";
		findSubSet(0);
		if (flag) {
			sb.append(ans).append("\n");
			for (int i = 0; i < isSelected.length; i++) {
				if (ansArr[i])
					sb.append(i + 1).append(" ");
			}
		} else {
			sb.append(-1);
		}
		System.out.println(sb.toString());
	}

	public static void findSubSet(int index) {
		if (index == N) {
			int tempPrice = 0;
			int[] restrictionCheck = Arrays.copyOf(restriction, restriction.length);
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					// 이제 합계 구해야.
					tempPrice += ingredientList.get(i).price;
					for (int j = 0; j < 4; j++) {
						// 각 영양소 비교해야.원하는 합이 나오나?
						restrictionCheck[j] = compareNutInfo(j, ingredientList.get(i), restrictionCheck[j]);
					}
				}
			}
			for (int j = 0; j < 4; j++) {
				if (restrictionCheck[j] > 0) {
					// 이건 글러먹은거. 그만 해야.
					return;
				}
			}
			// 여기까지 온 건 값이 다 제한조건 만족했다는거.그러면 price 누적해야.
			StringBuilder ansStr = new StringBuilder();
			if (ans > tempPrice) {
				flag = true;
				ans = tempPrice;
				ansArr = Arrays.copyOf(isSelected, isSelected.length);
				for (int i = 0; i < ansArr.length; i++) {
					if (ansArr[i])
						ansStr.append(i + 1);
				}
				ansString = ansStr.toString();
			} else if (ans == tempPrice) {
				ansStr.delete(0, ansStr.length());
				for (int i = 0; i < ansArr.length; i++) {
					if (isSelected[i])
						ansStr.append(i + 1);
				}

				String tempAnsStr = ansStr.toString();
				String a = tempAnsStr, b = ansString;

				if (tempAnsStr.length() > ansString.length()) {
					a = tempAnsStr.substring(0, ansString.length());
				} else {
					b = ansString.substring(0, tempAnsStr.length());
				}
				if ((b.compareTo(a)) > 0) {
					ansString = tempAnsStr;
					ansArr = Arrays.copyOf(isSelected, isSelected.length);
				}
			}

			return;
		}

		isSelected[index] = false;
		findSubSet(index + 1);
		isSelected[index] = true;
		findSubSet(index + 1);
	}

	private static int compareNutInfo(int n, Ingredient ingredient, int rest) {
		rest -= ingredient.nutrition[n];
		return rest;
	}

}
