import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class tree implements Comparable<tree> {
		int size, growth;

		public tree(int size, int growth) {
			super();
			this.size = size;
			this.growth = growth;
		}

		@Override
		public int compareTo(tree o) {

			return Integer.compare(this.growth, o.growth);
		}

	}

	static tree[] treeList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		treeList = new tree[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			treeList[i] = new tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
		}

		Arrays.sort(treeList);

		long ans = 0;
		for (int i = 0; i < N; i++) {
			ans += treeList[i].growth * (i) + treeList[i].size;
		}
		System.out.println(ans);
	}
}