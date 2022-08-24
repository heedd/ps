import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] drdc = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	//visited 따로 만들지 말고 "V"면 방문한걸로 방문처리할 예정
	static String[][] NMpicture;	//일반 사진
	static String[][] RBpicture;	//RB만 있는 사진   => 적록색약은 R과 B만 본다고 생각하자

	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. 입력
		n = Integer.parseInt(bf.readLine());
		NMpicture = new String[n][n];
		RBpicture = new String[n][n];
		for (int i = 0; i < n; i++) {
			String line = bf.readLine();
			NMpicture[i] = line.split("");
			RBpicture[i] = line.split("");
			//적록색맹인의 picture배열은 G를 R로 대체 (R과 G 구분못하므로)
			for (int j = 0; j < n; j++) {
				if (RBpicture[i][j].equals("G")) {
					RBpicture[i][j] = "R";
				}
			}

		}
		
		// 2. BFS
		int NMcnt = 0;	//NM영역 개수 count
		int RBcnt = 0;	//RB영역 개수 count
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!NMpicture[i][j].equals("V")) {
					BFS(NMpicture,i,j);
					NMcnt+=1;
				}
				if(!RBpicture[i][j].equals("V")) {
					BFS(RBpicture,i,j);
					RBcnt+=1;
				}
			}
		}
		
		System.out.println(NMcnt+" "+RBcnt);
	}

	private static void BFS(String[][] picture, int i, int j) {
		String color = picture[i][j];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		picture[i][j] = "V";		//방문처리
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + drdc[d][0];
				int nc = cur[1] + drdc[d][1];
				//경계검사, 같은영역 색인지검사
				if(nr<0 || nc<0 || nr>=n || nc>=n || !picture[nr][nc].equals(color)) continue;
				q.offer(new int[] {nr, nc});
				picture[nr][nc] = "V";
			}
		}
	}


}