import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {

	
	public static class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	 }
	 
	
	public static void connect(TreeLinkNode root) {
		if(root==null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
        	int k = q.size();
        	for(int i = 0; i < k; i++){
        		TreeLinkNode t1 = q.poll();
        		TreeLinkNode t2;
        		if(i==k-1)
        			t2 = null;
        		else
        			t2 = q.peek();
        		t1.next = t2;
        		if(t1.left!=null) q.offer(t1.left);
        		if(t1.right!=null) q.offer(t1.right);
        	}
        }
        
    }
	
	public static void main(String[] args){
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n7 = new TreeLinkNode(7);
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;
		n5.right = n6;
		n5.left = n7;
		
		connect(n4);
		System.out.println("sda");
//		System.out.println(zigzagLevelOrder(n4));
	}
	
	
}