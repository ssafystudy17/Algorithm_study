import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_����_2527_���簢��_�ǹ�1 {
	static int[] sq1, sq2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			sq1 = new int[4];
			sq2 = new int[4];
			for (int j = 0; j < 4; j++) {
				sq1[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) {
				sq2[j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(where(sq1[0], sq1[1], sq1[2], sq1[3], sq2[0], sq2[1], sq2[2], sq2[3])).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// �ּ��� �ٿ��� ǥ��
	public static char where(int l1, int b1, int r1, int t1, int l2, int b2, int r2, int t2) {
		if(r1 < l2 ||  l1 > r2 || t1 < b2 || b1 > t2) // ��ĥ���� ����
			return 'd';
		else if(r1 == l2 || l1 == r2) { // ���� ����
			if(t1 == b2 || b1 == t2)
				return 'c';
			else return 'b';
		}
        else if(t1 == b2 || b1 == t2) {
            if(r1 == l2 || l1 == r2) 
            	return 'c';
            else return 'b';
        }
        else return 'a';
	}
	
	// ex: �簢��1 ������ < �簢��2 ���� -> 1���� < 2��
//	public static char where(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
//		// x��ǥ���� �б�
//		if(x1 < x2) { // �簢��1 ���ʺ� < �簢��2 ���ʺ� (���� ����)
//			if(p1 < x2) // 1���� < 2�� -> ��ĥ���� ����
//				return 'd';
//			else if (p1 == x2) { // 1���� == 2�� ���� �����̶��
//				if(y1 < y2) { // 1�Ʒ� < 2�Ʒ�
//					if(q1 < y2) // 1�� < 2�Ʒ� -> �Ȱ�ħ
//						return 'd';
//					else if(q1 == y2) // 1�� == 2�Ʒ�
//						return 'c';
//					else // q1 > y2 // 1�� > 2�Ʒ�
//						return 'b';
//				} else if (y1 == y2) {// 1�Ʒ� == 2�Ʒ� -> �簢������ ��ĥ���ۿ� �����ʳ� ?
//					return 'a';
//				} else { // y1 > y2 // 1�Ʒ� > 2�Ʒ�
//					if(y1 > q2) // 1�Ʒ� > 2�� -> �Ȱ�ħ
//						return 'd';
//					else if(y1 == q2) // 1�Ʒ� == 2��
//						return 'c';
//					else // y1 < q2 // 1�Ʒ� < 2��
//						return 'b';
//				}
//			} else { // p1 > x2 // 1���� > 2��
//				if(y1 < y2) { // 1�Ʒ� < 2�Ʒ�
//					if(q1 < y2) // 1�� < 2�Ʒ� -> �Ȱ�ħ
//						return 'd';
//					else if(q1 == y2) // 1�� == 2�Ʒ�
//						return 'b';
//					else // q1 > y2 // 1�� > 2�Ʒ�
//						return 'a';
//				} else if (y1 == y2) {// 1�Ʒ� == 2�Ʒ� -> �簢������ ��ĥ���ۿ� �����ʳ� ?
//					return 'a';
//				} else { // y1 > y2 // 1�Ʒ� > 2�Ʒ�
//					if(y1 > q2) // 1�Ʒ� > 2�� -> �Ȱ�ħ
//						return 'd';
//					else if(y1 == q2) // 1�Ʒ� == 2��
//						return 'b';
//					else // y1 < q2 // 1�Ʒ� < 2��
//						return 'a';
//				}
//			}
//		} else if (x1 == x2) { // �簢��1 ���ʺ� == �簢��2 ���ʺ�
//			if(y1 < y2) { // 
//		}
//		
//		return 'z';
//	}

	
//	// ���� ù��° ���簢���� ��� ��ġ�ϴ���
//	// ���̸� 0 ���̸� 1 ���̸� 2 ���̸� 3
//	public static int where(int x, int y) {
//		// x��ǥ �������� �ϴ�
//		if(x < sq1[0] || x > sq1[2]) { // �簢���ۿ� ������ ������ 0
//			return 0;
//		} else if(x == sq1[0] || x == sq1[2]) { // ����, ������ �� �̶� ���� �����϶� y��ǥ Ȯ��
//			if(y > sq1[1] || y < sq1[3]) // ������ �ۿ��ִ�
//				return 0;
//			else if(y == sq1[1] || y == sq1[3]) // �簢���� ���̶� ��ġ
//				return 1;
//			else // �� ���� ����
//				return 2;
//		} else { // �簢�� �ȿ� ������ y��ǥȮ��
//			if(y > sq1[1] || y < sq1[3]) // ������ �ۿ��ִ�
//				return 0;
//			else if(y == sq1[1] || y == sq1[3]) // ���Ʒ� ������ ����
//				return 1;
//			else // �簢�� �ȿ� ����
//				return 3;
//		}
//	}
}
