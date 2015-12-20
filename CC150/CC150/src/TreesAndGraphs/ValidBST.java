package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class ValidBST {
	public static boolean checkBST(TreeNode root){
		return checkBST(root, null, null);
	}
	
	private static boolean checkBST(TreeNode root, Integer min, Integer max){
		if(root == null) return true;
		
		if(min != null && root.val <= min || max != null && root.val >= max){
			return false;
		}
		
		return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
	} 
	
	public static void main(String[] args){
		
		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(2);
		n3 = null;
		n4 = null;
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(20);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		System.out.println(checkBST(n0));
		
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(null);
//		System.out.println(q.size());
	}
	
	
}
