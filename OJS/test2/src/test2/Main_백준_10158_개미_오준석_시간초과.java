package main.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		//격자공간의 크기
		int w=Integer.parseInt(st.nextToken()), h=Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		//개미의 첫위치
		int ax=Integer.parseInt(st.nextToken()), ay=Integer.parseInt(st.nextToken());
		int t= Integer.parseInt(br.readLine());	//개미가 움직이는 시간
		int tx=ax,ty=ay;
		int dx=1,dy=1,count=0;
		int rw=w*2, rh=h*2;
		int gcd=getGcd(Math.max(rw,rh),Math.min(rw, rh));
		count=(rw*rh)/gcd;
		//w*2만큼 가로로 다녀오면 돌아오고, h*2만큼 세로로 다녀오면 돌아오기 때문에 이 둘의 최소공배수가 카운트가 된다.
		t%=count;
		for (int i = 0; i < t; i++) {
			tx+=dx;
			ty+=dy;
			//가로벽에 부딪히면 dx를 전환
			if (tx==w||tx==0) dx*=-1;
			//세로벽에 부딪히면 dy를 전환
			if (ty==h||ty==0) dy*=-1;
		}
		//t시간 후 개미의 위치를 출력하자
		System.out.println(tx+" "+ty);
	}
	private static int getGcd(int w, int h) {
		if (w%h==0) return h;
		else return getGcd(h, w%h);
	}
}