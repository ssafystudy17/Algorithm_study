import java.io.*;
import java.util.*;

public class Main_백준_2138_전구와스위치_오준석 {
	private static StringBuilder sb= new StringBuilder();
	private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static int[] getArr,getAns,tempArr;
	private static int count, answer=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		input();
		go();
		changeSwitch();
		System.out.println(sb.toString());
	}

	private static void go() {
		//첫번째를 안누르고  뒤로 쭉
		changeSwitch();
		//초기화하고 첫번째를 누르고 뒤로 쭉
		count=0;
		for (int i = 0; i < N; i++) {getArr[i]=tempArr[i];}
		change(0);
		count++;
		changeSwitch();
		if (answer==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}

	private static void changeSwitch() {
		//두번째부터 쭉 비교해나가기
		//뒤에만 볼건데 이전이 같으면 걍 지나가~ 다르면? 스위치해~
		for (int i = 1; i < N; i++) {
			if (getArr[i-1]==getAns[i-1]) continue;
			else {change(i);count++;}
		}
		//마지막 원소가 같으면 성공! 다르면 실패
		if (getArr[N-1]==getAns[N-1]) answer=Math.min(answer, count);
	}
	
	//본인, 앞, 뒤의 스위치값을 변경하는 메서드
	private static void change(int idx) {
		if (idx==0) {getArr[idx]^=1; getArr[idx+1]^=1;}
		else if(idx==getArr.length-1) {getArr[idx]^=1; getArr[idx-1]^=1;}
		else {getArr[idx+1]^=1; getArr[idx]^=1; getArr[idx-1]^=1;}
	}

	private static void input() throws Exception {
		N=Integer.parseInt(br.readLine());
		getArr= new int[N];
		tempArr= new int[N];
		getAns= new int[N];
		char[] getchar=br.readLine().toCharArray();
		for (int i = 0; i < getchar.length; i++) {getArr[i]=tempArr[i]=getchar[i]-'0';}
		getchar=br.readLine().toCharArray();
		for (int i = 0; i < getchar.length; i++) {getAns[i]=getchar[i]-'0';}
	}
}