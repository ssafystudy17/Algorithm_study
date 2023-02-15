
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int ans = line.length();
		String compare = "=-j";
		String alphabets = "c= c- dz= d- lj nj s= z=";
		for (int i = line.length() - 1; i >= 0; i--) {
			if (line.charAt(i) == '=') {
				if (i >= 2 && alphabets.contains(line.substring(i - 2, i))) {
					ans -= 2;
					i -= 2;
				} else if (alphabets.contains(line.substring(i - 1, i))) {
					ans -= 1;
					i -= 1;
				}
			}
			if (compare.contains(line.charAt(i) + "")) {
				if (alphabets.contains(line.substring(i - 1, i))) {
					ans -= 1;
					i -= 1;
				}
			}

		}
		System.out.println(ans);
	}
}
