import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	
	
	/**
	 * 아이디어 : 플로이드 와샬 응용
	 */
	static final int INF = Integer.MAX_VALUE>>3;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			
			int[][] map = new int[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(i==j) continue;
					map[i][j] = INF;
				}
			}
			
			for (int i = 0; i < m; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}
			
			for (int k = 1; k <= n; k++) {
				for (int a = 1; a <= n; a++) {
					for (int b = 1; b <= n; b++) {
						map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
					}					
				}
			}
			
			
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				boolean flag = true;
				for (int j = 1; j <= n; j++) {
					if( map[i][j] != INF || map[j][i]!=INF) continue;
					flag = false;
					break;
				}
				if(flag == true) {
					cnt++;
				}
			}
			
			System.out.printf("#%d %d%n", tc, cnt);
		}
		
	}

}