import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 : 괄호 추가하기
 * 링크 : https://www.acmicpc.net/problem/16637
 * 
 * 이이디어 : subset + stack
 * 			subset으로 괄호를 추가할지 말지 정한 후, 
 * 			구한 부분집합의 수식을 후위표기법으로 바꾼 후 stack을 이용하여 계산
 * 주의점 : 연산자의 우선순위가 동일하다는 조건!!!!!
 * 
 * 메서드 설명 : 
 * 		1. subset() : 괄호 추가여부 부분집합
 * 		수식의 길이가 n이면, 괄호가 들어갈 수 있는 자리는 n//2개 
 * 		그 자리에 괄호를 추가할지 말지 subset을 구하자.
 * 
 *		2. calculate() : 괄호가 추가된 수식을 계산
 * 		subset이 완성되면 수식을 계산하자.
 * 		이때 스택+후위표기법을 이용해서 계산한다.
 * 
 * 		3. maxResult : 결과 최댓값
 * 		subset별로 계산결과를 구하면서 maxResult를 구한다.
 */
public class Main {
	static int n;
	static char[] exp;
	static boolean[] selected;	//true면 해당 인덱스 앞에 괄호를 넣기로 선택했다는 뜻
	static int maxResult = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		exp = bf.readLine().toCharArray();
		selected = new boolean[n];
		
		subset(0);
		
		System.out.println(maxResult);
		
	}
	
	private static void subset(int idx) {
		if(idx>=n-1) {
			int tmpResult = calculate(exp);
			maxResult = Math.max(maxResult, tmpResult);
			return;
		}
		
		//괄호 추가O
		selected[idx] = true;
		subset(idx+4);
		
		//괄호 추가X
		selected[idx] = false;
		subset(idx+2);
	}
	
	

	private static int calculate(char[] exp) {
		//(1) 괄호 없애기
		List<String> newExp = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			//괄호 넣기로 결정했다면
			if(selected[i]) {
				if(exp[i+1] == '+') newExp.add(((exp[i]-'0')+(exp[i+2]-'0'))+"");
				else if(exp[i+1] == '-') newExp.add(((exp[i]-'0')-(exp[i+2]-'0'))+"");
				else if(exp[i+1] == '*') newExp.add(((exp[i]-'0')*(exp[i+2]-'0'))+"");
				i+=2;
				continue;
			}
			newExp.add((exp[i])+"");
		}
		
		//(2) *+- 계산
		if(newExp.size()==1) return Integer.parseInt(newExp.get(0));
		for (int i = 0; i < newExp.size(); i++) {
			if(newExp.get(i).equals("+")) {
				newExp.add(i-1, (Integer.parseInt(newExp.get(i-1)) + Integer.parseInt(newExp.get(i+1)))+"");
				newExp.remove(i);
				newExp.remove(i);
				newExp.remove(i);
				i-=1;
			}
			else if(newExp.get(i).equals("-")) {
				newExp.add(i-1, (Integer.parseInt(newExp.get(i-1)) - Integer.parseInt(newExp.get(i+1)))+"");
				newExp.remove(i);
				newExp.remove(i);
				newExp.remove(i);
				i-=1;
			}
			else if(newExp.get(i).equals("*")) {
				newExp.add(i-1, (Integer.parseInt(newExp.get(i-1)) * Integer.parseInt(newExp.get(i+1)))+"");
				newExp.remove(i);
				newExp.remove(i);
				newExp.remove(i);
				i-=1;
			}
		}
		if(newExp.size()==1) return Integer.parseInt(newExp.get(0));
		return 0;
	}
	

}