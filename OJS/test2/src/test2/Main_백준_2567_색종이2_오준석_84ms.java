package main.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567 {
	static int[] dr= {0,0,-1,1};
	static int[] dc= {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int[][] map= new int[101][101];
		int answer=0;
		int[][] getStart= new int[T][2];
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			getStart[i][0]=Integer.parseInt(st.nextToken());
			getStart[i][1]=Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < getStart.length; i++) {
			int nowx=getStart[i][0], nowy=getStart[i][1];
			//색칠하깅
			for (int row = getStart[i][0]; row < getStart[i][0]+10; row++) {
				for (int col = nowy=getStart[i][1]; col < getStart[i][1]+10; col++) {
					if (map[row][col]==0) {
						map[row][col]=1;
					}
				}
			}
		}
		//색칠한 애들을 돌면서 1일때 4방향 탐색으로 0이나 끝인지 여부를 찾기
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map.length; col++) {
				if (map[row][col]==1) {
					for (int i = 0; i < 4; i++) {
						int nr=row+dr[i], nc=col+dc[i];
						//4방향 탐색
						if (nr>=0&&nr<map.length&&nc>=0&&nc<map.length) {
							if (map[nr][nc]==0) answer++;
						}
						if (row==0||row==map.length-1) answer++;
						if (col==0||col==map.length-1) answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}