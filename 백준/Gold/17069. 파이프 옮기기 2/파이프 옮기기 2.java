import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static long[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//0:OK, 1:벽
		n = Integer.parseInt(bf.readLine());
		dp = new long[n+1][n+1][3];
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
		
		//dp[row][col][status] = 파이프 끝점이 (col,row)이고 상태가 status일때 도달하는 가짓수
		// status 가로|세로|대각선
		//         0 | 1 | 2
		// 사실상 끝점은 row:1~n, col:2~n
		dp[1][2][0] = 1;
		for (int row = 1; row <= n; row++) {
			for (int col = 3; col <= n ; col++) {
				if(map[row][col]==1) continue;
				//가로
				dp[row][col][0] = dp[row][col-1][0]+dp[row][col-1][2];
				//세로
				dp[row][col][1] = dp[row-1][col][1]+dp[row-1][col][2];
				//대각선
				if(map[row-1][col]==1 || map[row][col-1]==1) continue;
				dp[row][col][2] = dp[row-1][col-1][0] + dp[row-1][col-1][1] + dp[row-1][col-1][2];
			}
		}
		
//		for (int row = 1; row <= n; row++) {
//			for (int col = 1; col <= n ; col++) {
//				System.out.print(dp[row][col][0] + dp[row][col][1] + dp[row][col][2]+" ");
//			}
//			System.out.println();
//		}
		
		long cnt = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
		System.out.println(cnt);
	}

}