import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 : 야구
 * 링크 : https://www.acmicpc.net/problem/17281
 * 
 * 아이디어 : next permutation + 비트마스크 활용
 * 		   Integer.bitcount() : int에서 1인 비트 개수 세줌
 * 주의점 : juja에 진루상황 쌓일 떄 int 범위 넘어가지 않도록 주의해야됨.
 */
public class Main {
	static int maxScore;
	static int n;	//이닝 수
	static int[][] playerScore; //playerScore[이닝][타자idx]
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. 입력받기
		n = Integer.parseInt(bf.readLine());
		playerScore = new int[n][9];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 9; j++) {
				playerScore[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		// 2. 타자 순열 & 그때의 점수 구하기
		numbers = new int[] {1,2,3,4,5,6,7,8};
		do{
			// 2-1. 0번 선수 포함한 타자 선발목록
			int[] playerList = new int[9];
			for (int i = 0; i < 9; i++) {
				if(i==3) playerList[i] = 0;
				else if(i>3) playerList[i] = numbers[i-1];
				else if(i<3) playerList[i] = numbers[i];
			}

			// 2-2. 선발목록에 대한 점수 구하기
			int permScore = 0;
			int idx = 0;	// playerList에서 타자는 idx번 선수
			
			for (int in = 0; in < n ; in++) { // 0~n-1번 이닝에 대해
				// 1이닝에서의 점수 구하기
				int out = 0;	// 아웃된 인원 수
				int juja = 0;	// 현재 진루한 주자 수
				int base1=0, base2=0, base3=0;
				while(out != 3) {
					//i이닝, idx번 선수의 점수
					int sc = playerScore[in][playerList[idx]];
					if(sc==0) {
						out++;
					}else if(sc==1) {
						permScore += base3;
						base3 = base2;
						base2 = base1;
						base1 = 1;
					}else if(sc==2) {
						permScore += base3+base2;
						base3 = base1;
						base2 = 1;
						base1 = 0;
					}else if(sc==3) {
						permScore += base3+base2+base1;
						base3 = 1;
						base2 = 0;
						base1 = 0;
					}else if(sc==4) {
						permScore += base3+base2+base1+1;
						base3 = 0;
						base2 = 0;
						base1 = 0;
					}
					
					idx = (idx+1)%9;
				}// end of 1이닝
			}// end of 전체 이닝
			

			// maxScore 갱신
			maxScore = Math.max(maxScore, permScore);
		}while(np(numbers));	//0번 선수는 이미 순서 정해졌으니 빼고 순열구하기
		
		// 3. 최대 점수 출력
		System.out.println(maxScore);
	}
	
	private static boolean np(int[] numbers) {
		int i = 7;
		while(i>0 && numbers[i-1]>numbers[i]) i--;
		if(i==0) return false;
		
		int j = 7;
		while(numbers[i-1]>numbers[j]) j--;
		swap(numbers, i-1, j);
		
		int k = 7;
		while(i<k) swap(numbers, i++, k--);
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

}