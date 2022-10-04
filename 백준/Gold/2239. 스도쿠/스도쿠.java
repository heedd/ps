import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

	static int[][] map = new int[9][9];				// 스도쿠 판
	static boolean[][] solved = new boolean[9][9];	// 스도쿠 채웠는지 T/F 기록
	static List<int[]> blanks = new ArrayList<>();	// 스도쿠 빈칸들 리스트
	static boolean flag = false;					// 
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력
		//좌상부터 채워나가는게 목표
		for (int r = 0; r < 9; r++) {
			String line = bf.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = line.charAt(c) - '0';
				if(map[r][c] == 0) {
					blanks.add(new int[] {r,c});
				}
			}
		}
		
		// DFS
		dfs();
		
	}
	
	private static void dfs() {
		// 가장 먼저 채울 blank 값 얻어오기 - 좌상부터 채워야되니까
		int cnt = 0;
		int br=0, bc=0;
		for (int[] blank : blanks) {
			if (map[blank[0]][blank[1]]==0) {
				br = blank[0];
				bc = blank[1];
				break;
			}
			cnt+=1;
		}
		
		// dfs 종료조건
		//스도쿠 이미 완성했으면 dfs 탐색할 필요없으니까 return
		if(flag==true) return;
		//스도쿠 처음으로 완성했다면 결과 출력해주고 dfs 완전 탈출
		if(cnt == blanks.size()) {
			// 스도쿠 결과출력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			flag = true;
			return;
		}
		
		for (int num = 1; num <= 9; num++) {
			if (isValid(br, bc, num)) {
				map[br][bc] = num;
				dfs();
				map[br][bc] = 0;
			}
		}
		
	}
	
	// map[r][c]에 num을 채워도 되는지 검사
	private static boolean isValid(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			if(map[r][i]==num) return false;	//row에 같은 map[r][c]랑 같은 값 있으면 false
			if(map[i][c]==num) return false;	//col에 같은 map[r][c]랑 같은 값 있으면 false
		}
		
		int br=r-r%3, bc=c-c%3;					//(r,c)가 속한 3x3박스의 시작점
		for (int i = 0; i < 3; i++) {			//3x3박스에 map[r][c]랑 같은 값 있으면 false
			for (int j = 0; j < 3; j++) {
				if(map[br+i][bc+j]==num) return false;
			}
		}
		return true;		//다 통과했으면 true
	}
}