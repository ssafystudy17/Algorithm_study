	
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main_����_1484_���̾�Ʈ_���5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int G = Integer.parseInt(br.readLine());

        int ii, iijj;
        for (int i = 1; i <= 50001; i++) { // 50001^2 - 50000^2 == 100,001 �̾ ��������� �ϸ� �ɰŶ�� �����ߴµ�,,
        	ii = i*i;
			for (int j = i-1; j > 0; j--) { // �׳� �꺸�� ������ �� �˻�..
				iijj = ii-j*j;
				if(iijj > G) break; // �Ѿ�� �ʿ����
				else if(iijj == G) sb.append(i).append("\n"); // ������ �̾ƾ���
			}
		}
        if(sb.length() == 0) System.out.println(-1); // ���� ������ -1
        else System.out.println(sb.toString()); 	 // ������ ���
    }
}