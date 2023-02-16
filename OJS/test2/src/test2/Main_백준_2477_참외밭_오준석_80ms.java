package main.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477 {
	/*
	 * 같은 방향 사이에 끼어있는 놈이 작은 변..
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int K= Integer.parseInt(st.nextToken());
		int[] directions= new int[6];
		int[] sizes= new int[6];
		int[] small= new int[2];
		int[] big= new int[2];
		int idx=0;
		
		for (int i = 0; i < 6; i++) {
			st= new StringTokenizer(br.readLine()," ");
			directions[i]=Integer.parseInt(st.nextToken());
			sizes[i]=Integer.parseInt(st.nextToken());	
		}
		//재현이는 .length는 따로 연산이 없어서 편하게 사용하면 된다는데 얘기해보면 좋을듯
		//구현체를 보면 하나의 필드로 구성되어있음
		//배열만가능, arraylist의 size는 사용x
		//앞뒤를 확인하면서 같은 방향 사이에 껴있는 애가 작은 변, 1,4중에 큰애가 큰변, 2,3중에 큰애가 큰변
		for (int i = 0; i < sizes.length; i++) {
			if (i==0) { //0이면 이전 방향은 마지막에 있음
				//앞뒤를 확인하면서 같은 방향 사이에 껴있는 애가 작은 변
				if (directions[i+1]==directions[sizes.length-1]) {
					small[idx]=sizes[i];
					//앞뒤가 같으면 얘네 합친게 큰변임
					big[idx]=sizes[i+1]+sizes[sizes.length-1];
					idx++;
				}
			}else if (i==sizes.length-1) {
				if (directions[i-1]==directions[0]) {
					small[idx]=sizes[i];
					big[idx]=sizes[i-1]+sizes[0];
					idx++;
				}
			}else {
				if (directions[i-1]==directions[i+1]) {
					small[idx]=sizes[i];
					big[idx]=sizes[i-1]+sizes[i+1];
					idx++;
				}
			}
		}
		System.out.println(K*(big[0]*big[1]-small[0]*small[1]));
	}//eofmain

}//eofclass

