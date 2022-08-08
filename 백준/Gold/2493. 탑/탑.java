import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        Stack<int[]> s = new Stack<>();
        int[] cur = new int[2];
     
        for(int i = 1; i <= n; i++) {
            cur[0] =  Integer.parseInt(st.nextToken());
            cur[1] = i;
            while(!s.isEmpty()) {
            	if(cur[0] < s.peek()[0]) {
            		System.out.print(s.peek()[1]+" ");
            		break;
            	}
            	s.pop();
            }
            if(s.isEmpty()) {
            	System.out.print("0 ");	//아무도
            }
            s.push(Arrays.copyOf(cur, 2));
        }
    }
}