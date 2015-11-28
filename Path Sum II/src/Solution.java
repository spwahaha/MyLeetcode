import java.util.*;


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
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root ==null) return res;
		List<Integer> list = new ArrayList<Integer>();
		helper(root,res, list, 0,  sum);
		return res;
	}
	
	private static void helper(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum1, int sum2){
		if(root.left==null&&root.right==null){
			if(root.val+sum1==sum2){
				list.add(root.val);
				res.add(new ArrayList<Integer>(list));
				list.remove(list.size()-1);
				// base case of the recursive,
				// need to remove the last element even  we have reached one leaf
				// because we need to back one step to go to the next leaf 
				// that shares the has the same father
			}
		}
		
		if(root.left!=null){
			list.add(root.val);
			helper(root.left,res,list,root.val+sum1,sum2);
			list.remove(list.size()-1);
		}
		
		if(root.right!=null){
			list.add(root.val);
			helper(root.right,res,list,root.val+sum1,sum2);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(7,null,null);
		TreeNode n2 = new TreeNode(2,null,null);
		TreeNode n3 = new TreeNode(5,null,null);
		TreeNode n4 = new TreeNode(1,null,null);
		TreeNode n5 = new TreeNode(11,n1,n2);
		TreeNode n6 = new TreeNode(13,null,null);
		TreeNode n7 = new TreeNode(4,n3,n4);
		TreeNode n8 = new TreeNode(4,n5,null);
		TreeNode n9 = new TreeNode(8,n6,n7);
		TreeNode n10 = new TreeNode(5,n8,n9);
		System.out.println(pathSum(n10,22));
	}
}
