import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public static void flatten(TreeNode root) {
		if(root==null) return ;
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		if(left!=null){
			root.right = left;
			root.left = null;
			
			TreeNode rightMost = left;
			while(rightMost.right!=null)
				rightMost = rightMost.right;
			rightMost.right = right;
		}
		flatten(root.right);
	}
	

	
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = null;
		n4.left = n1;
//		n4.right = n5;
//		n2.left = n1;
		n2.right = n3;
//		n5.right = n6;
		n1.right = n2;
		flatten(n4);
		System.out.println();
	}
}
