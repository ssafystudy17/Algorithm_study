package _3월_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class SWEA_프로세서_연결하기_1767 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, answer, totalLines;
    static int[][] board;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static ArrayList<int[]> coreList;
 
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            input();
            plug(0, 0);
            System.out.println("#" + test_case + " " + answer);
        }
    }
 
    private static void plug(int idx, int cnt) { // idx : coreList의 인덱스 , cnt : 연결 시킨 전선의 개수
        if (coreList.size() - idx + cnt < totalLines) // 더 살펴봐봤자 총 연결 수를 넘어설 수 없다면
            return;
 
        if (idx == coreList.size()) { // 끝까지 다 살펴봤으면
            if (cnt < totalLines) // 전선 수가 최대 전선 수보다 적으면 그냥 return
                return;
 
            int curLen = countLen(); // 전선들의 길이
            if (cnt > totalLines || curLen < answer) { // cnt가 최종 전선의 수보다 많거나, 전선들의 길이가 더 짧다면
                totalLines = cnt;
                answer = curLen;
            }
            return;
        }
 
        int[] core = coreList.get(idx);
        for (int i = 0; i < 4; i++) {
            if (canConnect(core[0], core[1], i)) { // 전선을 놓을 수 있다면
                fill(core[0], core[1], i, -1); // 4번째 매개변수 : -1이면 전선 채우기, 0이면 채운 전선 삭제
                plug(idx + 1, cnt + 1);
                fill(core[0], core[1], i, 0); // 4번째 매개변수 : -1이면 전선 채우기, 0이면 채운 전선 삭제
            }
        }
        plug(idx + 1, cnt);
    }
 
    private static int countLen() { // 놓은 전선의 길이 count
        int len = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == -1)
                    len++;
            }
        }
        return len;
    }
 
    private static void fill(int r, int c, int i, int k) {
        while (true) { // 끝이 아닐때까지
            r += dr[i];
            c += dc[i];
            board[r][c] = k;
            if (r == N - 1 || c == N - 1 || r == 0 || c == 0)
                return;
        }
    }
 
    private static boolean canConnect(int r, int c, int i) {
        while (true) {
            r += dr[i];
            c += dc[i];
            if (board[r][c] != 0)
                break;
            if (r == N - 1 || c == N - 1 || r == 0 || c == 0)
                return true;
        }
        return false;
    }
 
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        answer = N * N;
        totalLines = 0;
        board = new int[N][N];
        coreList = new ArrayList<int[]>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N - 1; i++) { // 테두리는 확인 x
            for (int j = 1; j < N - 1; j++) {
                if (board[i][j] == 1)
                    coreList.add(new int[] { i, j });
            }
        }
    } // end of input
}