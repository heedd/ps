import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 *
 */
public class Main {
	static int[][] map;
	static int n;
	static int cnt;
						  //가로      세로     대각선
	static int[][] dydx = {{0,1},{1,0},{1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//0:OK, 1:벽
		n = Integer.parseInt(bf.readLine());
		
		//인덱스 1부터 시작
		//시작(1,1)~(1,2)
		//도착(n,n)
		map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1,2, 0);
		
		System.out.println(cnt);
	}
	
	
	// status 가로|세로|대각선
	//         0 | 1 | 2
	private static void dfs(int y, int x, int status) {
		if(y==n && x==n) {
			cnt++;
			return;
		}
		
		for (int d = 0; d < dydx.length; d++) {
			int ny = y + dydx[d][0];
			int nx = x + dydx[d][1];
			int ns = d;
			
			if(ny<1||nx<1||ny>n||nx>n || map[ny][nx]==1) continue;
			//대각선이면 추가 벽검사
			if(ns==2 && (map[ny-1][nx]==1 || map[ny][nx-1]==1)) continue;
			if(ns==2) {
				dfs(ny, nx, ns);
			}else if(status!=Math.abs((ns-1)%3)) {
				dfs(ny, nx, ns);
			}
		}
	}

}