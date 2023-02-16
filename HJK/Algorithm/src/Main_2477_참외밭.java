import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {

	static int K, ans;
	static int[] dirArray, lenArray;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); // 면적당 참외의 수. 나중에 곱할거.
		dirArray = new int[6]; //동서남북. 1,2 같, 3,4같.
		lenArray = new int[6]; //길이. 
		
		// 가장 긴 너비 index, 높이 index => 값 (어쨌든간 가장 큰 사각형에서 쪼마난거 빼내면 되니까.)
		// 위로 부터 가장 짧은 너비 높이  index 구한다.
		
		// 입력으로부터 각각 비교하면서 구한다.
		int wMax = 0;
		int wMaxIdx = 0;
		int hMax = 0;
		int hMaxIdx = 0;
		
		// 위의 값이 구해지면  +3 % 6 계산. 방향 트는게 가로세로/세로가로 세트로 들어올테니까.
		int wMinIdx = 0;
		int hMinIdx = 0;

		// 입력
		for (int i = 0; i < 6; i++) { //변 6개니까.
			StringTokenizer st = new StringTokenizer(br.readLine());
			dirArray[i] = Integer.parseInt(st.nextToken());
			lenArray[i] = Integer.parseInt(st.nextToken());
			
			
			switch( dirArray[i] ) { //방향따라 최대 길이 받기. 전체 사각형 크기 구해야 하니깐.
				// w
				case 1 :
				case 2 :
					if( lenArray[i] > wMax ) {
						wMax = lenArray[i];
						wMaxIdx = i;
					}
					break;
				// h
				case 3 :
				case 4 :
					if( lenArray[i] > hMax ) {
						hMax = lenArray[i];
						hMaxIdx = i;
					}
					break;					
			}
		}
		
		// 여기까지 진행되면 가로와 세로로 가장 긴 변의 index 를 확보 wMaxIdx, hMaxIdx
		// 대각선 방향 대응되는 wMinIdx, hMinIdx 를 구한다 <= + 3 하고 안전하게 % 6
		wMinIdx = (hMaxIdx + 3) % 6; //가장 긴거 맞은편에 들어오니깐. %6은 굳이 해야하나,,? 
		hMinIdx = (wMaxIdx + 3) % 6;
		
		ans = (lenArray[wMaxIdx]* lenArray[hMaxIdx] - lenArray[wMinIdx]* lenArray[hMinIdx])*K; //큰거에서 짝은거 빼깅
		System.out.println(ans);
	}

}




