import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, k;
	static int[][] gridOrigin;
	static int[][] grid;
	static int[][] rotations;
	//위,오른쪽,아래,왼쪽
	static int[][]drdc = {{-1,0},{0,1},{1,0},{0,-1}};
	static int minSum = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		gridOrigin = new int[n][m];
		rotations = new int[k][];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				gridOrigin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());
			rotations[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}

		//넥퍼
		int[] order =  new int[k];
		for (int i = 0; i < k; i++) {
			order[i] = i;
		}
		Arrays.sort(order);
		do {
			//회전시킨후
			grid = new int[n][m];
			for (int i = 0; i < n; i++) {
				System.arraycopy(gridOrigin[i], 0, grid[i], 0, gridOrigin[i].length);
			}
			for (int i = 0; i < k; i++) {
				rotate(rotations[order[i]]);
			}
			//배열의 값 구하기
			calculate();
		}while(np(order));
		
		//최종 minSum값 구하기
		System.out.println(minSum);
	}
	
	private static boolean np(int[] order) {
		int i = order.length-1;
		while(i>0 && order[i-1]>order[i]) i--;
		if(i==0) return false;
		
		int j = order.length-1;
		while(order[i-1]>order[j]) j--;
		swap(order, i-1, j);
		
		int k = order.length-1;
		while(i<k) swap(order, i++, k--);
		return true;
	}

	private static void swap(int[] order, int i, int j) {
		int tmp = order[i];
		order[i] = order[j];
		order[j] = tmp;
	}

	//배열 회전
	private static void rotate(int[] rot) {		//r,c,s
		int sr = rot[0]-rot[2]-1, sc = rot[1]-rot[2]-1;
		int er = rot[0]+rot[2]-1, ec = rot[1]+rot[2]-1;
		
		while(sr!=er||sc!=ec) {
			boxRotate(sr,sc,er,ec);
			sr++; sc++; er--; ec--;
		}
	}
	
	private static void boxRotate(int sr, int sc, int er, int ec) {
		int start = grid[sr][sc];
		int end = grid[er][ec];
		//왼쪽변
		for (int i=sr; i<er; i++) {
			grid[i][sc] = grid[i+1][sc];
		}
		//아래쪽변
		for (int i=sc; i<ec; i++) {
			grid[er][i] = grid[er][i+1];
		}
		grid[er][ec-1] = end;
		//오른쪽변
		for (int i=er; i>sr; i--) {
			grid[i][ec] = grid[i-1][ec];
		}
		//위쪽변
		for (int i=ec; i>sc; i--) {
			grid[sr][i] = grid[sr][i-1];
		}
		grid[sr][sc+1] = start;
	}
	
	
	//행렬의 최솟값을 구한후, minSum 갱신
	private static void calculate() {
		for (int i = 0; i < n; i++) {
			int tmpSum = 0;
			for (int j = 0; j < m; j++) {
				tmpSum += grid[i][j];
			}
			minSum = Math.min(minSum, tmpSum);
		}
	}

}