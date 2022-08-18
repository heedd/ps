import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[][] grid;
	static int[][] drdc = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static boolean[] alpha = new boolean[26];
	static int maxCnt;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		grid = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			String line = bf.readLine();
			for (int j = 0; j < c; j++) {
				grid[i][j] = line.charAt(j)-'A';	//알파벳 0~25로 변환해서 배열에 저장
			}
		}
		
		dfs(0,0,1);
		System.out.println(maxCnt);
	}

	private static void dfs(int sr, int sc, int cnt) {
//		System.out.printf("%c%n",grid[sr][sc]+'A');
		alpha[grid[sr][sc]] = true;	//방문체크 표시
		maxCnt = Math.max(maxCnt, cnt);		
		
		for (int i = 0; i < 4; i++) {
			int nr = sr + drdc[i][0];
			int nc = sc + drdc[i][1];
			
			if(nr<0 || nc<0 || nr>=r || nc>=c || alpha[grid[nr][nc]]) continue;	//경계검사 및 방문여부
			dfs(nr, nc, cnt+1);
			alpha[grid[nr][nc]] = false;	//방문체크 해제
		}
		
	}

}