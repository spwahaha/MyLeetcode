import java.util.Stack;

public class Solution {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    public static int kthSmallest(TreeNode root, int k) {
    	Stack<Integer> st = new Stack<Integer>();
    	
    	preTraversal(root,st);
    	int temp = 0;
    	for(int i = 0; i < k;i++){
    		temp = st.pop();
    	}
    	return temp;
    	
    }

	private static void preTraversal(TreeNode root, Stack st) {
		// TODO Auto-generated method stub
		if(root.right!=null) preTraversal(root.right,st);
		st.push(root.val);
		if(root.left!=null) preTraversal(root.left,st);
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
		
		System.out.println(kthSmallest(n4,2	));
	}
    
}