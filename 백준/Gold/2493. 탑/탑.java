import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Top {
		int height;
    	int idx;
    	public Top(int height, int idx) {
    		this.height = height;
    		this.idx = idx;
    	}
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        Stack<Top> s = new Stack<>();
        
     
        for(int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            while(!s.isEmpty()) {
            	if(height < s.peek().height) {
            		System.out.print(s.peek().idx+" ");
            		break;
            	}
            	s.pop();
            }
            if(s.isEmpty()) {
            	System.out.print("0 ");
            }
            s.push(new Top(height, i));
        }
    }
}