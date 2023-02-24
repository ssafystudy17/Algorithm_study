import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_18310_안테나_실버3_이용현_280ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] houseLoc = new int[100001]; // index가 바로 집의 위치, 값은 그 index에 존재하는 집의 갯수
		long sum = 0; // 탐색중 사용하는 총 거리합
		int tmp;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			houseLoc[tmp]++;
			sum += tmp-1;
		}

		long min = sum; // result - 입력중 위치가 0일때 총 거리합으로 초기화
		int minIdx = 1; // 가장 작을때의 안테나 idx
		int left = 0; // 탐색Idx보다 왼쪽에 있는 집들 갯수
		int right = N; // 탐색Idx보다 오른쪽에 있는 집들 갯수
		
		for (int i = 1; i <= 100000; i++) {
			left += houseLoc[i-1];
			sum += left - right; // 한칸 움직일때마다 왼쪽집들 거리는 집갯수만큼 늘어나고 오른쪽은 줄어듦
			right -= houseLoc[i];
//			System.out.println(i + " " + sum);
			if(min > sum) {
				min = sum;
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	} // end of main
} // end of class