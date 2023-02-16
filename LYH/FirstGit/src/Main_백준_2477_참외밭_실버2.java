import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���̵�� - ������̸� �ݺ��Ǵ� ������ �����Ѵ�
 * ����(423131)������ 3131�� �ݺ��Ǵµ� �׷��ٸ� �� ������ 1, 3 ������ ���� ���̸� ���� �ȴ�.
 * ���� �ݺ��Ǵ� ���� ���� �� 42���⿡ �ش��ϴ� ���̰� ��ü ������� ����������
 * ������ ���Ǹ� ���� 3131���� 3�� ���̸� ���Ѱ��� 1�� ���̸� ���� ���� ū ������� ���̷� �����Ͽ���.
*/
public class Main_����_2477_���ܹ�_�ǹ�2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		int[] dir = new int[12]; // 6�������� * 2 ���༭ �ݺ����� �����ϵ��� ����. ��)423141�� �ݺ������� ������ 423141423141 �� ���ָ� '1414'�ݺ� Ȯ�ΰ���
		int[] len = new int[12]; // ��� 6�����ϰ� %6�ϸ� ������ %���� ������ �ϼ����� �� �ι�
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = dir[i+6] = Integer.parseInt(st.nextToken());
			len[i] = len[i+6] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0; // �ݺ����� ���� �ε���
		for (int i = 0; i < 10; i++) {
			if(dir[i] == dir[i+2] && dir[i+1] == dir[i+3]) {
				idx = i;
				break;
			}
		}
		
		System.out.println(K*((len[idx]+len[idx+2]) * (len[idx+1]+len[idx+3]) - len[idx+1]*len[idx+2]));
	}
}
