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
	
	static boolean[][] graph;	//인접 행렬 : true면 간선있음
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new boolean[n+1][n+1];	//인덱스 1~n 까지 쓸것임
		visited = new boolean[n+1];
		
		int v1=0; int v2 = 0;
		for (int i = 0; i < m; i++) {	//간선개수만큼 돌면서 인접행렬 초기화
			st = new StringTokenizer(bf.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			graph[v1][v2] = true;
			graph[v2][v1] = true;
		}
		
		dfs(v);
		System.out.println();
		
		visited = new boolean[n+1];	//dfs돌았으므로 visited[] 한번 더 초기화해주자
		//Arrays.fill(visited, false);
		bfs(v);
		
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print(cur + " ");
		for (int ad = 1; ad <= n; ad++) {	//cur to vertices: 정점번호가 작은 것부터 먼저 방문~
			if(!graph[cur][ad] || visited[ad]) continue;  //간선없거나, 이미 방문했다면 continue
			dfs(ad);
		}
	}
	
	private static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(cur);			//bfs 넣을때 방문처리~~
		visited[cur] = true;
		
		while(!q.isEmpty()){
			cur = q.poll();
			System.out.print(cur + " ");
			for (int ad = 1; ad <= n; ad++) {
				if(!graph[cur][ad] || visited[ad]) continue;
				q.offer(ad);
				visited[ad] = true;
			}
		}
	}

}