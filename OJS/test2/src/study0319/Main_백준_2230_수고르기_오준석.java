import java.io.*;
import java.util.*;

public class Main_백준_2230_수고르기_오준석 {
	private static StringTokenizer st;
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	private static int N,M,first,answer=Integer.MAX_VALUE;
	private static int[] getArr;
	
	public static void main(String[] args) throws Exception {
		input();
		find();
		System.out.println(answer);
	}

	private static void find() {
		//마지막까지 본인이나 뒤에 애들을 고르면서 비교->그냥하면 시간초과, 매개변수 탐색으로 찾는다.
		for (int i = 0; i < getArr.length; i++) {
			first=getArr[i];
			binarySearch(i,N-1);
		}
	}

	private static void binarySearch(int low, int high) {
		int mid=(low+high)/2;
		if(low<=high) {
			int comp=getArr[mid]-first;
			if (comp<M) {//조건을 만족안할때 값을 높여야한다.
				binarySearch(mid+1, high);
			}else { //조건을 만족한다면 그 크기를 더 줄일 수 있는지 시도해본다.
				binarySearch(low, mid-1);
				answer=Math.min(answer, comp);
			}
		}
	}

	private static void input() throws Exception {
		st= new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		getArr= new int[N];
		for (int i = 0; i < getArr.length; i++) {
			getArr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(getArr);
	}
}
