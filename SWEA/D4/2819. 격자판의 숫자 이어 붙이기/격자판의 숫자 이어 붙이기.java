import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int[][] dydx = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static int[][] grid;
	static int[] numbers = new int[7];
	static Set<String> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			grid = new int[4][4];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 4; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			set = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					make_numbers(i, j, 0);
				}
			}
			System.out.println("#" + tc + " "+set.size());
			
		}// end of TC
	}
	
	private static void make_numbers(int y, int x, int cnt) {
		if(cnt == 7) {
			set.add(Arrays.toString(numbers));
			return;
		}
		numbers[cnt] = grid[y][x];
		
		for (int i = 0; i < 4; i++) {
			int ny = y+dydx[i][0];
			int nx = x+dydx[i][1];
			
			if(ny<0 || nx<0 || ny>=4 || nx>=4) continue;
			make_numbers(ny, nx, cnt+1);
		}
	}

}