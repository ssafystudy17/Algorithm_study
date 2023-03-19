import java.io.*;
import java.util.*;

public class Main_백준_1946신입사원_오준석 {
	
	static class Pair{
		int prank,irank,idx;
		public Pair(int prank, int irank, int idx) {
			this.prank = prank; this.irank = irank; this.idx=idx;
		}
	}
	private static BufferedReader br;
	private static StringTokenizer st;
	private static int T,N;
	private static Pair[] pairList;
	private static boolean[] checkPList,checkIList;

	public static void main(String[] args) throws Exception {
		br= new BufferedReader(new InputStreamReader(System.in));
		st= new StringTokenizer(br.readLine()," ");
		T=Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			input();
			selectPaper();
			selectInterView();			
		}
	}

	private static void selectInterView() {
		Arrays.sort(pairList, (Pair o1, Pair o2) -> o1.irank-o2.irank);
		int comp=pairList[0].prank;
		int answer=0;
		for (int i = 0; i < pairList.length; i++) {
			if (pairList[i].prank<=comp) {
				checkIList[pairList[i].idx]=true;
				comp=pairList[i].prank;
			}
		}
		for (int i = 0; i < checkIList.length; i++) {
			if (checkIList[i]&&checkPList[i]) answer++;
		}
		System.out.println(answer);
	}

	private static void selectPaper() {
		Arrays.sort(pairList, (Pair o1, Pair o2) -> o1.prank-o2.prank);
		int comp=pairList[0].irank;
		for (int i = 0; i < pairList.length; i++) {
			if (pairList[i].irank<=comp) {
				checkPList[pairList[i].idx]=true;
				comp=pairList[i].irank;
			}
		}
		int answer=0;
	}

	private static void input() throws Exception {
		st= new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		pairList= new Pair[N];
		checkPList= new boolean[N];
		checkIList= new boolean[N];
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int pr=Integer.parseInt(st.nextToken());
			int ir=Integer.parseInt(st.nextToken());
			pairList[i]= new Pair(pr, ir,i);
		}
	}
}