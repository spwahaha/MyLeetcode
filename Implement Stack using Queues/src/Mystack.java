import java.util.LinkedList;
import java.util.Queue;

public class Mystack {
	Queue<Integer> q = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q.size()>1){
        	q2.offer(q.poll());
        }
        q.poll();
        while(!q2.isEmpty()){
        	q.offer(q2.poll());
        }
    }

    // Get the top element.
    public int top() {
    	int top = 0;
        while(q.size()>1){
        	q2.offer(q.poll());
        }
        top = q.poll();
        while(!q2.isEmpty()){
        	q.offer(q2.poll());
        }
        q.offer(top);
		return top;
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
		return q.isEmpty();
        
    }
    
    public static void main(String[] args){
    	Mystack mq = new Mystack();
    	mq.push(1);
    	mq.push(2);
    	mq.push(3);
    	mq.push(4);
    	mq.push(5);
    	while(!mq.empty()){
    		System.out.println(mq.top());
        	mq.pop();
    	}
    }
}
