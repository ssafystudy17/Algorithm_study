import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {
	static final int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N;
	static int[][] board;
	static int eggCnt; // 장기알에 1부터 번호붙이기
	static int poX, poY;
	static boolean[] canFlag; // 탐색하며 가능한 장기알 번호 true로 바꿔줌
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
					} else if(input == 2) { // 포 찾기 후 0으로 바꿔줌
						poX = i;
						poY = j;
						board[i][j] = 0;
					}
				}
			}
			canFlag = new boolean[eggCnt+1];
			for (int i = 0; i <= N+1; i++) // 테두리 -1
				board[i][0] = board[0][i] = board[i][N+1] = board[N+1][i] = -1;
			// 세팅 끝
			
			dfs(0, poX, poY); // 탐색 진행
			
			for (int i = 1; i <= eggCnt; i++) { // 몇개 알까지 먹었나~
				if(canFlag[i])
					maxAte++;
			}
			sb.append("#").append(tc).append(" ").append(maxAte).append("\n");
		} // end of testCase
		System.out.println(sb.toString());
	} // end of main
	
	
	public static void dfs(int idx, int x, int y) {
		if(idx == 3) // 세번까지
			return;
		
		ArrayList<int[]> canGo = new ArrayList<int[]>(); // 알이 갈 수 있는 좌표 저장
		int curX, curY;
		int unitCnt;
		for (int d = 0; d < 4; d++) {
			curX = x+dir[d][0];
			curY = y+dir[d][1];
			unitCnt = 0;
			while(board[curX][curY] != -1) { // 테두리 만날때까지 진행
				if(unitCnt == 1) // 알을 한번만나 넘어간 위치는 전부 add
					canGo.add(new int[] {curX, curY});
				
				if(board[curX][curY] != 0) { // 알을 만나면
					if(++unitCnt == 2) break; // 만난 개수 ++해주고 나서 2면 break;
				} 
				
				curX += dir[d][0];
				curY += dir[d][1];
			}
		}
		
		int cnt;
		for (int[] xy : canGo) { // 갈 수 있는 위치에 있는 좌표값들에 대하여
			curX = xy[0];
			curY = xy[1];
			if(board[curX][curY] == 0) { // 빈공간이면 그냥 진행
				dfs(idx+1, curX, curY);
			} else { // 알을 만나면
				cnt = board[curX][curY]; // 살짝 저장해두고
				board[curX][curY] = 0; // 먹었으니 0으로 바꿔주고
				canFlag[cnt] = true; // 먹은 알 idx true로 해주고
				dfs(idx+1, curX, curY); // 다음으로 진행
				board[curX][curY] = cnt; // 돌아와서 다시 false
			}
		}
	}
} // end of class
