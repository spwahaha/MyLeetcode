

public class Solution {
	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  public static boolean hasPathSum(TreeNode root, int sum) {
		  if(root==null) return false;
		  return helper(root,0,sum);
	  }
	  
	  private static boolean helper(TreeNode root, int sum1, int sum2){
		  // sum1 is the sum from root to this node,
		  // sum2 is the target sum
		  boolean l = false;
		  boolean r = false;
		  if(root.left==null&&root.right==null) return (sum1+root.val==sum2);
		  if(root.left!=null) l = helper(root.left,root.val+sum1,sum2);
		  if(root.right!= null) r = helper(root.right,root.val+sum1,sum2);
		  return l||r;
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
//			n2.right = n3;
			n5.left = n3;
			n5.right = n6;

			System.out.println(hasPathSum(n4,6));
		}
}
