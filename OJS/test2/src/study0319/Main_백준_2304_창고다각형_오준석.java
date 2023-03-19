import java.io.*;
import java.util.*;

public class Main_백준_2304_창고다각형_오준석 {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	private static Wall[] wallArr;
	private static StringTokenizer st;
	private static int N,toplen,topidx, sum;
	private static ArrayDeque<Wall> deque;
	
	static class Wall{
		int idx,len;
		public Wall(int idx, int len) {
			this.idx = idx;
			this.len = len;
		}
	}
    
	public static void main(String[] args) throws Exception {
		input(); //입력받으면서 최대 기둥 저장.
		climbL(); //최대기둥가지 올라가서 면적 구하기->내려오면서 면적 구하기
		climbR(); //내려오면서 면적 구하기
		System.out.println(sum);
	}
    
	private static void climbR() {
		//덱의 뒤에서부터 정점까지 다시 올라감.
		Wall back=deque.pollLast();
		int flen=back.len, fidx=back.idx; //기둥값을 저장할 변수
		deque.offer(back);
		while(fidx>=topidx && !deque.isEmpty()) {
			Wall temp= deque.pollLast();
			if (temp.len>=flen) {
				sum+=(fidx-temp.idx)*flen;
				fidx=temp.idx; flen=temp.len; //더 큰 기둥!
			}
			if (fidx==topidx) break;
		}
	}
	private static void climbL() {
		//얘네 다 덱에 넣음
		deque= new ArrayDeque<>();
		for (int i = 0; i < wallArr.length; i++) {deque.offer(wallArr[i]);}
		//최대 기둥까지 올라가면서 면적 구하기, 큰 기둥이 나올때마다 이전기둥크기*인덱스차이를 더해준다.
		Wall front=deque.poll();
		deque.offerFirst(front);
		int flen=front.len, fidx=front.idx; //기둥값을 저장할 변수
		while(fidx<=topidx && !deque.isEmpty()) {
			Wall temp= deque.poll();
			if (temp.len>=flen) {
				sum+=(temp.idx-fidx)*flen;
				fidx=temp.idx; flen=temp.len; //더 큰 기둥!
			}
			if (fidx==topidx) {
				sum+=temp.len;
				deque.addFirst(temp);
				break;
			}
		}
	}
    
	private static void input() throws Exception {
		N=Integer.parseInt(br.readLine());
		wallArr= new Wall[N];
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int idx= Integer.parseInt(st.nextToken());
			int len= Integer.parseInt(st.nextToken());
			wallArr[i]= new Wall(idx, len);
			if (toplen<=len) {
				toplen=len; topidx=idx; 
			}
		}
		//인덱스 순서대로 벽 정렬
		Arrays.sort(wallArr, (Wall o1, Wall o2)->Integer.compare(o1.idx, o2.idx));
	}
}
