package feb.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int[] getArr= new int[N];
		for (int i = 0; i < getArr.length; i++) {
			getArr[i]=Integer.parseInt(br.readLine());
		}
		int sum=0, count=0, min=0;
		Arrays.sort(getArr);
		//정렬하고, 정렬된 리스트를 한번 쭉 돌면서 누적된 min*count+1의 값과 현재값의 대소비교를 통해 결과를 계속 가져가서 반복문 하나로 끝낸다.
		for (int i = 0; i < getArr.length; i++) {
			int rest=getArr.length-i+1;
			//Plan2. min*count와 현*rest를 비교해서 교환?
			if (min*(count+rest)<getArr[i]*rest) {
				min=getArr[i];
				count=1;
			}else count++;
		}
		System.out.println(count*min);
	}
}
