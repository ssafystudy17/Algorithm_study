import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2527_직사각형_실버1 {
	static int[] sq1, sq2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			sq1 = new int[4];
			sq2 = new int[4];
			for (int j = 0; j < 4; j++) {
				sq1[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) {
				sq2[j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(where(sq1[0], sq1[1], sq1[2], sq1[3], sq2[0], sq2[1], sq2[2], sq2[3])).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 주석은 줄여서 표현
	public static char where(int l1, int b1, int r1, int t1, int l2, int b2, int r2, int t2) {
		if(r1 < l2 ||  l1 > r2 || t1 < b2 || b1 > t2) // 겹칠수가 없음
			return 'd';
		else if(r1 == l2 || l1 == r2) { // 같은 라인
			if(t1 == b2 || b1 == t2)
				return 'c';
			else return 'b';
		}
        else if(t1 == b2 || b1 == t2) {
            if(r1 == l2 || l1 == r2) 
            	return 'c';
            else return 'b';
        }
        else return 'a';
	}
	
	// ex: 사각형1 오른쪽 < 사각형2 왼쪽 -> 1오른 < 2왼
//	public static char where(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2) {
//		// x좌표부터 분기
//		if(x1 < x2) { // 사각형1 왼쪽변 < 사각형2 왼쪽변 (이하 줄임)
//			if(p1 < x2) // 1오른 < 2왼 -> 겹칠수가 없음
//				return 'd';
//			else if (p1 == x2) { // 1오른 == 2왼 같은 라인이라면
//				if(y1 < y2) { // 1아래 < 2아래
//					if(q1 < y2) // 1위 < 2아래 -> 안겹침
//						return 'd';
//					else if(q1 == y2) // 1위 == 2아래
//						return 'c';
//					else // q1 > y2 // 1위 > 2아래
//						return 'b';
//				} else if (y1 == y2) {// 1아래 == 2아래 -> 사각형으로 겹칠수밖에 없지않나 ?
//					return 'a';
//				} else { // y1 > y2 // 1아래 > 2아래
//					if(y1 > q2) // 1아래 > 2위 -> 안겹침
//						return 'd';
//					else if(y1 == q2) // 1아래 == 2위
//						return 'c';
//					else // y1 < q2 // 1아래 < 2위
//						return 'b';
//				}
//			} else { // p1 > x2 // 1오른 > 2왼
//				if(y1 < y2) { // 1아래 < 2아래
//					if(q1 < y2) // 1위 < 2아래 -> 안겹침
//						return 'd';
//					else if(q1 == y2) // 1위 == 2아래
//						return 'b';
//					else // q1 > y2 // 1위 > 2아래
//						return 'a';
//				} else if (y1 == y2) {// 1아래 == 2아래 -> 사각형으로 겹칠수밖에 없지않나 ?
//					return 'a';
//				} else { // y1 > y2 // 1아래 > 2아래
//					if(y1 > q2) // 1아래 > 2위 -> 안겹침
//						return 'd';
//					else if(y1 == q2) // 1아래 == 2위
//						return 'b';
//					else // y1 < q2 // 1아래 < 2위
//						return 'a';
//				}
//			}
//		} else if (x1 == x2) { // 사각형1 왼쪽변 == 사각형2 왼쪽변
//			if(y1 < y2) { // 
//		}
//		
//		return 'z';
//	}

	
//	// 점이 첫번째 직사각형의 어디에 위치하는지
//	// 밖이면 0 점이면 1 선이면 2 안이면 3
//	public static int where(int x, int y) {
//		// x좌표 기준으로 일단
//		if(x < sq1[0] || x > sq1[2]) { // 사각형밖에 있으면 무조건 0
//			return 0;
//		} else if(x == sq1[0] || x == sq1[2]) { // 왼쪽, 오른쪽 변 이랑 같은 라인일때 y좌표 확인
//			if(y > sq1[1] || y < sq1[3]) // 이지만 밖에있다
//				return 0;
//			else if(y == sq1[1] || y == sq1[3]) // 사각형의 점이랑 일치
//				return 1;
//			else // 변 위에 존재
//				return 2;
//		} else { // 사각형 안에 있을때 y좌표확인
//			if(y > sq1[1] || y < sq1[3]) // 이지만 밖에있다
//				return 0;
//			else if(y == sq1[1] || y == sq1[3]) // 위아래 변위에 존재
//				return 1;
//			else // 사각형 안에 존재
//				return 3;
//		}
//	}
}
