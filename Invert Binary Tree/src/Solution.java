

public class Solution {

	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  public static TreeNode invertTree(TreeNode root) {
		  if(root==null) return null;
		  helper(root);
		  return root;
	  }
	  
	  public static void helper(TreeNode root){
		  if(root.left==null&&root.right==null) return;
		  // invert the left and right part
		  TreeNode temp = root.left;
		  root.left = root.right;
		  root.right = temp;
		  
		  if(root.left!=null)  helper(root.left);
		  if(root.right!=null) helper(root.right);
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
			n5.left = n3;
			n5.right = n6;
//			n1.left = n7;
			TreeNode result = invertTree(n4);
			System.out.println("hell0");
			System.out.println("hell0");
		}
}
