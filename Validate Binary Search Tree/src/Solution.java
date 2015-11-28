
public class Solution {
	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	    public static boolean isValidBST(TreeNode root) {
	    	return isValidBST(root,null,null);
	    }
	    
	    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
	    	if(root==null) return true;
	    	if(min!=null&&root.val<=min.val) return false;
	    	if(max!=null&&root.val>=max.val) return false;
	    	if(!isValidBST(root.left,min,root)) return false;
	    	if(!isValidBST(root.right,root,max)) return false;
	    	return true;
	    }
		public static void main(String[] args){
			TreeNode n1 = new TreeNode(1);
			TreeNode n3 = new TreeNode(3);
			TreeNode n2 = new TreeNode(2);
			TreeNode n6 = new TreeNode(6);
			TreeNode n5 = new TreeNode(5);
			TreeNode n4 = new TreeNode(4);
			n4.left = n2;
			n4.right = n5;
			n2.left = n1;
//			n2.right = n3;
			n5.left = n3;
			n5.right = n6;

			System.out.println(isValidBST(n4));
		}
	 
}
