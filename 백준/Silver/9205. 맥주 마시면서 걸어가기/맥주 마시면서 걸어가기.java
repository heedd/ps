import java.util.Arrays;
import java.util.Scanner;

public class Main {

	//경로?????
	//플로이드와샬로..?
	//맥주 1병 = 50m
	//맥주 20병 가지고다닐 수 있음
	// => 이동할때마다 1000안넘는지 check
	static final int INF = Integer.MAX_VALUE>>6;	//오버플로우 조심
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			// 1. 입력
			int n = sc.nextInt();

			int[][] vertex = new int[n+2][2];
			for (int i = 0; i < n+2; i++) {
				vertex[i] = new int[] {sc.nextInt(),sc.nextInt()};
			}
			
			// 2. 플로이드와샬
			// map[i][j] : i에서 j로가는 비용
			// idx==0 : 집
			// idx==n+1 : 페스티벌
			int[][] map = new int[n+2][n+2];
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					map[i][j] = Math.abs(vertex[i][0]-vertex[j][0]) + Math.abs(vertex[i][1]-vertex[j][1]);
					// 맥주 조건 여기서 check
					// 두 정점 사이가 1000이상이면 어차피 이동못하니까 INF로 채움
					if(i!=j && map[i][j]>1000) {
						map[i][j] = INF;
					}
				}
			}
			
			
			for (int k = 0; k < n+2; k++) {				// 경유지
				for (int i = 0; i < n+2; i++) {			// 출발지
					for (int j = 0; j < n+2; j++) {		// 도착지
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
			
//			for (int i = 0; i < n+2; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			
			//출력
			if(map[0][n+1] == INF) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
			
		} //end of Tc
	}

}