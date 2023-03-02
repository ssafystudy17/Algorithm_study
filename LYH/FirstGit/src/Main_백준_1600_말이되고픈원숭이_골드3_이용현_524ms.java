import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// Main_백준_1600_말이되고픈원숭이_골드3_이용현_524ms
public class Main_백준_1600_말이되고픈원숭이_골드3_이용현_524ms {
	static int[][] hDir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int K, W, H;
	static int[][] board; // 테두리 2줄씩 씌울거임 -> [2][2]시작 [H+1][W+1]종료
	static int[][][] count; // [x][y][k몇번썼나]이자리에 몇번만에 왔냐 저장. 초기값 : 50,000
	static Queue<int[]> q = new ArrayDeque<int[]>(); // {x, y, K(말처럼 이동가능 횟수), cnt}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H + 4][W + 4]; // 2 ~ W+1, 2 ~ H+1 테두리 두줄씩 씌움
		count = new int[H + 4][W + 4][K + 1]; // 2 ~ W+1, 2 ~ H+1, 말이동을 k번 했을때의 count
		for (int i = 0; i < W + 3; i++)
			board[0][i] = board[1][i] = 1;
		for (int i = 0; i < H + 3; i++)
			board[i][0] = board[i][1] = 1;

		for (int i = 2; i <= H + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 2; j <= W + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				for (int k = 0; k <= K; k++)
					count[i][j][k] = 50000; // 최대 40,000칸 이므로 최대 이상값 저장
			}
		}

		q.add(new int[] { 2, 2, 0, 0 });
		count[2][2][0] = 0;
		int x, y, k, cnt, dx, dy;
		int res = 50000;
		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			k = q.peek()[2];
			cnt = q.poll()[3];

			if (k < K) { // 말이동이 남았을때
				for (int d = 0; d < 8; d++) {
					dx = x + hDir[d][0];
					dy = y + hDir[d][1];
					if (board[dx][dy] == 0 && count[dx][dy][k + 1] > cnt + 1) { // 갈 수 잇고 현재보다 이동을 적게 했을때만 저장
						q.add(new int[] { dx, dy, k + 1, cnt + 1 });
						count[dx][dy][k + 1] = cnt + 1;
					}
				}
			}

			for (int d = 0; d < 4; d++) { // 그냥 4방향 이동
				dx = x + dir[d][0];
				dy = y + dir[d][1];
				if (board[dx][dy] == 0 && count[dx][dy][k] > cnt + 1) {
					q.add(new int[] { dx, dy, k, cnt + 1 });
					count[dx][dy][k] = cnt + 1;
				}
			}
		}
		
		for (int i = 0; i <= K; i++)
			res = Math.min(res, count[H+1][W+1][i]);
		if(res != 50000) System.out.println(res);
		else System.out.println(-1);
	}
}