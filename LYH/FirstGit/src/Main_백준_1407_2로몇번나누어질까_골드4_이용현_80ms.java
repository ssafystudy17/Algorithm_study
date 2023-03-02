import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * S(B) - S(A-1)�� ����ؾ� �ϸ� S(n)�� ��Ģ�� ã�Ƴ��� �Ѵ�.
 * ex) S(18)�� ���� �� Ȧ�������Ͽ� �ʱ�ȭ�ϰ� ¦���� �ݺ������� ���ذ��鼭 ���ߴ�.
 * ���̷� Ǯ���غôµ� �ٵ� �ٽú��� ��԰���... �ִ��� �Ẹ�ڴ�.
 *  n   : 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
 * f(n) : 1 2 1 4 1 2 1 8 1 2  1  4  1  2  1  16 1  2    �� ����.
 * 1�ܰ� (Ȧ������ sum���)  : 1*18
 *        0 1 0 3 0 1 0 7 0 1  0  3  0  1  0  15 0  1
 * 2�ܰ� (¦����� ���) 2^1 : 1*9
 *        0 0 0 2 0 0 0 6 0 0  0  2  0  0  0  14 0  0
 * 3�ܰ�                      2^2 : 2*4
 *        0 0 0 0 0 0 0 4 0 0  0  0  0  0  0  12 0  0
 * 4�ܰ�                      2^3 : 4*2
 *        0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  8  0  0
 * 5�ܰ�                      2^4 : 8*1
 *        0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  0  0  0          
 *        
 *   ��� sum = 1*18  +  1*9 + 2*4 + 4*2 + 8*1
 *   
 * �� ���� ������� ����
 * 
 */

// �Ʒ� ��ȭ�� ��� Ǯ�̵� ������ ���� �ѵ� �޸� ���� ��
//		if(n==1) return 1;
//		if(n%2 == 0) return 2*S(n/2) + n/2;
//		else return 2*S(n/2) + n/2+1;

public class Main_����_1407_2�θ������������_���4_�̿���_80ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		System.out.println(S(B) - S(A-1));
	}
	
	public static long S(long n) {
		long i = 1;
		long value = n/2;
		long sum = n + i*value;
		
		while(i <= n) {
			value /= 2;
			i *= 2;
			sum += i*value;
		}
		return sum;
	}
}

// �Ųٷ� ���� �õ��� �غ� ������ ��®���� Ȯ���������� ----------
//	public static long S(long n) {
//		long sum = 0;
//		long i = 1;
//		long half;
//		
//		while(n>0) {
//			half = n/2;
//			if(n%2 != 0) half++;
//			
//			sum += half*i;
//			n -= half;
//			i *= 2;
//		}
//		
//		return sum;
//	}
//}
