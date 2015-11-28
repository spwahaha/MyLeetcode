

public class Solution {

	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 public static boolean isBalanced(TreeNode root) {
		 return height(root)!=-1;
	 }
	 
	 private static int height(TreeNode root){
		 int l = 0;
		 int r = 0;
		 if(root==null) return 0;
		 if(root.left!=null) l = height(root.left);
		 if(root.right!=null) r = height(root.right);
		 if(l==-1||r==-1) return -1;
		 if(l-r>1||r-l>1) return -1;
		 
		 return Math.max(l, r) +1;
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
			System.out.println(isBalanced(null));
		}
	 

}
