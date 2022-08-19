import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Cctv{
	int r, c, type;
	public Cctv(int r, int c, int type) {
		this.r = r;
		this.c = c;
		this.type = type;
	}
}

public class Main {
	static int minArea;
	static int n, m;
	static int[][] grid;
	static boolean[][] watchArea;
	static int spaceCnt;

	static int[] dr = {-1, 1, 0, 0};	// 북 남 서 동 
	static int[] dc = {0, 0, -1, 1};
	
	static ArrayList<Cctv> CCTV = new ArrayList<>();
	static int CCTVsize;
	static int[] dirArr;

	static int[][] cctv1 = {{0}, {1}, {2}, {3}};	// {{동}, {남}, {서}, {북}}
	static int[][] cctv2 = {{0, 1}, {2, 3}};		// {{동, 서}, {북, 남}}
	static int[][] cctv3 = {{0, 3}, {3, 1}, {1, 2}, {2, 0}};
	static int[][] cctv4 = {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}};
	static int[][] cctv5 = {{0, 1, 2, 3}};		// {{북, 남, 서, 동}}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new int[n][m];
		watchArea = new boolean[n][m];
		spaceCnt=0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				grid[i][j] = tmp;
				if(tmp != 0 && tmp != 6) {
					CCTV.add(new Cctv(i,j,tmp));
				}else if(tmp == 0){
					spaceCnt+=1;
				}
			}
		}
		///////////////////////////////////////////////////
		CCTVsize = CCTV.size();
		dirArr = new int[CCTVsize];
		minArea = Integer.MAX_VALUE;
		combination(0);
		System.out.println(minArea);
		
	}


	

	private static void combination(int cnt) {
		if(cnt == CCTVsize) {		//CCTV 방향 조합 다 찾았으면 사각지대 영역 구하자
//			System.out.println(Arrays.toString(dirArr));
			watchArea = new boolean[n][m];
			for (int i = 0, end = CCTVsize; i < end; i++) {
				watch(i);
			}
			
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(watchArea[i][j]) sum+=1;
				}
//				System.out.println(Arrays.toString(watchArea[i]));
			}
//			System.out.println(sum);
			minArea = Math.min(minArea, spaceCnt-sum);  //n-sum : 빈공간 - 감시한영역
			
			return;
		}
		
		if(CCTV.get(cnt).type == 1) {
			dirArr[cnt] = 0; combination(cnt+1);
			dirArr[cnt] = 1; combination(cnt+1);
			dirArr[cnt] = 2; combination(cnt+1);
			dirArr[cnt] = 3; combination(cnt+1);
		}
		else if(CCTV.get(cnt).type == 2) {
			dirArr[cnt] = 0; combination(cnt+1);
			dirArr[cnt] = 1; combination(cnt+1);
		}
		else if(CCTV.get(cnt).type == 3) {
			dirArr[cnt] = 0; combination(cnt+1);
			dirArr[cnt] = 1; combination(cnt+1);
			dirArr[cnt] = 2; combination(cnt+1);
			dirArr[cnt] = 3; combination(cnt+1);
		}
		else if(CCTV.get(cnt).type == 4) {
			dirArr[cnt] = 0; combination(cnt+1);
			dirArr[cnt] = 1; combination(cnt+1);
			dirArr[cnt] = 2; combination(cnt+1);
			dirArr[cnt] = 3; combination(cnt+1);
		}
		else if(CCTV.get(cnt).type == 5) {
			dirArr[cnt] = 0; combination(cnt+1);
		}
		
	}




	private static void watch(int i) {	//감시영역 구해보자
		Cctv cur = CCTV.get(i);
		int r = cur.r;
		int c = cur.c;
		int dir = dirArr[i];
		
		if(cur.type == 1) {
			for (int j = 0; j < cctv1[dir].length; j++) {	//0 1 2 3
				int nr = r; int nc = c;
				while(true) {
					//경계밖이거나 벽이면 감시 멈춤!
					nr += dr[cctv1[dir][j]];
					nc += dc[cctv1[dir][j]];
					if(nr<0||nc<0||nr>=n||nc>=m || grid[nr][nc] == 6) break;
					if(grid[nr][nc]==0)
						watchArea[nr][nc] = true;
				}
			}	
		}else if(cur.type == 2) {
			for (int j = 0; j < cctv2[dir].length; j++) {	//0 1 2 3
				int nr = r; int nc = c;
				while(true) {
					//경계밖이거나 벽이면 감시 멈춤!
					nr += dr[cctv2[dir][j]];
					nc += dc[cctv2[dir][j]];
					if(nr<0||nc<0||nr>=n||nc>=m || grid[nr][nc] == 6) break;
					if(grid[nr][nc]==0)
						watchArea[nr][nc] = true;
				}
			}	
		}else if(cur.type == 3) {
			for (int j = 0; j < cctv3[dir].length; j++) {	//0 1 2 3
				int nr = r; int nc = c;
				while(true) {
					//경계밖이거나 벽이면 감시 멈춤!
					nr += dr[cctv3[dir][j]];
					nc += dc[cctv3[dir][j]];
					if(nr<0||nc<0||nr>=n||nc>=m || grid[nr][nc] == 6) break;
					if(grid[nr][nc]==0)
						watchArea[nr][nc] = true;
				}
			}	
		}else if(cur.type == 4) {
			for (int j = 0; j < cctv4[dir].length; j++) {	//0 1 2 3
				int nr = r; int nc = c;
				while(true) {
					//경계밖이거나 벽이면 감시 멈춤!
					nr += dr[cctv4[dir][j]];
					nc += dc[cctv4[dir][j]];
					if(nr<0||nc<0||nr>=n||nc>=m || grid[nr][nc] == 6) break;
					if(grid[nr][nc]==0)
						watchArea[nr][nc] = true;
				}
			}	
		}else if(cur.type == 5) {
//			System.out.printf("시작%d %d%n", r, c);
			for (int j = 0; j < cctv5[dir].length; j++) {	//0 1 2 3
				int nr = r; int nc = c;
				while(true) {
					//경계밖이거나 벽이면 감시 멈춤!
					nr += dr[cctv5[dir][j]];
					nc += dc[cctv5[dir][j]];
					if(nr<0||nc<0||nr>=n||nc>=m || grid[nr][nc] == 6) break;
//					System.out.printf("%d %d%n", nr, nc);
					if(grid[nr][nc]==0)
						watchArea[nr][nc] = true;
				}
//				System.out.println();
			}			
		}
	}
}