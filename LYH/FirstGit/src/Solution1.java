import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution1 {
	static final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; // 오른,아래,왼,위
	static int N;
	static int[][] board;
	static int[][][] check; // 일종의 dp 배열 [x][y][d] : rotate수(몇번 돌았는지) 를 저장
	static int appleCnt; // 사과 개수
	static Queue<int[]> q; // bfs
	static int nowX, nowY, nowD; // 좌표, 방향
	
	static int rotateCnt; // 계속 
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int input;
		int x, y, d, rc;
		int dx, dy, dd;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N+2][N+2];
			nowX = 1; nowY = 1; nowD = 0;
			rotateCnt = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					board[i][j] = input = Integer.parseInt(st.nextToken());
					if(input != 0) {
						appleCnt++; // 왼쪽 위부터 사과에 1부터 차례로 번호를 붙여주었다. 아래 bfs에서 apple이 증가하며 해당하는 apple을 발견할때까지 진행
					}
				}
			}
			for (int i = 0; i <= N+1; i++) // 테두리<3
				board[i][0] = board[i][N+1] = board[0][i] = board[N+1][i] = -1;
			// 세팅 끝
			
			
			for (int appleN = 1; appleN <= appleCnt; appleN++) { // 사과 하나씩 진행
				check = new int[N+2][N+2][4];  // 사과마다 길을 찾아야하니 초기화
				for (int i = 1; i <= N; i++)
					for (int j = 1; j <= N; j++)
						for (int di = 0; di < 4; di++)
							check[i][j][di] = Integer.MAX_VALUE; // 클 때 진행하도록, 찾으면서 갱신되도록 최댓값 초기화
				for (int i = 0; i <= N+1; i++)
					for (int di = 0; di < 4; di++)
						check[i][0][di] = check[i][N+1][di] = check[0][i][di] = check[N+1][i][di] = -1; // 못가도록 -1 -> 비교시 check가 더 클때만 진행하므로 작게설정
				q = new ArrayDeque<int[]>();
				q.add(new int[] {nowX, nowY, nowD, rotateCnt}); // 현재 좌표, 방향, 몇번이나 돌았는지
				check[nowX][nowY][nowD] = rotateCnt;
				
				while(!q.isEmpty()) {
					x = q.peek()[0];
					y = q.peek()[1];
					d = q.peek()[2];
					rc = q.poll()[3];
					
					if(board[x][y] == appleN) { // 해당 번호 찾을때까지
						nowX = x; nowY = y; nowD = d;
						rotateCnt = rc; // 얼마나 돌았나
						break;
					}
					
					// 직선으로 가면
					dx = x + dir[d][0];
					dy = y + dir[d][1];
					if(check[dx][dy][d] > rc) {
						q.add(new int[] {dx, dy, d, rc});
						check[dx][dy][d] = rc;
					}
					
					// 오른쪽으로 회전하고 진행하면
					dd = (d+1)%4;
					dx = x + dir[dd][0];
					dy = y + dir[dd][1];
					if(check[dx][dy][dd] > rc) {
						q.add(new int[] {dx, dy, dd, rc+1});
						check[dx][dy][dd] = rc+1;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(rotateCnt).append("\n");
		}
		System.out.println(sb.toString());
	} // end of main
} // end of class