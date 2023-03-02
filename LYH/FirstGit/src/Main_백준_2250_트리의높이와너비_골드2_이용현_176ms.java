import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Main_����_2250_Ʈ���ǳ��̿ͳʺ�_���2_�̿���_
public class Main_����_2250_Ʈ���ǳ��̿ͳʺ�_���2_�̿���_176ms {
	static int[][] tree; // Ʈ�� ������ 2���� �迭�� ���� -> index:Node, [0]:left, [1]:right
	static int height; // Ʈ�� ����
	static int[][] indexArray; // Ʈ�������� ������ ������ �迭, [0]:index, [1]:depth
	static int calIndex = 1; // ��ͼ�ȸ�ϸ� ����ҋ� �� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new int[N+1][]; // Ʈ�� ������ 2���� �迭�� ���� -> index:Node, [0]:left, [1]:right
		int[] callCount = new int[N+2]; // �ʱ⿡ ���� �� ���� �Ⱥҷȴ���(���� root�������) ã������ �迭 -> -1�� 0��° �ε����� �ֱ� ���� ��ĭ�� �ڷ� �о����
		indexArray = new int[N+1][]; // Ʈ�������� ������ ������ �迭, [0]:index, [1]:depth
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
		// ���� ��
		
		// ��Ʈ���ϱ�: �ʱ⿡ ���� �� ���� �Ⱥҷȴ���(���� root�������) ã������ �迭 -> -1�� 0��° �ε����� �ֱ� ���� ��ĭ�� �ڷ� �о����
		int root = 0;
		for (int i = 2; i <= N+1; i++) { // i-1 index���� ����
			if(callCount[i] == 0) {
				root = i-1; // -1ó���� ���� ��ĭ�� �о������ 1����
				break;
			}
		}
		
		findHeight(root, 1); // ���� ���� ���� height �������� ���, ����
		findIndexTree(root, 1); // indexArray�� �������
		
		int leftIdx, rightIdx;
		int maxWidthHeight = 1, maxWidth = 0;
		for (int h = 1; h <= height; h++) {
			for (leftIdx = 1; leftIdx <= N; leftIdx++) // ���ʿ������� ���� �ش� ���̿��� ó������ ��Ÿ����
				if(indexArray[leftIdx][1] == h) break;
			for (rightIdx = N; rightIdx >= 1; rightIdx--) // �����ʿ������� ���� �ش� ���̿��� ó������ ��Ÿ����
				if(indexArray[rightIdx][1] == h) break;
			
			if(maxWidth < rightIdx - leftIdx + 1) { // ���� ���ش��� 1 �����ָ� �ʺ�, ���̺� �ִ� ã��
				maxWidth = rightIdx - leftIdx + 1; 
				maxWidthHeight = h;
			}
		}
		
		System.out.println(maxWidthHeight + " " + maxWidth);
	}
	public static void findHeight(int curNode, int depth) {
		height = Math.max(height, depth); // ���� depth�� �� ������ ����ϸ鼭 ��� ã��
		
		if(tree[curNode][0] != -1) findHeight(tree[curNode][0], depth+1); // �����ڽ� �����ϸ� ��
		if(tree[curNode][1] != -1) findHeight(tree[curNode][1], depth+1); // �������ڽ� �����ϸ� ��
	}
	
	public static void findIndexTree(int curNode, int depth) {
		if(tree[curNode][0] != -1) findIndexTree(tree[curNode][0], depth+1); // �����ڽ� �����ϸ� ��
		indexArray[calIndex++] = new int[] {curNode, depth};
		if(tree[curNode][1] != -1) findIndexTree(tree[curNode][1], depth+1); // �������ڽ� �����ϸ� ��
	}
}