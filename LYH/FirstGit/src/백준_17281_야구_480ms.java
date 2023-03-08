import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17281_야구_480ms {
	static int[] perm; // 타순
	static int[][] hitterScore;
	static int N;
	static int maxScore = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		perm = new int[10];
		perm[4] = 1;
		hitterScore = new int[N][10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++)
				hitterScore[i][j] = Integer.parseInt(st.nextToken());
		}
		
		permutation(1, 1);
		
		System.out.println(maxScore);
	}
	
	static void permutation(int idx, int flag) {
		if(idx == 10) {
			playBall();
			return;
		}
		
		for (int i = 2; i <= 9; i++) {
			if((flag & 1<<i) == 0) {
				perm[idx] = i;
				permutation(idx==3?5:idx+1, flag|1<<i); // 4번타자 스킵
			}
		}
	}
	
	static void playBall() {
		int score = 0;
		int hitterIdx = 1;
		int outCnt;
		int[] base; // 0:사용X, 1~3루
		
		for (int inning = 0; inning < N; inning++) {
			outCnt = 0;
			base = new int[4];
			
			while(outCnt < 3) {
				switch (hitterScore[inning][perm[hitterIdx]]) {
				case 1:
					score += base[3];
					base[3] = base[2];
					base[2] = base[1];
					base[1] = 1;
					break;
				case 2:
					score += base[3] + base[2];
					base[3] = base[1];
					base[2] = 1;
					base[1] = 0;
					break;
				case 3:
					score += base[3] + base[2] + base[1];
					base[3] = 1;
					base[2] = base[1] = 0;
					break;
				case 4:
					score += base[3] + base[2] + base[1] + 1;
					base[3] = base[2] = base[1] = 0;
					break;
				case 0:
					outCnt++;
					break;
				}
				
				if(++hitterIdx == 10)
					hitterIdx = 1;
			}
		}
		maxScore = Math.max(maxScore, score);
	}
}
