import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_백준_2217_로프_실버4_이용현_308ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		for (int i = 0; i < N; i++)
			ropes[i] = Integer.parseInt(br.readLine());
		Arrays.sort(ropes);
		
		int max = 0;
		for (int i = 0; i < ropes.length; i++)
			max = Math.max(max, (N-i)*ropes[i]);
		System.out.println(max);
	} // end of main
} // end of class
