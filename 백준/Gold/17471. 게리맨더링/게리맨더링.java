import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 : 게리멘더링
 * 링크 : https://www.acmicpc.net/problem/17471
 * 
 * 아이디어 : subset + unionfind
 * 			subset으로 조합 구한후, unionFind로 조건에 맞게 선거구 나눠졌는지 check 
 */

public class Main {
	static int minDiff = Integer.MAX_VALUE;
	static int n;
	static int[] population; // 인덱스 1부터
	static int[][] adjList; // 인덱스 1부터
	static boolean[] selected;
	static boolean[] visited;
	static int[] parents;
	
	private static void make() {
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}
	private static int find(int a) {
		if(parents[a] == a) return parents[a];
		return parents[a] = find(parents[a]);
	}
	//1과 union시켜주는 메서드
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) 
			parents[pb] = pa;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 01. 입력
		n = Integer.parseInt(bf.readLine());
		population = new int[n + 1]; // 인덱스 1부터 시작
		adjList = new int[n + 1][];
		selected = new boolean[n + 1];
		visited = new boolean[n + 1];
		parents = new int[n + 1];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			adjList[i] = new int[num];
			for (int j = 0; j < num; j++) {
				adjList[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 02. minDiff 구하기
		// 1은 이미 뽑았다고 생각하고 진행
		selected[1] = true;
		subset(1);
		
		// 03. 출력
		if (minDiff == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minDiff);
		}
	}
	
	private static void subset(int cnt) {
		//조합 다 뽑았으면
		if(cnt==n) {
			int popA=0, popB=0;
			make();
			for (int i = 1; i <=n; i++) {
				//selected
				if(selected[i]) {
					for (int j = 0; j < adjList[i].length; j++) {
						if(selected[adjList[i][j]])
							union(i,adjList[i][j]);
					}
					popA += population[i];
				}else if(!selected[i]) {
					for (int j = 0; j < adjList[i].length; j++) {
						if(!selected[adjList[i][j]])
							union(i, adjList[i][j]);
					}
					popB += population[i];
				}
			}
			int flag = 0;
			for (int i = 1; i <= n; i++) {
				if(parents[i] == i) flag++;
			}
			
			//선거구가 2개의 집합으로 잘 나눠졌다면 minDiff 갱신
			if(flag == 2) {
				minDiff = Math.min(minDiff, Math.abs(popA - popB));
			}
			return;
		}
		
		selected[cnt+1] = true;
		subset(cnt+1);

		selected[cnt+1] = false;
		subset(cnt+1);
	}

	
}