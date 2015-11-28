

public class Solution {
	
	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    	// this is for binary search tree
	        if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);
	        if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);
	        return root;
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
//			n2.right = n3;
			n5.right = n6;
			n2.right = n3;
//			n1.left = n7;
			TreeNode node = lowestCommonAncestor(n4,n1,n3);
			System.out.println(node.val);
			System.out.println("hello");
		}
	 
}
