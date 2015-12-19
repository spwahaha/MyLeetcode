package stacksAndQueues;

import java.util.Stack;

public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!s2.isEmpty() && s2.peek() > temp){
				s.push(s2.pop());
			}
			s2.push(temp);
		}
		
		while(!s2.isEmpty()){
			s.push(s2.pop());
		}
		
		return s;
	}
	
	public static void main(String[] args){
		Stack<Integer> s1 = new Stack<Integer>();
		for(int i = 0; i < 7; i++){
			s1.push(i);
		}
		
		s1 = sort(s1);
		while(!s1.isEmpty()){
			System.out.println(s1.pop());
		}
	}
}
