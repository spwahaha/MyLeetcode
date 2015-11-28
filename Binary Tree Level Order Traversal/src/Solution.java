import java.util.*;

public class Solution {

//	  Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        helper(list,root,0);
	        return list;
	    }
	    
	    private void helper(List<List<Integer>> list, TreeNode root, int level){
	    	if(root==null) return;
	    	if(list.size()>level&&list.get(level)!=null){
	    		List<Integer> temp = list.get(level);
	    		temp.add(root.val);
	    		list.set(level, temp);
	    	}else{
	    		List<Integer> temp = new ArrayList<Integer>();
	    		temp.add(root.val);
	    		list.add(level, temp);
	    	}// add the element to list
	    	if(root.left!=null) helper(list,root.left,level+1);
	    	if(root.right!=null) helper(list,root.right,level+1);
	    }
	    
	    public static void main(String[] args){
	    	Solution sl = new Solution();
	    	TreeNode root = sl.new TreeNode(1);
	    	root.left = sl.new TreeNode(2);
	    	root.right = sl.new TreeNode(3);
	    	System.out.println(sl.levelOrder(root));
	    }
	 
}
