import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 외판원 순환문제 SP 
 * 방향 그래프 
 * 다익스트라
 */
public class Main {

	static int N;				//정점 개수
	static int[][] adjMatrix;	//인접행렬
	static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		adjMatrix = new int[N][N];

		// 1. 인접한 도시들과 가중치 저장받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = i;
		}
		
		boolean breaker = false;
		int tmpCost = 0;
		int minCost = Integer.MAX_VALUE;
		do {
			breaker = false;
			tmpCost = 0;
			for (int i = 1; i < N; i++) {
				if(adjMatrix[numbers[i-1]][numbers[i]] == 0) {
					breaker = true;
					break;
				}
				tmpCost += adjMatrix[numbers[i-1]][numbers[i]];
			}
			if(!breaker && adjMatrix[numbers[N-1]][numbers[0]]!=0)
				minCost = Math.min(minCost, tmpCost+adjMatrix[numbers[N-1]][numbers[0]]);
		}while(np(numbers));
		
		System.out.println(minCost);
	
	}
	
	public static boolean np(int[] numbers) {
		
		int i = N-1;
		while(i>0 && numbers[i-1]>numbers[i]) i--;
		if(i==0) return false;
		
		int j= N-1;
		while(numbers[i-1]>numbers[j]) j--;
		swap(numbers, i-1, j);
		
		int k = N-1;
		while(i<k) swap(numbers, i++, k--);
		return true;
	}
	
	public static void swap(int[] numbers,int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}


}