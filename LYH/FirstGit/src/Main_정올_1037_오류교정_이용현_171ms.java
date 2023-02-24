import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1037_오류교정_이용현_171ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] row = new int[n];
        int[] col = new int[n];
        int input;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				input = Integer.parseInt(st.nextToken());
				row[i] += input;
				col[j] += input;
			}
		}
        
        int cbi = -1, cbj = -1; // -1 : OK, -2 : Corrupt, >=0 : Change bit
        for (int idx = 0; idx < n; idx++) {
			if(row[idx] % 2 != 0) { // i행이 문제가 있다
				if(cbi == -1) // 첫발견
					cbi = idx + 1;
				else { // 두번째 발견
					cbi = -2;
					break;
				}
			}
			if(col[idx] % 2 != 0) { // i열이 문제가 있다
				if(cbj == -1) // 첫발견
					cbj = idx + 1;
				else { // 두번째 발견
					cbj = -2;
					break;
				}
			}
		}
        
        if(cbi == -1 && cbj == -1) System.out.println("OK");
        else if(cbi < 0 || cbj < 0) System.out.println("Corrupt");
        else System.out.println("Change bit (" + cbi + "," + cbj + ")");
        
        System.out.println(sb.toString());
    } // end of main
} // end of class
