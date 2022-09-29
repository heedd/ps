import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 백준 S1 1149
 * RGB 거리
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		
		// num 집번호, col 색깔 (RGB=012)
		// costs[num][col]: num번 집을 col 색으로 칠할 때의 비용
		int[][] costs = new int[n+1][3];	//인덱스 1부터 시작
		for (int num = 1; num <= n; num++) {
			st = new StringTokenizer(bf.readLine());
			for (int col = 0; col < 3; col++) {
				costs[num][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		//num 집번호, col 색깔
		// memo[num][col]: 그떄의 최소비용
		int[][] memo = new int[n+1][3];	//인덱스 1부터 시작
		
		int minCost = Integer.MAX_VALUE;

		memo[1] = costs[1];
		for (int i = 2; i <= n; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) +costs[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) +costs[i][1];
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) +costs[i][2];
		}
		
		minCost = Math.min(memo[n][0], Math.min(memo[n][1], memo[n][2]));
		System.out.println(minCost);
	}

}