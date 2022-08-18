import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static class House{
		int x, y;

		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m;
	static ArrayList<House> houses;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader bf = new BufferedReader(new FileReader("res/sample_input.txt"));
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st= new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			houses = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st= new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					if(Integer.parseInt(st.nextToken())==1) {
						houses.add(new House(i,j));
						
					}
				}
			}
			

			int limit = n%2==0? n+1: n; 
			int maxCnt = 0;
			for (int k = 1; k <= limit; k++) {
				int cost = k*k +(k-1)*(k-1);
				////////////////////////////////////////////////////////////
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						//(i,j)가 중심인 크기가 k인 방범서비스
						int cnt = 0;
						for(House h : houses) {
							
							if(k-1 >= Math.abs(i-h.y)+Math.abs(j-h.x))
								cnt+=1;
						}
						if(cnt*m-cost >= 0) {
							maxCnt = cnt>maxCnt? cnt: maxCnt;
						}
					}
				}
				////////////////////////////////////////////////////////////
			}
			
			
			
			System.out.println("#" + tc + " "+maxCnt);
		}
	}

}
