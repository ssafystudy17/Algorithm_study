import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * S(B) - S(A-1)을 사용해야 하며 S(n)의 규칙을 찾아내야 한다.
 * ex) S(18)을 구할 때 홀수관련하여 초기화하고 짝수를 반복문으로 더해가면서 구했다.
 * 종이로 풀이해봤는데 근데 다시보면 까먹겠지... 최대한 써보겠다.
 *  n   : 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
 * f(n) : 1 2 1 4 1 2 1 8 1 2  1  4  1  2  1  16 1  2    와 같다.
 * 1단계 (홀수포함 sum계산)  : 1*18
 *        0 1 0 3 0 1 0 7 0 1  0  3  0  1  0  15 0  1
 * 2단계 (짝수계속 계산) 2^1 : 1*9
 *        0 0 0 2 0 0 0 6 0 0  0  2  0  0  0  14 0  0
 * 3단계                      2^2 : 2*4
 *        0 0 0 0 0 0 0 4 0 0  0  0  0  0  0  12 0  0
 * 4단계                      2^3 : 4*2
 *        0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  8  0  0
 * 5단계                      2^4 : 8*1
 *        0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  0  0  0          
 *        
 *   결론 sum = 1*18  +  1*9 + 2*4 + 4*2 + 8*1
 *   
 * 와 같은 방식으로 접근
 * 
 */

// 아래 점화식 재귀 풀이도 맞을것 같긴 한데 메모리 터짐 ㅠ
//		if(n==1) return 1;
//		if(n%2 == 0) return 2*S(n/2) + n/2;
//		else return 2*S(n/2) + n/2+1;

public class Main_백준_1407_2로몇번나누어질까_골드4_이용현_80ms {

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

// 거꾸로 접근 시도만 해봄 끝까지 안짰으니 확실하지않음 ----------
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
