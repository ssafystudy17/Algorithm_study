import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
public static int ans = 2147483647;
public static int T;
public static int[][] arr;
public static int isSelect;
public static void main(String[] args) throws Exception {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		arr = new int[T][2];
		boolean check = false;
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int Sour = Integer.parseInt(st.nextToken());
			int Bitter = Integer.parseInt(st.nextToken());
			arr[testCase][0] = Sour;
			arr[testCase][1] = Bitter;
			if(Sour==Bitter) check = true;
		} // end of testcase
		if(check) {
			System.out.println(0);
			return;
		}
		bestCook(0,1,0);
		
		
	System.out.printf("%d\n",ans);
	}
	
	public static void bestCook(int cnt, int Sour, int Bitter) { //cnt: 직전까지 고려된 원소 수.
		if(cnt==T) {
			if(isSelect!=0&& Math.abs(Sour-Bitter)<ans)
				ans = Math.abs(Sour-Bitter);
			return;
		}
		
		//현제 원소를 부분집합의 구성에 포함
		isSelect = isSelect | 1 <<cnt;
		bestCook(cnt+1,Sour*arr[cnt][0],Bitter+arr[cnt][1]);
		
		//현재 원소를 부분집합의 구성에 미포함.
		//isSelected = false; 
		isSelect = isSelect - (1 <<cnt);
		bestCook(cnt+1,Sour,Bitter);
	}
}