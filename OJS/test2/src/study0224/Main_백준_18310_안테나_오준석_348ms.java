package feb.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18320 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int[] getArr= new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < getArr.length; i++) {getArr[i]=Integer.parseInt(st.nextToken());}
		Arrays.sort(getArr);
		int ans=0, size=getArr.length-1;
		if (size==0||size==1) ans=getArr[0];
		else ans=getArr[size/2];
		System.out.println(ans);
	}
}
