import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] grid = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					grid[j][k] = 1;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(grid[i][j]==1) {
					cnt+=1;
				}
			}
		}
		System.out.println(cnt);
		
	}

}