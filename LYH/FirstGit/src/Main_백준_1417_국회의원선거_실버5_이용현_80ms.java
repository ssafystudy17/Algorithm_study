import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_1417_국회의원선거_실버5_이용현_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[];
		int res = 0;
		arr = new int[N];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());
		if(N==1) System.out.println(0);
		else {
			Arrays.sort(arr,1,N);
			while(arr[0] <= arr[N-1]) {
				arr[0]++;
				arr[N-1]--;
				Arrays.sort(arr, 1, N);
				res++;
			}
			System.out.println(res);
		}
		
		System.out.println(sb.toString());
	} // end of main
} // end of class
