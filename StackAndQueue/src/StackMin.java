import java.util.Stack;

public class StackMin extends Stack<Integer>{
	Stack<Integer> minStack;
	public StackMin(){
		minStack = new Stack<Integer>();
	}
	
	public void push(int num){
		super.push(num);
		if(num <= min()){
			minStack.push(num);
		}
	}
	
	private int min() {
		// TODO Auto-generated method stub
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return minStack.peek();
		}
	}

	public Integer pop(){
		int val = super.pop();
		if(val == minStack.peek()){
			minStack.pop();
		}
		return val;
	}
	
	
	public static void main(String[] args){
		StackMin sm = new StackMin();
		sm.push(5);
		sm.push(6);
		sm.push(3);
		sm.push(7);
		System.out.println(sm.pop());
		System.out.println(sm.pop());
	}
}
