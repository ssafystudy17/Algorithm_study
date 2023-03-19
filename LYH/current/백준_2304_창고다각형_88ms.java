import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_2304_â��ٰ���_88ms {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int L, H;
		int[] pillars = new int[1001]; // ������� index : ��ġ, value : ����
		int pLeft = 1001, pRight = 0; // ��� �� ����, �����ʲ�
		int maxHeightIdx = 0, maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			pLeft = Math.min(pLeft, L);
			pRight= Math.max(pRight, L);
			if(maxHeight < H) { // �̷��� �ϸ� �� ū ����� ������ ������ ���߿� ���� ������ ����Ű�� �ְ���
				maxHeight = H;
				maxHeightIdx = L;
			} else if(maxHeight == H && maxHeightIdx > L) {
				maxHeightIdx = L;
			}
			pillars[L] = H;
		}
		// ���� ��
		
		
		// �ְ���� ���� �˰���
		// ���ʺ��� ���ٰ�
		// ������ ������?
		// 		���� �ö󰬴� ���� ���̺��� ���ݱ��� �ʺ� �߰� �� ������ �ε��� �����ص�
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
		
		// �ְ���� ���� �˰���
		// �����ʺ��� ���ٰ�
		// ������ ������?
		// 		���� �ö󰬴� ���� ���̺��� ���ݱ��� �ʺ� �߰� �� ������ �ε��� �����ص�
		bfIdx = pRight;
		bfHeight = pillars[pRight];
		for (int i = pRight-1; i >= maxHeightIdx; i--) {
			if(bfHeight < pillars[i]) {
				sum += bfHeight * (bfIdx - i);
				bfHeight = pillars[i];
				bfIdx = i;
			}
		}
		// ���� ū ����� �������϶� ó��������ϰ��� ?
		// ���� ū ����� �Ѱ��� bfIdx == maxHeightIdx�̹Ƿ� ��¥�� 0��
		sum += bfHeight * (bfIdx - maxHeightIdx);
		
		// ���������� �ְ��� �ʺ� ���ϱ�
		sum += maxHeight;
		
		System.out.println(sum);
	} // end of main
} // end of class