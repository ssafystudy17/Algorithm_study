package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1037 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//map에 받아서, 최대 100곱100이므로 완전탐색으로 풀이
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(br.readLine());
		int[][] Map= new int[size][size];
		int cx=0, cy=0;
		boolean possible=true,change=false;
		//근데 행검사 열검사 배열을 따로 만들어서 얘네를 조사하면 빠를듯?
		//비트연산자로 해보고싶으다.
		boolean[] oddRow= new boolean[size];
		boolean[] oddCol= new boolean[size];
		
		StringTokenizer st;
		for (int i = 0; i < size; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < size; j++) {
				Map[i][j]= Integer.parseInt(st.nextToken());
				if (Map[i][j]==1) {
					//input이 1일때만 홀짝이 바뀝니당.
					if (oddRow[i]) oddRow[i]=false;
					else oddRow[i]=true;
					if (oddCol[j]) oddCol[j]=false;
					else oddCol[j]=true;
				}
			}
		}
		//쭉돌면서 홀짝이면 놔두고 홀홀이면 바꾼다음 최종적으로 쭉 확인하면 끄읕
		loop:
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (oddRow[i]&&oddCol[j]) {//둘 다 홀이면 한번 바꿔주고 다음엔 안대융
					if (!change) {
						oddRow[i]=false;
						oddCol[j]=false;
						cx=i;
						cy=j;
						change=true;
					}else {
						possible=false;//한번바꿨는데 또 나오면 그때는 불가능한겨
						break loop;
					}
				}
			}
		}
		//마지막으로 쭈욱 돌면서 확인하깅
		if (possible) {
			for (int i = 0; i < size; i++) {
				if (oddCol[i]||oddRow[i]) {
					possible=false;
					break;
				}
			}
		}
		if (possible) {
			if (change) System.out.println("Change bit ("+(cx+1)+","+(cy+1)+")");
			else System.out.println("OK");
		}else System.out.println("Corrupt");
		
	}
}