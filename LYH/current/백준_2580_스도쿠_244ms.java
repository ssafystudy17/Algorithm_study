import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ¹éÁØ_2580_½ºµµÄí_244ms {
	static int[][] sdoku;
	static ArrayList<int[]> holes;
	static boolean[][] row;
	static boolean[][] col;
	static boolean[][] sqr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		
		sdoku = new int[9][9]; 
		holes = new ArrayList<int[]>(); // ºó Ä­ ÁÂÇ¥
		// index 1~9 Á¸Àç¿©ºÎ
		row = new boolean[9][10];
		col = new boolean[9][10];
		sqr = new boolean[9][10];
		
		int input;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sdoku[i][j] = input = Integer.parseInt(st.nextToken());
				if(input == 0) {
					holes.add(new int[] {i,j});
				} else {
					row[i][input] = true;
					col[j][input] = true;
					sqr[(i/3)*3 + j/3][input] = true;
				}
			}
		}
		
		dfs(0);
	} // end of main
	
	public static void dfs(int idx) {
		if(idx == holes.size())
			printSdoku();
		
		int x = holes.get(idx)[0], y = holes.get(idx)[1];
        int sq = x/3*3+y/3;
		for (int num = 1; num <= 9; num++) {
			if(!row[x][num] && !col[y][num] && !sqr[sq][num]) {
				row[x][num] = col[y][num] = sqr[sq][num] = true;
				sdoku[x][y] = num;
				dfs(idx+1);
				row[x][num] = col[y][num] = sqr[sq][num] = false;
			}
		}
	}
	
	public static void printSdoku() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(sdoku[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.exit(0);
	}
} // end of class