import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class ����_2138_�����ͽ���ġ_112ms {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String nowStr = br.readLine();
		boolean[] now1 = new boolean[nowStr.length() + 1];
		for (int i = 0; i < N; i++)
			if(nowStr.charAt(i) == '1')
				now1[i] = true;
		boolean[] now2 = new boolean[nowStr.length() + 1];
		for (int i = 0; i < N; i++)
			if(nowStr.charAt(i) == '1')
				now2[i] = true;
		
		String wantStr = br.readLine();
		boolean[] want = new boolean[wantStr.length() + 1];
		for (int i = 0; i < N; i++)
			if(wantStr.charAt(i) == '1')
				want[i] = true;
		boolean can = false;
		int cnt = 0;
		// ���� ��
		// �� ���� �Ȱ��� �������� 1������ �� �Ͱ� ���� ������ �����Ͽ� �ι�����
		
		
		// 1��°�� ������ ��
		for (int i = 1; i < N; i++) {
			if(now1[i-1] != want[i-1]) { // �������� �ٸ��� �̹��� �ٲ���� ������ ��ȸ��
				now1[i-1] ^= true;
				now1[i] ^= true;
				now1[i+1] ^= true;
				cnt++;
			}
		}
		if(now1[N-1] == want[N-1]) {
			System.out.println(cnt);
			can = true;
		}
		
		// 1��° ���ϰ� �ȵ�����
		// 1��° ������ �غ���
		if(!can) {
			cnt = 1;
			now2[0] ^= true;
			now2[1] ^= true;
			for (int i = 1; i < N; i++) {
				if(now2[i-1] != want[i-1]) { // �������� �ٸ��� �̹��� �ٲ���� ������ ��ȸ��
					now2[i-1] ^= true;
					now2[i] ^= true;
					now2[i+1] ^= true;
					cnt++;
				}
			}
			if(now2[N-1] == want[N-1]) {
				System.out.println(cnt);
				can = true;
			}
		}
		
		// �׷��� �ȵǸ�? -1
		if(!can) System.out.println(-1);
	} // end of main
} // end of class