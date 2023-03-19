import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_1259_팰린드롬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String num = "";
		
		loop: while (true) {
			num = br.readLine();
			if (num.equals("0")) {
				break;
			}

			for (int i = 0; i < num.length() / 2; i++) {
				if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
					System.out.println("no");
					continue loop;
				}
			}
			System.out.println("yes");
		}
	}
}
