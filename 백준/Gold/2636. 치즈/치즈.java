import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] drdc = {{0,1}, {1,0}, {-1,0}, {0,-1}};
	static int n, m;
	static int[][] map;
	static int cntCheeze;
	static int killCheeze;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cntCheeze = 0;	//총 치즈 개수
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp==1) cntCheeze+=1;
			}
		}
		

		/* 상자의 외곽은 항상 0이므로, 공기는 항상 하나로 이어진다.
		 * 따라서 공기를 기준으로 BFS를 돌릴것!
		 */
		//loop == time
		int time= 0;
		while(true) {
			killCheeze = 0;
			bfs();
			time++;
			if(cntCheeze==0) break;
		}
		
		//출력
		System.out.println(time);
		System.out.println(killCheeze);
	}

	private static void bfs() {
		boolean[][] visited = new boolean[n][m];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0]+drdc[d][0];
				int nc = cur[1]+drdc[d][1];
				
				//경계검사 & 방문검사
				if(nr<0 || nc<0 || nr>=n || nc>=m || visited[nr][nc]) continue;
				if(map[nr][nc]==0) {
					q.offer(new int[] {nr,nc});
					visited[nr][nc] = true;
				}else if(map[nr][nc]==1) {
					visited[nr][nc] = true;
					map[nr][nc] = 0;
					cntCheeze--;
					killCheeze++;
				}
			}
		}
	}

}