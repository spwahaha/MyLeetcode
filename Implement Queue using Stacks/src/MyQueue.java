import java.util.Stack;

public class MyQueue {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!stack.empty()){
        	stack2.push(stack.pop());
        }
        stack2.pop();
        while(!stack2.empty()){
        	stack.push(stack2.pop());
        }
    }

    // Get the front element.
    public int peek() {
    	 while(!stack.empty()){
         	stack2.push(stack.pop());
         }
         int temp = stack2.peek();
         while(!stack2.empty()){
         	stack.push(stack2.pop());
         }
		return temp;
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
		return stack.isEmpty();
        
    }
    
    public static void main(String[] args){
    	MyQueue mq = new MyQueue();
    	mq.push(1);
    	mq.push(2);
    	mq.push(3);
    	mq.push(4);
    	mq.push(5);
    	while(!mq.empty()){
    		System.out.println(mq.peek());
        	mq.pop();
    	}
    }
}
