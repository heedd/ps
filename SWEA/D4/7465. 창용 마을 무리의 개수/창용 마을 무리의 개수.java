import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			make();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			HashSet<Integer> set = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				set.add(find(i));
			}
			System.out.println("#" + tc + " "+set.size());
		}// end of TC
		
	}
	
	private static void make() {
		parents = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) parents[pa] = pb;
	}
}