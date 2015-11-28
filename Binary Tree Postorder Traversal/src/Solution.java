import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	    public static List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<Integer>();
	        postorderTraversal(list,root);
	        return list;
	    }
	    
	    private static void postorderTraversal(List<Integer> list,TreeNode root){
	    	if(root==null) return;
	    	// left right root
	    	if(root.left!=null) postorderTraversal(list,root.left);
	    	if(root.right!=null) postorderTraversal(list,root.right);
	    	list.add(root.val);
	    }
	    
		public static void main(String[] args){
			TreeNode n1 = new TreeNode(1);
			TreeNode n3 = new TreeNode(3);
			TreeNode n2 = new TreeNode(2);
			TreeNode n6 = new TreeNode(6);
			TreeNode n5 = new TreeNode(5);
			TreeNode n4 = new TreeNode(4);
			n4.left = n2;
			n4.right = n5;
			n2.left = n1;
			n2.right = n3;
//			n5.left = n3;
			n5.right = n6;

			System.out.println(postorderTraversal(n4));
		}
	 
}
