import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] axis = new int[8];

		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				axis[i] = Integer.parseInt(st.nextToken());
			}
			// 비교함수
			char ans = ' ';
			
			if((axis[0]==axis[6]&&axis[1]==axis[7])||(axis[0]==axis[6]&&axis[3]==axis[5])||(axis[2]==axis[4]&&axis[3]==axis[5])||(axis[2]==axis[4]&&axis[1]==axis[7])) //점일때. 안에 겹쳐버리는 경우는 제외. 
				ans='c'; //코너 하나하나 비교. 일치해야.
			else if((axis[0]>axis[6])||(axis[2]<axis[4])||(axis[1]>axis[7])||(axis[3]<axis[5])) //아예 안겹칠 때
				ans='d'; //서로의 끝이 닫지 않으면 되는거니깐.
			else if((axis[0]==axis[6])||(axis[1]==axis[7])||(axis[2]==axis[4])||(axis[3]==axis[5])) //선분으로 만날때. 4번 가능. 근데 쩜이면 곤란.아 근ㄷ 쩜인건 위에서 걸러지니까 고려 안해도 괜츈.
				ans = 'b'; //선분으로 만날라면 하나가 일치해야 하니깐. 모서리만 만나는 건 맨 앞에서 걸러져서 괜츈
			else //겹칠때. 위 3 경우 뺀 모든 경우니까.
				ans='a';
			
			
			
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}
}
