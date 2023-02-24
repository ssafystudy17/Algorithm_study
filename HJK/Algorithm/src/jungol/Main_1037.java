package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1037 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[T][T];
		String[] ansArr = { "OK", "Change bit (%d,%d)", "Corrupt" };
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < T; i++) {
				arr[t][i] = Integer.parseInt(st.nextToken()); 
			}
		} // finished importing
		
		char[][] map = new char[T][];
		for(int i=0;i<T;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int prX = -1, prY = -1;
		int countX = 0, countY = 0;
		int ans = 0;
		for (int i = 0; i < T; i++) {
			int tempX = 0, tempY = 0;
			for (int j = 0; j < T; j++) {
				tempX += arr[i][j];
				tempY += arr[j][i];
			}
			if (tempX % 2 != 0) {
				if (prX == -1)
					countX++;
				prX = i;
			}
			if (tempY % 2 != 0 && prY == -1) {
				if (prY == -1)
					countY++;
				prY = i;
			}
		}
		if (prX == -1 && prY == -1) {
			ans = 0;
		} else if (countX > 1 || countY > 1 || countX != countY) {
			ans = 2;
		} else if(countX==1){ 
			ans = 1;
			arr[prX ][ prY ]^=1;
		}
		em: for (int i = 0; i < T; i++) {
			if(ans==0)break em;
//			for(int j=0;j<T;j++)
//			System.out.println(Arrays.toString(arr[j]));
//			System.out.println("--------------------------------------");
			int tempX = 0, tempY = 0;
			for (int j = 0; j < T; j++) {
				tempX += arr[i][j];
				tempY += arr[j][i];
			}
			if (tempX % 2 == 0 &&tempY % 2 == 0 ) {
				ans=1;
			}else {
				ans=2;
				break;
			}
			
		}
		if (ans != 1)
			System.out.println(ansArr[ans]);
		else
			System.out.printf(ansArr[ans], prX + 1, prY + 1);
	}
} 
