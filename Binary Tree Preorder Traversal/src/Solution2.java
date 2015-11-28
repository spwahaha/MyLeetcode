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
	
	
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
    	Stack<TreeNode> stack = new Stack<TreeNode>(); 
        //root left right
    	stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.pop();
        	res.add(node.val);
            if(node.right!=null)
            	stack.push(node.right);
            if(node.left!=null)
            	stack.push(node.left);        	
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
		System.out.println(preorderTraversal(n4));
	}
    
    
}