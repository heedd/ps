import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, start;		//간선 개수, 시작점
	static int[][] graph;		//인접행렬 - bfs돌면서 time정보 갱신해줄 것임
	static boolean[] visited;	//방문check
	static int time;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new FileReader("res/input.txt"));

		// 1. 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			//노드 번호 1~100
			graph = new int[101][101];
			visited = new boolean[101];
			st = new StringTokenizer(bf.readLine());
			int from = 0, to = 0;
			while(st.hasMoreTokens()) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				graph[from][to] = 1;
			}

			// 2. 레벨단위 bfs
			bfs(start);
			
			
			// 3. 출력 - graph[from][to]==time 인 인덱스to 중 가장 큰 인덱스 출력
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
			//레벨(time)단위 bfs - 같은 시간에 동시다발적으로 연락이 가므로
			int end = q.size();
			for (int i = 0; i < end; i++) {
				cur = q.poll();
				for (int ad = 1; ad <= 100; ad++) {
					// cur와 연결되지 않은 노드거나, 이미 방문했다면 continue
					if(graph[cur][ad]==0 || visited[ad]) continue;
					// 연락받아야될 노드면, Q에 넣고-방문표시하고-그래프에 time정보 갱신
					q.offer(ad);
					visited[ad] = true;
					graph[cur][ad] += time;
				}
			}
		}
		
	}

}