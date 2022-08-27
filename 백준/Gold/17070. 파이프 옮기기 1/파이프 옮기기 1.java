import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Pipe {
		int er, ec, dir;

		public Pipe(int er, int ec, int dir) {
			super();
			this.er = er;
			this.ec = ec;
			this.dir = dir;
		}
	}

	static int n;
	static int[][] map;
	// 가로 {0,1} 세로{1,0} 대각선{1,1}
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
	// 가로면 dir[0],dir[1]번 움직임.
	static int[][] move = {{0,2}, {1,2}, {0,1,2}};
	static int cnt; // 이동시키는 방법의 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();

		System.out.println(cnt);
	}

	// 0가로, 1세로, 2대각선
	private static void bfs() {
		Queue<Pipe> q = new ArrayDeque<>();
		q.offer(new Pipe(0, 1, 0)); // er, ec, dir

		while(!q.isEmpty()) {
			Pipe cur = q.poll(); // er, ec, dir
//			System.out.println(cur.er+" "+cur.ec+" "+cur.dir);
			for (int i=0, end=move[cur.dir].length; i<end; i++) {
				int nr=cur.er+dir[move[cur.dir][i]][0];
				int nc=cur.ec+dir[move[cur.dir][i]][1];
				int nd = move[cur.dir][i];
				//경계밖이거나, 벽이면 못지나감
				if(nr<0||nc<0||nr>=n||nc>=n || map[nr][nc]==1) continue;
				//대각선이면 벽검사 추가로 해줘야됨
				if(nd==2) {
					if(map[nr-1][nc] == 1 || map[nr][nc-1] == 1) continue;
				}
				//도착점이면 q에 넣지않고 cnt+=1 (nr,nc) == (n-1,n-1)
				if(nr==n-1 && nc==n-1) {
					cnt+=1;
					continue;
				}
				q.offer(new Pipe(nr,nc,nd));
//				System.out.println(nr+" "+nc+" "+nd);
			}
		}
		
	}

}