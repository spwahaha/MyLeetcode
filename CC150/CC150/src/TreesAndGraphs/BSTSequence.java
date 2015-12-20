package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BSTSequence {
	public static List<List<Integer>> allSequence(TreeNode node){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(node == null) return res;
		List<Integer> list = new ArrayList<Integer>();
		int size = size(node);
//		list.add(root.val);
		helper(node, list, res, size);
		return res;
	}
	
	private static void helper(TreeNode root, List<Integer> list, List<List<Integer>> res,int size){
		if(list.size() == size){
			res.add(new ArrayList<Integer>(list));
			return;
		}
//		if(root == null) return;
		if(root==null) return;
		
//		if(root.left!=null){
			list.add(root.val);
			helper(root.left, list, res, size);
			helper(root.right,list,res,size);
			list.remove(list.size()-1);
//		}
			
//			list.add(root.val);
//			helper(root.right, list, res, size);
//			helper(root.left,list,res,size);
//			list.remove(list.size()-1);
//		if(root.right!=null){
//			list.add(root.val);
//			helper(root.right, list, res, size);
//			list.remove(list.size()-1);
//		}		

//		list.add(root.val);
//		helper(null, list, res, size);
//		list.remove(list.size()-1);
		
	}
	
	private static int size(TreeNode root){
		if(root==null) return 0;
		return size(root.left) + size(root.right) + 1;
	}
	
	public static void main(String[] args){
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n2.left = n1;
		n2.right = n3;
		List<List<Integer>> res = allSequence(n2);
		System.out.println(res);
	}
}
