

public class Solution {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x, TreeNode l, TreeNode r){
			val = x;
			this.left = l;
			this.right = r;
			}
	}
	
	public static boolean isSymmetric(TreeNode root){
		if(root == null) return true;
		return helper(root.left,root.right);
	}
	
	public static boolean helper(TreeNode r1, TreeNode r2){
		if(r1==null && r2==null) return true;
		if(r1==null&&r2!=null) return false;
		if(r1!=null&&r2==null) return false;
		if(r1.val!=r2.val) return false;
		return helper(r1.left,r2.right)&&helper(r1.right,r2.left);
	}
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(3,null,null);
		TreeNode n2 = new TreeNode(4,null,null);
		TreeNode n3 = new TreeNode(4,null,null);
		TreeNode n4 = new TreeNode(3,null,null);
		TreeNode n5 = new TreeNode(2,n1,n2);
		TreeNode n6 = new TreeNode(2,n3,n4);
		TreeNode n7 = new TreeNode(1,n5,n6);
;

		System.out.println(isSymmetric(n7));
	}
}
