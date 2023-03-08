import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {
	static final int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N;
	static int[][] board;
	static int eggCnt;
	static int poX, poY;
	static boolean[] canFlag;
	static int maxAte;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int input;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N+2][N+2];
			eggCnt = 0;
			maxAte = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					input = Integer.parseInt(st.nextToken());
					if(input == 1) {
						board[i][j] = ++eggCnt;
					} else if(input == 2) {
						poX = i;
						poY = j;
						board[i][j] = 0;
					}
				}
			}
			canFlag = new boolean[eggCnt+1];
			for (int i = 0; i <= N+1; i++)
				board[i][0] = board[0][i] = board[i][N+1] = board[N+1][i] = -1;
			
			dfs(0, poX, poY);
			for (int i = 1; i <= eggCnt; i++) {
				if(canFlag[i])
					maxAte++;
			}
			sb.append("#").append(tc).append(" ").append(maxAte).append("\n");
		} // end of testCase
		System.out.println(sb.toString());
	} // end of main
	
	
	public static void dfs(int idx, int x, int y) {
		if(idx == 3)
			return;
		
		ArrayList<int[]> canGo = new ArrayList<int[]>();
		int curX, curY;
		int unitCnt;
		for (int d = 0; d < 4; d++) {
			curX = x+dir[d][0];
			curY = y+dir[d][1];
			unitCnt = 0;
			while(board[curX][curY] != -1) { // 테두리 일때까지
				if(unitCnt == 1)
					canGo.add(new int[] {curX, curY});
				
				if(board[curX][curY] != 0) { // 알 발견
					if(++unitCnt == 2) break; // 두번째 발견이면 break;
				} 
				
				curX += dir[d][0];
				curY += dir[d][1];
			}
		}
		
		int cnt;
		for (int[] xy : canGo) {
			curX = xy[0];
			curY = xy[1];
			if(board[curX][curY] == 0) {
				dfs(idx+1, curX, curY);
			} else {
				cnt = board[curX][curY];
				board[curX][curY] = 0;
				canFlag[cnt] = true;
				dfs(idx+1, curX, curY);
				board[curX][curY] = cnt;
			}
		}
	}
} // end of class
