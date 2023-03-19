import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2304_창고다각형_88ms {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int L, H;
		int[] pillars = new int[1001]; // 기둥정보 index : 위치, value : 높이
		int pLeft = 1001, pRight = 0; // 기둥 젤 왼쪽, 오른쪽꺼
		int maxHeightIdx = 0, maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			pLeft = Math.min(pLeft, L);
			pRight= Math.max(pRight, L);
			if(maxHeight < H) { // 이렇게 하면 젤 큰 기둥이 여러개 있을때 그중에 가장 왼쪽을 가리키고 있겠죠
				maxHeight = H;
				maxHeightIdx = L;
			} else if(maxHeight == H && maxHeightIdx > L) {
				maxHeightIdx = L;
			}
			pillars[L] = H;
		}
		// 세팅 끝
		
		
		// 최고높이 이전 알고리즘
		// 왼쪽부터 가다가
		// 높은걸 만나면?
		// 		이전 올라갔던 지점 높이부터 지금까지 너비 추가 후 높아진 인덱스 저장해둠
		int bfIdx = pLeft;
		int bfHeight = pillars[pLeft];
		int sum = 0;
		for (int i = pLeft+1; i <= maxHeightIdx; i++) {
			if(bfHeight < pillars[i]) {
				sum += bfHeight * (i - bfIdx);
				bfHeight = pillars[i];
				bfIdx = i;
			}
		}
		
		// 최고높이 이후 알고리즘
		// 오른쪽부터 오다가
		// 높은걸 만나면?
		// 		이전 올라갔던 지점 높이부터 지금까지 너비 추가 후 높아진 인덱스 저장해둠
		bfIdx = pRight;
		bfHeight = pillars[pRight];
		for (int i = pRight-1; i >= maxHeightIdx; i--) {
			if(bfHeight < pillars[i]) {
				sum += bfHeight * (bfIdx - i);
				bfHeight = pillars[i];
				bfIdx = i;
			}
		}
		// 가장 큰 기둥이 여러개일때 처리해줘야하겠죠 ?
		// 가장 큰 기둥이 한개면 bfIdx == maxHeightIdx이므로 어짜피 0임
		sum += bfHeight * (bfIdx - maxHeightIdx);
		
		// 마지막으로 최고기둥 너비 구하기
		sum += maxHeight;
		
		System.out.println(sum);
	} // end of main
} // end of class