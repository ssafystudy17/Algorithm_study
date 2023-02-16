	
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1484_다이어트_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int G = Integer.parseInt(br.readLine());

        int ii, iijj;
        for (int i = 1; i <= 50001; i++) { // 50001^2 - 50000^2 == 100,001 이어서 여기까지만 하면 될거라고 생각했는데,,
        	ii = i*i;
			for (int j = i-1; j > 0; j--) { // 그냥 얘보다 작은거 싹 검사..
				iijj = ii-j*j;
				if(iijj > G) break; // 넘어가면 필요없지
				else if(iijj == G) sb.append(i).append("\n"); // 같은건 뽑아야지
			}
		}
        if(sb.length() == 0) System.out.println(-1); // 값이 없으면 -1
        else System.out.println(sb.toString()); 	 // 있으면 출력
    }
}