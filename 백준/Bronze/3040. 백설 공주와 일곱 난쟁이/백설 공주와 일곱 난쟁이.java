import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr = new int[9];
	static int[] subset = new int[9];
	static int[] ans = new int[9];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 입력
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		//2. 조합
		for (int s=0, end=1<<9; s<end; s++) {	// 2^9가지 경우의 수
			int cnt = 0;
			for (int i = 0; i < 9; i++) {
				if( (s&1<<i) != 0 ) {
					subset[i] = 1;
					cnt++;
				}
				
			}
			
			int sum = 0;
			if(cnt == 7) {	//7개 다뽑았다면 sum 구하기
				for (int i = 0; i < 9; i++) {
					if(subset[i]!=0) {
						sum += arr[i];
					}
				}
				if(sum==100) {	//번호 합이 100이라면 찾던 조합! break
					for (int i = 0; i < 9; i++) {
						if(subset[i]!=0)
							//3. 출력
							System.out.println(arr[i]);
					}
					break;
				}
			}
			
			Arrays.fill(subset, 0);
		}

	}

}