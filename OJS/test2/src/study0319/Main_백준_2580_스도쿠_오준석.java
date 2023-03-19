import java.io.*;
import java.util.*;

public class Main_백준_2580_스도쿠_오준석 {
	
	static class Pair{
		int r,c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + "]";
		}
	}
	
	private static BufferedReader br;
	private static boolean clear;
	private static int[][] Map;
	private static StringTokenizer st;
	private static ArrayList<Pair> zeroList= new ArrayList<>();
	private static boolean[][] rowCheck,colCheck;
	
	public static void main(String[] args) throws Exception {
		input();//입력을 받으면서 0의 위치들을 순서대로 기억한다. 또한 각 행의 숫자들도 확인해놓자.
		dfs(0);//첫번째 좌표부터 들어갈 수 있는 숫자들을 넣는데 여기 안에서는 열과 작은 상자를 확인한다.
		//0인 위치의 좌표들을 쭉 가지고 있다가, 0인 위치에 들어갈 수 있는 값들을 하나씩 넣어보면서
		//불가능하면 이전으로 돌아가서 다른 숫자를 넣는다.
	}
	//dfs에 가능한 숫자들을 반복해서 넣어주고 재귀호출.
	//끝까지 숫자를 모두 넣을 수 있었다면 dfs를 종료한다.
	//중간에 겹치는 숫자가 발생한다면 걔는 백트레킹 처리
	
	//dfs함수
	private static void dfs(int cnt) {
		if (clear) return;
		if (cnt==zeroList.size()) {//모든 0을 채우면 탈출 조건!
			print();
			clear=true;
			return;
		}
		Pair now=zeroList.get(cnt);
		//가로체크해서 되는값 체크
		//세로체크해서 되는 값 체크
		//박스체크해서 되는 값 체크
		//반복문 돌면서 남는 값 넣기.
		for (int i = 1; i <= 9; i++) {
			if (!rowCheck[now.r][i]&&!colCheck[now.c][i]&&boxCheck(3*(now.r/3),3*(now.c/3),i)) {
				Map[now.r][now.c]=i;
				rowCheck[now.r][i]=true;
				colCheck[now.c][i]=true;
				dfs(cnt+1);
				rowCheck[now.r][i]=false;
				colCheck[now.c][i]=false;
				Map[now.r][now.c]=0;
			}
		}
	}
	
	//박스체크 함수
	private static boolean boxCheck(int r, int c, int val) {
		//박스 전부 조사, 가능하면 true안되면 false
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if (Map[i][j]==val) {
					return false;
				}
			}
		}
		return true;
	}
	
	//출력함수
	private static void print() {
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < Map.length; i++) {
			for (int j = 0; j < Map.length; j++) {
				sb.append(Map[i][j]+" ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	//입력함수
	private static void input() throws Exception {
		br= new BufferedReader(new InputStreamReader(System.in));
		Map= new int[9][9];
		rowCheck= new boolean[9][10];
		colCheck= new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 9; j++) {
				Map[i][j]= Integer.parseInt(st.nextToken());
				if (Map[i][j]==0) {
					zeroList.add(new Pair(i, j));
				}else {
					rowCheck[i][Map[i][j]]=true;
					colCheck[j][Map[i][j]]=true;
				}
			}
		}
	}
}