import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.tree.Tree;


public class Solution {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	/** given an int n, generate all the bst with the node 1~n*/
    public static List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }


	private static List<TreeNode> helper(int start, int end) {
		// TODO Auto-generated method stub
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(start>end){
			res.add(null); return res;
		}
		
		for(int rootValue = start;rootValue<=end;rootValue++){
			//get a root value as the boundary, and divide the tree to the left and right
			List<TreeNode> leftSubTrees = helper(start,rootValue-1);
			List<TreeNode> rightSubTrees = helper(rootValue+1,end);
			// for all the left and right, the leftSubTree contains [1~rootVaue-1], right contains[rootValue+1~n]
			for(TreeNode leftSubTree:leftSubTrees){
				for(TreeNode rightSubTree:rightSubTrees){
					TreeNode root = new TreeNode(rootValue);
					root.left = leftSubTree;
					root.right = rightSubTree;
					res.add(root);
				}
			}
		}
		return res;
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
		n2.right = n3;
		n5.right = n6;
//		n1.left = n7;
		
		List<TreeNode> tree = generateTrees(3);
		System.out.println("sda");
//		System.out.println(zigzagLevelOrder(n4));
	}
    
}