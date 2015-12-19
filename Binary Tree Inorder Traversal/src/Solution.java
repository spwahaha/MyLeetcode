import java.util.ArrayList;
import java.util.List;

public class Solution {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        inorderTra(res, root);
        return res;
    }
    private void inorderTra(List<Integer> res,TreeNode root){
        if(root==null) return;
        if(root.left!=null) inorderTra(res,root.left);
        res.add(root.val);
        if(root.right!=null) inorderTra(res,root.right);
    }
}