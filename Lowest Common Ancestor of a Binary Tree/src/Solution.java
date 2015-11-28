
public class Solution {
	
	
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	
    	if(contains(p,q)) return p;
    	if(contains(q,p)) return q;
    	if(!contains(root,p)||!contains(root,q)) return null;
    	if(	root.left!=null&&contains(root.left,p)&&contains(root.left,q))
    		return lowestCommonAncestor(root.left,p,q);
    	if(	root.right!=null&&contains(root.right,p)&&contains(root.right,q))
    		return lowestCommonAncestor(root.right,p,q);
    	
    	return root;
    }

	private static boolean contains(TreeNode root, TreeNode p) {
		// TODO Auto-generated method stub
		if(root==null) return false;
		if(root==p) return true;
		if(root.left==null&&root.right==null) return false;
		boolean l = false;
		boolean r = false;
		if(root.left!=null) l =  contains(root.left,p);
		if(root.right!=null) r = contains(root.right,p);
		return l||r;
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
		System.out.println(lowestCommonAncestor(n4,n2,n1).val);
	}
    
    
}