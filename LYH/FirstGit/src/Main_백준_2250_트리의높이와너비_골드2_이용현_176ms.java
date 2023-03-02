import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Main_백준_2250_트리의높이와너비_골드2_이용현_
public class Main_백준_2250_트리의높이와너비_골드2_이용현_176ms {
	static int[][] tree; // 트리 구조를 2차원 배열로 저장 -> index:Node, [0]:left, [1]:right
	static int height; // 트리 높이
	static int[][] indexArray; // 트리노드들의 순서를 저장할 배열, [0]:index, [1]:depth
	static int calIndex = 1; // 재귀순회하며 계산할떄 쓸 변수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new int[N+1][]; // 트리 구조를 2차원 배열로 저장 -> index:Node, [0]:left, [1]:right
		int[] callCount = new int[N+2]; // 초기에 누가 한 번도 안불렸는지(누가 root노드인지) 찾기위한 배열 -> -1을 0번째 인덱스에 넣기 위해 한칸씩 뒤로 밀어놨음
		indexArray = new int[N+1][]; // 트리노드들의 순서를 저장할 배열, [0]:index, [1]:depth
		int treeIdx, left, right;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			treeIdx = Integer.parseInt(st.nextToken());
			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());
			tree[treeIdx] = new int[] {left, right};
			callCount[left+1]++;
			callCount[right+1]++;
		}
		// 세팅 끝
		
		// 루트구하기: 초기에 누가 한 번도 안불렸는지(누가 root노드인지) 찾기위한 배열 -> -1을 0번째 인덱스에 넣기 위해 한칸씩 뒤로 밀어놨음
		int root = 0;
		for (int i = 2; i <= N+1; i++) { // i-1 index임을 주의
			if(callCount[i] == 0) {
				root = i-1; // -1처리를 위해 한칸씩 밀어놨으니 1빼줌
				break;
			}
		}
		
		findHeight(root, 1); // 가장 깊이 들어가서 height 전역변수 계산, 갱신
		findIndexTree(root, 1); // indexArray를 계산하자
		
		int leftIdx, rightIdx;
		int maxWidthHeight = 1, maxWidth = 0;
		for (int h = 1; h <= height; h++) {
			for (leftIdx = 1; leftIdx <= N; leftIdx++) // 왼쪽에서부터 누가 해당 높이에서 처음으로 나타나냐
				if(indexArray[leftIdx][1] == h) break;
			for (rightIdx = N; rightIdx >= 1; rightIdx--) // 오른쪽에서부터 누가 해당 높이에서 처음으로 나타나냐
				if(indexArray[rightIdx][1] == h) break;
			
			if(maxWidth < rightIdx - leftIdx + 1) { // 둘이 빼준다음 1 더해주면 너비, 높이별 최댓값 찾기
				maxWidth = rightIdx - leftIdx + 1; 
				maxWidthHeight = h;
			}
		}
		
		System.out.println(maxWidthHeight + " " + maxWidth);
	}
	public static void findHeight(int curNode, int depth) {
		height = Math.max(height, depth); // 현재 depth가 젤 높은지 재귀하면서 계속 찾기
		
		if(tree[curNode][0] != -1) findHeight(tree[curNode][0], depth+1); // 왼쪽자식 존재하면 들어가
		if(tree[curNode][1] != -1) findHeight(tree[curNode][1], depth+1); // 오른쪽자식 존재하면 들어가
	}
	
	public static void findIndexTree(int curNode, int depth) {
		if(tree[curNode][0] != -1) findIndexTree(tree[curNode][0], depth+1); // 왼쪽자식 존재하면 들어가
		indexArray[calIndex++] = new int[] {curNode, depth};
		if(tree[curNode][1] != -1) findIndexTree(tree[curNode][1], depth+1); // 오른쪽자식 존재하면 들어가
	}
}