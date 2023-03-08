import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16236_아기상어_88ms {
	static final int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int[][] map;
	static boolean[][] check;
	static int N;
	static int ateFish = 0;
	static int sharkSize = 2;
	static int curX, curY;
	static int findX, findY;
	static Queue<int[]> q; // [x][y][cnt]
	static ArrayList<int[]> fishes; // [x][y] : 같은 거리에 있는 물고기들 모임
	static int res = 0;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		int input;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				input = Integer.parseInt(st.nextToken());
				if(input == 9) {
					curX = i; curY = j;
					input = 0;
				}
				map[i][j] = input;
			}
		}
		for (int i = 0; i <= N+1; i++)
			map[i][0] = map[i][N+1] = 100;
		for (int i = 1; i <= N; i++)
			map[0][i] = map[N+1][i] = 100; // 테두리는 100으로 둘러 아기상어가 못가게 한다.
		// 세팅 끝
		
		int findTime;
		while(true) {
			findTime = findFish(); // 찾았을때 간 시간, 못찾았을때 500
			if(findTime == 500) break; // 못찾음
			res += findTime;
			
			if(++ateFish == sharkSize) { // 먹은 고기 +1 해주고 사이즈만큼 먹었으면
				sharkSize++; // 사이즈 키워주기
				ateFish = 0;
			}
			map[findX][findY] = 0;
			curX = findX; curY = findY;
		}
		
		System.out.println(res);
	}


	public static int findFish() {
		int findCnt = 500; // 찾았으면 몇초만에 걸리는 거리니? -> 처음 찾을때 갱신해줘서 그 거리까지만 이동
		check = new boolean[N+2][N+2];
		
		q = new ArrayDeque<int[]>();
		fishes = new ArrayList<int[]>();
		q.add(new int[] {curX, curY, 0});
		
		int x, y, cnt, dx, dy;
		while(!q.isEmpty()) { // bfs : 물고기 처음찾고, 그 거리까지 가는 애들 전부 fishes Array에 저장
			x = q.peek()[0];
			y = q.peek()[1];
			cnt = q.poll()[2];
			
			if(cnt > findCnt) continue;
			if(0 < map[x][y] && map[x][y] < sharkSize && findCnt >= cnt) { // 물고기가 있고, 이전에 잡은 물고기 거리와 같거나(찾았을때의 값) 작을때(초기화된 값500)
				findCnt = cnt;
				fishes.add(new int[] {x, y});
			}
			
			for (int d = 0; d < 4; d++) {
				dx = x + dir[d][0];
				dy = y + dir[d][1];
				if(map[dx][dy] <= sharkSize && !check[dx][dy]) { // 크기가 같거나 작고 안간곳이면
					q.add(new int[] {dx, dy, cnt+1});
					check[dx][dy] = true;
				}
			}
		}
		
		findX = findY = 21; // 초기값
		for (int[] fish : fishes) {
			if(findX > fish[0]) { // 물고기가 가장 위에있으면 갱신
				findX = fish[0];
				findY = fish[1];
			}
			else if(findX == fish[0]) { // 같은 높이면
				if(findY > fish[1]) { // 더 왼쪽일 때 갱신
					findX = fish[0];
					findY = fish[1];
				}
			}
		}
		
		return findCnt;
	}
}
