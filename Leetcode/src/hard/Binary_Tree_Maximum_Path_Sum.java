package hard;


public class Binary_Tree_Maximum_Path_Sum {
	private static int max = Integer.MIN_VALUE;
	// traversal all the node to find the max path
    public static int maxPathSum(TreeNode root) {
    	if(root != null){
    		calculate(root);
    	}
    	if(root.left!=null){
    		maxPathSum(root.left);
    	}
    	if(root.right!=null){
    		maxPathSum(root.right);
    	}
    	
    	return max;
    }
	
    // calculate the max sum of root 
    private static void calculate(TreeNode root){
    	if(root==null){
    		return;
    	}
    	int val = root.val;
    	int left = oneLineMax(root.left,0);
    	int right = oneLineMax(root.right,0);
    	max = Math.max(max, Math.max(val, Math.max(val + left,
    			Math.max(val+right, val + left + right))));
    	
    }
    
    //calculate the 
    private static int oneLineMax(TreeNode root, int sum){
    	if(root==null) return 0;
    	
    	int val = root.val;
    	
    	
    	return Math.max(sum+val, Math.max(oneLineMax(root.left, sum + root.val), 
    			oneLineMax(root.right, sum + root.val)));
    }
	static int Max = Integer.MIN_VALUE;
    public static int maxPathSum2(TreeNode root) {
    	helper(root);
    	return Max;
    }

	private static int helper(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		
		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right),0);
		Max = Math.max(Max, root.val + left + right);
		
		return Math.max(left, right) + root.val;

	}

	public static void main(String[] args){
		TreeNode n0 = new TreeNode(-15);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(-8);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(6);
		TreeNode n9 = new TreeNode(0);
		TreeNode n10 = new TreeNode(-4);
		TreeNode n11 = new TreeNode(-1);
		TreeNode n12 = new TreeNode(-10);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n3.left = n7;
		n3.right = n8;
		n6.right = n9;
		n9.left = n10;
		n9.right = n11;
		n11.left = n12;
//		n3.left = n6;
//		n3.right = n7;
//		n4.right = n8;
		System.out.println(maxPathSum2(n0));
		
	}
}
