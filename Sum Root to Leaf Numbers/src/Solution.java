import java.util.ArrayList;
import java.util.List;


public class Solution {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
    public static int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        List<Integer> list = new ArrayList<Integer>();
        helper(root, 0,list);
        int sum = 0;
        for(int i = 0; i < list.size();i++)
        	sum+=list.get(i);
        return sum;
    }
    
	    private static void helper(TreeNode root, int sum,List<Integer> list){
	    	sum = sum*10+root.val;
	    	if(root.left==null&&root.right==null){
	    		list.add(sum);
	    		return;
	    	}
	    	
	    	if(root.left!=null) helper(root.left,sum,list);
	    	if(root.right!=null) helper(root.right,sum,list);
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
//		n2.right = n3;
		n5.left = n3;
		n5.right = n6;
//		n1.left = n7;
		System.out.println(sumNumbers(n4));
	}
}