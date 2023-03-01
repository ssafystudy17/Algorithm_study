import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_색종이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		boolean[][] isSelected = new boolean[102][102]; //모서리 있을 때 처리할라고 2크게
		int count = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (!isSelected[i][j]) {
						isSelected[i][j] = true;
						count++;
					}
				}
			}
		} //여기까진 색종이 입력 고대로.

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int ans = 0;
		em: for (int r = 1; r < 102; r++) {
			for (int c = 1; c < 102; c++) {
				if (count == 0) {
					break em; //칠한 칸만 다 돌면 테두리 없으니깐.
				}
				if (isSelected[r][c]) { //만일 색종이 있는 칸인데 주변에 공백 있으면 모서리니깐
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (nr >= 0 && nr < 102 && nc >= 0 && nc < 102 && !isSelected[nr][nc]) {
							ans++; //원래 여기서 break 했었는데 코너는 두번 count 해야해서 그러면 안되는거였..
						}
					}
					count--; //색칠된 칸 하나 탐색했으니깐 --
				}

			}
		} // end of r for
		System.out.println(ans);
	}
}