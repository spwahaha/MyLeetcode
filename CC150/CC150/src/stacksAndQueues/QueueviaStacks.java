package stacksAndQueues;

import java.util.Stack;

public class QueueviaStacks<T> {
	Stack<T> stackNewest, stackOldest;
	public QueueviaStacks(){
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public void push(T value){
		stackNewest.push(value);
	}
	
	public T pop(){
		transfor();
		return stackOldest.pop();
	}
	
	public T peek(){
		transfor();
		return stackOldest.peek();
	}
	
	private void transfor(){
		if(stackOldest.isEmpty()){
			while(!stackNewest.isEmpty()){
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public static void main(String[] args){
		QueueviaStacks<Integer> queue = new QueueviaStacks<Integer>();
		
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
