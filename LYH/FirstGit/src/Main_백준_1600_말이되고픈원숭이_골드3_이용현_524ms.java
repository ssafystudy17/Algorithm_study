import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// Main_����_1600_���̵ǰ��¿�����_���3_�̿���_524ms
public class Main_����_1600_���̵ǰ��¿�����_���3_�̿���_524ms {
	static int[][] hDir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int K, W, H;
	static int[][] board; // �׵θ� 2�پ� ������� -> [2][2]���� [H+1][W+1]����
	static int[][][] count; // [x][y][k����質]���ڸ��� ������� �Գ� ����. �ʱⰪ : 50,000
	static Queue<int[]> q = new ArrayDeque<int[]>(); // {x, y, K(��ó�� �̵����� Ƚ��), cnt}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H + 4][W + 4]; // 2 ~ W+1, 2 ~ H+1 �׵θ� ���پ� ����
		count = new int[H + 4][W + 4][K + 1]; // 2 ~ W+1, 2 ~ H+1, ���̵��� k�� �������� count
		for (int i = 0; i < W + 3; i++)
			board[0][i] = board[1][i] = 1;
		for (int i = 0; i < H + 3; i++)
			board[i][0] = board[i][1] = 1;

		for (int i = 2; i <= H + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 2; j <= W + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				for (int k = 0; k <= K; k++)
					count[i][j][k] = 50000; // �ִ� 40,000ĭ �̹Ƿ� �ִ� �̻� ����
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

			if (k < K) { // ���̵��� ��������
				for (int d = 0; d < 8; d++) {
					dx = x + hDir[d][0];
					dy = y + hDir[d][1];
					if (board[dx][dy] == 0 && count[dx][dy][k + 1] > cnt + 1) { // �� �� �հ� ���纸�� �̵��� ���� �������� ����
						q.add(new int[] { dx, dy, k + 1, cnt + 1 });
						count[dx][dy][k + 1] = cnt + 1;
					}
				}
			}

			for (int d = 0; d < 4; d++) { // �׳� 4���� �̵�
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