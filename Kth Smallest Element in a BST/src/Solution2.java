import java.util.ArrayList;
import java.util.List;



public class Solution2 {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static int kthSmallest(TreeNode root, int k) {
    	List<Integer> res = new ArrayList<Integer>();
    	preTraversal(root,res,k);
    	return res.get(res.size()-1);
    	
    }

	private static void preTraversal(TreeNode root, List<Integer> res, int k) {
		// TODO Auto-generated method stub
		if(res.size()==k)
			return;
		if(root.left!=null) preTraversal(root.left,res,k);
		if(res.size()<k)
			res.add(root.val);
		if(root.right!=null) preTraversal(root.right,res,k);
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
		
		System.out.println(kthSmallest(n4,4	));
	}
    
}