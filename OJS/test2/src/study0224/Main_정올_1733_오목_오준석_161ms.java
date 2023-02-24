package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_1733 {
	static final int LEN=19;
	static int answer,ax,ay;
	static boolean find=false;
	static int[][] Map=new int[LEN][LEN];
	static int[] Dx= {0,1,1,1};
	static int[] Dy= {1,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < LEN; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < LEN; j++) {
				Map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//전체 탐색하다가 1이나 2나오면 dfs들어가기
		loop:
		for (int r = 0; r < LEN; r++) {
			for (int c = 0; c < LEN; c++) {
				if (Map[r][c]!=0) {
					//방향을 넣어주자
					for (int i = 0; i < 4; i++) {
						dfs(Map[r][c], 1, i, r, c);
						if (find) {
							//찾았으면 
							if (i==3) {ax=r+4;ay=c-4;
							}else {ax=r;ay=c;}
							break loop;
						}
					}
				}
			}
		}
		if (find) {
			System.out.println(answer);
			System.out.println((ax+1)+" "+(ay+1));
		}else System.out.println(answer);
	}
	
	private static void dfs(int color, int cnt, int direct, int r, int c) {
		int nx=r+Dx[direct], ny=c+Dy[direct];
		//탈출 분기: 카운트가 5일때 다음디렉션이 존재한다면 해당 디렉션이 반대면 성공 같으면 실패, 존재하지 않으면 성공.
		if (cnt==5) {
			//다음디렉션 존재?->다르면 성공 같으면 실패
			//없으면 성공->좌하대각 확인이면 최종좌표는 연산해서!
			//이전칸에서 육목이 만들어지는지 여부도 확인.
			int bx=r-(Dx[direct]*5), by=c-(Dy[direct]*5);
			if (bx>=0&&bx<LEN && by>=0&&by<LEN) {
				if (Map[bx][by]==color) {
					return;
				}
			}
			if (nx>=0&&nx<LEN && ny>=0&&ny<LEN) {
				if (Map[nx][ny]==color) {
					return;
				}
			}
			find=true;
			answer=color;
			return;
		}
		//로직
		if (nx>=0&&nx<LEN && ny>=0&&ny<LEN&&Map[nx][ny]==color) {
			dfs(color, cnt+1, direct, nx, ny);
		}
	}
}















