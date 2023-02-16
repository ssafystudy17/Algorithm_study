import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2567_색종이2_실버4 {
	static boolean[][] paper = new boolean[102][102];
	static boolean[][] check = new boolean[102][102];
	static int[][] dir = {{-1,0}, {0,1},{1,0},{0,-1}};
	static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int x, y;
		
		for (int p = 1; p <= N; p++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					paper[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(paper[i][j] && !check[i][j]) {
					check[i][j] = true;
					bfs(i, j);
					for (int k = 0; k < 4; k++) {
						if(!paper[i+dir[k][0]][j+dir[k][1]])
							res++;
					}
				}
			}
		}
		
		System.out.println(res);
	}
	
	public static void bfs(int x, int y) {
		int dx,dy;
		for (int i = 0; i < 4; i++) {
			dx = x+dir[i][0];
			dy = y+dir[i][1];
			if(paper[dx][dy] && !check[dx][dy]) {
				check[dx][dy] = true;
				for (int j = 0; j < 4; j++) {
					if(!paper[dx+dir[j][0]][dy+dir[j][1]])
						res++;
				}
				bfs(dx, dy);
			}
		}
	}
}