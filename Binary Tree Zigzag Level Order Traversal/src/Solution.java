import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class Solution {
	
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int i = 0;
        while(!q.isEmpty()){
        	int k = q.size();
        	i++;
        	List<Integer> list = new ArrayList<Integer>();
        	/** Use stack to get the opposite direction*/
        	// the last element in the queue should be the first one to get children
        	// so we use stack to reverse the node in the queue
    		Stack<TreeNode> st = new Stack<TreeNode>();
    		for(int j = 0; j < k; j ++){
    			st.push(q.poll());
    		}
        	for(int j = 0;j < k; j++) {
        		TreeNode temp = st.pop();
        		list.add(temp.val);
        		if(i%2==0){
        			//right -> left
        			if(temp.right!=null) q.add(temp.right);
        			if(temp.left!=null) q.add(temp.left);
        		}else{
        			// left -> right
        			if(temp.left!=null) q.add(temp.left);
        			if(temp.right!=null) q.add(temp.right);
        		}        		
        	}
        	res.add(new ArrayList<Integer>(list));
        }
        return res;
    }
    
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;
		n5.right = n6;
//		n1.left = n7;
		

		System.out.println(zigzagLevelOrder(n4));
	}
}