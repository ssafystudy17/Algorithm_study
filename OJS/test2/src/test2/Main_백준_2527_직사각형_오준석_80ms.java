package main.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	  //(0,  1,  2,  3)
		int[][] sq1= new int[2][2];//(ax1,ay1,ax2,ay2)
		int[][] sq2= new int[2][2];//(bx1,by1,bx2,by2)
		char answer;
	
		//4개 줄
		for (int i = 0; i < 4; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int ax1=Integer.parseInt(st.nextToken());
			int ay1=Integer.parseInt(st.nextToken());
			int ax2=Integer.parseInt(st.nextToken());
			int ay2=Integer.parseInt(st.nextToken());
			int bx1=Integer.parseInt(st.nextToken());
			int by1=Integer.parseInt(st.nextToken());
			int bx2=Integer.parseInt(st.nextToken());
			int by2=Integer.parseInt(st.nextToken());
			//닿는게 있는지 없는지를 나누고, 닿는게 있다면 그게 점인지 섬인지 그냥 포함인지
			//ax2 가 bx1보다 작거나, ax1이 bx2보다 크면 닿지 않는다.
			//ay2가 by1보다 작거나, ay1이 by2보다 크면 닿지 않는다.
			if ((ax2<bx1||ax1>bx2)||(ay2<by1||ay1>by2)) {
				answer='d';
              //이미 닿지 않는 경우를 제외하였으므로 나머지는 어떻게든 닿는 상황.. 따로 예외처리를 해줄 필요가 없었다.
			} else if((ay1==by2&&(ax2==bx1||ax1==bx2))||(ay2==by1&&(ax2==bx1||ax1==bx2))) {
				//점만 닿는 경우를 생각해보자.
				answer='c';
			} else if(ax2==bx1||ay1==by2||bx2==ax1||ay2==by1) {
				answer='b';
			}
			else {//겹치는 경우
				answer='a';
			}
			System.out.println(answer);		
		}
	}
}