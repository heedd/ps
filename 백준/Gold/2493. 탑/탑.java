import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    
    public static void main(String[] args) throws Exception {
    	// 1. 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        Stack<int[]> s = new Stack<>();
        int curHeight = 0;
        int[] answer = new int[n];
        
        // 2. 신호 송수신
        for(int i = 1; i <= n; i++) {	// 탑의 번호 1,2...,n이므로
            curHeight = Integer.parseInt(st.nextToken());
            // 스택의 마지막에 들어간 값이 input보다 작으면 계속 pop
            while(!s.isEmpty() && s.peek()[0] < curHeight) {
            	// curHeight보다 크면 수신받음
            		s.pop();
            }
            
            // 스택비어있으면 아무도 curHeight의 신호 수신받을 수 없음
            if(!s.isEmpty()) {
            	answer[i-1] = s.peek()[1];
            }else{
            	answer[i-1] = 0;
            }
            s.push(new int[]{curHeight, i});	//참조형 변수 넘겨주면 안됨! pass by value
        }
        
        //3. 출력
        for(int a:answer) {
        	System.out.print(a+" ");
        }
    }
}