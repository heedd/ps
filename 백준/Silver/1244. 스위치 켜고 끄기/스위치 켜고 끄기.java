import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//남(1) : 스위치번호가 배수이면 상태 반전
//여(2) : 나 중심으로 좌우 대칭 구간
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1. 입력
		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			switches[i] = Integer.parseInt(st.nextToken());

		// 2. switch 바꾸기
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int d = 1;
			
			if (gen == 1) { // 남자일때
				for (int j = 0; j < switches.length; j++) {
					if((j+1)%num == 0)
						switches[j] = (switches[j] == 0 ? 1 : 0);
				}
			} else { // 여자일때
				switches[num-1] = (switches[num-1] == 0 ? 1 : 0);
				while (0<=num-d-1 && num+d-1<n) {
					if (switches[num-d-1] == switches[num+d-1]) {
						switches[num-d-1] = (switches[num-d-1] == 0 ? 1 : 0);
						switches[num+d-1] = switches[num-d-1];
						d++;
					} else
						break;
				}
			}
		}

		// 3. 스위치 출력
		for (int i = 0; i < switches.length; i++) {
			System.out.print(switches[i] + " ");
			if ((i+1) % 20 == 0)
				System.out.println();
		}
	}

}