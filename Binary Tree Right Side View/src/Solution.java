import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        helper(root,res);
        return res;
        
    }


	private static void helper(TreeNode root, List<Integer> res) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			int k = q.size();
			for(int i = 0; i < k;i++){
				TreeNode temp = q.poll();
				if(i==k-1)
					res.add(temp.val);
				if(temp.left!=null) q.offer(temp.left);
				if(temp.right!=null) q.offer(temp.right);
			}
		}
		
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
//		n2.right = n3;
		n5.left = n3;
		n5.right = n6;
		n1.left = n7;
		System.out.println(rightSideView(n4));
	}
	
}