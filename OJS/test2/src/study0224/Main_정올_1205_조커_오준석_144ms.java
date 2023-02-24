package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1205 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int N= Integer.parseInt(st.nextToken());
		int jokers=0, max=0;
		int[] getArr= new int[N];
		st= new StringTokenizer(br.readLine()," ");
		//해당인덱스부터 시작해서 이을 수 있는 최대 길이를 출력하자.
		//정렬해야할거고
		//누적합으로 풀면최악의 경우여도->개수가 1000이므로 충분할듯?
		//앞쪽에 있는 0들을 세고 이후 토큰처럼 사용하면 되지 않을까?
		for (int i = 0; i < N; i++) {
			getArr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(getArr);
		for (int i = 0; i < N; i++) {
			//0이면 조커개수 세고 넘어가자
			int tempjokers=0;
			if (getArr[i]==0) {
				jokers++;
				continue;
			}
			int len=1,before=getArr[i];
			tempjokers=jokers;
			for (int idx = i+1; idx < getArr.length; idx++) {
				if (getArr[idx]==before+1) {
					len++;
					before=getArr[idx];
				}else if(getArr[idx]==before) {
					continue;
				}
				else {
					if (tempjokers>0) {
						tempjokers--;
						idx--;
						len++;
						before+=1;
					}else break;
				}
			}
			if (len>max) max=len+tempjokers;
		}
		max=Math.max(max, jokers);
		System.out.println(max);
	}
}
