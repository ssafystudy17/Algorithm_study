import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1205_조커_이용현_146ms {
	static int N;
	static int[] nums;
	static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N]; // 조커가 N개일때 재귀함수에서 index오류가 나지 않게 하기위해 
        st = new StringTokenizer(br.readLine(), " ");
        int tmp;
        int joker = 0;
        for (int i = 0; i < N; i++) {
        	tmp = Integer.parseInt(st.nextToken());
        	if(tmp == 0) joker++;
        	nums[i] = tmp;
        }
        // 세팅 끝
        
        Arrays.sort(nums); // 세기전에 정렬해야함
        max = joker; // 주어진 모든 카드가 joker일때 최소값
        for (int i = joker; i < nums.length; i++) {
			find(i, 1, joker);
		}
        
        System.out.println(max);
    } // end of main
    
    public static void find(int idx, int cnt, int joker) { // idx, 스트레이트 개수, 남은 조커 개수
    	if(max < cnt+joker) max = cnt+joker;
    	if(idx >= N-1) return; // 카드 다쓰면 끝
    	
    	int diff = nums[idx+1]-nums[idx]; // 이번카드와 다음카드의 차이를 조커로 메울 수 있는지 확인하기 위해
    	if(diff == 0) find(idx+1, cnt, joker); // 같으면 그냥 다음꺼보자
    	else if(diff == 1) { // 차이가 1이면 조커없이도 cnt++가능하다
    		find(idx+1, cnt+1, joker);
    	} else { // 차이가 1보다 크면 조커를 쓰면서 갈 수 있는지 확인해보자
    		if(diff <= joker+1)
    			find(idx+1, cnt+diff, joker-diff+1);
    	}
    }
} // end of class
