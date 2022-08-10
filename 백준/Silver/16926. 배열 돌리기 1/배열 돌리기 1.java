import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int r;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		//1.입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		//2.r번 회전
		for (int i = 0; i < r; i++) {
			rotate();
		}
		
		//3.출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	//NxM grid 왼쪽회전
	//                      D      R       U      L
	//static int[][] d = {{0,1}, {0,1}, {0,-1}, {0,-1}};

	private static void rotate() {
		int box = Math.min(n, m)/2;	//돋릴 박스 개수
		
		for (int s = 0; s < box; s++) {	//박스 개수만큼 돌면서
			int maxR = n-1 - s;	//한변 중 상하로 움직일 개수
			int maxC = m-1 - s;	//한변 중 좌우로 움직일 개수 
			int start = arr[s][s];

			//box위쪽 : L
			for (int i = s; i < maxC; i++) {
				arr[s][i] = arr[s][i+1];
			}

			//box왼쪽 : D
			for (int i = s; i < maxR; i++) {
				arr[i][maxC] = arr[i+1][maxC];
			}
			
			//box아래쪽 : R
			for (int i = maxC; i > s; i--) {
				arr[maxR][i] = arr[maxR][i-1];
			}
			
			//box오른쪽 : U
			for (int i = maxR; i > s; i--) {
				arr[i][s] = arr[i-1][s];
			}
			arr[s+1][s] = start;
			
		}
	}

}