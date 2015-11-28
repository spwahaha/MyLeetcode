import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BSTIterator {
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	 
    public BSTIterator(TreeNode root) {
    	postTraversal(root);
    }
    
    


    private void postTraversal(TreeNode root) {
		// TODO Auto-generated method stub
    	if(root==null) return;
		if(root.right!=null) postTraversal(root.right);
		stack.push(root);
		if(root.left!=null) postTraversal(root.left);
    }




	/** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
        
    }

    /** @return the next smallest number */
    public int next() {

    	TreeNode temp = stack.pop();
    	return temp.val;
        
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
		
		BSTIterator it = new BSTIterator(n4);
//s		System.out.println(it.height(n4));
		while(it.hasNext()){
			System.out.println(it.next());
		}
//		System.out.println(binaryTreePaths(n5));
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */