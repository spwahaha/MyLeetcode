
public class Solution1 {
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 public static boolean isBalanced(TreeNode root) {
		 if(root==null) return true;
		 if(root.left==null&&root.right==null) return true;
		 return(Math.abs(height(root.left)-height(root.right))<=1
				 &&isBalanced(root.left)&&isBalanced(root.right));
	 }
	 
	 private static int height(TreeNode root){
		 if(root==null) return 0;
		 if(root.left==null&&root.right==null) return 0;// the height of a single node is 1;
		 int l = 0;
		 int r = 0;
		 if(root.left!=null) l = height(root.left);
		 if(root.right!=null) r = height(root.right);
		 
		 return Math.max(l, r)+1;
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
			System.out.println(isBalanced(n4));
		}
}
