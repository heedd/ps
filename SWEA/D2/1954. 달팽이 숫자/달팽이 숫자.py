import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	
	//			인덱스       0  1  2  3
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int[][] grid;
	static int n;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			//1. 입력
			n = sc.nextInt();
			grid = new int[n][n];
			
			
			//2. 달팽이 숫자
			for (int i = 0; i < n; i++) {	// 1 2 3
				grid[0][i] = i+1;
			}
			

			int y = 0;
			int x = n-1;
			int d = 0;
			int val = n+1;
			for (int i = n-1; i > 0; i--) { // 4,5 - 6,7 - 8 - 9
				d = (d+1)%4;
				for (int k = 0; k < i; k++) {
					y = y+dy[d];
					x = x+dx[d];
					grid[y][x] = val;
					val++;
				}
				
				d = (d+1)%4;
				for (int k = 0; k < i; k++) {
					y = y+dy[d];
					x = x+dx[d];
					grid[y][x] = val;
					val++;
				}
			}
			
			//3. 출력
		    System.out.print("#"+test_case+"\n");
		    for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(grid[i][j]+" ");
					if (j == n-1){
						System.out.println();
					}
				}
			}
		    
		    
		}//end of tc
	}
}