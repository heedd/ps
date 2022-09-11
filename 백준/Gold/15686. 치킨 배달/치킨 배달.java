import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
//	static int[][] city;
	static List<int[]> house = new LinkedList<int[]>(); // 집좌표
	static List<int[]> chicken = new LinkedList<int[]>(); // 치킨 좌표
	static int[][] comb_res;

	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static int minSum = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 1. 입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		comb_res = new int[m][2];

		// 좌표들 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1)
					house.add(new int[] { i, j });
				if (tmp == 2)
					chicken.add(new int[] { i, j });
			}
		}

		comb(chicken.size(), m); // 치킨집 C m
		System.out.println(minSum);
	}

	private static void comb(int n, int r) {
		if (r == 0) {
//			for (int i = 0; i < comb_res.length; i++) {
//				System.out.print(Arrays.toString(comb_res[i]));
//			}
			int sum = 0;

			for (int j = 0; j < house.size(); j++) {
				int dist = Integer.MAX_VALUE;
				for (int i = 0; i < comb_res.length; i++) {
					int tmp = Math.abs(house.get(j)[0] - comb_res[i][0]) + Math.abs(house.get(j)[1] - comb_res[i][1]);
					dist = Math.min(dist, tmp);
				}
				sum += dist;
			}

			minSum = Math.min(minSum, sum);
//			System.out.println(minSum);
			return;
		}
		if (n < r)
			return;

		comb_res[r - 1] = chicken.get(n - 1); //
		comb(n - 1, r - 1);

		comb(n - 1, r);
	}

}