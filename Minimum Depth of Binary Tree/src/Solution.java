

public class Solution {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left!=null&&root.right!=null) return 1+Math.min(minDepth(root.left),minDepth(root.right));
        // if root only has left child, then the depth of 
        // this root is the depth of his left child +1
        if(root.left!=null) return 1+minDepth(root.left);
        if(root.right!=null) return 1+minDepth(root.right);
        return 1;
    }
    
    public static void main(String[] args){
    	Solution sl = new Solution();
    	TreeNode root = sl.new TreeNode(1);
    	root.left = sl.new TreeNode(2);
    	root.right = sl.new TreeNode(3);
    	root.left.left = sl.new TreeNode(2);
    	System.out.println(sl.minDepth(root.left));
    }
}
