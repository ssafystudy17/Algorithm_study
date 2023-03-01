package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1407_March_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long ans = 0;
		long cnt=0;
		while (B > 0) {
			//zvrk of X is 2n if X is divisible by 2n-1, and X divided by 2n-1 yields an odd number
			long temp = 0;
			long tempA = A % 2; // 1 || 0
			long tempB = B % 2;
			//counting odd numbers
			if (tempA ==0 && tempB == 0) { //when both are even
				temp = (B - A) / 2;
			} else if (tempA != tempB) { //when only one's odd
				temp = (B - A + 1) / 2;
			} else { //when both are odd
				temp = ((B - A) / 2) + 1;
			}
			
			//ith iteration, add the number of odd integers in the current interval multiplied by 2i-1
			ans+=temp*(1L<<cnt); 
			//We then divide the endpoints of the interval by 2, rounding the lower bound upwards and the upper bound downwards
			A=(long)Math.ceil((double)A/2);			
			B/=2; 
			//we have discarded all odd numbers from the interval and divided all even numbers by 2
			cnt++;
		}

		System.out.println(ans);
	}

}