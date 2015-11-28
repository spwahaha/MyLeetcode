import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class Solution1 {
	
	
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
        boolean ltr = true;
        while(!q.isEmpty()){
        	int k = q.size();
        	List<Integer> list = new ArrayList<Integer>();
        	for(int j = 0;j < k; j++) {
        		TreeNode temp = q.poll();
        		if(ltr){
            		list.add(temp.val);
        		}else{
        			//use list.add(0,val) to add to the head of the list
        			list.add(0,temp.val);
        		}     
    			// left -> right
    			if(temp.left!=null) q.add(temp.left);
    			if(temp.right!=null) q.add(temp.right);
        	}
        	res.add(new ArrayList<Integer>(list));
        	ltr = !ltr;
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