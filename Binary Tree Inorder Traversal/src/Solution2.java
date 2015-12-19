
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution2 {
	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
    public static List<Integer> inorderTraversal(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
        	while(cur!=null){
        		stack.push(cur);
        		cur = cur.left;
        	}
        	cur = stack.pop();
        	res.add(cur.val);
        	cur = cur.right;
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
//		n2.right = n3;
		n5.left = n3;
		n5.right = n6;
//		n1.left = n7;
		System.out.println(inorderTraversal(n4));
	}

}