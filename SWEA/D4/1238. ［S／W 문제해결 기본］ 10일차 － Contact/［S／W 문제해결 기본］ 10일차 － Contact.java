import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, start;
	static int[][] graph;
	static boolean[] visited;
	static int time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph = new int[101][101];
			visited = new boolean[101];
			st = new StringTokenizer(bf.readLine());
			int from = 0, to = 0;
			while(st.hasMoreTokens()) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				graph[from][to] = 1;
			}

			bfs(start);
			
			int last = 0;
			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					if(graph[i][j] == time)
						last = Math.max(last, j);
				}
			}
			System.out.println("#" + tc + " "+last);
			
		}// end of TC
		
	}// end of main
	
	
	public static void bfs(int cur){
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(cur);
		visited[cur] = true;
		
		time = 0;
		while(!q.isEmpty()) {
			time+=1;
			int end = q.size();
			for (int i = 0; i < end; i++) {
				cur = q.poll();
				for (int ad = 1; ad <= 100; ad++) {
					if(visited[ad] || graph[cur][ad]==0) continue;
					q.offer(ad);
					graph[cur][ad] += time;
					visited[ad] = true;
				}
			}
		}
		
	}

}
