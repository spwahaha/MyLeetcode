package TreesAndGraphs;

public class CheckBalanced {
	
	/**
	 * compare the height of left subtree and right subtree
	 * to check the balance of root
	 * @param root
	 * @return the tree with root as root is balanced
	 */
	public static boolean isBalanced(TreeNode root){
		// check the height diff of left subtree and right subtree
		// is no more than 1
		if(root == null) return true;
		int lheight = getHeight(root.left);
		int rheight = getHeight(root.right);
		int heiDiff = Math.abs(lheight - rheight);
		if(heiDiff>1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	/**
	 * get the height of the root
	 * @param root
	 * @return height of the root
	 */
	private static int getHeight(TreeNode root){
		if(root==null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	
	/**
	 * check the balance by height code,
	 * if height returns error code(-2), the tree is not balanced
	 * @param root root of the tree
	 * @return tree is balanced
	 */
	public static boolean checkBalanced(TreeNode root){
		return checkHeight(root)!=-2;
	}
	
	/**
	 * check the balance by checking height
	 * if the height difference between left subtree and right subtree 
	 * if larger than 1, then return error code(-2)
	 * else return real height,
	 * one thing should notice that error code should return from 
	 * one level to another (not regarded as height)
	 * @param root
	 * @return 
	 */
	private static int checkHeight(TreeNode root){
		if(root == null) return -1;
		
		int l = checkHeight(root.left);
		int r = checkHeight(root.right);
		if(l == -2 || r == -2){
			return -2;
		}
		int diff = Math.abs(l-r);
		if(diff > 1){
			return -2;
		}
		return Math.max(l,r) + 1;
	}
	
	
	
	public static void main(String[] args){
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		System.out.println(checkBalanced(n0));
	}
}
