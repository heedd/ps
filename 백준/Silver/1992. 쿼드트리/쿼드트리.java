import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] grid;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				grid[i][j]= str.charAt(j)-'0';
			}
		}


		zip(0,0,n);
		System.out.println(sb);
	}
	
	public static void zip(int y, int x, int len) {
		if(!check(y,x,len)) {	//단일색아니면  => 분할 후 zip
			int[] dy = {0, 0, len/2, len/2};
			int[] dx = {0, len/2, 0, len/2};
			
			sb.append("(");
			for (int i = 0; i < 4; i++) {
				int sy = y+dy[i];
				int sx = x+dx[i];
				zip(sy,sx,len/2);
			}
			sb.append(")");

		}else {					//단일색이면
			sb.append(grid[y][x]);
		}
	}
	
	public static boolean check(int y, int x, int len){
		int color = grid[y][x];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(grid[y+i][x+j] != color)
					return false;
			}
		}
		return true;
	}

}