import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int v;
	
	static boolean[][] graph;	//1이면 간선있음
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new boolean[n][n];
		visited = new boolean[n];
		
		int v1=0; int v2 = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			v1 = Integer.parseInt(st.nextToken())-1;
			v2 = Integer.parseInt(st.nextToken())-1;
			graph[v1][v2] = true;
			graph[v2][v1] = true;
		}
		
		dfs(v-1);
		System.out.println();
		
		Arrays.fill(visited, false);
		bfs(v-1);
		
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.printf("%d ", cur+1);

		for (int ad = 0; ad < n; ad++) {
			if(graph[cur][ad] && !visited[ad]) {
				dfs(ad);
			}
		}
		
	}
	
	private static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(cur);
		visited[cur] = true;
		
		while(!q.isEmpty()) {
			cur = q.poll();	
			System.out.printf("%d ", cur+1);
			
			for (int ad = 0; ad < n; ad++) {
				if(graph[cur][ad] && !visited[ad]) {
					q.offer(ad);
					visited[ad] = true;

				}
			}
		}
	}

}