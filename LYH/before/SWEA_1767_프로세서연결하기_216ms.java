import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기_216ms {
	static final int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N;
	static int[] dirLast; // 4방향별 최대치
	static boolean[][] board; // 멕시노스 // 빈공간 true, 배치불가면 false;
	static ArrayList<int[]> cores; // 코어 위치 정보 2차원 배열 
	static int coresSize;
	
	static int maxCoreCnt;
	static int minLineSum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			dirLast = new int[] {0, N+1, N+1, 0};
			board = new boolean[N+2][N+2];
			cores = new ArrayList<int[]>();
			maxCoreCnt = 0;
			minLineSum = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					if(Integer.parseInt(st.nextToken()) == 0)
						board[i][j] = true; // 빈공간이면 그칸 true
					else {
						if(i != 1 && i != N && j != 1 && j != N) // 파워와 닿았을 땐 계산 안함
							cores.add(new int[] {i,j}); // 프로세서 존재시 어레이에 추가
					}
				}
			}
			coresSize = cores.size();
			dfs(0,0,0);
			sb.append("#").append(tc).append(" ").append(minLineSum).append("\n");
		}
		System.out.println(sb.toString());
	} // end of main
	
	public static void dfs(int idx, int coreCnt, int lineSum) { // 프로세스 인덱스, 사용된 프로세스수, 전선 길이 합, 전선 사용 binaryFlag
		if(idx == coresSize) {
			if(maxCoreCnt > coreCnt) return; // 코어개수가 작으면 할필요없지
			
			if(maxCoreCnt < coreCnt) { // 코어개수 많으면 무조건 얘로 초기화
				maxCoreCnt = coreCnt;
				minLineSum = lineSum;
			} else if(maxCoreCnt == coreCnt && minLineSum > lineSum) // 코어개수 같으면 최소전선으로 갱신
				minLineSum = lineSum;
			
			return;
		}
		
		// core 선택하고 4방향 재귀
		int x = cores.get(idx)[0];
		int y = cores.get(idx)[1];
		for (int d = 0; d < 4; d++) {
			if(checkPower(x, y, d)) { // d방향으로 라인설치 가능할때
				dfs(idx+1, coreCnt+1, lineSum + fillLine(x, y, d, false)); // fill과 동시에 dfs
				fillLine(x, y, d, true); // 다시 fill한 곳 취소
			}
		}
		
		// core 선택 안하고 가기
		dfs(idx+1, coreCnt, lineSum);
	}
	
	/** x, y좌표에서 d방향으로 갔을때 power에 도달하는지 */
	public static boolean checkPower(int x, int y, int d) {
		int dx = x + dir[d][0], dy = y + dir[d][1];
		
		while(dx != dirLast[d] && dy != dirLast[d]) { // 벽까지 닿는가?
			if(!board[dx][dy]) return false; // 닿기전에 false발견시 
			dx += dir[d][0];
			dy += dir[d][1];
		}
		return true;
	}
	
	/** x, y좌표에서 d방향으로 파워까지 뭘로 채울건지 */
	public static int fillLine(int x, int y, int d, boolean what) {
		int line = 0; // 몇개나 깔았는지
		int dx = x + dir[d][0], dy = y + dir[d][1];
		
		while(dx != dirLast[d] && dy != dirLast[d]) { // 벽까지 닿는가?
			board[dx][dy] = what; // 닿을때까지 what 입력
			line++;
			dx += dir[d][0];
			dy += dir[d][1];
		}
		
		return line;
	}
} // end of class
