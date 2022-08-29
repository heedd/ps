import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 제출시 filerader 지우고 import하기!!!
 * core최대로 연결했을 때, 전선 길이의 최소합
 */
class Solution {
	static int maxCore;
	static int minLength;	//core최대로 연결했을 때, 전선 길이의 최소합
	static int n;
	static int[][] map;
	static int[][] grid;
	static List<int[]> coreList;
//	static boolean[][] visited;
	static int[][] drdc = {{0,-1},{0,1},{-1,0},{1,0}};
	public static void main(String args[]) throws IOException {
		StringTokenizer st;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader bf = new BufferedReader(new FileReader("res/input4.txt"));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <=T; tc++) {
			n = Integer.parseInt(bf.readLine());
			map = new int[n][n];
			coreList = new ArrayList<>();
			minLength = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					//외곽이 아닌 core이고
					if(tmp==1 && i!=0 && j!=0 && i!=n-1 && j!=n-1) {
							coreList.add(new int[] {i,j});
					}
					map[i][j] = tmp;
				}
			}
			
			for (int i = 0; i < coreList.size(); i++) {
				int[] tmp = coreList.get(i);
				if(map[tmp[0]-1][tmp[1]]==0
						||map[tmp[0]][tmp[1]-1]==0
						||map[tmp[0]][tmp[1]+1]==0
						||map[tmp[0]+1][tmp[1]]==0) continue;
				//전선 뻗을 길이 하나도 없다면
				coreList.remove(i);
			}
			
			//0:빈셀, 1:core, 2:전선
			//dfs돌리자
			dfs(0, 0, 0);
			
			System.out.printf("#%d %d%n", tc, minLength);
		}
	}

	private static void dfs(int cnt, int tmpCore, int tmpLength) {
		//cnt:확인한 core수   tmpCore:연결된 core 수    tmpLength:길이 수
		if(cnt==coreList.size()) {
			if(tmpCore>maxCore) {
				maxCore = tmpCore;
				minLength = tmpLength;
			}else if(tmpCore==maxCore) {
				minLength = Math.min(minLength, tmpLength);
			}
			return;
		}
		
		
		int[] cur = coreList.get(cnt);
		int r =cur[0], c= cur[1];
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r+drdc[dir][0];
			int nc = c+drdc[dir][1];
			
			//1:다른 코어 중첩 불가, 2:다른 전선과 중첩 불가
			//0일때만 전선 뻗을 수 있음
			if(map[nr][nc]!=0) continue;
			
			//전선 쭉 뻗을 수 있다면 dfs 계속 진행
			if(isAvail(nr,nc,dir)) {
				int colored = colorMap(r,c,dir);
				dfs(cnt+1, tmpCore+1, tmpLength+colored);
				uncolorMap(r,c,dir);
			}
			
		}
		/****************************************/
		// 이걸 안했네.............................
		// isAvail==true여도 연결안할 수도 있잖아.......
		dfs(cnt+1, tmpCore, tmpLength);
		/****************************************/
	}
	
	private static int colorMap(int nr, int nc, int dir) {
		int length = 0;
		while(true) {
			nr += drdc[dir][0];
			nc += drdc[dir][1];
			//경계까지 도착했으면 다 칠한 것임
			if(nr<0||nc<0||nr>=n||nc>=n) break;
			map[nr][nc] = 2;
			length++;
		}
		return length;
	}
	private static void uncolorMap(int nr, int nc, int dir) {
		while(true) {
			nr += drdc[dir][0];
			nc += drdc[dir][1];
			//경계까지 다 uncolor함
			if(nr<0||nc<0||nr>=n||nc>=n) return;
			map[nr][nc] = 0;
		}
	}


	private static boolean isAvail(int nr, int nc,int dir) {
		while(true) {
			nr += drdc[dir][0];
			nc += drdc[dir][1];
			//경계까지 무사히 도착했으면 전선 뻗어도 됨
			if(nr<0||nc<0||nr>=n||nc>=n) return true;
			if(map[nr][nc]!=0) return false;
		}
	}
	
	

}